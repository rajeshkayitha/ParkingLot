package bike.rapido.parkingLot;

import bike.rapido.parkingLot.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingLotTest {

    @Test
    void shouldReturnTrueIfSlotsAvailableGreaterThan0() {
        int slotsAvailable = 4;
        boolean isSlotAvailable = new ParkingLot(slotsAvailable).checksSlotAvailability();

        assertEquals(true, isSlotAvailable);
    }

    @Test
    void shouldReturnFalseIfSlotsAvailableEquals0() {
        int slotsAvailable = 0;
        boolean isSlotAvailable = new ParkingLot(slotsAvailable).checksSlotAvailability();

        assertEquals(false, isSlotAvailable);
    }

    @Test
    void shouldReturnVehicleParkedAndSlotAvailabilityWhenGreaterThan0() {
        int slotsAvailable = 2;
        String parkingStatus =new ParkingLot(slotsAvailable).decrementsSlotAvailabilityByParkingVehicle();

        assertEquals("Vehicle Parked. Remaining Available Slots = 1", parkingStatus);

    }

    @Test
    void shouldReturnNoAvailabilityParkingSlotWhenSlotsAvailableEquals0() {
        int slotsAvailable = 0;

        String parkingStatus =new ParkingLot(slotsAvailable).decrementsSlotAvailabilityByParkingVehicle();

        assertEquals("No Available Parking Slots", parkingStatus);

    }

    @Test
    void shouldReturnNoAvailableParkingSlotForSecondCarWhenSlotsAvailableEquals1() {
        int slotsAvailable = 1;

        ParkingLot parkingLot=new ParkingLot(slotsAvailable);
        parkingLot.decrementsSlotAvailabilityByParkingVehicle();                        //FirstCar
        String parkingStatus = parkingLot.decrementsSlotAvailabilityByParkingVehicle();

        assertEquals("No Available Parking Slots", parkingStatus);

    }
}