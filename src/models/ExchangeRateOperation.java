package models;

import com.google.gson.annotations.SerializedName;

public class ExchangeRateOperation {
    @SerializedName("base_code")
    private final String base_currency;
    @SerializedName("target_code")
    private final String target_currency;
    private final float conversion_rate;
    private final float conversion_result;


    public ExchangeRateOperation(String base_currency, String target_currency, float conversion_rate, float conversion_result) {
        this.base_currency = base_currency;
        this.target_currency = target_currency;
        this.conversion_rate = conversion_rate;
        this.conversion_result = conversion_result;
    }

    @Override
    public String toString() {
        return String.format("Converting the currency: %s to %s, at a conversion rate of: %s, resulting into: %s value", base_currency, target_currency, conversion_rate, conversion_result);
    }
}
