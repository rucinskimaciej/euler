package airCondition;

public class Room {
    private String roomName;
    private double temperature;
    private AirConditioner ac;
    private double m3;

    public Room(String roomName, double temperature, double m3, AirConditioner ac) {
        this.roomName = roomName;
        this.temperature = temperature;
        this.ac = ac;
        this.m3 = m3;
    }

    void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    double getTemperature() {
        return temperature;
    }

    AirConditioner getAc() {
        return ac;
    }

    double getM3() {
        return m3;
    }

    public String getRoomName() {
        return roomName;
    }
}
