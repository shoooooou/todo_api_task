package springchatapp.demo.model.value.object;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class TaskName {
    private String taskName;

    public static TaskName noValidateOf(String taskname) {
        return Objects.isNull(taskname) ? new TaskName("") : new TaskName(taskname);
    }

    public String getValue() {
        return this.taskName;
    }
}
