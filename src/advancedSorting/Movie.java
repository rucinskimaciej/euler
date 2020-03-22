package advancedSorting;

public class Movie {

    private String title;
    private String director;
    private int year;
    private double rating;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        String output = "";
        try {
            output = String.format("%s{%s=%-30s" + "%s=%-20s" + "%s=%d   " + "%s=%-4.1f}",
                    getClass().getSimpleName(),
                    getClass().getDeclaredField("title").getName(), ("'" + title + "'"),
                    getClass().getDeclaredField("director").getName(), director,
                    getClass().getDeclaredField("year").getName(), year,
                    getClass().getDeclaredField("rating").getName(), rating);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return output;
    }

    //    @Override
//    public int compareTo(Movie m) {
//        return title.compareTo(m.title);
//    }
}