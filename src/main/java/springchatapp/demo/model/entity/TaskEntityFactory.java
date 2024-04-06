package springchatapp.demo.model.entity;

import springchatapp.demo.model.resource.TaskResource;
import springchatapp.demo.model.value.object.TaskName;
import springchatapp.demo.model.value.object.Uid;

public class TaskEntityFactory {
    public static TaskEntity create(TaskResource taskResource) {
        return TaskEntity.builder()
                .taskName(TaskName.noValidateOf(taskResource.getTaskName()))
                .uid(Uid.noValidateOf(taskResource.getUid()))
                .build();
    }
}
