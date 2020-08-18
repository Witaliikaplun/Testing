package com.example.testing;
public class Values {
    private String firstOperand = "";
    private String secondOperand = "";

    public boolean equalsToValues(Values values) {
        return firstOperand.equals(values.firstOperand)
                && secondOperand.equals(values.secondOperand);
    }

    public void setFirstOperand(String firstOperand){
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(String secondOperand){
        this.secondOperand = secondOperand;
    }

    public String getFirstOperand(){
        return this.firstOperand;
    }

    public String getSecondOperand(){
        return this.secondOperand;
    }
}