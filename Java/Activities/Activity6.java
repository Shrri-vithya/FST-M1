package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    public Plane(int maxPassengers){
        this.maxPassengers=maxPassengers;
        this.passengers=new ArrayList<>();
    }
    public void onboard(String passenger){
        this.passengers.add(passenger);
    }
    public Date land(){
        this.lastTimeLanded=new Date();
        this.passengers.clear();
        return lastTimeLanded;
    }
    public Date takeOff(){
        this.lastTimeTookOf=new Date();
        return lastTimeTookOf;
    }
    public Date getLastTimeLanded(){
        return lastTimeLanded;
    }
    public List<String> getPassengers(){
        return passengers;
    }
}
public class Activity6 {
    public static void main(String[] args) throws InterruptedException{
        Plane plane=new Plane(10);
        plane.onboard("passenger1");
        plane.onboard("passenger2");
        plane.onboard("passenger3");
        System.out.println("Take off time:" + plane.takeOff());
        System.out.println("passengers list:" + plane.getPassengers());
        Thread.sleep(5000);
        System.out.println("The landed time:"+ plane.land());

    }
}
