import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void ReturnsSlotAvailabilityIfOccupiedSlotsDoesNotExceedTotalParkingSlots() {
        int occupiedSlots=1;
        String isSlotOccupied = new ParkingLot(occupiedSlots).occupancyOfParkingSlots();


        assertEquals("Parking Slot Occupied", isSlotOccupied );

    }

    @Test
    void ReturnsNoSlotAvailableIfOccupiedSlotsEqualsTotalParkingSlots() {
        int occupiedSlots=3;
        String isSlotOccupied = new ParkingLot(occupiedSlots).occupancyOfParkingSlots();


        assertEquals("No Slot Available", isSlotOccupied );

    }
}