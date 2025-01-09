package com.unitTesting.helloworld;

public class Hello {

  public String message(String prenom) {
    if(prenom == null) {
      throw new IllegalArgumentException("il n'y a pas de prénom");
    } else {

      return "Hello " + prenom + " !";
    }
  }
}
