package airCondition;

import java.math.BigDecimal;
import java.math.RoundingMode;

abstract class AirConditioner {
    private boolean powerOn;
    private double expectedTemp;
    private double efficiency; // temperature delta per m3, per minute
    private Room acRoom;

    public AirConditioner(double efficiency) {
        this.efficiency = efficiency;
    }

    enum AcType{
        BASIC(5),
        PRO(10),
        ;

        int efficiency;

        AcType(int efficiency) {
            this.efficiency = efficiency;
        }
    }

    double cool(){
        if (powerOn){
            tempDecrease();
        }
        return acRoom.getTemperature();
    }

    private void tempDecrease(){
        BigDecimal newTemp = BigDecimal.valueOf(acRoom.getTemperature()).subtract(roomEfficiencyPerMinute());
        acRoom.setTemperature(newTemp.doubleValue());
    }

    private BigDecimal roomEfficiencyPerMinute(){
        return BigDecimal.valueOf(efficiency / acRoom.getM3()).setScale(2, RoundingMode.HALF_UP);
    }

    String deviceName(){
        return getClass().getSimpleName();
    }

    String status(){
        return powerOn ? "ON" : "OFF";
    }

    void setPower(boolean powerOn) {
        this.powerOn = powerOn;
    }

    boolean isPowerOn() {
        return powerOn;
    }

    public double getExpectedTemp() {
        return expectedTemp;
    }

    void setExpectedTemp(double expectedTemp) {
        this.expectedTemp = expectedTemp;
    }

    void setAcRoom(Room acRoom) {
        this.acRoom = acRoom;
    }
}
