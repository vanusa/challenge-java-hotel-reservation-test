import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class HotelReservationUtil {

    public static PriceRatingEnum getRating(String input) throws HotelReservationException {
        PriceRatingEnum ratingEnum;

        String rating = input.split(":")[0];

        if(rating.equalsIgnoreCase("Regular") || rating.equalsIgnoreCase("Rewards")){
            ratingEnum = PriceRatingEnum.getByValue(StringUtils.capitalize(rating));
        } else {
            throw new HotelReservationException("Rating does not exists");
        }

        return ratingEnum;
    }

    public static List<LocalDate> getDates(String str) throws HotelReservationException {
        List<String> datesAsStringList = new ArrayList<>();
        List<LocalDate> dates = new ArrayList<>();

        String inputWithoutRating = removeRatingFromInputString(str);
        String[] datesAsStringArray = inputWithoutRating.split(",");

        datesAsStringList = Arrays.asList(datesAsStringArray);
        datesAsStringList.replaceAll(String::trim);

        dates = getLocalDatesFromStringList(datesAsStringList);

        return dates;
    }

    public static Boolean isWeekend(LocalDate date){
        switch (date.getDayOfWeek()) {
            case SATURDAY:
                return Boolean.TRUE;
            case SUNDAY:
                return Boolean.TRUE;
            default:
                return Boolean.FALSE;
        }
    }
    private static List<LocalDate> getLocalDatesFromStringList(List<String> datesAsStringList) throws HotelReservationException {
        List<LocalDate> dates = new ArrayList<>();

        for (String dtStr : datesAsStringList) {
            LocalDate date;
            dtStr = removeDayOfWeekFromString(dtStr);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy", new Locale("en", "US"));
            if(dtStr.matches("\\d{1,2}\\w{3}\\d{4}")) {
                date = LocalDate.parse(dtStr, formatter);
            } else {
                throw new HotelReservationException("This date format is not valid: " + dtStr);
            }

            dates.add(date);
        }
        return dates;
    }

    private static String removeDayOfWeekFromString(String str) {
        str = str.substring(0, str.indexOf("("));
        return str;
    }

    private static String removeRatingFromInputString(String str) {
        String inputWithoutRating = str.substring(str.indexOf(":") + 1);
        return inputWithoutRating;
    }

}
