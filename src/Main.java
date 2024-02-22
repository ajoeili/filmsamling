import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Controller controller = new Controller();

        controller.addMovie("Edward Scissorhands", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Corpse Bride", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Nightmare Before Christmas", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Charlie and the Chocolate Factory", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Alice in Wonderland", "Tim Burton", 1991, true, 87, "Fantasy");

        System.out.println("Welcome to my movie collection!");
        System.out.println("1. Add a new movie");
        System.out.println("2. Exit");
        System.out.println("3. Search");


        int sentinel = 2;
        int choice = input.nextInt();

        while (choice != sentinel) {
            if (choice > 3 || choice < 0) {
                System.out.println("Please enter 1 to add a new movie, 2 to end the program or 3 to search the database");
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
                System.out.println("3. Search");

                choice = input.nextInt();

            } else if (choice == 3) {
                System.out.println("Please enter the title of the movie you wish to see");
                input.nextLine();
                String search = input.nextLine();
                {
                    controller.searchMovie(search);
                }
                System.out.println();
                choice = input.nextInt();
                }

                }
            }
        }

