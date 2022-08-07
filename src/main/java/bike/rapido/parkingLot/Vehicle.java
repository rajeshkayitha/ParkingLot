package bike.rapido.parkingLot;

public class Vehicle {
    private boolean isParked = false;


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