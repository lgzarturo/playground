package com.testme.junit;

public class TestingJunit5 {

    private int nbErrors = 0;

    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 20);
        if (result != 40) {
            throw new IllegalStateException("Expected 40 but got " + result);
        }
    }

    public static void main(String[] args) {
        TestingJunit5 test = new TestingJunit5();
        try {
            test.testAdd();
        } catch (Throwable e) {
            test.nbErrors++;
            e.printStackTrace();
        }
        if (test.nbErrors > 0) {
            throw new IllegalStateException("Test failed with " + test.nbErrors + " errors");
        }
    }
}
