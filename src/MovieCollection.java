import java.util.ArrayList;

public class MovieCollection {

    private ArrayList<Movie> collection;

    public MovieCollection() {
        collection = new ArrayList<Movie>();
    }

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre) {
        Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        collection.add(movie);
    }

    public ArrayList<Movie> getCollection() {
        return collection;
    }
}
