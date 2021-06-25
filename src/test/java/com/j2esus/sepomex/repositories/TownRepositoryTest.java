package com.j2esus.sepomex.repositories;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.j2esus.sepomex.model.Suburb;
import com.j2esus.sepomex.model.Town;
import com.j2esus.sepomex.util.Datasource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TownRepositoryTest {
  private static Datasource datasource;
  private static TownRepository townRepository;
  
  @BeforeAll
  public static void beforeAll(){
    datasource = mock(Datasource.class);
    when(datasource.getSuburbs()).thenReturn(someSuburbs());
    townRepository = new TownRepository(datasource);
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
      new Suburb("98424","El Mezquital", "Colonia", "Río Grande", "Zacatecas"));
    return suburbs;
  }

  @Test
  public void findByState_stateExists_listWithTwoElements(){
    Set<Town> towns = townRepository.findByState("zacatecas");
    Assertions.assertEquals(expectedTowns(), towns);
  }

  private Set<Town> expectedTowns(){
    Set<Town> towns = new TreeSet<>();
    towns.add(new Town("Río Grande", "Zacatecas"));
    towns.add(new Town("Zacatecas", "Zacatecas"));
    return towns;
  }

  @Test
  public void findByState_stateExists_listWithOneElements(){
    Set<Town> towns = townRepository.findByState("YUCATÁN ");
    Assertions.assertEquals(expectedTown(), towns);
  }

  private Set<Town> expectedTown(){
    Set<Town> towns = new TreeSet<>();
    towns.add(new Town("Mérida", "Yucatán"));
    return towns;
  }

  @Test
  public void findByState_stateNotExists_emptyList(){
    Set<Town> towns = townRepository.findByState("texas");
    Assertions.assertTrue(towns.isEmpty());
  }
}
