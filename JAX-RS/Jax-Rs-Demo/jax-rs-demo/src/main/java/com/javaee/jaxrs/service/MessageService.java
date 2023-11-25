package com.javaee.jaxrs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.javaee.jaxrs.database.DatabaseClass;
import com.javaee.jaxrs.model.Message;


public class MessageService {
	
	private Map<Integer, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1, new Message(1, "hello world 1", "naba 1"));
	}

	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessages(int idd){
		List<Message> messagesList = new ArrayList<>(messages.values());

		List<Message> idMessage=new ArrayList<>();
		for (Message message : messagesList) {
			if(message.getId()>idd){
				idMessage.add(message);
			}
		}
		return idMessage;
	}
	
	public Message getMessage(int id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(int id) {
		return messages.remove(id);
	}
}
