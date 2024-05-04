package springchatapp.demo.model.resource;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddTaskResource {
  private String uid;
  private String taskName;
  private String statusCd;
  private int sequenceNo;
}
