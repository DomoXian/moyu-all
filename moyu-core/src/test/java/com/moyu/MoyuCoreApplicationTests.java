package com.moyu;

import com.moyu.model.form.UserForm;
import com.moyu.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoyuCoreApplication.class)
public class MoyuCoreApplicationTests {

	@Test
	public void contextLoads() {
		UserForm userForm = new UserForm();
		userForm.setLoginName("123");
		userForm.setLoginPwd("123456");
		userForm.setUserStatus(0);
		iUserService.register(userForm);
	}

	@Autowired
	private IUserService iUserService;



}
