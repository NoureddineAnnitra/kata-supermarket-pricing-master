package kata.market.model;

import io.vavr.Tuple;
import io.vavr.Tuple2;

public class Item {
    private boolean byWeight;
    private Tuple2<Integer, Float> reductionValueByNumber = Tuple.of(null, null);
    private String name;
    private int unitaryPrice;

    public Item(boolean byWeight, Tuple2<Integer, Float> reductionValueByNumber, String name, int unitaryPrice) {
        this.byWeight = byWeight;
        this.reductionValueByNumber = reductionValueByNumber;
        this.name = name;
        this.unitaryPrice = unitaryPrice;
    }

    public boolean isByWeight() {
        return this.byWeight;
    }

    public Tuple2<Integer, Float> getReductionValueByNumber() {
        return this.reductionValueByNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getUnitaryPrice() {
        return this.unitaryPrice;
    }

    public void setByWeight(boolean byWeight) {
        this.byWeight = byWeight;
    }

    public void setReductionValueByNumber(Tuple2<Integer, Float> reductionValueByNumber) {
        this.reductionValueByNumber = reductionValueByNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitaryPrice(int unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Item)) return false;
        final Item other = (Item) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.isByWeight() != other.isByWeight()) return false;
        final Object this$reductionValueByNumber = this.getReductionValueByNumber();
        final Object other$reductionValueByNumber = other.getReductionValueByNumber();
        if (this$reductionValueByNumber == null ? other$reductionValueByNumber != null : !this$reductionValueByNumber.equals(other$reductionValueByNumber))
            return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.getUnitaryPrice() != other.getUnitaryPrice()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Item;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + (this.isByWeight() ? 79 : 97);
        final Object $reductionValueByNumber = this.getReductionValueByNumber();
        result = result * PRIME + ($reductionValueByNumber == null ? 43 : $reductionValueByNumber.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + this.getUnitaryPrice();
        return result;
    }

    public String toString() {
        return "Item(byWeight=" + this.isByWeight() + ", reductionValueByNumber=" + this.getReductionValueByNumber() + ", name=" + this.getName() + ", unitaryPrice=" + this.getUnitaryPrice() + ")";
    }
}
