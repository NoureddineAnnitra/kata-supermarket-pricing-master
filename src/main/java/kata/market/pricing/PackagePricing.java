package kata.market.pricing;

import kata.market.model.Item;

public class PackagePricing extends Pricing {
    public PackagePricing() {
    }

    public float calculatePrice(Item item, float numberBought) {
        int numberForReduction = item.getReductionValueByNumber()._1();
        int timesReductionApplied = (int) (numberBought / numberForReduction);
        float numberOfFullPriceGoods = numberBought % numberForReduction;
        float reductionValue = item.getReductionValueByNumber()._2();
        float reducedPrice = timesReductionApplied * item.getUnitaryPrice() * numberForReduction * reductionValue;
        float unreducedPrice = numberOfFullPriceGoods * item.getUnitaryPrice();
        return reducedPrice + unreducedPrice;
    }

    public String toString() {
        return "PackagePricing()";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PackagePricing)) return false;
        final PackagePricing other = (PackagePricing) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PackagePricing;
    }

    public int hashCode() {
        int result = super.hashCode();
        return result;
    }
}
