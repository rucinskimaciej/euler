package vendingMachine;

import java.util.Objects;

class Game {
    private String title;
    private double price;

    public Game(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Double.compare(game.getPrice(), getPrice()) == 0 &&
                Objects.equals(getTitle(), game.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPrice());
    }
}
