package warehouse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Data {
    private List<WarehousePosition> data;
    private File file;;

    public Data(String fileName){
        data = new ArrayList<>();
        file = new File(fileName);
        try (
                var br = new BufferedReader(
                        new FileReader(file))
                ){
            String line;
            while ((line = br.readLine()) != null){
                data.add(newWarehousePosition(line));
            }
        } catch (IOException e) {
            System.err.println("Sth wrong with the file here!!!!!!!");;
        }
    }

    private WarehousePosition newWarehousePosition(String line){
        Product product = new Product(line.substring(0,line.indexOf(";")));
        StockQuantity quantity = new StockQuantity(Integer.parseInt(line.substring(line.indexOf(";") + 1)));
        return new WarehousePosition(product, quantity);
    }

    public List<WarehousePosition> getData() {
        return data;
    }
}
