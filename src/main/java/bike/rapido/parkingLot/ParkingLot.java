package bike.rapido.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot  {
    private int capacity;
    private final List<ParkingLotObserver> observerList = new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addObserver(ParkingLotObserver observer) {
        observerList.add(observer);
    };

    public void removeObserver(ParkingLotObserver observer){
        observerList.remove(observer);
    }

    public boolean parksVehicle(Vehicle vehicle) {
        if (!isLotFull() && !vehicle.isVehicleParked()) {
            decrementCapacity();
            vehicle.park();
            notifyLotIsFull();
            return true;
        } else
            return false;
    }


    public boolean unParksVehicle(Vehicle vehicle) {
        if (vehicle.isVehicleParked()) {
            if(isLotFull())
            {
                notifyLotIsEmptyAgain();
            }
            incrementCapacity();
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

    private boolean isLotFull() {
        if ( capacity==0)
            return true;
        else
            return false;
    }

    private void incrementCapacity() {
        capacity++;
    }

    private void decrementCapacity() {
        capacity--;
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

