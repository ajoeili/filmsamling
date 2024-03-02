public class Controller {
    private MovieCollection collection; //Field of the type MovieCollection named collection

    public Controller() { //Constructor: Creates the collection
        collection = new MovieCollection();
    }

    //The addMovie method from the MovieCollection class
    public void addMovie(String title, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre) {
        collection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
    }

    //The collectionList method from the MovieCollection class
    public void collectionList() {
        collection.collectionList();
    }

    //The searchMovie method from the MovieCollection class
    public String searchMovie(String input) {
        return collection.searchMovie(input);
    }

    //The editMovie method from the MovieCollection class
    public void editMovie(String title, String fieldToEdit, String newValue) {
        collection.editMovie(title, fieldToEdit, newValue);
    }

}