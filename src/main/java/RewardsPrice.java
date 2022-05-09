public class RewardsPrice {
    private Integer weekdayPrice;
    private Integer weekendPrice;

    public RewardsPrice(Integer weekdayPrice, Integer weekendPrice) {
        this.weekdayPrice = weekdayPrice;
        this.weekendPrice = weekendPrice;
    }

    public Integer getWeekdayPrice() {
        return weekdayPrice;
    }

    public void setWeekdayPrice(Integer weekdayPrice) {
        this.weekdayPrice = weekdayPrice;
    }

    public Integer getWeekendPrice() {
        return weekendPrice;
    }

    public void setWeekendPrice(Integer weekendPrice) {
        this.weekendPrice = weekendPrice;
    }

}

