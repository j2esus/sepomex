package com.j2esus.sepomex.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@TestInstance(Lifecycle.PER_CLASS)
public class StateControllerTest extends BaseControllerTest {

  @BeforeAll
  public void setUp(){
    super.setUp();
  }

  @Test
  public void getStates_returnHttpStatus200() throws Exception{
    String uri = "/sepomex/v1/estados";

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

    int status = mvcResult.getResponse().getStatus();
    Assertions.assertEquals(HttpStatus.OK.value(), status);
  }

  @Test
  public void getStates_returnHttpStatus404() throws Exception{
    String uri = "/sepomex/v1/estadoss";

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

    int status = mvcResult.getResponse().getStatus();
    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), status);
  }
}
