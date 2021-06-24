package com.j2esus.sepomex.repositories;

import java.util.Set;
import java.util.TreeSet;
import com.j2esus.sepomex.util.Datasource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

public class StateRepositoryTest {
  private static Datasource datasource;
  private static StateRepository stateRepository;

  @BeforeAll
  public static void beforeAll(){
    datasource = new Datasource();
    stateRepository = new StateRepository(datasource);
  }

  @Test
  public void getAllStates_returnSetWith32Elements(){
    Set<String> states = stateRepository.getAllStates();
    Assertions.assertEquals(expectedStates(), states);
  }

  public Set<String> expectedStates(){
    Set<String> states = new TreeSet<>();
    states.add("Aguascalientes");
    states.add("Baja California");
    states.add("Baja California Sur");
    states.add("Campeche");
    states.add("Coahuila de Zaragoza");
    states.add("Colima");
    states.add("Chiapas");
    states.add("Chihuahua");
    states.add("Ciudad de México");
    states.add("Durango");
    states.add("Guanajuato");
    states.add("Guerrero");
    states.add("Hidalgo");
    states.add("Jalisco");
    states.add("México");
    states.add("Michoacán de Ocampo");
    states.add("Morelos");
    states.add("Nayarit");
    states.add("Nuevo León");
    states.add("Oaxaca");
    states.add("Puebla");
    states.add("Querétaro");
    states.add("Quintana Roo");
    states.add("San Luis Potosí");
    states.add("Sinaloa");
    states.add("Sonora");
    states.add("Tabasco");
    states.add("Tamaulipas");
    states.add("Tlaxcala");
    states.add("Veracruz de Ignacio de la Llave");
    states.add("Yucatán");
    states.add("Zacatecas");
    return states;
  }

  @Test
  public void findByName_returnSetWith2Elements(){
    Set<String> states = stateRepository.findByName("baja california");
    Assertions.assertEquals(expectedByNameStates(), states);
  }

  public Set<String> expectedByNameStates(){
    Set<String> states = new TreeSet<>();
    states.add("Baja California");
    states.add("Baja California Sur");
    return states;
  }

  @Test
  public void findByName_returnSetWithOnlyOneElement(){
    Set<String> states = stateRepository.findByName("Guerrer");
    Assertions.assertEquals(expectedByNameState(), states);
  }

  public Set<String> expectedByNameState(){
    Set<String> states = new TreeSet<>();
    states.add("Guerrero");
    return states;
  }

  @Test
  public void findByName_nameNotExists_emptyList(){
    Set<String> states = stateRepository.findByName("Texas");
    Assertions.assertTrue(states.isEmpty());
  }
}
