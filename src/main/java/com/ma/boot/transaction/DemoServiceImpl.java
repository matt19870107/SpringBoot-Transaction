package com.ma.boot.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	PersonResponsitory personResponsitory;
	
	@Transactional(rollbackFor= {IllegalArgumentException.class})
	@Override
	public Person savePersonWithRollback(Person person) {
		Person p = personResponsitory.save(person);
		if(person.getName().equals("matt")) {
			throw new IllegalArgumentException("matt已经存在，数据将回滚");
		}
		return p;
	}

	@Transactional(noRollbackFor= {IllegalArgumentException.class})
	@Override
	public Person savePersonWithoutRollback(Person person) {
		Person p = personResponsitory.save(person);
		if(person.getName().equals("xxx")) {
			throw new IllegalArgumentException("xxx已经存在，数据将不回滚");
		}
		return p;
	}

}
