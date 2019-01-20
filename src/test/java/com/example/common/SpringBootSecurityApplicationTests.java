package com.example.common;

import com.example.SpringBootSecurityApplication;
import com.example.modules.test.controller.HelloController;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringBootSecurityApplication.class)
//@WebAppConfiguration
public class SpringBootSecurityApplicationTests {
//
//	private MockMvc mvc;
//
//	@Autowired
//	private HelloController controller;
//
//	@Before
//	public void setUp() {
//		mvc = MockMvcBuilders.standaloneSetup(controller).build();
//	}
//
//	@Test
//	public void contextLoads() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//		   .andExpect(MockMvcResultMatchers.status().isOk())
//		   .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("hello")));
//	}

	public static void main(String[] args) {


		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("123456"));;

	}

}
