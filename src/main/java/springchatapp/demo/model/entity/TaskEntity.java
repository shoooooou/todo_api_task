package springchatapp.demo.model.entity;

import lombok.Builder;
import lombok.Getter;
import springchatapp.demo.model.value.object.StatusCd;
import springchatapp.demo.model.value.object.TaskName;

@Builder
@Getter
public class TaskEntity {
    private StatusCd statusCd;
    private TaskName taskName;
}
