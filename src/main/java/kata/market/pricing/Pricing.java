package kata.market.pricing;

import kata.market.model.Item;

public abstract class Pricing {

    public Pricing() {
    }

    public abstract float calculatePrice(Item item, float numberBought);

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Pricing)) return false;
        final Pricing other = (Pricing) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Pricing;
    }

    public int hashCode() {
        int result = 1;
        return result;
    }

    public String toString() {
        return "Pricing()";
    }
}
