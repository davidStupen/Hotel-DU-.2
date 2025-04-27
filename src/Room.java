import java.math.BigDecimal;

public class Room {
    private int numRoom;
    private int numBed;
    private BigDecimal price;
    private boolean haveBalcony;
    private boolean haveSeaView;
    public Room(int numRoom, int numBed, BigDecimal price, boolean haveBalcony, boolean haveSeaView){
        this.numRoom = numRoom;
        this.numBed = numBed;
        this.price = price;
        this.haveBalcony = haveBalcony;
        this.haveSeaView = haveSeaView;
    }

    public boolean isHaveSeaView() {
        return haveSeaView;
    }

    public void setHaveSeaView(boolean haveSeaView) {
        this.haveSeaView = haveSeaView;
    }

    public boolean isHaveBalcony() {
        return haveBalcony;
    }

    public void setHaveBalcony(boolean haveBalcony) {
        this.haveBalcony = haveBalcony;
    }

    public int getNumBed() {
        return numBed;
    }

    public void setNumBed(int numBed) {
        this.numBed = numBed;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }
}
