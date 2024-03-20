package springchatapp.demo.model.resource;

import lombok.Builder;

@Builder
public class TaskListResource {

    public String taskName;
    public int uid;


    public TaskListResource(int id, String taskName, int uid, String name, int age) {
        this.taskName = taskName;
        this.uid = uid;
    }
}
