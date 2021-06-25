package com.j2esus.sepomex.model;

public class Town implements Comparable<Town> {
  private String name;
  private String state;

  public Town(){

  }

  public Town(String name, String state){
    this.name = name;
    this.state = state;
  }

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
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
    Town other = (Town) obj;
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
    return true;
  }

  @Override
  public String toString() {
    return "Town [name=" + name + ", state=" + state + "]";
  }

  @Override
  public int compareTo(Town o) {
    int name = this.name.compareTo(o.name);
    return name == 0 ? this.state.compareTo(o.state) : name;
  }
}
