package bike.rapido.parkingLot;

public interface ParkingLotObserver {

    void notifyParkingLotIsFull();

    void notifyParkingLotIsEmptyAgain();
}
