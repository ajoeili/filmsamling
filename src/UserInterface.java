import java.util.Scanner;

public class UserInterface {
    Scanner input = new Scanner(System.in); //Creates a new scanner object
    Controller controller = new Controller(); //Creates a new instance of the type Controller named controller

    private boolean collectionListPrinted = false; //Variable used in the collectionList method to make sure it doesn't print multiple times
    private int choice; //Variable to store the choices of the user using the scanner object
    private boolean isInColor = false; //Variable to store date on whether a movie is in color or not - used later in the addMovie method
    int sentinel = 5; //Variable to help us close the program

    //Fields to store the welcome message and the menu
    String intro = "Welcome to my movie collection! \n1. Add new movie \n2. Edit an existing movie \n3. Search \n4. Show all movies in collection \n5. Exit\n";
    String menu = "***** MENU ***** \n1. Add new movie \n2. Edit an existing movie \n3. Search \n4. Show all movies in collection \n5. Exit\n";

    //Method to start the program. Takes the user through the menu to the specific methods
    public void startProgram() {
        System.out.println(intro);
        choice = Integer.parseInt(input.nextLine()); //Using the parseInt to make sure we avoid the scanner bug
        while (choice != sentinel) {
            if (choice > 4 || choice < 1) {
                System.out.println("Please enter 1 to add a new movie, \n2 to edit an existing movie, \n3 to search the database, \n4 to get an overview of all the films in the collection, \nor 5 to end the program\n");
                choice = Integer.parseInt(input.nextLine());
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

    //Method to add a movie to the collection
    public void addMovie() {
        System.out.println("Input movie title\n");
        String title = input.nextLine();
        System.out.println("Input director\n");
        String director = input.nextLine();
        System.out.println("Input year of creation\n");
        int yearCreated = Integer.parseInt(input.nextLine()); //Again we use the parseInt to avoid the scanner bug
        System.out.println("Is the movie in color?\n");
        String answer = input.nextLine();
        isInColor = answer.equalsIgnoreCase("yes");
        System.out.println("Input length in minutes\n");
        double lengthInMinutes = Double.parseDouble(input.nextLine()); //Same here
        System.out.println("Input genre\n");
        String genre = input.nextLine();

        controller.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre); //A call to the controller to add the film to the collection using the input from the user

        System.out.println("Thank you for your input!\n");
        System.out.println(menu); //Takes us back to the menu

        choice = Integer.parseInt(input.nextLine()); //And let's the user make a new choice
    }

    //Method to search for a movie
    public void searchMovie() {
        System.out.println("Please enter the title of the movie you wish to see\n");
        String search = input.nextLine();
        String movieData = controller.searchMovie(search); //Calls the controller to search through the collection using the input from the user
        System.out.println(movieData); //And prints the data to the console
        System.out.println(menu); //Takes us back to the menu

        choice = Integer.parseInt(input.nextLine()); //And lets the user make a new choice
    }

    //Method to print the titles of the movies in the collection
    public void printCollectionList() {
        if (!collectionListPrinted) { //Now we are using the variable from above to check if the list has been printed before
            controller.collectionList(); //And call the controller to print the collection
            collectionListPrinted = true; //And then we set the variable to true, because now the list has been printed
        } else {
            System.out.println("Movie collection list has already been printed\n"); //And if the list has already been printed we get this message
        }
        System.out.println();
        System.out.println(menu); //The user gets back to the menu

        choice = Integer.parseInt(input.nextLine()); //And gets to make a new choice
    }

    //Method to edit a movie in the collection
    public void editMovie() {
        while (choice == 2) { //Loops through the choice
            System.out.println("Please enter the title of the movie you wish to edit\n");
            String title = input.nextLine();

            String movieData = controller.searchMovie(title); //Calls the controller to search for the movie via the search method
            System.out.println(movieData); //And then print the data of the specific movie

            System.out.println("Please enter the field you wish to edit (i.e. Title, Director, Year etc.)\n");
            String fieldToEdit = input.nextLine(); //Field to store the input from the user about which category they wish to edit

            System.out.println("Please enter the new value you would like to save\n");
            String newValue = input.nextLine(); //Field to store the input from the user about which edit they wish to make

            controller.editMovie(title, fieldToEdit, newValue); //Call to the controller to edit the movie using the user input

            System.out.println("Do you wish to save your changes? Press yes to save or press no to exit\n");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("Your changes have been saved\n");
                String newMovieData = controller.searchMovie(title); //Next best thing now that we don't have a database to store the edits
                System.out.println(newMovieData + "\n"); //Prints the new data of the movie
            }
            if (answer.equalsIgnoreCase("no")) {
                choice = sentinel; //Closes the program
            }
            System.out.println();
            System.out.println(menu); //Takes the user back to the menu

            choice = Integer.parseInt(input.nextLine()); //And lets them make a new choice
        }
    }

    //Just a method to add some films to the collection, so I can perform tests without manually adding movies
    public void testerAdds() {
        controller.addMovie("Edward Scissorhands", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Corpse Bride", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Nightmare Before Christmas", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Charlie and the Chocolate Factory", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Alice in Wonderland", "Tim Burton", 1991, true, 87, "Fantasy");
        controller.addMovie("Alice in Wonderworld", "Tim Burton", 1991, true, 87, "Fantasy");
    }

}

