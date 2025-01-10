package com.unitTesting.moneybag;

class Money implements IMoney {
  private int fAmount;
  private String fCurrency;

  public Money(int amount, String currency) {
    fAmount = amount;
    fCurrency = currency;
  }

  public int amount() {
    return fAmount;
  }

  public String currency() {
    return fCurrency;
  }
/*
  public Money add(Money m) {
    int somme = this.amount()+m.amount();
    return new Money(somme,"CHF");
  }
*/
  public boolean equals(Money m){
    return m.amount() == this.amount() && m.currency().equals(this.currency());
  }

  public IMoney add(IMoney aMoney) {
    if (aMoney.currency().equals(currency()))
      return new Money(amount() + aMoney.amount(), currency());
    return new MoneyBag(this, aMoney);
  }

}
