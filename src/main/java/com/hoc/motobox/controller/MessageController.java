package com.hoc.motobox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoc.motobox.entity.Message;
import com.hoc.motobox.service.MessageService;
import com.hoc.motobox.utils.SuperController;
import com.hoc.motobox.utils.SuperRestService;

@RestController
@RequestMapping("/message")
public class MessageController extends SuperController<Message> {

	@Autowired
	public MessageController(SuperRestService<Message> service) {
		super(service);
	}
	@Autowired
	MessageService messageService;
	
	@PostMapping("/send")
	public Message postMessage(@RequestBody Message message) {
		return this.messageService.postMessage(message);	
	}

}
