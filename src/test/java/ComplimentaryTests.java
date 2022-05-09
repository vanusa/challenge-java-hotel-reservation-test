import org.junit.Test;

public class ComplimentaryTests {
   @Test(expected = HotelReservationException.class)
   public void testANotValidRating() throws HotelReservationException {
       HotelReservationUtil.getRating("NOTVALIDRATING: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)");
   }

    @Test(expected = HotelReservationException.class)
    public void testANotValidDate() throws HotelReservationException {
        HotelReservationUtil.getDates("Regular: 16Mar09(mon)");
    }
}
