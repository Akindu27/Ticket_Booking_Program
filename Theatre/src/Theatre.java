import java.io.PrintWriter;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class Theatre {
    static Scanner scanner =new Scanner(System.in);

    //create 3 rows and an arraylist and make them static to use it in every method that is created
    static int[] row1=new int[12];
    static int[] row2=new int[16];
    static int[] row3=new int[20];
    static ArrayList<Ticket> ticketsArray =new ArrayList<>();

    public static void main(String[] args) {

        boolean endProgram = false;      //created a boolean variable called endProgram to assign the boolean value till the user inputs 0
        System.out.println("Welcome to the New Theatre!");

        while(!endProgram) {     //used a while loop to repeat until the user enters 0 to end the program
            System.out.print("""
                   
                    -------------------------------------------------
                    Please select an option:
                    1) Buy a ticket
                    2) Print seating area
                    3) Cancel ticket
                    4) List available seats
                    5) Save to file
                    6) Load from file
                    7) Print ticket information and total price
                    8) Sort ticket by price
                    \t0) Quit
                    -------------------------------------------------""");

            try {                //used try and catch to validate the user inputs as the user inputs a String value for an integer
                System.out.print("\nEnter option: ");
                int userInput = scanner.nextInt();

                switch (userInput) {                            //used a switch case to get the user inputs
                    case 1:
                        buy_ticket();
                        break;
                    case 2:
                        print_seating_area();
                        break;
                    case 3:
                        cancel_ticket();
                        break;
                    case 4:
                        show_available();
                        break;
                    case 5:
                        save();
                        break;
                    case 6:
                        load();
                        break;
                    case 7:
                        show_tickets_info();
                        break;
                    case 8:
                        sort_tickets();
                        break;
                    case 0:
                        endProgram = true;
                        System.out.println("--------Thanks for using!!!--------");
                        break;
                    default:
                        System.out.println("Sorry! You have entered a wrong Input.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Sorry! You have entered a wrong Input.");
                scanner.next();
            }
        }
    }

    public static void buy_ticket() {
        String emailAddress;
        int rowNumber, seatNumber;


        System.out.println("""
                                
                ---Ticket Prices---
                                
                1st Row seats are £30
                2nd Row seats are £20
                3rd Row seats are £10
                """);
        int ticketPrice;
        System.out.print("Enter your First Name: ");
        String firstName = scanner.next();
        System.out.print("Enter your Last Name: ");
        String lastName = scanner.next();

        do {                                                            //created a do while loop to validate the user inputs ,loop until the user enters correct inputs
            System.out.print("Enter your Email address: ");
            emailAddress = scanner.next();
            System.out.println("Enter a valid Email address.\n");
        } while (!emailAddress.contains("@") || !emailAddress.contains(".com"));
        System.out.println("-----User details entered successfully-----\n");

        System.out.println("Enter the row and the seat number...");

        while (true) {                                                   //created while loop to validate the user inputs ,loop until the user enters correct inputs
            try {
                System.out.print("Row number: ");
                rowNumber = scanner.nextInt();
                System.out.print("Seat number: ");
                seatNumber = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nSorry! You have entered a wrong Input.");
                scanner.next();
            }
        }

        switch (rowNumber) {                //used a switch case to get the row number that user inputs
            case 1:

                ticketPrice = 30;           //assigned the ticket price
                if(seatNumber<=12){         //used if condition to validate the user input of seat number
                    if (row1[seatNumber - 1] == 0) {
                        row1[seatNumber - 1] = 1;
                        System.out.println("Seat booked successfully!");
                        Person person = new Person(firstName, lastName, emailAddress);              //created a new person object using the person class
                        Ticket ticket = new Ticket(person, rowNumber, seatNumber, ticketPrice);     //created a new ticket object using the ticket class
                        ticketsArray.add(ticket);

                    } else {
                        System.out.println("Sorry! The selected seat in that row is already booked.");
                    }
                }else{
                    System.out.println("Sorry!You have entered a wrong Seat number.");
                }
                break;

            case 2:

                ticketPrice = 20;
                if(seatNumber<=16){
                    if (row2[seatNumber - 1] == 0) {
                        row2[seatNumber - 1] = 1;
                        System.out.println("Seat booked successfully!");
                        Person person = new Person(firstName, lastName, emailAddress);
                        Ticket ticket = new Ticket(person, rowNumber, seatNumber, ticketPrice);
                        ticketsArray.add(ticket);

                    } else {
                        System.out.println("Sorry! The selected seat in that row is already booked.");
                    }
                }else{
                    System.out.println("Sorry!You have entered a wrong Seat number.");
                }
                break;

            case 3:

                ticketPrice = 10;
                if(seatNumber<=20){
                    if (row3[seatNumber - 1] == 0) {
                        row3[seatNumber - 1] = 1;
                        System.out.println("Seat booked successfully!");
                        Person person = new Person(firstName, lastName, emailAddress);
                        Ticket ticket = new Ticket(person, rowNumber, seatNumber, ticketPrice);
                        ticketsArray.add(ticket);

                    } else {
                        System.out.println("Sorry! The selected seat in that row is already booked.");
                    }
                }else {
                    System.out.println("Sorry!You have entered a wrong Seat number.");
                }
                break;

            default:
                System.out.println("Sorry! You have entered a wrong row number.");
        }
    }

    public static void print_seating_area(){
        System.out.println("""
                      *************
                      *   STAGE   *
                      *************
                """);

        System.out.print("      ");
        for (int j=0;j< row1.length;j++) {                  // used a for loop to iterate through the row 1 array to print the seating area
            if (row1[j] == 0)                               //and checked the values using if conditions.
                System.out.print("o");
            else
                System.out.print("x");
            if(j==5)
                System.out.print(" ");
        }
        System.out.println();

        System.out.print("    ");
        for (int j=0;j<row2.length;j++) {                   // used a for loop to iterate through the row 2 array to print the seating area
            if (row2[j] == 0)                               //and checked the values using if conditions.
                System.out.print("o");
            else
                System.out.print("x");
            if(j==7)
                System.out.print(" ");
        }
        System.out.println();

        System.out.print("  ");
        for (int j=0;j<row3.length;j++) {                   // used a for loop to iterate through the row 3 array to print the seating area
            if (row3[j] == 0)                               //and checked the values using if conditions.
                System.out.print("o");
            else
                System.out.print("x");
            if(j==9)
                System.out.print(" ");
        }
        System.out.println();
    }

    public static void cancel_ticket(){

        int rowNumber,seatNumber;

        while (true){                                       //used a while loop to loop until the user inputs the correct input
            try{                                        //used a try catch to validate the user inputs
                System.out.println("\nEnter the row and the seat number...");
                System.out.print("Row number: ");
                rowNumber=scanner.nextInt();
                System.out.print("Seat number: ");
                seatNumber= scanner.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("\nSorry! You have entered a wrong Input.");
                scanner.next();
            }
        }

        for(Ticket tickets: ticketsArray){                                              //created a for loop to iterate through the ticketsArray
            if ((tickets.getRow()==rowNumber)&&(tickets.getSeat()==seatNumber)){        //using an if condition checked the relevant row and seat number
                ticketsArray.remove(tickets);                                           //using remove method removed the ticket object from the arraylist.
                break;
            }
        }

        switch (rowNumber) {                            //used switch to get the row number
            case 1:

                if(seatNumber<=12){                             //used if condition to validate the user input of seat number
                    if (row1[seatNumber - 1] == 1) {                //removed the seat number from the row array using indexing
                        row1[seatNumber - 1] = 0;
                        System.out.println("\nSeat cancellation successful!.");
                    } else {
                        System.out.println("\nSorry! The selected seat in that row is not booked.");
                    }
                }else{
                    System.out.println("Sorry!You have entered a wrong Seat number.");
                }
                break;

            case 2:

                if(seatNumber<=16){
                    if (row2[seatNumber - 1] == 1) {
                        row2[seatNumber - 1] = 0;
                        System.out.println("\nSeat cancellation successful!.");
                    } else {
                        System.out.println("\nSorry! The selected seat in that row is not booked.");
                    }
                }else {
                    System.out.println("Sorry!You have entered a wrong Seat number.");
                }
                break;

            case 3:

                if(seatNumber<=20){
                    if (row3[seatNumber - 1] == 1) {
                        row3[seatNumber - 1] = 0;
                        System.out.println("\nSeat cancellation successful!.");
                    } else {
                        System.out.println("\nSorry! The selected seat in that row is not booked.");
                    }
                }else {
                    System.out.println("Sorry!You have entered a wrong Seat number.");
                }
                break;

            default:
                System.out.println("Sorry! You have entered a wrong row number.");
        }
    }

    public static void show_available(){

        System.out.print("Seats available in row 1: ");
        for (int k=0;k<row1.length;k++) {                       //used a for loop to iterate through row arrays
            if (row1[k] == 0)                               //using if condition and checking the values of elements printed on the console
                System.out.print(k+1 + ",");
        }
        System.out.println();
        System.out.print("Seats available in row 2: ");
        for (int k=0;k<row2.length;k++) {
            if (row2[k] == 0)
                System.out.print(k+1 + ",");
        }
        System.out.println();
        System.out.print("Seats available in row 3: ");
        for (int k=0;k<row3.length;k++) {
            if (row3[k] == 0)
                System.out.print(k+1 + ",");
        }
        System.out.println();
    }

    public static void save(){
        try{
            PrintWriter myWriter=new PrintWriter("tickets_data.txt");   //created a new PrintWriter object to write on the text file

            myWriter.println("Row 1:");                         //write the data line by line as it is easy to access when reading
            for(int seats:row1)                                 //used a for loop to iterate through the row arrays
                myWriter.println(seats);

            myWriter.println("Row 2:");
            for(int seats:row2)
                myWriter.println(seats);

            myWriter.println("Row 3:");
            for(int seats:row3)
                myWriter.println(seats);

            myWriter.close();
            System.out.println("Row's information saved successfully.");

        }
        catch(IOException e){
            System.out.println("Sorry! Something went wrong.");
        }
    }

    public static void load(){

        try {
            File myFile = new File("tickets_data.txt");
            Scanner myFile_reader = new Scanner(myFile);                    //created a new Scanner object to read the file
            int lineCounter=1;                                      //added a line counter variable to read the lines in the file
            int linesToBeReducedToAccessTheIndexesOfRow1=2;         //created this variable to easily access the row1 elements by reducing from the line counter
            int linesToBeReducedToAccessTheIndexesOfRow2=15;        //created this variable to easily access the row2 elements by reducing from the line counter
            int linesToBeReducedToAccessTheIndexesOfRow3=32;        //created this variable to easily access the row3 elements by reducing from the line counter

            while(myFile_reader.hasNext()) {             //created a while loop to iterate through the file lines until it ends
                String line = myFile_reader.nextLine();             //assigned the read line data to a String variable
                if (lineCounter <= 13) {
                    if (line.startsWith("Row")) {           //using an if condition checked whether the file line start with "Row" and added line counter
                        lineCounter++;
                    }
                    else  {
                        if (line.equals("0")) {
                            row1[lineCounter - linesToBeReducedToAccessTheIndexesOfRow1] = 0;
                            lineCounter++;
                        }if (line.equals("1")) {
                            row1[lineCounter - linesToBeReducedToAccessTheIndexesOfRow1] = 1;
                            lineCounter++;
                        }
                    }
                }
                else if (lineCounter <= 30) {
                    if (line.startsWith("Row")) {
                        lineCounter++;
                    }
                    else {
                        if (line.equals("0")) {
                            row2[lineCounter - linesToBeReducedToAccessTheIndexesOfRow2] = 0;
                            lineCounter++;
                        }if (line.equals("1")) {
                            row2[lineCounter - linesToBeReducedToAccessTheIndexesOfRow2] = 1;
                            lineCounter++;
                        }
                    }
                }
                else if (lineCounter <= 51) {
                    if (line.startsWith("Row")) {
                        lineCounter++;
                    }
                    else{
                        if (line.equals("0")) {
                            row3[lineCounter - linesToBeReducedToAccessTheIndexesOfRow3] = 0;
                            lineCounter++;
                        }if (line.equals("1")) {
                            row3[lineCounter - linesToBeReducedToAccessTheIndexesOfRow3] = 1;
                            lineCounter++;
                        }
                    }
                }
            }
            myFile_reader.close();
            System.out.println("Row's information loaded successfully.");
        }

        catch(IOException e){
            System.out.println("Sorry! Something went wrong.");
        }
    }

    public static void show_tickets_info(){

        //set an integer to sum up the total ticket price
        int ticketTotalValue=0;
        for(Ticket tickets: ticketsArray) {                     //iterate through the arraylist using a for loop
                System.out.println(tickets.print());            //using .print method printed the data on the console
                //add ticket prices
                ticketTotalValue += tickets.getPrice();         //adds ticket price to the total using get.price method
            }
        System.out.println("-".repeat(40)+"\nTotal ticket price is: £" + ticketTotalValue+"\n"+"-".repeat(40));
    }

    public static void sort_tickets(){

        ArrayList<Ticket> sortedArray=new ArrayList<>();
        sortedArray=(ArrayList)ticketsArray.clone();      //cloning the same data in the ticketsArray to a new Array to sort

        int lastIndex = sortedArray.size() - 2;
        Ticket temporaryTicket;                   //Declares a ticket variable called temporaryTicket
        boolean ticketsSwitched = true;
        while (ticketsSwitched) {               //checks and loops until the elements of arraylist gets switched
            ticketsSwitched = false;
            for (int i = 0; i <= lastIndex; i++) {
                int ticketPrice1 = sortedArray.get(i).getPrice();           //assigns i th objects' ticket price to a variable
                int ticketPrice2 = sortedArray.get(i + 1).getPrice();       //assigns i+1 th objects' ticket price to a variable
                if (ticketPrice1 > ticketPrice2) {
                    temporaryTicket = sortedArray.get(i);               //saves i+1 ticket data to the variable temporaryTicket to use later
                    sortedArray.set(i, sortedArray.get(i + 1));         //switches the data of i+1 to i th ticket
                    sortedArray.set(i + 1, temporaryTicket);            //saving the data saved on temporary ticket variable to i+1 index
                    ticketsSwitched = true;
                }
            } lastIndex--;
        }
        for (Ticket ticket: sortedArray){                   //iterate through the new sorted array to print data suing a for loop
            System.out.println(ticket.print());
        }
    }
}