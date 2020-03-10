package airCondition;

public class RoomTemperatureControl {
    private Room room;
    private AirConditioner ac;

    public RoomTemperatureControl(Room room) {
        this.room = room;
        this.ac = room.getAc();
    }

    void powerOn(){
        ac.setPower(true);
    }

    private void powerOff(){
        ac.setPower(false);
    }

    void coolRoom(double expectedTemp){
        ac.setAcRoom(room);
        ac.setExpectedTemp(expectedTemp);
        if (room.getTemperature() > ac.getExpectedTemp()) {
            room.setTemperature(ac.cool());
        } else {
            powerOff();
        }
    }

    String info(){
        return room.getRoomName() + ": " +
                room.getTemperature() +
                " (" + room.getAc().deviceName() + " - " + room.getAc().status() + ")";
    }

    AirConditioner getAc() {
        return ac;
    }
}
