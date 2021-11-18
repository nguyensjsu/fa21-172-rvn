package com.example.springshoelocker.gumballmachine;

public class GumballMachine {
 
  State soldOutState;
  State noQuarterState;
  State hasQuarterState;
  State soldState;

  State state = noQuarterState ;
  private String modelNumber;
  private String serialNumber;

  public GumballMachine() {
    soldOutState = new SoldOutState(this);
    noQuarterState = new NoQuarterState(this);
    hasQuarterState = new HasQuarterState(this);
    soldState = new SoldState(this);
    state = noQuarterState ;
  }
 
  public void insertQuarter() {
    state.insertQuarter();
  }
 
  public void ejectQuarter() {
    state.ejectQuarter();
  }
 
  public void turnCrank() {
    state.turnCrank();
    state.dispense();
  }

  void setState(State state) {
    this.state = state;
  }
 
  void releaseBall() {
    System.out.println("A gumball comes rolling out the slot...");
  }

  void refill(int count) {
    state = noQuarterState;
  }

  public State getState() {
      return state;
  }

  public State getSoldOutState() {
      return soldOutState;
  }

  public State getNoQuarterState() {
      return noQuarterState;
  }

  public State getHasQuarterState() {
      return hasQuarterState;
  }

  public State getSoldState() {
      return soldState;
  }
 
  public void setState( String state ) {
    switch ( state ) {
      case "com.example.gumballmachine.NoQuarterState":
        this.state = noQuarterState ;
        break ;
      case "com.example.gumballmachine.HasQuarterState":
        this.state = hasQuarterState ;
        break ;
      case "com.example.gumballmachine.SoldOutState":
        this.state = soldOutState ;
        break ;
      case "com.example.gumballmachine.SoldState":
        this.state = soldState ;
        break ;
      default:
        this.state = noQuarterState ;
        break ;
    }
  }

  public void setModelNumber(String modelNumber) {
    this.modelNumber = modelNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }
  
  public String toString() {
    StringBuffer result = new StringBuffer();
    result.append("Mighty Gumball, Inc.");
    result.append("\nSpring Boot Standing Gumball");
	result.append("\nModel #" + modelNumber + " Serial #" + serialNumber);
    result.append("\n\n");
    result.append("\nMachine is " + state + "\n");
    return result.toString();
  }

}