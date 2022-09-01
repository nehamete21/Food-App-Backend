package com.cl.FoodApp.dto;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmailDetails {

 private String recipient;
 private String msgBody;
 private String subject;
 private String attachment;
public String getRecipient() {
	return recipient;
}
public void setRecipient(String recipient) {
	this.recipient = recipient;
}
public String getMsgBody() {
	return msgBody;
}
public void setMsgBody(String msgBody) {
	this.msgBody = msgBody;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getAttachment() {
	return attachment;
}
public void setAttachment(String attachment) {
	this.attachment = attachment;
}
 
 
}