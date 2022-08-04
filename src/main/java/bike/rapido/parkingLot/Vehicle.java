package bike.rapido.parkingLot;

public class Vehicle {
    private boolean isParked = false;
    private ParkingLot parkedIn;

    public ParkingLot parkedIn() {
        return parkedIn;
    }

    public void parkingIn(ParkingLot parkingLot) {
        this.parkedIn = parkingLot;
    }

    public boolean isVehicleParked() {

        return isParked;
    }

    public void park() {
        isParked = true;
    }

    public void unPark() {
        isParked = false;
    }
}