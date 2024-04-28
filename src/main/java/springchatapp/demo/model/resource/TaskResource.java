package springchatapp.demo.model.resource;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class TaskResource {
    public String taskName;
    public String statusCd;
    private int sequenceNo;
}
