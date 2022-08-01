package bike.rapido.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void shouldReturnVehicleParkedWhenSlotAvailable() {
        int totalSlots = 2;
        Vehicle car = new Vehicle();


        String parkingStatus = new ParkingLot(totalSlots).parksVehicle(car);

        assertEquals("Vehicle Parked.", parkingStatus);

    }

    @Test
    void shouldReturnNoAvailabilityParkingSlotWhenSlotNotAvailable() {
        int totalSlots = 0;
        Vehicle bike = new Vehicle();

        String parkingStatus = new ParkingLot(totalSlots).parksVehicle(bike);

        assertEquals("No Available Parking Slots", parkingStatus);

    }

    @Test
    void shouldReturnNoAvailableParkingSlotForSecondCarWhenTotalSlotsEquals1() {
        int totalSlots = 1;
        Vehicle car = new Vehicle();
        Vehicle bike = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);                        //FirstCar
        String parkingStatus = parkingLot.parksVehicle(bike);

        assertEquals("No Available Parking Slots", parkingStatus);

    }

    @Test
    void shouldReturnVehicleUnParkedWhenThereIsParkedVehicle() {
        int totalSlots = 5;
        Vehicle car = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);                         //Vehicle Parked
        String parkingStatus = parkingLot.unParksVehicle(car);

        assertEquals("Vehicle UnParked.", parkingStatus);

    }

    @Test
    void shouldReturnAllSlotsAreEmptyWhenNoVehicleIsParked() {
        int totalSlots = 2;
        Vehicle car = new Vehicle();

        String parkingStatus = new ParkingLot(totalSlots).unParksVehicle(car);

        assertEquals("All Slots Are Empty.", parkingStatus);

    }


    @Test
    void shouldNotAllowVehicleToParkedWhenSameVehicleAskedToParkAgain() {
        int totalSlots=2;
        Vehicle car = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);
        String parkingStatus = parkingLot.parksVehicle(car);

        assertEquals("Vehicle already parked." , parkingStatus);
    }

    @Test
    void shouldNotAllowVehicleToUnParkWhenNotParkedVehicleAskedToUnParkWithNoEmptySlots() {
        int totalSlots=2;
        Vehicle car = new Vehicle();
        Vehicle auto = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);
        String parkingStatus = parkingLot.unParksVehicle(auto);

        assertEquals("Vehicle not yet parked." , parkingStatus);
    }

    @Test
    void shouldReturnSlotIsFullWhenAllSlotsAreFilled() {
        int totalSlots = 3;
        Vehicle car = new Vehicle();
        Vehicle bike = new Vehicle();
        Vehicle auto = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);
        parkingLot.parksVehicle(bike);
        String parkingStatus = parkingLot.parksVehicle(auto);

        assertEquals("Vehicle Parked. \n ParkingLot Is Full." , parkingStatus);
    }

    @Test
    void shouldReturnTrueIfParkingLotIsFull() {
        int totalSlots = 3;
        Vehicle car = new Vehicle();
        Vehicle bike = new Vehicle();
        Vehicle auto = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);
        parkingLot.parksVehicle(bike);
        parkingLot.parksVehicle(auto);
        Boolean expectedStatus = parkingLot.isLotFull();

        assertTrue(expectedStatus);
    }

    @Test
    void shouldReturnFalseIfLotIsNotFull() {
        int totalSlots = 3;
        Vehicle car = new Vehicle();
        Vehicle bike = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);
        parkingLot.parksVehicle(bike);
        Boolean expectedStatus = parkingLot.isLotFull();

        assertFalse(expectedStatus);

    }

}