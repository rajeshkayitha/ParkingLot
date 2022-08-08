package bike.rapido.parkingLot;

import java.util.ArrayList;
import java.util.Optional;

public class FirstFreeFillingStrategy implements ParkingStrategy {
    private ArrayList<ParkingLot> parkingLots;

    public FirstFreeFillingStrategy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    @Override
    public Optional<ParkingLot> chooseParkingLotToPark() {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getCapacity() > 0) {
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }
}
