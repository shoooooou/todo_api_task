package springchatapp.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springchatapp.demo.mapper.TaskMapper;
import springchatapp.demo.model.resource.TaskResource;

import java.util.List;

@Repository
public class TaskRepository {
    @Autowired
    private TaskMapper taskMapper;

    public List<TaskResource> getTaskList(final String uid) {
        List<TaskResource> TaskResourceList = taskMapper.selectByUid(uid);
        return TaskResourceList;
    }
}
