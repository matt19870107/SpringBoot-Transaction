package com.ma.boot.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/rollback")
	public Person rollback(Person person) {
		return demoService.savePersonWithRollback(person);
	}
	
	@RequestMapping("/norollback")
	public Person norollback(Person person) {
		return demoService.savePersonWithoutRollback(person);
	}
}
