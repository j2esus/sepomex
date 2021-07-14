package com.j2esus.sepomex.controllers;

import com.j2esus.sepomex.SepomexApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SepomexApplication.class)
@WebAppConfiguration
public abstract class BaseControllerTest {
  protected MockMvc mockMvc;
  @Autowired
  protected WebApplicationContext webApplicationContext;

  public void setUp(){
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }
}
