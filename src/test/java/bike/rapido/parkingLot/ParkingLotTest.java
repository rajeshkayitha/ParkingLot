package bike.rapido.parkingLot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    private Owner owner;
    private SecurityPersonnel securityPersonnel;

    private Vehicle car1;
    private Vehicle car2;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        securityPersonnel = new SecurityPersonnel();
        car1 = new Vehicle();
        car2 = new Vehicle();
    }

    @Test
    void shouldAllowVehicleToParkWhenSlotIsAvailable() {
        int totalSlots = 2;

        boolean isVehicleParked = new ParkingLot(totalSlots).parksVehicle(car1);

        assertTrue(isVehicleParked);

    }

    @Test
    void shouldNotAllowVehicleToParkWhenSlotNotAvailable() {
        int totalSlots = 0;

        boolean isVehicleParked = new ParkingLot(totalSlots).parksVehicle(car1);

        assertFalse(isVehicleParked);

    }

    @Test
    void shouldNotAllowVehicleToParkAfterAllSlotsGetsFilled() {
        int totalSlots = 1;
        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car1);

        boolean isVehicleParked = parkingLot.parksVehicle(car2);

        assertFalse(isVehicleParked);
    }

    @Test
    void shouldNotAllowVehicleToParkWhenSameVehicleAskedToParkAgain() {
        int totalSlots = 2;
        ParkingLot parkingLot = new ParkingLot(totalSlots);

        parkingLot.parksVehicle(car1);
        boolean isVehicleParked = parkingLot.parksVehicle(car1);

        assertFalse(isVehicleParked);
    }

    @Test
    void shouldAllowVehicleToUnParkIfTheVehicleIsAlreadyParked() {
        int totalSlots = 5;
        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.parksVehicle(car1);

        boolean isVehicleUnParked = parkingLot.unParksVehicle(car1);

        assertTrue(isVehicleUnParked);

    }

    @Test
    void shouldNotAllowVehicleToUnParkIfTheVehicleIsNotParkedYet() {
        int totalSlots = 2;
        ParkingLot parkingLot = new ParkingLot(totalSlots);

        parkingLot.parksVehicle(car1);
        boolean isVehicleUnParked = parkingLot.unParksVehicle(car2);

        assertFalse(isVehicleUnParked);
    }

    @Test
    void shouldNotifyOwnerWhenParkingLotIsFull() {
        int totalSlots = 2;
        ParkingLot parkingLot = new ParkingLot(totalSlots);
        parkingLot.addObserver(owner);
        parkingLot.parksVehicle(car1);

        boolean parkingStatus = parkingLot.parksVehicle(car2);
        boolean isNotifiedLotIsFull = owner.isLotFull();

        assertTrue(parkingStatus);
        assertTrue(isNotifiedLotIsFull);
    }

    @Test
    void shouldNotNotifyOwnerWhenParkingLotIsNotFull() {
        int totalSlots = 2;
        ParkingLot parkingLot = new ParkingLot(totalSlots);

        parkingLot.addObserver(owner);
        boolean parkingStatus = parkingLot.parksVehicle(car1);

        assertTrue(parkingStatus);
        assertFalse(owner.isLotFull());
    }

    @Test
    void shouldNotifySecurityPersonalWhenParkingLotIsFull() {
        int totalSlots = 2;
        ParkingLot parkingLot = new ParkingLot(totalSlots);

        parkingLot.parksVehicle(car1);
        parkingLot.addObserver(securityPersonnel);
        boolean parkingStatus = parkingLot.parksVehicle(car2);

        assertTrue(parkingStatus);
        assertTrue(securityPersonnel.isLotFull());
    }

    @Test
    void shouldNotNotifySecurityPersonalWhenParkingLotIsNotFull() {
        int totalSlots = 2;
        ParkingLot parkingLot = new ParkingLot(totalSlots);

        boolean parkingStatus = parkingLot.parksVehicle(car1);
        parkingLot.addObserver(securityPersonnel);

        assertTrue(parkingStatus);
        assertFalse(securityPersonnel.isLotFull());
    }

    @Test
    void shouldNotifyLotOwnerWhenParkingLotHasSpaceAgain() {
        int totalSlots = 1;
        ParkingLot parkingLot = new ParkingLot(totalSlots);

        parkingLot.parksVehicle(car1);
        parkingLot.addObserver(owner);
        boolean parkingStatus = parkingLot.unParksVehicle(car1);

        assertTrue(parkingStatus);
        assertTrue(owner.isParkingLotEmptyAgain());

    }

    @Test
    void shouldNotNotifyLotOwnerApartWhenLotHasSpaceAgain() {
        int totalSlots = 2;
        ParkingLot parkingLot = new ParkingLot(totalSlots);

        boolean parkingStatus = parkingLot.parksVehicle(car1);
        parkingLot.addObserver(owner);

        assertTrue(parkingStatus);
        assertFalse(owner.isParkingLotEmptyAgain());

    }

    @Test
    void shouldParkVehicleWhenParkingAttendedAskedToParkTheVehicle() {
        int totalSlots = 2;
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot = new ParkingLot(totalSlots);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(parkingLot);
        boolean parkingStatus = parkingAttendant.parksTheVehicle(parkingLots, car1);

        assertTrue(parkingStatus);

    }

    @Test
    void shouldParkVehicleInLotWithSlotsAvailableWhenParkingAttendedAskedToParkVehicle() {
        int totalSlots = 1;
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot1 = new ParkingLot(totalSlots);
        ParkingLot parkingLot2 = new ParkingLot(totalSlots);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingAttendant.parksTheVehicle(parkingLots, car1);
        boolean parkingStatus = parkingAttendant.parksTheVehicle(parkingLots, car2);

        assertTrue(parkingStatus);
    }

    @Test
    void shouldNotAllowToParkVehicleByParkingAttendedWhenAllLotsAreFull() {
        int totalSlots = 1;
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot1 = new ParkingLot(totalSlots);
        ParkingLot parkingLot2 = new ParkingLot(totalSlots);
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
        int totalSlots = 1;
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot1 = new ParkingLot(totalSlots);
        ParkingLot parkingLot2 = new ParkingLot(totalSlots);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingAttendant.parksTheVehicle(parkingLots, car1);
        boolean parkingStatus = parkingAttendant.UnParksTheVehicle(car1);

        assertTrue(parkingStatus);
    }

    @Test
    void shouldNotAllowToUnParkVehicleWhichIsNotParkedYetByParkingAttended() {
        int totalSlots = 1;
        ParkingAttendant parkingAttendant = new ParkingAttendant();
        ParkingLot parkingLot1 = new ParkingLot(totalSlots);
        ParkingLot parkingLot2 = new ParkingLot(totalSlots);
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();

        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingAttendant.parksTheVehicle(parkingLots, car1);
        boolean parkingStatus = parkingAttendant.UnParksTheVehicle(car2);

        assertFalse(parkingStatus);
    }
}