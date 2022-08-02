package bike.rapido.parkingLot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    private Owner owner;
    private  SecurityPersonnel securityPersonnel;

    @BeforeEach
    void setUp() {
        owner = new Owner();
       securityPersonnel = new SecurityPersonnel();
    }

    @Test
    void shouldAllowVehicleToParkWhenSlotAvailable() {
        int totalSlots = 2;
        Vehicle car = new Vehicle();


        boolean parkingStatus = new ParkingLot(totalSlots).parksVehicle(car);

        assertTrue(parkingStatus);

    }

    @Test
    void shouldNotAllowVehicleToParkWhenSlotNotAvailable() {
        int totalSlots = 0;
        Vehicle bike = new Vehicle();

        boolean parkingStatus = new ParkingLot(totalSlots).parksVehicle(bike);

        assertFalse(parkingStatus);

    }

    @Test
    void shouldNotAllowSecondVehicleToParkWhenTotalSlotsEquals1() {
        int totalSlots = 1;
        Vehicle car = new Vehicle();
        Vehicle bike = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);                        //FirstCar
        boolean parkingStatus = parkingLot.parksVehicle(bike);

        assertFalse(parkingStatus);
    }

    @Test
    void shouldAllowVehicleToUnParkIfTheVehicleIsAlreadyParked() {
        int totalSlots = 5;
        Vehicle car = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);                         //Vehicle Parked
        boolean parkingStatus = parkingLot.unParksVehicle(car);

        assertTrue(parkingStatus);

    }

    @Test
    void shouldNotAllowVehicleToUnParkWhenNoSlotIsFilled() {
        int totalSlots = 2;
        Vehicle car = new Vehicle();

        boolean parkingStatus = new ParkingLot(totalSlots).unParksVehicle(car);

       assertFalse(parkingStatus);

    }


    @Test
    void shouldNotAllowVehicleToParkWhenSameVehicleAskedToParkAgain() {
        int totalSlots=2;
        Vehicle car = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);
        boolean parkingStatus = parkingLot.parksVehicle(car);

       assertFalse(parkingStatus);
    }

    @Test
    void shouldNotAllowVehicleToUnParkIfTheVehicleNotParkedYet() {
        int totalSlots=2;
        Vehicle car = new Vehicle();
        Vehicle auto = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);
        boolean parkingStatus = parkingLot.unParksVehicle(auto);

        assertFalse(parkingStatus);
    }

    @Test
    void shouldNotifyOwnerWhenParkingLotIsFull() {
        int totalSlots=2;
        Vehicle car = new Vehicle();
        Vehicle auto = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.addObserver(owner);
        parkingLot.parksVehicle(car);
        boolean parkingStatus = parkingLot.parksVehicle(auto);

        assertTrue(parkingStatus);
        assertTrue(owner.isLotFull());
    }

    @Test
    void shouldNotNotifyOwnerWhenParkingLotIsNotFull() {
        int totalSlots=2;
        Vehicle car = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.addObserver(owner);
        boolean parkingStatus = parkingLot.parksVehicle(car);

        assertTrue(parkingStatus);
        assertFalse(owner.isLotFull());
    }

    @Test
    void shouldNotifySecurityPersonalWhenParkingLotIsFull() {
        int totalSlots=2;
        Vehicle car = new Vehicle();
        Vehicle auto = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);
        parkingLot.addObserver(securityPersonnel);
        boolean parkingStatus = parkingLot.parksVehicle(auto);

        assertTrue(parkingStatus);
        assertTrue(securityPersonnel.isLotFull());
    }

    @Test
    void shouldNotNotifySecurityPersonalWhenParkingLotIsNotFull() {
        int totalSlots=2;
        Vehicle car = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        boolean parkingStatus = parkingLot.parksVehicle(car);
        parkingLot.addObserver(securityPersonnel);

        assertTrue(parkingStatus);
        assertFalse(securityPersonnel.isLotFull());
    }

    @Test
    void shouldNotifyLotOwnerWhenParkingLotHasSpaceAgain() {
        int totalSlots = 1;
        Vehicle car = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car);
        parkingLot.addObserver(owner);
        boolean parkingStatus = parkingLot.unParksVehicle(car);

        assertTrue(parkingStatus);
        assertTrue(owner.isParkingLotEmptyAgain());

    }

    @Test
    void shouldNotNotifyLotOwnerApartWhenLotHasSpaceAgain() {
        int totalSlots = 2;
        Vehicle car = new Vehicle();

        ParkingLot parkingLot = new ParkingLot(totalSlots);
        boolean parkingStatus = parkingLot.parksVehicle(car);
        parkingLot.addObserver(owner);

        assertTrue(parkingStatus);
        assertFalse(owner.isParkingLotEmptyAgain());

    }
}