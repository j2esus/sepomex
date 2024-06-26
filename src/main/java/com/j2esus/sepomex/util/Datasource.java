package com.j2esus.sepomex.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.j2esus.sepomex.exceptions.FunctionalException;
import com.j2esus.sepomex.model.Suburb;
import org.springframework.stereotype.Component;

@Component
public class Datasource {
  private List<Suburb> suburbs = new ArrayList<>();

  public void loadFromURL() throws IOException{
    URL source = new URL(Constants.URL_FILE);
    BufferedReader reader = new BufferedReader(
      new InputStreamReader(source.openStream(),"ISO-8859-1"));
    String line = "";
    while((line = reader.readLine()) != null){
      if(isHeader(line))
        continue;
        suburbs.add(parse(convertToUTF8(line)));
    }
  }

  public List<Suburb> getSuburbs(){
    if(suburbs.isEmpty()){
      try{
        loadFromURL();
      }catch(IOException e){
        throw new FunctionalException("Error to process the file from "+
          Constants.URL_FILE, e);
      }
    }
    return suburbs;
  }

  private String convertToUTF8(String in) throws IOException{
    return new String(in.getBytes("UTF-8"));
  }

  private boolean isHeader(String line){
    return !line.contains("|") || line.contains("_");
  }

  private Suburb parse(String line){
    String[] fields = line.split("\\|");
    Suburb suburb = new Suburb();
    suburb.setZipCode(fields[Field.ZIPCODE]);
    suburb.setName(fields[Field.NAME]);
    suburb.setType(fields[Field.TYPE]);
    suburb.setTown(fields[Field.TOWN]);
    suburb.setState(fields[Field.STATE]);
    return suburb;
  }

  private interface Field {
    Integer ZIPCODE = 0;
    Integer NAME = 1;
    Integer TYPE = 2;
    Integer TOWN = 3;
    Integer STATE = 4;
  }
}
