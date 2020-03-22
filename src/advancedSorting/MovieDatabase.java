package advancedSorting;

import java.util.*;

public class MovieDatabase {
    public static void main(String[] args) {
        List<Movie> moviesList = createMoviesList();
        Comparator<Movie> sortAlgorithm = getSortAlgorithm(); //TODO
        moviesList.sort(sortAlgorithm);
        print(moviesList);

    }

    private static List<Movie> createMoviesList() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Jumanji", "Johnston Joe", 1995, 6.8));
        movies.add(new Movie("The Shawshank Redemption", "Johnston Joe", 1994, 8.75));
        movies.add(new Movie("The Green Mile", "Darabont Frank", 1999, 8.61));
        movies.add(new Movie("Spider Man", "Raimi Sam", 2002, 6.7));
        movies.add(new Movie("Transformers", "Bay Michael", 2007, 7.3));
        movies.add(new Movie("Alien", "Scott Ridley", 1979, 7.8));
        movies.add(new Movie("Home Alone", "Columbus Chris", 1979, 7.1));
        return movies;
    }

    private static Comparator<Movie> getSortAlgorithm() {
        String choice;
        System.out.println("Wybierz kryterium sortowania" + "\n" +
                "   > Title" + "\n" +
                "   > Rating" + "\n" +
                "   > Year");
        System.out.print("> ");
        switch (choice = new Scanner(System.in).nextLine().toLowerCase()) {
            case "title":
                return Comparator.comparing(Movie::getTitle);
            case "rating":
                return Comparator.comparingDouble(Movie::getRating).reversed();
            case "year":
                return Comparator.comparing(Movie::getYear).reversed();
            default:
                throw new IllegalArgumentException("Could not sort - program failed : " + choice);
        }
    }

    private static void print(List<Movie> movies) {
        System.out.println("Lista filmów:");
        movies.forEach(System.out::println);
    }

}