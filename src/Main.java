import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MovieCollection collection = new MovieCollection();

        System.out.println("Velkommen til min filmsamling!");
        System.out.println("1. Opret en film");
        System.out.println("2. Afslut");

        int sentinel = 2;
        int choice = input.nextInt();

        while(choice != sentinel) {
            if(choice == 1) {
                System.out.println("Input movie title");
                String title = input.nextLine();
                input.nextLine();
                System.out.println("Input director");
                String director = input.nextLine();

                System.out.println("Input year of creation");
                int yearCreated = input.nextInt();

                System.out.println("Is the movie in color? (true/false)");
                boolean isInColor = input.nextBoolean();

                System.out.println("Input length in minutes");
                double lengthInMinutes = input.nextDouble();

                input.nextLine();

                System.out.println("Input genre");
                String genre = input.nextLine();

                collection.addMovie(title,director,yearCreated,isInColor,lengthInMinutes,genre);

                System.out.println("***** MENU ****");
                System.out.println("1. Opret en film");
                System.out.println("2. Afslut");

                choice = input.nextInt();

            } else {
                System.out.println("Please press 1 to add new movie, or press 2 to exit");
            }
        }
    }
}