package com.websokect.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.websokect.demo.ResponseMessage;

@Service
public class NotificationService {
	
	private final SimpMessagingTemplate messagingTemplate;

	@Autowired 
	public NotificationService(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}
	
	public void sendGlobalNotification() {
		ResponseMessage message =	new ResponseMessage("Global Notifiction");
		messagingTemplate.convertAndSend("/topic/global-notifications",message);
	}
	
	public void sendPrivateNotification(final String userId) {
		ResponseMessage message = new ResponseMessage("Private Notification");
		
		messagingTemplate.convertAndSendToUser(userId,"/topic/private-notifications",message);
	}
}
