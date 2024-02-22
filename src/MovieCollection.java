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
    public void collectionList() {
        for(Movie movie : collection) {
            System.out.println(collection.toString());
        }
    }

    public void searchMovie(String input) {
        if (input != null) {
            System.out.println("Searching for: " + input);
            for (Movie movie : collection) {
                if (movie.getTitle().toLowerCase().contains(input.toLowerCase())) {
                    System.out.println("Found movie: " + movie.getTitle());
                }
            }
        } else {
            System.out.println("You have entered nothing. Please enter the title of the movie you wish to find");
        }
    }
}



