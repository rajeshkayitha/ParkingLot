package bike.rapido.parkingLot;

import java.util.ArrayList;
import java.util.Optional;

public class MaxCapacityParkingStrategy implements ParkingStrategy{

    private ArrayList<ParkingLot> parkingLots;

    public MaxCapacityParkingStrategy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Optional<ParkingLot> chooseParkingLotToPark() {
        int maxCapacityOfLots = 0;
        ParkingLot lotWithMaxCapacity=null;
        for(ParkingLot parkingLot: parkingLots){
            if(maxCapacityOfLots<parkingLot.getCapacity()){
                maxCapacityOfLots=parkingLot.getCapacity();
                lotWithMaxCapacity = parkingLot;
            }
        }
        return Optional.ofNullable(lotWithMaxCapacity);
    }
}
