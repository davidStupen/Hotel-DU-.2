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

    public BigDecimal getPrice() {
        return price;
    }

    public int getNumRoom() {
        return numRoom;
    }
}
