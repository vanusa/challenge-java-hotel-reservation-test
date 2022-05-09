import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HotelReservation reservation = new HotelReservation();

        //String input = "Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)";
        System.out.println("Type in the Price Rating and dates");
        String input = scan.nextLine();

        System.out.println(reservation.getCheapestHotel(input));
    }
}
