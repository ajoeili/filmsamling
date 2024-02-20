import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MovieCollection collection = new MovieCollection();

        System.out.println("Input movie title");
        String title = input.nextLine();

        System.out.println("Input director");
        String director = input.nextLine();

        System.out.println("Input year of creation");
        int yearCreated = input.nextInt();

        System.out.println("Is the movie in color? (True/False)");
        boolean isInColor = input.nextBoolean();

        System.out.println("Input length in minutes");
        double lengthInMinutes = input.nextDouble();

        System.out.println("Input genre");
        String genre = input.next();

        collection.addMovie(title,director,yearCreated,isInColor,lengthInMinutes,genre);

        for(Movie movie : collection.getCollection()) {
            if(movie != null) {
                System.out.println("Title: " + title);
                System.out.println("Director: " + director);
                System.out.println("Year of creation: " + yearCreated);
                System.out.println("The film is a color film: ");
                System.out.println("Length in minutes: " + lengthInMinutes);
                System.out.println("Genre: " + genre);
            }
        }

    }
}