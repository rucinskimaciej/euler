package warehouse;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

class StockQuantity {
    private int stockQuantity;

    public StockQuantity(int quantity) {
        this.stockQuantity = quantity;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    @Override
    public String toString() {
        return String.valueOf(stockQuantity);
    }
}
