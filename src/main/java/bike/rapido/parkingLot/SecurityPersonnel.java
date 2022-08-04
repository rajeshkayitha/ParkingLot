package bike.rapido.parkingLot;

public class SecurityPersonnel implements ParkingLotObserver {

    private boolean isParkingLotFull = false;

    public boolean isLotFull() {

        return isParkingLotFull;
    }

    public void notifyParkingLotIsFull() {
        isParkingLotFull = true;
    }

    public void notifyParkingLotIsEmptyAgain() {

    }
}
