package com.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tools.Tools;

@Component("taskTest")
public class TaskTest {
	private static Logger log = Logger.getLogger(TaskTest.class);

//	@Scheduled(cron = "1/10 * * * * ?") 
	public void test1() {
		String time = Tools.getNowTime();
		log.info("tasktest-test1:" + time);
	}
}
