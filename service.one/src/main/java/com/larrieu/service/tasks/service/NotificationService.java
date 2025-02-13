package com.larrieu.service.tasks.service;

import com.larrieu.service.tasks.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-notification")
public interface NotificationService {
    @PostMapping("/notification")
    void sendNotification(@RequestBody NotificationRequest request);
}
