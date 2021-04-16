/*
 * @created on: 17/04/2021 - 0.30
 * @project: calc
 * @author: tdessalegn
 * @author name: Temesgen Dessalegn
 * ================================
 *
 */
package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
  private final float[] credits;
  private final float[] debits;

  public SavingsCalculator(float[] credits, float[] debits) {
    this.credits = credits;
    this.debits = debits;
  }

  public static void main(String[] args) {
    String[] creditsAsString = args[0].split(",");
    String[] debitsAsString = args[1].split(",");

    float[] credits = new float[creditsAsString.length];
    float[] debits = new float[debitsAsString.length];

    // Parse creditsAsString values from String to float and store them in credits variable
    for (int i = 0; i < creditsAsString.length; i++) {
      credits[i] = Float.parseFloat(creditsAsString[i]);
    }

    // Parse debitsAsString values from String to Float and store them in debits variable
    for (int i = 0; i < debitsAsString.length; i++) {
      debits[i] = Float.parseFloat(debitsAsString[i]);
    }

    SavingsCalculator calculator = new SavingsCalculator(credits, debits);

    float netSavings = calculator.calculate();

    System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
  }

  private static int remainingDaysInMonth(LocalDate date) {

    YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
    int totalDaysInMonth = yearMonth.lengthOfMonth();
    return totalDaysInMonth - date.getDayOfMonth();
  }

  private float sumOfCredits() {
    float sum = 0.0f;
    for (float credit : credits)
      sum += credit;
    return sum;
  }

  private float sumOfDebits() {
    float sum = 0.0f;
    for (float debit : debits)
      sum += debit;
    return sum;
  }

  public float calculate() {
    return sumOfCredits() - sumOfDebits();
  }

}
