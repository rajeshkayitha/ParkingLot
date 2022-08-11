package bike.rapido.parkingLot;

import java.util.ArrayList;
import java.util.Optional;

public class FirstFreeFillingStrategy implements ParkingStrategy {

    @Override
    public Optional<ParkingLot> chooseParkingLotToPark(ArrayList<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getCapacity() > 0) {
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }
}
