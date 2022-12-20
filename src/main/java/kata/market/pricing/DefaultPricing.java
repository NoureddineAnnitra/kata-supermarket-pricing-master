package kata.market.pricing;

import kata.market.model.Item;

public class DefaultPricing extends Pricing {
    public DefaultPricing() {
    }

    public float calculatePrice(Item item, float numberBought) {
        return (item.getUnitaryPrice() * numberBought);
    }

    public String toString() {
        return "DefaultPricing()";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof DefaultPricing)) return false;
        final DefaultPricing other = (DefaultPricing) o;
        if (!other.canEqual((Object) this)) return false;
        if (!super.equals(o)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DefaultPricing;
    }

    public int hashCode() {
        int result = super.hashCode();
        return result;
    }
}
