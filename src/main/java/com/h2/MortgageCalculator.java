/*
 * @created on: 17/04/2021 - 17.22
 * @project: calc
 * @author: tdessalegn
 * @author name: Temesgen Dessalegn
 * ================================
 *
 */
package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
  private long loanAmount;
  private int termInYears;
  private float annualRate;
  private double monthlyPayment;

  public static void main(String[] args) {
    long loanAmount = Long.parseLong(args[0]);
    int termInYears = Integer.parseInt(args[1]);
    float annualRate = Float.parseFloat(args[2]);

    MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);
    calculator.calculateMonthlyPayment();

    System.out.println(calculator.toString());
  }

  public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
    this.loanAmount = loanAmount;
    this.termInYears = termInYears;
    this.annualRate = annualRate;
  }

  private int getNumberOfPayments() {
    return 12 * termInYears;
  }

  private float getMonthlyInterestRate() {
    float interestRate = annualRate / 100;
    return interestRate / 12;
  }

  public void calculateMonthlyPayment() {
    /**
     * The formula for mortgage calculation is:
     *  M = P(r(1+r)^n/(((1+r)^n)-1)
     * M is the calculated monthly mortgage payment,
     *
     * P is the principal amount, represented by loanAmount in our class,
     *
     * r is the monthly interest rate, which you can find by calling getMonthlyInterestRate().
     *
     * n is the total number of payments which you can find by calling getNumberOfPayments().
     */

    long P = loanAmount;
    float r = getMonthlyInterestRate();
    int n = getNumberOfPayments();
    this.monthlyPayment = P * ((r * Math.pow(1 + r, n)) / ((Math.pow((1 + r), n)) - 1));
  }

  public String toString() {
    DecimalFormat df = new DecimalFormat("####0.00");
    return "monthlyPayment: " + df.format(monthlyPayment);
  }

}
