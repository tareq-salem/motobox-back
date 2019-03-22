/**
 * 
 */
package com.hoc.motobox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.hoc.motobox.entity.Message;
import com.hoc.motobox.repository.MessageRepository;
import com.hoc.motobox.utils.SuperRestService;

/**
 * @author adminHOC
 *
 */
@Service
public class MessageService implements  SuperRestService<Message> {

	@Autowired
	private MessageRepository messageRepository;
	@Override
	public JpaRepository<Message, Long> getDao() {
		return messageRepository;
	}
	
	public Message postMessage(Message message) {
		
		messageRepository.save(message);
		
		return message;
	}

	@Override
	public Message update(Long id, Message t) {
		// TODO Auto-generated method stub
		return null;
	}

}
