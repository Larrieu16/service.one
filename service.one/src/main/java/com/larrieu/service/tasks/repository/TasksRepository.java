package com.larrieu.service.tasks.repository;

import com.larrieu.service.tasks.entity.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<TasksEntity, Long> {
}
