package com.larrieu.service.tasks.service;

import com.larrieu.service.tasks.dto.NotificationRequest;
import com.larrieu.service.tasks.entity.TasksEntity;
import com.larrieu.service.tasks.repository.TasksRepository;

import java.util.List;

public class TaskService {
    private final TasksRepository tasksRepository;
    private final NotificationService notificationService;

    public TaskService(TasksRepository tasksRepository, NotificationService notificationService){
        this.tasksRepository = tasksRepository;
        this.notificationService = notificationService;
    }

    public void sendNotificationForDueTasks(){
        List<TasksEntity> tasks = tasksRepository.findDueTasks();
        for(TasksEntity task : tasks){
        NotificationRequest request = new NotificationRequest(task.getTitle() +
                "is close to due date.",
                task.getEmail());
            notificationService.sendNotification(request);
            task.setNotified(true);
        }
    }
}
