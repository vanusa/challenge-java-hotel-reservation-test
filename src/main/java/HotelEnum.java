public enum HotelEnum {
    LAKEWOOD("Lakewood", 3, 110, 80, 90, 80 ),
    BRIDGEWOOD("Bridgewood", 4, 160, 110, 60, 50),
    RIDGEWOOD("Ridgewood", 5, 220, 100, 150,40);

    HotelEnum(String name, Integer classificatin,
              Integer regularWeekdayPrice, Integer rewardWeekdayPrice,
              Integer regularWeekendPrice, Integer rewardWeekendPrice) {
        this.name = name;
        this.classificatin = classificatin;
        this.regularWeekdayPrice = regularWeekdayPrice;
        this.rewardWeekdayPrice = rewardWeekdayPrice;
        this.regularWeekendPrice = regularWeekendPrice;
        this.rewardWeekendPrice = rewardWeekendPrice;
    }

    private String name;
    private Integer classificatin;
    private Integer regularWeekdayPrice;
    private Integer rewardWeekdayPrice;
    private Integer regularWeekendPrice;
    private Integer rewardWeekendPrice;

    public String getName() {
        return name;
    }


    public Integer getClassification() {
        return classificatin;
    }


    public Integer getRegularWeekdayPrice() {
        return regularWeekdayPrice;
    }

    public Integer getRewardsWeekdayPrice() {
        return rewardWeekdayPrice;
    }

    public Integer getRegularWeekendPrice() {
        return regularWeekendPrice;
    }

    public Integer getRewardsWeekendPrice() {
        return rewardWeekendPrice;
    }

}
