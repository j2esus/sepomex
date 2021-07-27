package com.j2esus.sepomex.repositories;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.j2esus.sepomex.model.Suburb;
import com.j2esus.sepomex.util.Datasource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SuburbRepositoryTest {
  private static Datasource datasource;
  private static SuburbRepository suburbRepository;

  @BeforeAll
  public static void beforeAll(){
    datasource = mock(Datasource.class);
    when(datasource.getSuburbs()).thenReturn(someSuburbs());
    suburbRepository = new SuburbRepository(datasource);
  }
  
  private static List<Suburb> someSuburbs(){
    List<Suburb> suburbs = new ArrayList<>();
    suburbs.add(
      new Suburb("01000","San Ángel", "Colonia", "Álvaro Obregón", "Ciudad de México"));
    suburbs.add(
      new Suburb("01010","Los Alpes", "Colonia", "Álvaro Obregón", "Ciudad de México"));
    suburbs.add(
      new Suburb("20000","Zona Centro", "Colonia", "Aguascalientes", "Aguascalientes"));
    suburbs.add(
      new Suburb("21000","Centro Cívico", "Colonia", "Mexicali", "Baja California"));
    suburbs.add(
      new Suburb("23000","Zona Centro", "Colonia", "La Paz", "Baja California Sur"));
    suburbs.add(
      new Suburb("24000","San Francisco de Campeche Centro", "Colonia", "Campeche", "Campeche"));
    suburbs.add(
      new Suburb("29000","Guadalupe", "Barrio", "Tuxtla Gutiérrez", "Chiapas"));
    suburbs.add(
      new Suburb("31000","Colon", "Colonia", "Chihuahua", "Chihuahua"));
    suburbs.add(
      new Suburb("25000","Saltillo Zona Centro", "Colonia", "Saltillo", "Coahuila de Zaragoza"));
    suburbs.add(
      new Suburb("28000","Colima Centro", "Colonia", "Colima", "Colima"));
    suburbs.add(
      new Suburb("34010","Morga", "Colonia", "Durango", "Durango"));
    suburbs.add(
      new Suburb("36000","Guanajuato Centro", "Colonia", "Guanajuato", "Guanajuato"));
    suburbs.add(
      new Suburb("39010","Caminos", "Colonia", "Chilpancingo de los Bravo", "Guerrero"));
    suburbs.add(
      new Suburb("42119","Las Torres", "Fraccionamiento", "Pachuca de Soto", "Hidalgo"));
    suburbs.add(
      new Suburb("44150","Barrera", "Colonia", "Guadalajara", "Jalisco"));
    suburbs.add(
      new Suburb("58020","Cuauhtémoc", "Colonia", "Morelia", "Michoacán de Ocampo"));
    suburbs.add(
      new Suburb("62563","Sumiya", "Fraccionamiento", "Jiutepec", "Morelos"));
    suburbs.add(
      new Suburb("50450","Centro", "Colonia", "Atlacomulco", "México"));
    suburbs.add(
      new Suburb("63000","Tepic Centro", "Colonia", "Tepic", "Nayarit"));
    suburbs.add(
      new Suburb("64000","Monterrey Centro", "Colonia", "Monterrey", "Nuevo León"));
    suburbs.add(
      new Suburb("68418","Sagrado Corazón", "Colonia", "Cosolapa", "Oaxaca"));
    suburbs.add(
      new Suburb("72000","Centro", "Colonia", "Puebla", "Puebla"));
    suburbs.add(
      new Suburb("76000","Centro", "Colonia", "Querétaro", "Querétaro"));
    suburbs.add(
      new Suburb("77000","Chetumal Centro", "Colonia", "Othón P. Blanco", "Quintana Roo"));
    suburbs.add(
      new Suburb("78000","San Luis Potosí Centro", "Colonia", "San Luis Potosí", "San Luis Potosí"));
    suburbs.add(
      new Suburb("80000","Centro Sinaloa", "Colonia", "Culiacán", "Sinaloa"));
    suburbs.add(
      new Suburb("83000","Centro Norte", "Colonia", "Hermosillo", "Sonora"));
    suburbs.add(
      new Suburb("86020","Framboyanes", "Colonia", "Centro", "Tabasco"));
    suburbs.add(
      new Suburb("87000","Ciudad Victoria Centro", "Colonia", "Victoria", "Tamaulipas"));
    suburbs.add(
      new Suburb("90000","Tlaxcala Centro", "Colonia", "Tlaxcala", "Tlaxcala"));
    suburbs.add(
      new Suburb("91013","Solidaridad", "Colonia", "Xalapa", "Veracruz de Ignacio de la Llave"));
    suburbs.add(
      new Suburb("97000","Los Cocos", "Fraccionamiento", "Mérida", "Yucatán"));
    suburbs.add(
      new Suburb("98000","Zacatecas Centro", "Colonia", "Zacatecas", "Zacatecas"));
    suburbs.add(
      new Suburb("98000","La Pinta", "Colonia", "Zacatecas", "Zacatecas"));
    return suburbs;
  }

  @Test
  public void findByZipCode_zipCodeExists_listWithOneElement(){
    List<Suburb> suburbs = suburbRepository.findByZipCode("20000");
    Assertions.assertIterableEquals(getExpectedSuburb(), suburbs);
  }

  private List<Suburb> getExpectedSuburb(){
    List<Suburb> suburbs = new ArrayList<>();
    suburbs.add(
      new Suburb("20000","Zona Centro", "Colonia", "Aguascalientes", "Aguascalientes"));
    return suburbs;
  }

  @Test
  public void findByZipCode_zipCodeNotExists_listWithOneElement(){
    List<Suburb> suburbs = suburbRepository.findByZipCode("100000");
    Assertions.assertTrue(suburbs.isEmpty());
  }

  @Test
  public void findByZipCode_zipCodeExists_listWithTwoElement(){
    List<Suburb> suburbs = suburbRepository.findByZipCode("98000");
    Assertions.assertIterableEquals(getExpectedSuburbs(), suburbs);
  }

  private List<Suburb> getExpectedSuburbs(){
    List<Suburb> suburbs = new ArrayList<>();
    suburbs.add(
      new Suburb("98000","Zacatecas Centro", "Colonia", "Zacatecas", "Zacatecas"));
    suburbs.add(
      new Suburb("98000","La Pinta", "Colonia", "Zacatecas", "Zacatecas"));
    return suburbs;
  }

  @Test
  public void findByStateAndTown_stateAndTownExists_listWithTwoElement(){
    List<Suburb> suburbs = suburbRepository.findByStateAndTown("Zacatecas", "Zacatecas");
    Assertions.assertIterableEquals(getExpectedSuburbsByStateAndTown(), suburbs);
  }

  private List<Suburb> getExpectedSuburbsByStateAndTown(){
    List<Suburb> suburbs = new ArrayList<>();
    suburbs.add(
      new Suburb("98000","Zacatecas Centro", "Colonia", "Zacatecas", "Zacatecas"));
    suburbs.add(
      new Suburb("98000","La Pinta", "Colonia", "Zacatecas", "Zacatecas"));
    return suburbs;
  }

  @Test
  public void findByStateAndTown_stateAndTownNotExists_emptyList(){
    List<Suburb> suburbs = suburbRepository.findByStateAndTown("Guerrero", "Unnexists");
    Assertions.assertTrue(suburbs.isEmpty());
  }

  @Test
  public void findByStateAndTown_stateAndTownExists_listWithOneElement(){
    List<Suburb> suburbs = suburbRepository.findByStateAndTown("AGUASCALIENTES", "Aguascalientes");
    Assertions.assertIterableEquals(getExpectedSuburbsByStateAndTownOneElement(), suburbs);
  }

  private List<Suburb> getExpectedSuburbsByStateAndTownOneElement(){
    List<Suburb> suburbs = new ArrayList<>();
    suburbs.add(
      new Suburb("20000","Zona Centro", "Colonia", "Aguascalientes", "Aguascalientes"));
    return suburbs;
  }

  @Test
  public void findByStateAndTown_stateAndTownExistsWithoutAccentMark_listWithOneElement(){
    List<Suburb> suburbs = suburbRepository.findByStateAndTown("Queretaro", "Queretaro");
    Assertions.assertIterableEquals(getSuburbsByStateAndTownWithAccentMarkOneElement(), suburbs);
  }

  private List<Suburb> getSuburbsByStateAndTownWithAccentMarkOneElement(){
    List<Suburb> suburbs = new ArrayList<>();
    suburbs.add(
      new Suburb("76000","Centro", "Colonia", "Querétaro", "Querétaro"));
    return suburbs;
  }

  @Test
  public void findByName_nameExists_listWithOneElement(){
    List<Suburb> suburbs = suburbRepository.findByName("ciudad");
    Assertions.assertIterableEquals(getSuburbsWithCiudadName(), suburbs);
  }

  public List<Suburb> getSuburbsWithCiudadName(){
    List<Suburb> suburbs = new ArrayList<>();
    suburbs.add(
      new Suburb("87000","Ciudad Victoria Centro", "Colonia", "Victoria", "Tamaulipas"));
    return suburbs;
  }

  @Test
  public void findByName_emptyName_emptyList(){
    List<Suburb> suburbs = suburbRepository.findByName("");
    Assertions.assertTrue(suburbs.isEmpty());
  }

  @Test
  public void findByName_nameWithTwoCharacters_emptyList(){
    List<Suburb> suburbs = suburbRepository.findByName("ci");
    Assertions.assertTrue(suburbs.isEmpty());
  }

  @Test
  public void findByName_nameWithThreeCharacters_listWithOneElement(){
    List<Suburb> suburbs = suburbRepository.findByName("rga");
    Assertions.assertIterableEquals(getSuburbsWithMorganName(), suburbs);
  }

  public List<Suburb> getSuburbsWithMorganName(){
    List<Suburb> suburbs = new ArrayList<>();
    suburbs.add(
      new Suburb("34010","Morga", "Colonia", "Durango", "Durango"));
    return suburbs;
  }

  @Test
  public void findByName_nameExists_listWithThreeElements(){
    List<Suburb> suburbs = suburbRepository.findByName("zona");
    Assertions.assertIterableEquals(getSuburbsWithZonaName(), suburbs);
  }

  public List<Suburb> getSuburbsWithZonaName(){
    List<Suburb> suburbs = new ArrayList<>();
    suburbs.add(
      new Suburb("20000","Zona Centro", "Colonia", "Aguascalientes", "Aguascalientes"));
    suburbs.add(
      new Suburb("23000","Zona Centro", "Colonia", "La Paz", "Baja California Sur"));
    suburbs.add(
      new Suburb("25000","Saltillo Zona Centro", "Colonia", "Saltillo", "Coahuila de Zaragoza"));
    return suburbs;
  }
}
