import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Controller controller = new Controller();

        System.out.println("Welcome to my movie collection!");
        System.out.println("1. Add a new movie");
        System.out.println("2. Exit");

        int sentinel = 2;
        int choice = input.nextInt();

        while (choice != sentinel) {
            if (choice > 2) {
                System.out.println("Please enter 1 to add a new movie or 2 to end the program");
                choice = input.nextInt();

            } else if (choice == 1) {
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

                controller.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);

                System.out.println("***** MENU ****");
                System.out.println("1. Add a new movie");
                System.out.println("2. Exit");

                choice = input.nextInt();
            }
        }
    }
}
