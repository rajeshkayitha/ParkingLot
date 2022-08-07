package bike.rapido.parkingLot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingAttendedTest {

    private Vehicle car1;
    private Vehicle car2;

    @BeforeEach
    void setUp() {
        car1 = new Vehicle();
        car2 = new Vehicle();
    }
    @Test
    void shouldParkVehicleInMaxCapacityParkingLotWhenParkingAttendedAskedToParkTheVehicle() {
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(3);
        Vehicle car3 = new Vehicle();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingAttendant.parksTheVehicle(parkingLots,car1);
        parkingAttendant.parksTheVehicle(parkingLots,car2);

        ParkingLot vehicleParkedIn = parkingAttendant.parksTheVehicle(parkingLots, car3);

        assertEquals(parkingLot2,vehicleParkedIn);

    }

      @Test
      void shouldNotAllowToParkVehicleByParkingAttendedWhenAllLotsAreFull() {
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Vehicle car3 = new Vehicle();
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingAttendant.parksTheVehicle(parkingLots, car1);
        parkingAttendant.parksTheVehicle(parkingLots, car2);

        ParkingLot vehicleParkedIn = parkingAttendant.parksTheVehicle(parkingLots, car3);

        assertNull(vehicleParkedIn);
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
