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

    public void collectionList() {
        for (Movie movie : collection) {
            System.out.println(movie.getTitle());
        }
    }

    public String searchMovie(String input) {
        String result = "";
        if (!(input.isEmpty())) {
            result += "Searching for: " + input + "\n";
            boolean found = false;
            for (Movie movie : collection) {
                if (movie.getTitle().toLowerCase().contains(input.toLowerCase())) {
                    result += "Title: " + movie.getTitle() + "\n";
                    result += "Director: " + movie.getDirector() + "\n";
                    result += "Year: " + movie.getYearCreated() + "\n";
                    result += "In Color: " + (movie.isInColor() ? "Yes" : "No") + "\n";
                    result += "Length: " + movie.getLengthInMinutes() + " minutes" + "\n";
                    result += "Genre: " + movie.getGenre() + "\n";
                    result += "\n";
                    found = true;
                }
            }
            if (!found) {
                result += "No movies matching your search\n";
            }
        } else {
            result += "You have entered nothing. Please enter the title of the movie you wish to find\n";
        }
        System.out.println(result);
        return result;
    }

    public void printMovieData(Movie movie) {
        if (movie != null) {
            System.out.println("Title: " + movie.getTitle() + "\n");
            System.out.println("Director: " + movie.getDirector() + "\n");
            System.out.println("Year Created: " + movie.getYearCreated() + "\n");
            System.out.println("Color: " + (movie.isInColor() ? "Yes" : "No" + "\n"));
            System.out.println("Length: " + movie.getLengthInMinutes() + " minutes" + "\n");
            System.out.println("Genre: " + movie.getGenre() + "\n");
            System.out.println();
        } else {
            System.out.println("Movie not found\n");
        }
    }

    public String editMovie(String title, String fieldToEdit, String newValue) {
        if (!(title.isEmpty())) {
            for (Movie movie : collection) {
                if (movie.getTitle().equalsIgnoreCase(title)) {
                    if ("title".equalsIgnoreCase(fieldToEdit)) {
                        movie.setTitle(newValue);
                        printMovieData(movie);
                        return "Title updated successfully\n";
                    }
                    if ("director".equalsIgnoreCase(fieldToEdit)) {
                        movie.setDirector(newValue);
                        printMovieData(movie);
                        return "Director updated successfully\n";
                    }
                    if ("year".equalsIgnoreCase(fieldToEdit)) {
                        movie.setYearCreated(Integer.parseInt(newValue));
                        printMovieData(movie);
                        return "Year created updated successfully\n";
                    }
                    if ("color".equalsIgnoreCase(fieldToEdit)) {
                        movie.setIsInColor(Boolean.parseBoolean(newValue));
                        printMovieData(movie);
                        return "Color updated successfully\n";
                    }
                    if ("length".equalsIgnoreCase(fieldToEdit)) {
                        movie.setLengthInMinutes(Double.parseDouble(newValue));
                        printMovieData(movie);
                        return "Length in minutes updated successfully\n";
                    }
                    if ("genre".equalsIgnoreCase(fieldToEdit)) {
                        movie.setGenre(newValue);
                        printMovieData(movie);
                        return "Genre updated successfully\n";
                    }
                    return "Invalid input, please try again\n";
                }
            }
        }
        return "Movie not found\n";
    }
}





