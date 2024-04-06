package springchatapp.demo.model.resource;

import springchatapp.demo.model.entity.TaskEntity;

public class TaskResourceFactory {
    public static TaskResource create(TaskEntity taskEntity) {
        return TaskResource.builder()
                .uid(taskEntity.getUid().getValue())
                .taskName(taskEntity.getTaskName().getValue())
                .build();
    }
}
