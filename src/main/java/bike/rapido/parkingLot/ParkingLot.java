package bike.rapido.parkingLot;

public class ParkingLot {
    private static final int TOTAL_NO_OF_SLOTS=3;
    private int occupiedSlots=0;
    public String checksAvailabilityAndParksVehicle() {
        if(occupiedSlots<TOTAL_NO_OF_SLOTS)
        {
            occupiedSlots+=1;
            return "Vehicle Parked";
        }
        else
            return "No Parking Slot Available";
    }

}

