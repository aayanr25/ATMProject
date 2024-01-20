public class Customer {
    private String name;
    private String pinNum;
    public Customer(String name, String pinNum) {
        this.name = name;
        this.pinNum = pinNum;
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
