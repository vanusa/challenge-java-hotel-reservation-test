import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotelReservation {
    public String getCheapestHotel(String input) {
        PriceRatingEnum rating = null;
        Integer totalPriceLakewood = 0;
        Integer totalPriceBridgewood = 0;
        Integer totalPriceRidgewood = 0;
        List<Hotel> hotels = new ArrayList<>();
        Hotel cheapestHotel = new Hotel();

        try {
            rating = HotelReservationUtil.getRating(input);
            List<LocalDate> dates = HotelReservationUtil.getDates(input);

            Hotel lakewoodHotel = new Hotel(HotelEnum.LAKEWOOD);
            Hotel bridgewoodHotel = new Hotel(HotelEnum.BRIDGEWOOD);
            Hotel ridgewoodHotel = new Hotel(HotelEnum.RIDGEWOOD);

            for (LocalDate date : dates) {
                if (HotelReservationUtil.isWeekend(date)) {
                    switch (rating) {
                        case REGULAR:
                            totalPriceLakewood += lakewoodHotel.getRegularPrice().getWeekendPrice();
                            totalPriceBridgewood += bridgewoodHotel.getRegularPrice().getWeekendPrice();
                            totalPriceRidgewood += ridgewoodHotel.getRegularPrice().getWeekendPrice();
                        case REWARDS:
                            totalPriceLakewood += lakewoodHotel.getRewardsPrice().getWeekendPrice();
                            totalPriceBridgewood += bridgewoodHotel.getRewardsPrice().getWeekendPrice();
                            totalPriceRidgewood += ridgewoodHotel.getRewardsPrice().getWeekendPrice();
                    }
                } else {
                    switch (rating) {
                        case REGULAR:
                            totalPriceLakewood += lakewoodHotel.getRegularPrice().getWeekdayPrice();
                            totalPriceBridgewood += bridgewoodHotel.getRegularPrice().getWeekdayPrice();
                            totalPriceRidgewood += ridgewoodHotel.getRegularPrice().getWeekdayPrice();
                        case REWARDS:
                            totalPriceLakewood += lakewoodHotel.getRewardsPrice().getWeekdayPrice();
                            totalPriceBridgewood += bridgewoodHotel.getRewardsPrice().getWeekdayPrice();
                            totalPriceRidgewood += ridgewoodHotel.getRewardsPrice().getWeekdayPrice();
                    }
                }
            }

            lakewoodHotel.setTotal(totalPriceLakewood);
            bridgewoodHotel.setTotal(totalPriceBridgewood);
            ridgewoodHotel.setTotal(totalPriceRidgewood);

            hotels.add(lakewoodHotel);
            hotels.add(bridgewoodHotel);
            hotels.add(ridgewoodHotel);

            Comparator<Hotel> totalPriceComparator = (o1, o2) -> Integer.compare(o1.getTotal(), o2.getTotal());
            Comparator<Hotel> bestClassificationComparator = (o1, o2) -> Integer.compare(o2.getClassification(), o1.getClassification());

            cheapestHotel = hotels.stream().min(totalPriceComparator.thenComparing(bestClassificationComparator)).get();

        } catch (HotelReservationException e) {
            e.printStackTrace();
        }

        return cheapestHotel.getHotelName();
    }
}
