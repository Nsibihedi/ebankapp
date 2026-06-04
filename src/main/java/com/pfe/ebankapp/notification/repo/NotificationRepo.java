package com.pfe.ebankapp.notification.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.ebankapp.notification.entity.Notification;


public interface NotificationRepo extends JpaRepository<Notification, Long> {
}
