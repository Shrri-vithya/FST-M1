package activities;

public class Activity3 {
    public static void main(String[] args) {
        double seconds = 1000000000;

        double EarthSeconds = 31557600;
        double MercurySeconds = 0.2408467;
        double VenusSeconds = 0.61519726;
        double MarsSeconds = 1.8808158;
        double JupiterSeconds = 11.862615;
        double SaturnSeconds = 29.447498;
        double UranusSeconds = 84.016846;
        double NeptuneSeconds = 164.79132;
        System.out.println("Your age in Earth is: "+ seconds/EarthSeconds);
        System.out.println("Your age in Mercury is: "+ seconds/EarthSeconds/MercurySeconds);
        System.out.println("Your age in Venus is: "+ seconds/EarthSeconds/VenusSeconds);
        System.out.println("Your age in Mars is: "+ seconds/EarthSeconds/MarsSeconds);
        System.out.println("Your age in Jupiter is: "+ seconds/EarthSeconds/JupiterSeconds);
        System.out.println("Your age in Saturn is: "+ seconds/EarthSeconds/SaturnSeconds);
        System.out.println("Your age in Uranus is: "+ seconds/EarthSeconds/UranusSeconds);
        System.out.println("Your age in Neptune is: "+ seconds/EarthSeconds/NeptuneSeconds);

    }
}
