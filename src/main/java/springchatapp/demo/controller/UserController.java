package springchatapp.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springchatapp.demo.model.entity.TaskEntity;
import springchatapp.demo.model.resource.TaskListResource;
import springchatapp.demo.model.value.object.TaskName;
import springchatapp.demo.model.value.object.Uid;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @GetMapping("/todo/tasklist")
    private ResponseEntity<?> getTaskList() {

        List<TaskEntity> taskListEntityList = getTaskListEntityList();
        List<TaskListResource> taskListResourceList = new ArrayList<TaskListResource>();
        for (TaskEntity taskEntity : taskListEntityList) {
            TaskListResource taskListResource = TaskListResource.builder().uid(taskEntity.getUid().getUid()).taskName(taskEntity.getTaskName().getTaskName()).build();
            taskListResourceList.add(taskListResource);
        }
        return ResponseEntity.ok().body(taskListResourceList);
    }

    @PostMapping("/todo/tasklist")
    private ResponseEntity<String> addTaskList(@PathVariable int uid) {
        return ResponseEntity.ok("User Info");
    }

    private List<TaskEntity> getTaskListEntityList() {
        Uid uid1 = new Uid();
        uid1.setUid(1);
        TaskName taskName1 = new TaskName("task1");
        Uid uid2 = new Uid(2);
        TaskName taskName2 = new TaskName("task2");
        TaskEntity taskEntity1 = TaskEntity.builder().uid(uid1).taskName(taskName1).build();
        TaskEntity taskEntity2 = TaskEntity.builder().uid(uid2).taskName(taskName2).build();
        List<TaskEntity> taskEntityList = new ArrayList<TaskEntity>();
        taskEntityList.add(taskEntity1);
        taskEntityList.add(taskEntity2);
        return taskEntityList;
    }
}
