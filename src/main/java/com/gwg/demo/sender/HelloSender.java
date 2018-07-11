package com.gwg.demo.sender;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.gwg.demo.model.Student;

@Component
public class HelloSender {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloSender.class);
	
	//使用Autowired注解 免去setter方法注入，如果使用setter,还需要在spring配置文件中配置注入对象
	@Autowired
    private AmqpTemplate rabbitTemplate;
	
	@Value("${rabbitmq.queue}")
	private String queue;
 
    public void send() {
    	
    	logger.info("rabbitTemplate :" + rabbitTemplate);
    	List<Student> studentList = new ArrayList<Student>();
    	studentList.add(new Student(1, "gaoweigang", 22));
    	studentList.add(new Student(2, "高伟刚", 23));
    	String data = JSON.toJSONString(studentList);
        logger.info("Sender : " + data);
        
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("application/json");

        Message message = new Message(data.getBytes(),messageProperties);

        this.rabbitTemplate.convertAndSend(queue, message);
    }

/*	public AmqpTemplate getRabbitTemplate() {
		return rabbitTemplate;
	}

	public void setRabbitTemplate(AmqpTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
    */
 
}
