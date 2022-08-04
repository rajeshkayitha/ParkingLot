package bike.rapido.parkingLot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingAttendedTest {

    private Vehicle car1;
    private Vehicle car2;

    @BeforeEach
    void setUp() {
        car1 = new Vehicle();
        car2 = new Vehicle();
    }
    @Test
    void shouldParkVehicleWhenParkingAttendedAskedToParkTheVehicle() {
        int capacity = 2;
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot = new ParkingLot(capacity);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(parkingLot);
        boolean parkingStatus = parkingAttendant.parksTheVehicle(parkingLots, car1);

        assertTrue(parkingStatus);

    }

    @Test
    void shouldParkVehicleInLotWithSlotsAvailableWhenParkingAttendedAskedToParkVehicle() {
        int capacity = 1;
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot1 = new ParkingLot(capacity);
        ParkingLot parkingLot2 = new ParkingLot(capacity);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingAttendant.parksTheVehicle(parkingLots, car1);
        boolean parkingStatus = parkingAttendant.parksTheVehicle(parkingLots, car2);

        assertTrue(parkingStatus);
    }

    @Test
    void shouldNotAllowToParkVehicleByParkingAttendedWhenAllLotsAreFull() {
        int capacity = 1;
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot1 = new ParkingLot(capacity);
        ParkingLot parkingLot2 = new ParkingLot(capacity);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        Vehicle car3 = new Vehicle();

        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingAttendant.parksTheVehicle(parkingLots, car1);
        parkingAttendant.parksTheVehicle(parkingLots, car2);
        boolean parkingStatus = parkingAttendant.parksTheVehicle(parkingLots, car3);

        assertFalse(parkingStatus);
    }

    @Test
    void shouldUnParkParkedVehicleWhenParkingAttendedAskedToUnParkVehicle() {
        int capacity = 1;
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot1 = new ParkingLot(capacity);
        ParkingLot parkingLot2 = new ParkingLot(capacity);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingAttendant.parksTheVehicle(parkingLots, car1);
        boolean parkingStatus = parkingAttendant.UnParksTheVehicle(car1);

        assertTrue(parkingStatus);
    }

    @Test
    void shouldNotAllowToUnParkVehicleWhichIsNotParkedYetByParkingAttended() {
        int capacity = 1;
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot1 = new ParkingLot(capacity);
        ParkingLot parkingLot2 = new ParkingLot(capacity);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingAttendant.parksTheVehicle(parkingLots, car1);
        boolean parkingStatus = parkingAttendant.UnParksTheVehicle(car2);

        assertFalse(parkingStatus);
    }
}
