package bike.rapido.parkingLot;

import java.util.ArrayList;
import java.util.Optional;

public class MaxCapacityParkingStrategy implements ParkingStrategy{

    @Override
    public Optional<ParkingLot> chooseParkingLotToPark(ArrayList<ParkingLot> parkingLots) {
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
