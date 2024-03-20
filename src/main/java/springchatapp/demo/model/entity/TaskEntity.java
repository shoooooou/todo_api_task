package springchatapp.demo.model.entity;

import lombok.Builder;
import lombok.Getter;
import springchatapp.demo.model.vo.TaskName;
import springchatapp.demo.model.vo.Uid;

@Builder
@Getter
public class TaskEntity {
    private Uid uid;
    private TaskName taskName;
}
