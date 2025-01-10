package com.unitTesting.moneybag;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
  private static Money f12CHF;
  private static Money f14USD;
  private static Money f7USD;
  private static Money f21USD;
  private static MoneyBag fMB1;
  private static MoneyBag fMB2;

  @BeforeAll
  public static void setUp() {
    f12CHF= new Money(12, "CHF");
    f14USD= new Money(14, "USD");
    f7USD= new Money( 7, "USD");
    f21USD= new Money(21, "USD");
    fMB1= new MoneyBag(f14USD, f12CHF);
    fMB2= new MoneyBag(f21USD, f12CHF );
  }


  @Test
  public void testSimpleAdd() {
    Money m12CHF = new Money(12, "CHF"); // création de données
    Money m14CHF = new Money(14, "CHF");
    Money expected = new Money(26, "CHF");
    IMoney result = m12CHF.add(m14CHF); // exécution de la méthode testée
    assertTrue(expected.equals(result)); // comparaison
  }

  @Test
  public void testEqualsDifferentCurrency() {
    Money m12CHF = new Money(12, "CHF"); // création de données
    Money m12EUR = new Money(12, "EUR");
    assertFalse(m12CHF.equals(m12EUR)); // comparaison
  }

  @Test
  public void testEqualsDifferentAmount() {
    Money m12CHF = new Money(12, "CHF"); // création de données
    Money m34CHF = new Money(34, "CHF");
    assertFalse(m12CHF.equals(m34CHF)); // comparaison
  }

  @Test
  public void testAddMoneyBagToMoney() {
    Money m12CHF = new Money(12, "CHF"); // création de données
    assertTrue(fMB2.equals(f7USD.add(fMB1))); // comparaison
  }


}

