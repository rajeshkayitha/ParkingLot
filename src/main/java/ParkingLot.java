public class ParkingLot {
    private static final int TOTAL_NO_OF_SLOTS=3;
    private int occupiedSlots=0;
    public ParkingLot(int occupiedSlots){
        this.occupiedSlots = occupiedSlots;
    }
    public String occupancyOfParkingSlots() {
        if(occupiedSlots<TOTAL_NO_OF_SLOTS)
        {
            occupiedSlots+=1;
            return "Parking Slot Occupied";
        }
        return "No Slot Available";
    }
}
