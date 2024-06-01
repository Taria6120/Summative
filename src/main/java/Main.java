// Filename: W8U2A4_Alishba_Tariq_Employees_Database
// Author: Alishba Tariq 
// Date: Wednesday, April 17, 2024
// Purpose: Collecting_Employee_Database
// */

// import java.util.Scanner;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    String[][] array = new String[3][6];
    // The array is going to be 3 rows and 6 columns. The rows will be the employees and the columns will be their - lastname, ID number, hours worked in week 1, hours worked in week 2, and hours worked in week 3.
    Scanner input = new Scanner(System.in);
    for (int i = 0; i < 3; i++) {
      System.out.println("Please enter your last name: ");
      String lastName = input.nextLine();
      array[i][0] = lastName;

      System.out.println("Please enter your four digit ID number: ");
      String id = input.nextLine();
      array[i][1] = id;

      for (int j = 2; j <= 5; j++) {
        System.out.println("Please enter the number of hours you worked in week " + (j - 1));
        String hours = input.nextLine();
        array[i][j] = hours;
      }
    }
    // The user will be asked to enter their last name and ID number. The user will be asked to enter their hours worked in the weeks.
    while (true) {
      System.out.println("Please enter 1 to List All Database Info ");
      System.out.println("Please enter 2 to List Employee Info ");
      System.out.println("Please enter 3 to List Company's Weekly Hours Stats ");
      System.out.println("Please enter 4 to List Company's Monthly Hours Stats ");
      System.out.println("Please enter 5 to exit the program ");
// The user will be asked to enter a number from 1 to 5. 
      int option = input.nextInt();
      switch (option) {
        case 1:
          print_database(array);
          // If the user enters 1, the program will print the entire database.
          break;
        case 2:
          System.out.println("Please enter 1 to search by Lastname ");
          System.out.println("Please enter 2 to search by ID Number ");
          Scanner sub_input = new Scanner(System.in);
          int row = -1;
          if (sub_input.nextInt() == 1) {
            System.out.println("Enter Lastname:");
            String name = input.nextLine();
            while(name.length() == 0)
              name = input.nextLine();
            System.out.println(name);
            row = search_database_by_lastname(array, name);
          } else {
            System.out.println("Enter ID:");
            String employee_id = input.nextLine();
            while(employee_id.length() == 0)
              employee_id = input.nextLine();
            System.out.println(employee_id);
            row = search_database_by_id(array, employee_id);
          }
 // If the user enters 2, the program will ask the user to enter 1 to search the employees by their lastnames or 2 to search the employees by their ID number. 
          if (row != -1) {
            print_database_for_row(array, row);
// If the user enters a valid row number, the program will print the information for that row.
            calculate_average_hours_for_row(array, row);
          } else {
            System.out.println("Could not find employee");
// If the user enters an invalid row number, the program will print "Could not find employee".
          }
          break;
        case 3:
           System.out.println("What week would you like to see the stats for?");
           int week = input.nextInt();
           if(week >= 1 & week < 5)
           {
             calculate_average_hours_for_column(array, week+1);
// If the user enters 3, the program will ask the user to enter the week they would like to see the stats for that week. The if statement will check if the week is valid. If it is, the program will calculate the average hours worked for that week and the total hours worked in that week.
           } 
           else 
           {
              System.out.println("Invalid week");
             
           }
          break;
        case 4:
          print_monthly_stats(array);
// If the user enters 4, the program will print the monthly stats for the employees. It will show the data of all employees from the four weeks. 
        case 5:
          System.out.println("Exiting...");
          System.exit(0);
// If the user enters 5, the program will exit.
          break;
        default:
          System.out.println("Incorrect option.");
          input.close();
// If the user enters an invalid option, the program will print "Incorrect option. Please try again." and exit.
          return;
      }
    }
  }

  static void print_database(String array[][]) {
    for (int i = 0; i < 3; i++) {
      System.out.println("Employee lastname:" + array[i][0]);
      System.out.println("Employee ID:" + array[i][1]);
      for (int j = 2; j <= 5; j++) {
        System.out.println("Week " + (j - 1) + " hours: " + array[i][j]);
// This method will print the entire database.This is done by using a for loop to iterate through the rows and columns of the array. This will happen when the user enters 1.
      }
    }
  }

  static void print_database_for_row(String array[][], int row) {
    System.out.println("Employee lastname:" + array[row][0]);
    System.out.println("Employee ID:" + array[row][1]);
    for (int j = 2; j <= 5; j++) {
      System.out.println("Week " + (j - 1) + " hours: " + array[row][j]);
    }
  }
// This method will print the information for a specific row. This is done by using a for loop to iterate through the columns of the weeks. This will happen when the user enters 2.
  static int search_database_by_lastname(String array[][], String lastname) {
    for (int i = 0; i < 3; i++) {
      if (array[i][0].equals(lastname)) {
        return i;
      }
    }
    return -1;
  }
// This method will search the database by lastname. This is done by using a for loop to iterate through the rows and checking if the lastname matches. This will happen when the user enters 2 and the suboption 1.
  static int search_database_by_id(String array[][], String id) {
    for (int i = 0; i < 3; i++) {
      if (array[i][1].equals(id)) {
        return i;
      }
    }
    return -1;
  }
// This method will search the database by ID number. This is done by using a for loop to iterate through the rows and checking if the ID number matches. This will happen when the user enters 2 and the suboption 2.
  static void calculate_average_hours_for_row(String array[][], int row){
    double total = 0;
    for(int i = 2; i <= 5; i++){
      total += Double.parseDouble(array[row][i]);
    }
    System.out.println("Average hours worked: " + (total/4));
  }
// This method will calculate the average hours worked for a specific row. This is done by using a for loop to iterate through the columns of the weeks and adding up the total hours worked. 

  static void calculate_average_hours_for_column(String array[][], int column) {
    double total = 0;
    for (int i = 0; i < 3; i++){
      total += Double.parseDouble(array[i][column]);
    }
    System.out.println("Average hours for week " + (column - 1) + " is " + total/ 3);
    System.out.println("Total hours: " + total);
      
    }
// This method will calculate the average hours worked for a specific column. This is done by using a for loop to iterate through the rows and adding up the total hours worked. 

  static void print_monthly_stats(String array[][]){
    double total = 0;
    for (int i = 0; i < 3; i++){
      for (int j = 2; j <= 5; j++){
        total += Double.parseDouble(array[i][j]);
      }
    }
    System.out.println("Total hours: " + total);
    System.out.println("Average hours: " + total / 12);
  }
// This method will print the monthly stats for the employees. It will show the data of all employees from the four weeks. This will show the total amount of hours all the employees worked and the average hours they worked, This is done by using a for loop to iterate through the rows and columns of the array. This will happen when the user enters 4.
}

