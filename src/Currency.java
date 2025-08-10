import com.google.gson.annotations.SerializedName;

public class Currency {
    @SerializedName("base_code")
    String baseCurrency;

    @SerializedName("target_code")
    String finalCurrecy;

    @SerializedName("conversion_result")
    double finalAmount;


    public Currency(String baseCurrency, String finalCurrecy, double finalAmount) {
        this.baseCurrency = baseCurrency;
        this.finalCurrecy = finalCurrecy;
        this.finalAmount = finalAmount;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getFinalCurrecy() {
        return finalCurrecy;
    }

    public void setFinalCurrecy(String finalCurrecy) {
        this.finalCurrecy = finalCurrecy;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", finalCurrecy='" + finalCurrecy + '\'' +
                ", finalAmount=" + finalAmount +
                '}';
    }
}
