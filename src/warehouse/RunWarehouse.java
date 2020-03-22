package warehouse;

import java.io.File;

class RunWarehouse {
    public static void main(String[] args) {
        String filename = "data.csv";
        new FileCreator(filename);
        new Stock(filename).printStock();
        deleteFile(filename);
    }

    private static void deleteFile(String fileName){
        new File(fileName).delete();
    }
}
