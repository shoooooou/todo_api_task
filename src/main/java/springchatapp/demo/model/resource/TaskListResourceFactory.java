package springchatapp.demo.model.resource;

import springchatapp.demo.model.entity.TaskEntity;

public class TaskListResourceFactory {
    public static TaskListResource create(TaskEntity taskEntity) {
        return TaskListResource.builder()
                .uid(taskEntity.getUid().getValue())
                .taskName(taskEntity.getTaskName().getValue())
                .build();
    }
}
