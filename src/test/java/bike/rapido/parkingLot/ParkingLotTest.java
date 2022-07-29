package bike.rapido.parkingLot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingLotTest {

    ParkingLot parkingLot;
    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot();
    }

    @Test
    void shouldReturnVehicleParkedIfOccupiedSlotsDoesNotExceedTotalParkingSlots() {

        String parkingStatus = parkingLot.checksAvailabilityAndParksVehicle();

        assertEquals("Vehicle Parked", parkingStatus);

    }


    @Test
    void shouldReturnNoParkingSlotAvailableWhenOccupiedSlotsEqualsTotalParkingSlots() {

        parkingLot.checksAvailabilityAndParksVehicle();
        parkingLot.checksAvailabilityAndParksVehicle();
        parkingLot.checksAvailabilityAndParksVehicle();
        String parkingStatus =  parkingLot.checksAvailabilityAndParksVehicle();

        assertEquals("No Parking Slot Available", parkingStatus);

    }
}