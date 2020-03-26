package newRestaurant;

import java.util.List;

class Order {
    private List<Client> clients;
    private double totalPrice;

    Order(List<Client> clients) {
        this.clients = clients;

    }

    private double sumPrice() {
        return sumAllOrders() + sumTips();
    }

    private double sumTips() {
        double sumTips = clientNumberTip();
        for (Client client: clients) {
            sumTips += client.getTip();
        }
        return sumTips;
    }

    private double clientNumberTip() {
        if (clients.size() < 10) {
            return 0;
        } else {
            double tip = sumAllOrders() * 0.1;
            double tipPerPerson = tip / clients.size();
            clients.forEach(client -> client.setTip(tipPerPerson));
            return tip;
        }

    }

    private double sumAllOrders() {
        double allOrders = 0;
        for (Client client: clients) {
            allOrders += client.getMealPrice();
        }
        return allOrders;
    }

    void printReceipt() {
        int count = 0;
        for (Client client: clients) {
            System.out.println("Zamówienie " + ++count);
            client.printClientOrder();
        }
        String lineFormat = "%-51.50s" + "%7.2f zł";
        System.out.println();
        String lineSumAllOrders = String.format(lineFormat, "KOSZT POSIŁKÓW" + ".".repeat(40), sumAllOrders());
        String sumAllTips = String.format(lineFormat, "NAPIWKI" + ".".repeat(50), sumTips());
        String sumPrice = String.format(lineFormat, "W SUMIE" + ".".repeat(50), sumPrice());

        String sum = lineSumAllOrders + "\n" +
                sumAllTips + "\n" +
                sumPrice + "\n";
        System.out.println(sum);
    }
}
