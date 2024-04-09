package springchatapp.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springchatapp.demo.model.entity.TaskEntity;
import springchatapp.demo.model.resource.TaskRequestResource;
import springchatapp.demo.model.resource.TaskResource;
import springchatapp.demo.model.resource.TaskResourceFactory;
import springchatapp.demo.service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

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

    // TODO: 実装の肉付けをしたい
    @PostMapping("/todo/tasklist/{uid}")
    private ResponseEntity<?> addTask(@PathVariable int uid, @RequestBody TaskRequestResource taskRequestResource) {

        return ResponseEntity.ok("User Info");
    }

}
