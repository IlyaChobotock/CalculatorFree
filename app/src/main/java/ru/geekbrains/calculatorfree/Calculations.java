package ru.geekbrains.calculatorfree;

class Calculations {

    private int actualNum;
    private int result;
    private int firstNum;
    private int secondNum;
    private char sign;
    private final char SUM = '+';
    private final char SUB = '-';
    private final char MULTIPLY = 'x';
    private final char DIV = '/';
    private boolean equalPressed;
    private final char EMPTY = Character.MIN_VALUE;

    public Calculations() {
        this.result = 0;
        this.firstNum = 0;
        this.secondNum = 0;
        this.actualNum = 0;
    }

    private void setEqualPressed(boolean equalPressed) {
        this.equalPressed = equalPressed;
    }

    void setEqual() {
        if (sign == EMPTY) {
            return;
        }
        if (actualNum == 0) {
            makeCalculation(result, result);
        } else {
            makeCalculation(result, actualNum);
        }
        resetNum();
        clearSign();
        setEqualPressed(true);
    }

    private void clearSign() {
        this.sign = EMPTY;
    }

    private void resetNum() {
        result = actualNum;
        actualNum = 0;
    }

    public void makeCalculation(int firstNum, int secondNum) {
        switch (sign) {
            case (SUM):
                result = firstNum + secondNum;
                break;
            case (SUB):
                result = firstNum - secondNum;
                break;
            case (MULTIPLY):
                result = firstNum * secondNum;
                break;
            case (DIV):
                result = firstNum / secondNum;
                break;
        }
    }

    void clear() {
        actualNum = 0;
        result = 0;
    }

    void setNum(String number) {
        int intNumber = Integer.parseInt(number);
        actualNum = actualNum * 10 + intNumber;
    }

//    String getStringResult() {
//        int length = getMinLength(result)
//    }

}
