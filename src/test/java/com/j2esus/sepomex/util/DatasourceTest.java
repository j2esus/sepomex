package com.j2esus.sepomex.util;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DatasourceTest {
  
  @Test
  public void loadFromURL_returnListWithAllSuburbs() throws IOException {
    Datasource.loadFromURL();
    Assertions.assertTrue(Datasource.suburbs.size() >= Constants.NUM_OF_SUBURBS);
  }
}
