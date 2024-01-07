import java.util.Scanner;
public class Customer {
    private String name;
    private String pinNum;
    private Scanner scan;
    public Customer(String name, String pinNum) {
        this.name = name;
        this.pinNum = pinNum;
    }
    public Customer() {

    }

    public String getName() {
        return name;
    }

    public String getPinNum() {
        return pinNum;
    }
    public void setPinNum(String pin) {
        pinNum = pin;
    }

}
