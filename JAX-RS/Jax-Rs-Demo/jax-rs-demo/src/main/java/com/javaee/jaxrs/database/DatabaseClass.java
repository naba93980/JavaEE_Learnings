package com.javaee.jaxrs.database;

import java.util.HashMap;
import java.util.Map;

import com.javaee.jaxrs.model.Message;

public class DatabaseClass {
	
	private static Map<Integer, Message> messages = new HashMap<Integer, Message>();
	
	public static Map<Integer, Message> getMessages() {
		return messages;
	}
	
}
