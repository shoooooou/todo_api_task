package springchatapp.demo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springchatapp.demo.mapper.TaskMapper;
import springchatapp.demo.model.resource.TaskResource;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepository {
    final private TaskMapper taskMapper;

    public List<TaskResource> getTaskList(final String uid) {
        List<TaskResource> taskResourceList = taskMapper.selectByUid(uid);

        return taskResourceList;
    }
}
