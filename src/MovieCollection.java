import java.util.ArrayList;

public class MovieCollection {

    private ArrayList<Movie> collection; //Field of an ArrayList named collection of the type Movie

    public MovieCollection() { //Constructor: Creates the ArrayList collection
        collection = new ArrayList<Movie>();
    }

    //Method to add movies to the collection: Creates an instance of Movie and adds it to the ArrayList
    public void addMovie(String title, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre) {
        Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        collection.add(movie);
    }

    //Method to print the titles in the collection: Iterates through the collection and prints all the films
    public void collectionList() {
        for (Movie movie : collection) { //For every movie of the type Movie in the collection
            System.out.println(movie.getTitle()); //Print the title
        }
    }

    //Method to search for a movie in the collection taking one argument of the type String
    public String searchMovie(String input) {
        String result = ""; //Empty variable of the type String
        if (!input.isEmpty()) { //If the input argument is not empty do the following
            boolean found = false; //Boolean variable that comes in handy later
            for (Movie movie : collection) { //Iterates through the movie collection
                if (movie.getTitle().toLowerCase().contains(input.toLowerCase())) { //If the title contains the input argument do the following
                    result = "Title: " + movie.getTitle() + "\n"; //Adds the title to the result
                    result += "Director: " + movie.getDirector() + "\n"; //Along with the director
                    result += "Year: " + movie.getYearCreated() + "\n"; //The year
                    result += "In Color: " + (movie.isInColor() ? "Yes" : "No") + "\n"; //The color
                    result += "Length: " + movie.getLengthInMinutes() + " minutes" + "\n"; //The length
                    result += "Genre: " + movie.getGenre() + "\n"; //And the genre
                    result += "\n"; //This means next line
                    found = true; //Helps check if the movie is actually part of the collection
                }
            }
            if (!found) { //If the movie is not found
                result += "No movies matching your search\n"; //Add this to the result instead
            }
        } else {
            result += "You have entered nothing. Please enter the title of the movie you wish to find\n"; //If nothing is entered add this to result instead
        }
        return result; //Self-explanatory
    }

    //Method to edit a movie taking three arguments of the type String
    public String editMovie(String title, String fieldToEdit, String newValue) {
        if (!title.isEmpty()) { //If the title is not empty
            for (Movie movie : collection) { //Then iterate through the collection
                if (movie.getTitle().equalsIgnoreCase(title)) { //If the title of the movie is equal to the title argument
                    if ("title".equalsIgnoreCase(fieldToEdit)) { //And the argument fieldToEdit is equal to "title"
                        movie.setTitle(newValue); //Then set title to whatever the argument newValue is
                        return "Title edited successfully"; //And return a message
                    } else if ("director".equalsIgnoreCase(fieldToEdit)) { //Otherwise if the fieldToEdit is equal to director
                        movie.setDirector(newValue); //Then set director to whatever the argument newValue is
                        return "Director edited successfully"; //And return a message
                    } else if ("year".equalsIgnoreCase(fieldToEdit)) { //And so on..
                        movie.setYearCreated(Integer.parseInt(newValue));
                        return "Year edited successfully";
                    } else if ("color".equalsIgnoreCase(fieldToEdit)) {
                        movie.setIsInColor(Boolean.parseBoolean(newValue));
                        return "Color edited successfully";
                    } else if ("length".equalsIgnoreCase(fieldToEdit)) {
                        movie.setLengthInMinutes(Double.parseDouble(newValue));
                        return "Length edited successfully";
                    } else if ("genre".equalsIgnoreCase(fieldToEdit)) {
                        movie.setGenre(newValue);
                        return "Genre edited successfully";
                    } else { //If none of the above match the argument fieldToEdit
                        return "No match found"; //Return this
                    }

                }
            }
        }
        return "No movie found"; //And if no movie of this title exists in the collection return this
    }
}





