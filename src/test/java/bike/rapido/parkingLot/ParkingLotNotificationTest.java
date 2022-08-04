package bike.rapido.parkingLot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class ParkingLotNotificationTest {

    private Vehicle car1;
    private Vehicle car2;

    @BeforeEach
    void setUp() {
        car1 = new Vehicle();
        car2 = new Vehicle();
    }

    @Test
    void shouldNotifyOwnerWhenParkingLotIsFull() {
        int capacity = 2;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Owner ownerMock = Mockito.mock(Owner.class);
        parkingLot.addObserver(ownerMock);
        parkingLot.parksVehicle(car1);

        boolean isVehicleParked = parkingLot.parksVehicle(car2);

        assertTrue(isVehicleParked);
        verify(ownerMock).notifyParkingLotIsFull();
    }

    @Test
    void shouldNotNotifyOwnerWhenParkingLotIsNotFull() {
        int capacity = 2;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Owner ownerMock = Mockito.mock(Owner.class);
        parkingLot.addObserver(ownerMock);

        boolean isVehicleParked = parkingLot.parksVehicle(car1);

        assertTrue(isVehicleParked);
        verify(ownerMock,never()).notifyParkingLotIsFull();
    }

    @Test
    void shouldNotifySecurityPersonalWhenParkingLotIsFull() {
        int capacity = 2;
        ParkingLot parkingLot = new ParkingLot(capacity);
        SecurityPersonnel securityPersonnelMock = Mockito.mock(SecurityPersonnel.class);
        parkingLot.addObserver(securityPersonnelMock);
        parkingLot.parksVehicle(car1);

        boolean isVehicleParked = parkingLot.parksVehicle(car2);

        assertTrue(isVehicleParked);
        verify(securityPersonnelMock).notifyParkingLotIsFull();
    }

    @Test
    void shouldNotNotifySecurityPersonalWhenParkingLotIsNotFull() {
        int capacity = 2;
        ParkingLot parkingLot = new ParkingLot(capacity);
        SecurityPersonnel securityPersonnelMock = Mockito.mock(SecurityPersonnel.class);
        parkingLot.addObserver(securityPersonnelMock);

        boolean isVehicleParked = parkingLot.parksVehicle(car1);

        assertTrue(isVehicleParked);
        verify(securityPersonnelMock,never()).notifyParkingLotIsFull();
    }

    @Test
    void shouldNotifyLotOwnerWhenParkingLotHasSpaceAgain() {
        int capacity = 1;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Owner ownerMock = Mockito.mock(Owner.class);
        parkingLot.addObserver(ownerMock);
        parkingLot.parksVehicle(car1);

        boolean isVehicleUnParked = parkingLot.unParksVehicle(car1);


        assertTrue(isVehicleUnParked);
        verify(ownerMock).notifyParkingLotIsEmptyAgain();

    }

    @Test
    void shouldNotNotifyLotOwnerApartWhenLotHasSpaceAgain() {
        int capacity = 2;
        ParkingLot parkingLot = new ParkingLot(capacity);
        Owner ownerMock = Mockito.mock(Owner.class);
        parkingLot.addObserver(ownerMock);

        boolean isVehicleParked = parkingLot.parksVehicle(car1);



        assertTrue(isVehicleParked);
        verify(ownerMock,never()).notifyParkingLotIsEmptyAgain();

    }

}
