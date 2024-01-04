public class Customer {
    private String name;
    private int pinNum;
    public Customer(String name, int pinNum) {
        this.name = name;
        this.pinNum = pinNum;
    }
    public Customer() {
        name = "";
        pinNum = 0000;
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
