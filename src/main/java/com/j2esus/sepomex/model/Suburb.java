package com.j2esus.sepomex.model;

public class Suburb {
  private String zipCode;
  private String name;
  private String type;
  private String town;
  private String state;

  public Suburb(){

  }

  public Suburb(String zipCode, String name, String type,
      String town, String state){
    this.zipCode = zipCode;
    this.name = name;
    this.type = type;
    this.town = town;
    this.state = state;
  }
  
  public String getZipCode() {
    return zipCode;
  }
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getTown() {
    return town;
  }
  public void setTown(String town) {
    this.town = town;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }

  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    result = prime * result + ((town == null) ? 0 : town.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Suburb other = (Suburb) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (state == null) {
      if (other.state != null)
        return false;
    } else if (!state.equals(other.state))
      return false;
    if (town == null) {
      if (other.town != null)
        return false;
    } else if (!town.equals(other.town))
      return false;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    if (zipCode == null) {
      if (other.zipCode != null)
        return false;
    } else if (!zipCode.equals(other.zipCode))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    return "Suburb [name=" + name + ", state=" + state + ", town=" + town + 
      ", type=" + type + ", zipCode=" + zipCode + "]";
  }
}
