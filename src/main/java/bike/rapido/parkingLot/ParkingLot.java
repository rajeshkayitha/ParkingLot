package bike.rapido.parkingLot;

public class ParkingLot {
    private final int totalSlots;
    private int filledSlots = 0;

    public ParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
    }


    public String parksVehicle(Vehicle vehicle) {
        if (totalSlots > filledSlots) {
            if (vehicle.isVehicleParked()) {
                return "Vehicle already parked.";
            }
            else {
                vehicle.park();
                filledSlots += 1;
                if (filledSlots == totalSlots) {
                    return "Vehicle Parked. \n ParkingLot Is Full.";
                }
                return "Vehicle Parked.";
            }
            }
        else
            return "No Available Parking Slots";
    }


    public String unParksVehicle(Vehicle vehicle) {
        if (filledSlots > 0) {
            if(vehicle.isVehicleParked()) {
                filledSlots -= 1;
                vehicle.unPark();
                return "Vehicle UnParked.";
            }
            else {
                return "Vehicle not yet parked.";
            }
        } else
            return "All Slots Are Empty.";
    }

    public Boolean isLotFull() {
        if (filledSlots < totalSlots)
            return false;
        else
            return true;
    }
}

