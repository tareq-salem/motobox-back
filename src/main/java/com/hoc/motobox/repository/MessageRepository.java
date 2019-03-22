/**
 * 
 */
package com.hoc.motobox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hoc.motobox.entity.Message;

/**
 * @author adminHOC
 *
 */
public interface MessageRepository extends JpaRepository<Message, Long>{

}
