package com.javaee.jaxrs.resources;

import java.util.List;

import com.javaee.jaxrs.model.Message;
import com.javaee.jaxrs.service.MessageService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{idd}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessagesById(@QueryParam("idd") int idd) {
		return messageService.getAllMessages(idd);
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("id") int id) {
		return messageService.getMessage(id);                                                                                                                                                                                                                                   
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("id") int id) {
		return messageService.removeMessage(id);                                                                                                                                                                                                                                   
	}
}
