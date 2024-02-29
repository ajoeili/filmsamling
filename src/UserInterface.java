import java.util.Scanner;

public class UserInterface {
    Scanner input = new Scanner(System.in);
    Controller controller = new Controller();

    private boolean collectionListPrinted = false;
    private int choice;
    private boolean isInColor = false;
    int sentinel = 5;

    String intro = "Welcome to my movie collection! \n1. Add new movie \n2. Edit an existing movie \n3. Search \n4. Show all movies in collection \n5. Exit\n";
    String menu = "***** MENU **** \n1. Add new movie \n2. Edit an existing movie \n3. Search \n4. Show all movies in collection \n5. Exit\n";

    public void startProgram() {
        System.out.println(intro);
        choice = input.nextInt();
        while (choice != sentinel) {
            if (choice > 4 || choice < 1) {
                System.out.println("Please enter 1 to add a new movie, \n2 to edit an existing movie, \n3 to search the database, \n4 to get an overview of all the films in the collection, \nor 5 to end the program\n");
                choice = input.nextInt();
            } else if (choice == 1) {
                addMovie();
            } else if (choice == 2) {
                editMovie();
            } else if (choice == 3) {
                searchMovie();
            } else {
                printCollectionList();
            }
        }
    }
    public void addMovie() {
        System.out.println("Input movie title\n");
        String title = input.nextLine();
        input.nextLine();
        System.out.println("Input director\n");
        String director = input.nextLine();
        System.out.println("Input year of creation\n");
        int yearCreated = input.nextInt();
        System.out.println("Is the movie in color?\n");
        String answer = input.nextLine();
        if (answer.equals("yes")) {
            isInColor = true;
        }
        input.nextLine();
        System.out.println("Input length in minutes\n");
        double lengthInMinutes = input.nextDouble();
        input.nextLine();
        System.out.println("Input genre\n");
        String genre = input.nextLine();

        controller.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);

        System.out.println("Thank you for your input!\n");
        System.out.println(menu);

        choice = input.nextInt();
    }

    public void searchMovie() {
        System.out.println("Please enter the title of the movie you wish to see\n");
        input.nextLine();
        String search = input.nextLine();
        controller.searchMovie(search);
        System.out.println(menu);

        choice = input.nextInt();
    }

    public void printCollectionList() {
        if (!collectionListPrinted) {
            controller.collectionList();
            collectionListPrinted = true;
        } else {
            System.out.println("Movie collection list has already been printed\n");
        }
        System.out.println();
        System.out.println(menu);

        choice = input.nextInt();
    }
    public void editMovie() {
        while (choice != sentinel) {
            System.out.println("Please enter the title of the movie you wish to edit\n");
            String title = input.nextLine();
            input.nextLine();
            System.out.println("Please enter the field you wish to edit (i.e. Title, Director, Year etc.)\n");
            String fieldToEdit = input.nextLine();
            System.out.println("Please enter the new value you would like to save\n");
            String newValue = input.nextLine();
            controller.editMovie(title, fieldToEdit, newValue);

            System.out.println("Do you wish to save your changes? Press yes to save or press no to exit\n");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("Your changes have been saved\n");
            }
            if (answer.equalsIgnoreCase("no")) {
                choice = sentinel;
            }
            System.out.println();
            System.out.println(menu);

            choice = input.nextInt();
        }
    }
    public void testerAdds() {
        controller.addMovie("Edward Scissorhands", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Corpse Bride", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Nightmare Before Christmas", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Charlie and the Chocolate Factory", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Alice in Wonderland", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Alice in Wonderworld", "Tim Burton", 1991, true, 87, "Fantasy");
    }

}

