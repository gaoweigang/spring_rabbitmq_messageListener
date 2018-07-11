package com.gwg.demo.receiver;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.gwg.demo.model.Student;

@Component
public class HelloReceiver {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloReceiver.class);
	 
	/**
	 * 使用RabbitListener需要配置RabbitListenerContainerFactory
	 * @param studentList
	 */
	//@RabbitListener(queues = "${rabbitmq.queue}")
    public void process(List<Student> studentList) {
    	logger.info("集合 start .....");
		logger.info("Receiver  : " + JSON.toJSONString(studentList));
    }
    
    public void process(byte[] studentList) {
    	logger.info("字节数组 start ....."+studentList.length);
    	logger.info("Receiver  :{}", new String(studentList));
    }
    
    public void process(String studentList) {
    	logger.info("字符串  start .....");
    	logger.info("Receiver  :{}", studentList);
    }
 
 
}
