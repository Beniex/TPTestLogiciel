package com.unitTesting.moneybag;

import java.util.Vector;

class MoneyBag implements IMoney{

  private Vector<Money> fMonies = new Vector<Money>();

  MoneyBag(Money m1, Money m2) {
    appendMoney(m1);
    appendMoney(m2);
  }

  MoneyBag(Money[] bag) {
    for (Money money : bag) {
      appendMoney(money);
    }
  }

  private void appendMoney(Money m) {
    if (fMonies.isEmpty()) {
      fMonies.add(m);
    } else {
      int i = 0;
      while ((i < fMonies.size()) && (!(fMonies.get(i).currency().equals(m.currency())))) {
        i++;
      }
      if (i >= fMonies.size()) {
        fMonies.add(m);
      } else {
        fMonies.set(i, new Money(fMonies.get(i).amount() + m.amount(), m.currency()));
      }
    }
  }


  public boolean equals(MoneyBag mb) {
    if (mb == null){
      return false;
    }
    if (this.fMonies.size() != mb.fMonies.size()) return false;

    for (Money thisMoney : this.fMonies) {
      boolean found = false;
      for (Money otherMoney : mb.fMonies) {
        if (thisMoney.equals(otherMoney)) {
          found = true;
          break;
        }
      }
      if (!found) return false;
    }
    return true;
  }


  public IMoney add(IMoney aMoney) {
    if (aMoney.currency().equals(currency()))
      return new Money(amount() + aMoney.amount(), currency());
    return new MoneyBag(this, aMoney);
  }

}

