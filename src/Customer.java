import java.util.Scanner;
public class Customer {
    private String name;
    private int pinNum;
    private Scanner scan;
    public Customer(String name, int pinNum) {
        this.name = name;
        this.pinNum = pinNum;
    }
    public Customer() {

    }

    public String getName() {
        return name;
    }

    public int getPinNum() {
        return pinNum;
    }
    public void setPinNum(int pin) {
        pinNum = pin;
    }

}
