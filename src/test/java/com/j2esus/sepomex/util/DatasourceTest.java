package com.j2esus.sepomex.util;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatasourceTest {
  
  @Test
  public void loadFromURL_returnListWithAllSuburbs() throws IOException {
    Datasource.loadFromURL();
    Assertions.assertTrue(Datasource.getSuburbs().size() >= Constants.NUM_OF_SUBURBS);
  }
}
