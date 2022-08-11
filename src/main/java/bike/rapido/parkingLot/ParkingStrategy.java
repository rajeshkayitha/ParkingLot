package bike.rapido.parkingLot;

import java.util.ArrayList;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingLot> chooseParkingLotToPark(ArrayList<ParkingLot> parkingLots);
}
