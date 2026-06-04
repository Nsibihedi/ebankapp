package com.pfe.ebankapp.notification.services;

import com.pfe.ebankapp.auth_users.entity.User;
import com.pfe.ebankapp.notification.dtos.NotificationDTO;

public interface NotificationService {
    void sendEmail(NotificationDTO notificationDTO, User user);
}
