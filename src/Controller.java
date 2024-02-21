public class Controller {
    private MovieCollection collection;

    public Controller() {
        collection = new MovieCollection();
    }

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre) {
        collection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
    }
}