package bike.rapido.parkingLot;

public class SecurityPersonnel implements ParkingLotObserver {

    public void notifyParkingLotIsFull() {
        System.out.println("Redirect Security Staff");
    }

    public void notifyParkingLotIsEmptyAgain() {

    }
}
