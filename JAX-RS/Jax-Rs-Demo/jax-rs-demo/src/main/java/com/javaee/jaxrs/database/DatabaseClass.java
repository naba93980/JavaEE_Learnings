package com.javaee.jaxrs.database;

import java.util.HashMap;
import java.util.Map;

import com.javaee.jaxrs.model.Message;
import com.javaee.jaxrs.model.Profile;

public class DatabaseClass {
	
	private static Map<Integer, Message> messages = new HashMap<Integer, Message>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	public static Map<Integer, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
