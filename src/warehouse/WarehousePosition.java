package warehouse;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

class WarehousePosition {
    private Product product;
    private StockQuantity quantity;
    private String stars;

    public WarehousePosition(Product product, StockQuantity quantity) {
        this.product = product;
        this.quantity = quantity;
        setStars();
    }

    private void setStars(){
        double quantity = this.quantity.getStockQuantity();
        StringBuilder starsBuilder = new StringBuilder();
        if (quantity % 10 < 5){
            quantity = BigDecimal.valueOf(quantity / 10).round(new MathContext(1, RoundingMode.HALF_DOWN)).doubleValue();
        } else{
            quantity = BigDecimal.valueOf(quantity / 10).round(new MathContext(1, RoundingMode.HALF_UP)).doubleValue();
        }
        starsBuilder.append("*".repeat(Math.max(0, (int) quantity)));
        stars = starsBuilder.toString();
    }

    @Override
    public String toString() {
        return product + " (" + quantity + ") " + stars;
    }

    public static void main(String[] args) {
        WarehousePosition w1 = new WarehousePosition(new Product("Product1"), new StockQuantity(33));
        WarehousePosition w2 = new WarehousePosition(new Product("Product2"), new StockQuantity(47));

        System.out.println(w1);
        System.out.println(w2);
    }
}
