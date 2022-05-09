public class Hotel {
    private String hotelName;
    private Integer classification;
    private RegularPrice regularPrice;
    private RewardsPrice rewardsPrice;
    private Integer total;

    public Hotel(HotelEnum hotelEnum) {
        this.hotelName = hotelEnum.getName();
        this.classification = hotelEnum.getClassification();
        this.regularPrice = new RegularPrice(hotelEnum.getRegularWeekdayPrice(), hotelEnum.getRegularWeekendPrice());
        this.rewardsPrice = new RewardsPrice(hotelEnum.getRewardsWeekdayPrice(), hotelEnum.getRewardsWeekendPrice());
    }

    public Hotel() {

    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public RegularPrice getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(RegularPrice regularPrice) {
        this.regularPrice = regularPrice;
    }

    public RewardsPrice getRewardsPrice() {
        return rewardsPrice;
    }

    public void setRewardsPrice(RewardsPrice rewardsPrice) {
        this.rewardsPrice = rewardsPrice;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
