package activities;

interface BicycleParts {
    public int gears=0;
    public int speed=0;
}
interface BicycleOperations {
        public int applyBrake(int decrement);
        public int speedUp(int increment);
    }

class Bicycle implements BicycleParts, BicycleOperations{
    public int gears;
    public int currentSpeed;
    public Bicycle(int gears,int currentSpeed){
        this.gears=gears;
        this.currentSpeed=currentSpeed;
    }
    public int applyBrake(int decrement) {
        return currentSpeed-=decrement;
    }
    public int speedUp(int increment) {
        return currentSpeed+=increment;
    }
    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
    }
}
class MountainBike extends Bicycle{
    public int seatHeight;
    public MountainBike(int gears,int currentSpeed,int seatHeight){
        super(gears,currentSpeed);
        this.seatHeight=seatHeight;
    }

    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    public String bicycleDesc() {
        return(super.bicycleDesc()+"\nSeat Height is "+ seatHeight );
    }
}

public class Activity7 {
    public static void main(String args[]) {
        MountainBike mb = new MountainBike(3, 0, 25);
        System.out.println(mb.bicycleDesc());
        System.out.println("after brake speed:" + mb.speedUp(20));
        System.out.println("after speed up :" + mb.applyBrake(5));
    }
}
