package kata.market.model;

import java.util.LinkedHashMap;

import static io.vavr.API.*;


class Customer {
    private Supermarket supermarket;
    private LinkedHashMap cart = new LinkedHashMap<Item, Float>();

    public Customer() {
    }

    void addToCart(Item item, float numberToBuy) {
        if (cart.containsKey(item)) {
            if(item.isByWeight() && (numberToBuy - (int) numberToBuy) != 0)
            {
                throw new RuntimeException("Error case: you cannot buy half an item !");
            }
            else
            {
                cart.put(item, numberToBuy + (Float) cart.get(item));
            }
        }
        else
        {
            cart.put(item, numberToBuy);
        }
    }

    void removeFromCart(Item item, float number) {
        if (cart.containsKey(item))
        {
            Match((Float) cart.get(item) - number).of(
                    Case($(n -> n > 0), () -> cart.replace(item, (Float) cart.get(item) - number)),
                    Case($(), () -> cart.remove(item)));
        }
    }

    public Supermarket getSupermarket() {
        return this.supermarket;
    }

    public LinkedHashMap getCart() {
        return this.cart;
    }

    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }

    public void setCart(LinkedHashMap cart) {
        this.cart = cart;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Customer)) return false;
        final Customer other = (Customer) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$supermarket = this.getSupermarket();
        final Object other$supermarket = other.getSupermarket();
        if (this$supermarket == null ? other$supermarket != null : !this$supermarket.equals(other$supermarket))
            return false;
        final Object this$cart = this.getCart();
        final Object other$cart = other.getCart();
        if (this$cart == null ? other$cart != null : !this$cart.equals(other$cart)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Customer;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $supermarket = this.getSupermarket();
        result = result * PRIME + ($supermarket == null ? 43 : $supermarket.hashCode());
        final Object $cart = this.getCart();
        result = result * PRIME + ($cart == null ? 43 : $cart.hashCode());
        return result;
    }

    public String toString() {
        return "Customer(supermarket=" + this.getSupermarket() + ", cart=" + this.getCart() + ")";
    }
}

