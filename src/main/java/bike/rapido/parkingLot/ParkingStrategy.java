package bike.rapido.parkingLot;

import java.util.Optional;

public interface ParkingStrategy {
    public Optional<ParkingLot> chooseParkingLotToPark();
}
