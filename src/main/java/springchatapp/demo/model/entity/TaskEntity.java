package springchatapp.demo.model.entity;

import lombok.Builder;
import lombok.Getter;
import springchatapp.demo.model.value.object.TaskName;
import springchatapp.demo.model.value.object.Uid;

@Builder
@Getter
public class TaskEntity {
    private Uid uid;
    private TaskName taskName;
}
