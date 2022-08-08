package bike.rapido.parkingLot;

public class Owner implements ParkingLotObserver {



    public void notifyParkingLotIsFull() {
        System.out.println("Put full sign board");
    }


    public void notifyParkingLotIsEmptyAgain(){
        System.out.println("Take out full sign board");
    }
}
