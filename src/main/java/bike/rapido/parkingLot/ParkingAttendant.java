package bike.rapido.parkingLot;

import java.util.ArrayList;
import java.util.HashMap;


public class ParkingAttendant {
    private final HashMap<Vehicle, ParkingLot> vehicleParkingLotHashMap = new HashMap<>();

    public ParkingLot parksTheVehicle(ArrayList<ParkingLot> parkingLots, Vehicle car) {
        ParkingLot lotWithMaximumCapacity = getMaximumCapacityParkingLot(parkingLots);
        if(lotWithMaximumCapacity!=null) {
            lotWithMaximumCapacity.parksVehicle(car);
            vehicleParkingLotHashMap.put(car, lotWithMaximumCapacity);
            return lotWithMaximumCapacity;
        }
        else return null;
    }


    private ParkingLot getMaximumCapacityParkingLot(ArrayList<ParkingLot> parkingLots) {
        int maxCapacityOfLots = 0;
        ParkingLot lotWithMaxCapacity=null;
        for(ParkingLot parkingLot:parkingLots){
            if(maxCapacityOfLots<parkingLot.getCapacity()){
                maxCapacityOfLots=parkingLot.getCapacity();
                lotWithMaxCapacity = parkingLot;
            }
        }
        return lotWithMaxCapacity;
    }

    public boolean UnParksTheVehicle(Vehicle car) {
        if (vehicleParkingLotHashMap.containsKey(car)) {
            ParkingLot parkingLot = vehicleParkingLotHashMap.get(car);
            vehicleParkingLotHashMap.remove(car);
            return parkingLot.unParksVehicle(car);
        } else
            return false;
    }
}
