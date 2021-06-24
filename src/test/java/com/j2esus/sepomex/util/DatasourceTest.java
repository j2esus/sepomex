package com.j2esus.sepomex.util;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatasourceTest {
  private Datasource datasource = new Datasource();
  
  @Test
  public void loadFromURL_returnListWithAllSuburbs() throws IOException {
    datasource.loadFromURL();
    Assertions.assertTrue(datasource.getSuburbs().size() >= Constants.NUM_OF_SUBURBS);
  }
}
