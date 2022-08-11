package bike.rapido.parkingLot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;


public class ParkingAttendant {
    private final HashMap<Vehicle, ParkingLot> vehicleParkingLotHashMap = new HashMap<>();
    private final  ArrayList<ParkingLot> parkingLots;

    private ParkingStrategy parkingStrategy;

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingAttendant(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Optional<ParkingLot> parkTheVehicle(Vehicle car) {
       Optional<ParkingLot> parkingLotToPark = parkingStrategy.chooseParkingLotToPark(parkingLots);
       if(parkingLotToPark.isPresent()) {
           parkingLotToPark.get().parksVehicle(car);
           vehicleParkingLotHashMap.put(car, parkingLotToPark.get());
           return parkingLotToPark;
       }else{
           return Optional.empty();
       }
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
