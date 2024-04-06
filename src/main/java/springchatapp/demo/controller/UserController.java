package springchatapp.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springchatapp.demo.model.entity.TaskEntity;
import springchatapp.demo.model.resource.TaskResource;
import springchatapp.demo.model.resource.TaskResourceFactory;
import springchatapp.demo.service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/todo/tasklist/{uid}")
    private ResponseEntity<?> getTaskList(@PathVariable String uid) {

        Optional<List<TaskEntity>> optionalTaskEntities = taskService.getTaskList(uid);

        // タスクがない場合は早期リターン
        if (optionalTaskEntities.isEmpty()) {
            return ResponseEntity.ok().body(null);
        }

        List<TaskResource> taskListEntityList = new ArrayList<>();
        optionalTaskEntities.get().stream().forEach(taskEntity -> {
            taskListEntityList.add(TaskResourceFactory.create(taskEntity));
        });

        return ResponseEntity.ok().body(taskListEntityList);
    }

    @PostMapping("/todo/tasklist")
    private ResponseEntity<String> addTaskList(@PathVariable int uid) {
        return ResponseEntity.ok("User Info");
    }

}
