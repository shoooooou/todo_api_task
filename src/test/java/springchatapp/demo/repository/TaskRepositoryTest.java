package springchatapp.demo.repository;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import springchatapp.demo.model.resource.TaskResource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    @DatabaseSetup("/getTaskListSetup.xml")
    @DisplayName("タスク一覧が取得できる")
    void getTaskList_ok1() {
        final var expected = getExpectedTaskList();
        List<TaskResource> target = taskRepository.getTaskList("0000000001");

        Assertions.assertEquals(expected.size(), target.size());
//        for文使わずに比較をしたい
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i).getTaskName(), target.get(i).getTaskName());
            Assertions.assertEquals(expected.get(i).getStatusCd(), target.get(i).getStatusCd());
        }
    }

    @Test
    @DatabaseSetup("/getTaskListSetup.xml")
    @DisplayName("データベースアクセスエラーの場合は例外をスローする")
    void getTaskList_error1() {
        List<TaskResource> target = taskRepository.getTaskList("0000000001");
        
    }

    private List<TaskResource> getExpectedTaskList() {
        List<TaskResource> taskList = new ArrayList<>();
        taskList.add(TaskResource.builder().taskName("todo1").statusCd("0").build());
        taskList.add(TaskResource.builder().taskName("todo2").statusCd("1").build());
        taskList.add(TaskResource.builder().taskName("todo3").statusCd("2").build());
        return taskList;
    }
}