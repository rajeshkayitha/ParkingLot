package bike.rapido.parkingLot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    private Vehicle car1;
    private Vehicle car2;

    @BeforeEach
    void setUp() {
        car1 = new Vehicle();
        car2 = new Vehicle();
    }

    @Test
    void shouldAllowVehicleToParkWhenSlotIsAvailable() {
        int capacity = 2;

        boolean isVehicleParked = new ParkingLot(capacity).parksVehicle(car1);

        assertTrue(isVehicleParked);

    }

    @Test
    void shouldNotAllowVehicleToParkAfterAllSlotsGetsFilled() {
        int capacity = 1;
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLot.parksVehicle(car1);

        boolean isVehicleParked = parkingLot.parksVehicle(car2);

        assertFalse(isVehicleParked);
    }

    @Test
    void shouldNotAllowVehicleToParkWhenSameVehicleAskedToParkAgain() {
        int capacity = 2;
        ParkingLot parkingLot = new ParkingLot(capacity);

        parkingLot.parksVehicle(car1);
        boolean isVehicleParked = parkingLot.parksVehicle(car1);

        assertFalse(isVehicleParked);
    }

    @Test
    void shouldAllowVehicleToUnParkIfTheVehicleIsAlreadyParked() {
        int capacity = 5;
        ParkingLot parkingLot = new ParkingLot(capacity);
        parkingLot.parksVehicle(car1);

        boolean isVehicleUnParked = parkingLot.unParksVehicle(car1);

        assertTrue(isVehicleUnParked);

    }

    @Test
    void shouldNotAllowVehicleToUnParkIfTheVehicleIsNotParkedYet() {
        int capacity = 2;
        ParkingLot parkingLot = new ParkingLot(capacity);

        parkingLot.parksVehicle(car1);
        boolean isVehicleUnParked = parkingLot.unParksVehicle(car2);

        assertFalse(isVehicleUnParked);
    }
}