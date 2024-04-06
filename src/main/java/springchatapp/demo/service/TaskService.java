package springchatapp.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springchatapp.demo.model.entity.TaskEntity;
import springchatapp.demo.model.entity.TaskEntityFactory;
import springchatapp.demo.model.resource.TaskResource;
import springchatapp.demo.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Optional<List<TaskEntity>> getTaskList(final String uid) {
        List<TaskResource> listTaskResource = taskRepository.getTaskList(uid);

        // タスクがない場合は早期リターン
        if (listTaskResource.isEmpty()) {
            return Optional.empty();
        }

        List<TaskEntity> listTaskEntity = new ArrayList<>();
        listTaskResource.stream().forEach(taskResource -> {
            listTaskEntity.add(TaskEntityFactory.create(taskResource));
        });

        return Optional.of(listTaskEntity);
    }
}
