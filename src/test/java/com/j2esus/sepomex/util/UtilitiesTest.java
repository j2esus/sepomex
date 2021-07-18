package com.j2esus.sepomex.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilitiesTest {

  @Test
  public void equalsIgnoreDiacritics_sameStrings_true(){
    Assertions.assertTrue(Utilities.equalsIgnoreDiacritics("name", "name"));
  }

  @Test
  public void equalsIgnoreDiacritics_upperStrings_true(){
    Assertions.assertTrue(Utilities.equalsIgnoreDiacritics("name", "NAME"));
  }

  @Test
  public void equalsIgnoreDiacritics_mixUpperAndLowerStrings_true(){
    Assertions.assertTrue(Utilities.equalsIgnoreDiacritics("name", "NamE"));
  }

  @Test
  public void equalsIgnoreDiacritics_accentMarkStrings_true(){
    Assertions.assertTrue(Utilities.equalsIgnoreDiacritics("náme", "name"));
  }

  @Test
  public void equalsIgnoreDiacritics_spanishCharacterStrings_true(){
    Assertions.assertTrue(Utilities.equalsIgnoreDiacritics("niño", "nino"));
  }

  @Test
  public void equalsIgnoreDiacritics_spanishCharacterStrings_false(){
    Assertions.assertFalse(Utilities.equalsIgnoreDiacritics("niños", "nino"));
  }
}
