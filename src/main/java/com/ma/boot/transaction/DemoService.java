package com.ma.boot.transaction;

public interface DemoService {
	public Person savePersonWithRollback(Person person);
	public Person savePersonWithoutRollback(Person person);
}
