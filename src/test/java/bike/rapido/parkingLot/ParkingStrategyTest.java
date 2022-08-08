package bike.rapido.parkingLot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingStrategyTest {

    private Vehicle car1;
    private Vehicle car2;

    @BeforeEach
    void setUp() {
        car1 = new Vehicle();
        car2 = new Vehicle();
    }
    @Test
    void shouldParkVehicleInMaxCapacityParkingLotWhenParkingAttendedAskedToParkTheVehicle() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);
        Vehicle car3 = new Vehicle();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLots);
        parkingAttendant.setParkingStrategy(new MaxCapacityParkingStrategy(parkingLots));
        parkingAttendant.parkTheVehicle(car1);
        parkingAttendant.parkTheVehicle(car2);

        Optional<ParkingLot> vehicleParkedIn = parkingAttendant.parkTheVehicle(car3);

        assertTrue(vehicleParkedIn.isPresent());
        assertEquals(parkingLot2,vehicleParkedIn.get());

    }
    @Test
    void shouldParkVehicleInFirstNonEmptyParkingLotWhenParkingAttendedAskedToParkTheVehicle() {
        ParkingLot parkingLot1 = new ParkingLot(3);
        ParkingLot parkingLot2 = new ParkingLot(3);
        Vehicle car3 = new Vehicle();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLots);
        parkingAttendant.setParkingStrategy(new FirstFreeFillingStrategy(parkingLots));
        parkingAttendant.parkTheVehicle(car1);
        parkingAttendant.parkTheVehicle(car2);

        Optional<ParkingLot> vehicleParkedIn = parkingAttendant.parkTheVehicle(car3);

        assertTrue(vehicleParkedIn.isPresent());
        assertEquals(parkingLot1,vehicleParkedIn.get());

    }

      @Test
      void shouldNotAllowToParkVehicleByParkingAttendedWhenAllLotsAreFull() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Vehicle car3 = new Vehicle();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLots);
        parkingAttendant.setParkingStrategy(new FirstFreeFillingStrategy(parkingLots));
        parkingAttendant.parkTheVehicle(car1);
        parkingAttendant.parkTheVehicle(car2);

        Optional<ParkingLot> vehicleParkedIn = parkingAttendant.parkTheVehicle(car3);

        assertFalse(vehicleParkedIn.isPresent());
    }

    @Test
    void shouldUnParkParkedVehicleWhenParkingAttendedAskedToUnParkVehicle() {
        int capacity = 1;
        ParkingLot parkingLot1 = new ParkingLot(capacity);
        ParkingLot parkingLot2 = new ParkingLot(capacity);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLots);
        parkingAttendant.setParkingStrategy(new FirstFreeFillingStrategy(parkingLots));
        parkingAttendant.parkTheVehicle(car1);

        boolean isVehicleUnParked = parkingAttendant.UnParksTheVehicle(car1);

        assertTrue(isVehicleUnParked);
    }

    @Test
    void shouldNotAllowToUnParkVehicleWhichIsNotParkedYetByParkingAttended() {
        int capacity = 1;
        ParkingLot parkingLot1 = new ParkingLot(capacity);
        ParkingLot parkingLot2 = new ParkingLot(capacity);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingAttendant parkingAttendant = new ParkingAttendant(parkingLots);
        parkingAttendant.setParkingStrategy(new MaxCapacityParkingStrategy(parkingLots));
        parkingAttendant.parkTheVehicle(car1);

        boolean isVehicleUnParked = parkingAttendant.UnParksTheVehicle(car2);

        assertFalse(isVehicleUnParked);
    }
}
