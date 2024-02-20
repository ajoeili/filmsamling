public class MovieCollection {

    private Movie[] collection;
    int count = 0;

    public MovieCollection() {
        this.collection = new Movie[5];
    }


    public void addMovie(String title, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre) {
        // count++ tæller én op
        collection[count++] = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
    }

    public Movie[] getCollection() {
        return collection;
    }
}
