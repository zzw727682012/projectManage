package com.haiyu;

import com.project.manager.ManagerApplication;
import com.project.manager.dao.BaseAdminUserMapper;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class ManagerApplicationTests {

	@Autowired
	private BaseAdminUserMapper baseAdminUserMapper;

	@Test
	public void contextLoads() {
		String url = "http://172.16.4.31:8087/TEST_HK_WMS/flex/DeliveryTracking.html?trackingId=SAM-SO202003120018";
		SimpleDateFormat sdf = new SimpleDateFormat("MMMdd,yyyy HH:mma",Locale.UK);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mma");
//		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mma");
//
	//	System.out.println(sdf.format(null));
//		System.out.println(sdf1.format(new Date()));


		System.out.println("AAAR".endsWith("R"));
	}

	private String get(){
		String a=null;
	    try{
	    	a = "123";


	    	return a;
		}catch (Exception e){
	    	e.printStackTrace();
		}finally {
			System.out.println("aaaaaaaaaaa");
		}
	    return a;
    }

}
