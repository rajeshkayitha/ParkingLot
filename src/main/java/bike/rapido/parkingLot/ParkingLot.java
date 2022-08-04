package bike.rapido.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot  {
    private final int totalSlots;
    private int filledSlots = 0;

    private final List<ParkingLotObserver> observerList = new ArrayList<>();

    public ParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public void addObserver(ParkingLotObserver observer) {
        observerList.add(observer);
    };

    public void removeObserver(ParkingLotObserver observer){
        observerList.remove(observer);
    }

    public boolean parksVehicle(Vehicle vehicle) {
        if (!isLotFull() && !vehicle.isVehicleParked()) {
            incrementFilledSlots();
            vehicle.park();
            notifyLotIsFull();
            return true;
        } else
            return false;
    }


    public boolean unParksVehicle(Vehicle vehicle) {
        if (!isLotEmpty() && vehicle.isVehicleParked()) {
            if(isLotFull())
            {
                notifyLotIsEmptyAgain();
            }
            decrementFilledSlots();
            vehicle.unPark();

            return true;
        } else
            return false;
    }

    private void notifyLotIsEmptyAgain() {
        for (ParkingLotObserver parkingLotObserver : observerList)
        {
            parkingLotObserver.notifyParkingLotIsEmptyAgain();
        }
    }

    private boolean isLotEmpty() {
        if (filledSlots == 0) {
            return true;
        } else
            return false;
    }

    private boolean isLotFull() {
        if (filledSlots < totalSlots)
            return false;
        else
            return true;
    }

    private void incrementFilledSlots() {
        filledSlots++;
    }

    private void decrementFilledSlots() {
        filledSlots--;
    }

    private void notifyLotIsFull() {
        if (isLotFull()) {
            for (ParkingLotObserver parkingLotObserver : observerList)
            {
                parkingLotObserver.notifyParkingLotIsFull();
            }
        }
    }

}

