public enum PriceRatingEnum {
    REGULAR("Regular"),
    REWARDS("Rewards");

    PriceRatingEnum(String desc){
        description = desc;
    }
    private String description;

    public String getDescription() {
        return description;
    }

    public static PriceRatingEnum getByValue(String value) {
        for (PriceRatingEnum priceRating : PriceRatingEnum.values()) {
            if (priceRating.description.equalsIgnoreCase(value)) {
                return priceRating;
            }
        }

        return null;
    }

}
