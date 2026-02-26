package sn.isi.l3gl.core.service;

import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.entity.Task;
import sn.isi.l3gl.core.enums.TaskStatus;
import sn.isi.l3gl.core.repository.TaskRepository;
import java.util.List;
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String title, String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(TaskStatus.TODO);
        return taskRepository.save(task);
    }
    public List<Task> listTasks() {
    return taskRepository.findAll();
    }
    public Task updateStatus(Long id, TaskStatus status) {
    Task task = taskRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    task.setStatus(status);
    return taskRepository.save(task);
    }
    public long countCompletedTasks() {
    return taskRepository.findByStatus(TaskStatus.DONE).size();
}
}
