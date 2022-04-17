package baseball.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public Player(){

    }
    private int firstNumber;

    private int secondNumber;

    private int thirdNumber;

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getThirdNumber() {
        return thirdNumber;
    }

    public void setThirdNumber(int thirdNumber) {
        this.thirdNumber = thirdNumber;
    }

    public Player(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                ", thirdNumber=" + thirdNumber +
                '}';
    }
    public List<Integer> toList(){
        List<Integer> list = new ArrayList<>();
        list.add(firstNumber);
        list.add(secondNumber);
        list.add(thirdNumber);
        return list;
    }
}
