package com.haiyu;

import com.project.manager.ManagerApplication;
import com.project.manager.dao.BaseAdminUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.NoSuchAlgorithmException;


public class ManagerApplicationTests {

	@Autowired
	private BaseAdminUserMapper baseAdminUserMapper;

	@Test
	public void contextLoads() {
		String response = "";
		System.out.println((response != null)&&(response.length()>0));

	}

}
