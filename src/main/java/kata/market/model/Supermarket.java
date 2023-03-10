package kata.market.model;

import io.vavr.Tuple2;
import kata.market.pricing.DefaultPricing;
import kata.market.pricing.PackagePricing;

import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Optional;

class Supermarket {
    public Supermarket() {
    }

    private Optional<Integer> itemPromotion(Item item)
    {
        return Optional.ofNullable(item.getReductionValueByNumber())
                .filter(reductionList -> Objects.nonNull(reductionList._1))
                .filter(reductionList -> Objects.nonNull(reductionList._2))
                .map(reductionList -> reductionList._1);
    }

    float calculateBill(Customer customer)
    {
        LinkedHashMap<Item, Float> input = customer.getCart();
        float bill = 0f;

        bill = processDefaultPricing(input, bill);
        bill = processPackagePricing(input, bill);

        return bill;
    }

    private float processPackagePricing(LinkedHashMap<Item, Float> inputMap, float bill)
    {
        return inputMap.entrySet().stream()
                .filter(item -> itemPromotion(item.getKey()).isPresent())
                .map(item -> new PackagePricing().calculatePrice(item.getKey(), item.getValue()))
                .reduce(bill, (f1, f2) -> f1 + f2);
    }

    private float processDefaultPricing(LinkedHashMap<Item, Float> inputMap, float bill)
    {
        return inputMap.entrySet().stream()
                .filter(item -> !itemPromotion(item.getKey()).isPresent())
                .map(item -> new DefaultPricing().calculatePrice(item.getKey(), item.getValue()))
                .reduce(bill, (f1, f2) -> f1 + f2);
    }

    void addReduction(Item item, int numberToBuy, float reduction)
    {
        item.setReductionValueByNumber(new Tuple2<>(numberToBuy, reduction));
    }

    void removeReductions(Item item)
    {
        item.setReductionValueByNumber(new Tuple2<>(null, null));
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Supermarket)) return false;
        final Supermarket other = (Supermarket) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Supermarket;
    }

    public int hashCode() {
        int result = 1;
        return result;
    }

    public String toString() {
        return "Supermarket()";
    }
}