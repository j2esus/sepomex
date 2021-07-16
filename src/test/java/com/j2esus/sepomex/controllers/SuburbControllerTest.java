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
public class SuburbControllerTest extends BaseControllerTest {

  @BeforeAll
  public void setUp(){
    super.setUp();
  }

  @Test
  public void getSuburbs_returnHttpStatus200() throws Exception{
    String uri = "/sepomex/v1/colonias?estado=yucatan&municipio=mérida";

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

    int status = mvcResult.getResponse().getStatus();
    Assertions.assertEquals(HttpStatus.OK.value(), status);
  }

  @Test
  public void getSuburbs_returnHttpStatus400() throws Exception{
    String uri = "/sepomex/v1/colonias?estado=yucatan";

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

    int status = mvcResult.getResponse().getStatus();
    Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(), status);
  }

  @Test
  public void getSuburbs_returnHttpStatus404() throws Exception{
    String uri = "/sepomex/v1/coloniass?estado=yucatan";

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

    int status = mvcResult.getResponse().getStatus();
    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), status);
  }

  @Test
  public void getSuburbsByZipcode_returnHttpStatus200() throws Exception{
    String uri = "/sepomex/v1/colonias/codigo-postal/04200";

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

    int status = mvcResult.getResponse().getStatus();
    Assertions.assertEquals(HttpStatus.OK.value(), status);
  }

  @Test
  public void getSuburbsByZipcode_returnHttpStatus404() throws Exception{
    String uri = "/sepomex/v1/coloniass/codigo-postal/04200/";

    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

    int status = mvcResult.getResponse().getStatus();
    Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), status);
  }
}
