package bike.rapido.parkingLot;

public class Owner {
    ParkingLot parkingLot;

    public Owner(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public boolean isLotFull()
    {
        return parkingLot.isLotFull();
    }
}
