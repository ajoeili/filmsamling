public class Movie {

    //Saves data of the movie
    private String title;
    private String director;
    private int yearCreated;
    private boolean isInColor;
    private double lengthInMinutes;
    private String genre;

    //Constructor: Creates the movie instance
    public Movie(String title, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
    }
    //Getter methods to access the private data in the fields above
    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public boolean isInColor() {
        return isInColor;
    }

    public double getLengthInMinutes() {
        return lengthInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    //Setter methods to edit the private data in the fields above
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public void setIsInColor(boolean isInColor) {
        this.isInColor = isInColor;
    }

    public void setLengthInMinutes(double lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

