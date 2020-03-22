package warehouse;

import java.util.List;

class Stock {
    private List<WarehousePosition> stock;

    public Stock(String fileName) {
        this.stock = new Data(fileName).getData();
    }

    void printStock(){
        stock.forEach(warehousePosition -> System.out.println(warehousePosition));
    }
}
