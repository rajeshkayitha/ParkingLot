package bike.rapido.parkingLot;

public class ParkingLot {
    private int availableSlots;

    public ParkingLot(int availableSlots)
    {
        this.availableSlots = availableSlots;
    }

    public boolean checksSlotAvailability() {
        if(availableSlots>0)
            return true;
        else
            return false;
    }
    public String decrementsSlotAvailabilityByParkingVehicle() {
        if(checksSlotAvailability())
        {
            availableSlots -=1;
            return String.format("Vehicle Parked. Remaining Available Slots = %d", availableSlots);
        }
        else
            return "No Available Parking Slots";
    }


}

