package springchatapp.demo.model.resource;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TaskResource {

    public String taskName;
    public String uid;
}
