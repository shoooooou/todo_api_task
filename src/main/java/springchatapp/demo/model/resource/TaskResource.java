package springchatapp.demo.model.resource;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TaskResource {
    public int sequenceNo;
    public String taskName;
    public String statusCd;
}
