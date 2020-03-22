package airCondition;

import java.util.ArrayList;
import java.util.List;

class Test {
    public static void main(String[] args) throws InterruptedException {
        List<RoomTemperatureControl> controlRoom = new ArrayList<>();
        controlRoom.add(new RoomTemperatureControl(new Room("Room 0", 23.5,60, new BasicAirConditioner())));
        controlRoom.add(new RoomTemperatureControl(new Room("Room 1", 25, 100, new ProAirConditioner())));
        controlRoom.add(new RoomTemperatureControl(new Room("Room 3", 22,120, new BasicAirConditioner())));
        controlRoom.add(new RoomTemperatureControl(new Room("Room 4", 26.1,90, new ProAirConditioner())));

        double expectedTemp = 21;

        coolAll(controlRoom, expectedTemp);


    }
    private static void coolAll(List<RoomTemperatureControl> rooms, double expectedTemp) throws InterruptedException {
        long count;
        rooms.forEach(r -> r.powerOn());
        do {
            rooms.forEach(r -> {
                r.coolRoom(expectedTemp);
                System.out.println(r.info());

            });
            count = rooms.stream().filter(r -> r.getAc().isPowerOn()).count();
            System.out.println();
            Thread.sleep(1000);
        } while (count > 0);

    }

}
