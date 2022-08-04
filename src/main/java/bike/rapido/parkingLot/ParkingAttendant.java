package bike.rapido.parkingLot;

import java.util.ArrayList;

public class ParkingAttendant {


    public boolean parksTheVehicle(ArrayList<ParkingLot> parkingLots, Vehicle car1) {
        for (ParkingLot parkingLot : parkingLots) {
            boolean isVehicleParked = parkingLot.parksVehicle(car1);
            if (isVehicleParked) {
                car1.parkingIn(parkingLot);
                return true;
            }
        }
        return false;
    }

    public boolean UnParksTheVehicle(Vehicle car) {
        if (car.isVehicleParked()) {
            ParkingLot parkingLot = car.parkedIn();
            return parkingLot.unParksVehicle(car);
        } else
            return false;
    }
}
