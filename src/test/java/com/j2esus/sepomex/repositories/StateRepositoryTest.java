package com.j2esus.sepomex.repositories;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StateRepositoryTest {
  
  @Test
  public void getAllStates_returnSetWith32Elements(){
    StateRepository stateRepository = new StateRepository();
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
}
