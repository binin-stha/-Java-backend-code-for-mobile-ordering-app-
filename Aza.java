import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Aza {
    static Scanner in = new Scanner(System.in);  // to take inputs form user

    public static void main(String[] args) {
        clear(); 
        start();  
      }
      
      // Asking the user to sign in or quit
      public static void start() {
      System.out.println("Welcome to the mobile ordering app.\n");
      System.out.println("Enter 1 for Sign Up.");
        System.out.println("Enter 2 for Quit.");
        System.out.print("User choice: ");
        int choice = in.nextInt();
        in.nextLine();
        switch (choice) {
            case 1:
                clear();
                signIn();
                break;
            case 2:
                System.out.println("Thank you for using the application.");
                break;
            default:
                System.out.println("Invalid Input.");
        }
    }
    
    
    // All sign in processes
    public static void signIn() {
      ArrayList<String> arr = new ArrayList<>();
        boolean validInput = false;
        do {
            System.out.print("Please enter your full name: ");
            String name = in.nextLine();
            validInput = nameValid(name);
            if (!validInput) {
                 clear();
                System.out.println("Invalid name.\nHint: Name cannot be less than 4 letters and Surname cannot be empty.\nPlease try again.\n");
            } else arr.add(name);
        } while (!validInput);

        validInput = false;
        do {
            System.out.print("Enter your mobile number: ");
            String number = in.next();
            in.nextLine();
            validInput = numValid(number);

            if (!validInput) {
                 clear();
                System.out.println("Invalid number.\nHint: Number should start with zero(0) and should only contain digits (exact 10).\nPlease try again.\n");
            } else arr.add(number);
        } while (!validInput);

        validInput = false;
        String password;
        do {
            System.out.print("Enter your password: ");
            password = in.next();
            in.nextLine();
            validInput = passwordValid(password);

            if (!validInput) {
                 clear();
                System.out.println("Invalid password.\nHint: Your password should start with an alphabet followed by either '@' or '&' and end with a number.\nEg: 'John@123' or 'john&32'.\nPlease try again.\n");
            } else arr.add(password);
        } while (!validInput);

        validInput = false;
        do {
            System.out.print("Please confirm your password: ");
            String confirmPassword = in.next();
            in.nextLine();
            validInput = confirmPasswordValid(confirmPassword, password);

            if (!validInput) {
                // clear();
                System.out.println("Your passwords do not match. Please try again.\n");
            }
        } while (!validInput);

        validInput = false;
        do {
            System.out.print("Please enter your Date of Birth #DD/MM/YYYY (No space): ");
            String dob = in.nextLine();
            validInput = dobValid(dob);

            if (!validInput) {
                 clear();
                System.out.println("You have entered the Date of Birth in invalid format.\nHint: You must be atleast 21 years.\nPlease try again.\n");
            } else arr.add(dob);
        } while (!validInput);
        // System.out.println("\n" + arr);
        display(arr);
        System.out.println("You have successfully signed up.\n");
        start(); 
    }
    
    // to check if the given name meants the criteria
    public static boolean nameValid(String name) {
      if (name.length() < 4 || !name.contains(" ")) {
        return false; 
      }
      else{
        return true;
      }
    }

    // to check if the user confirms the password
    public static boolean confirmPasswordValid(String confirmPassword, String password) {
        boolean right = password.equals(confirmPassword);
        if (!right) {
          return false;
        }
        return true;
      }


    // to check if the given number is valid according to given criteria
    public static boolean numValid(String num) {
      boolean containLetter = letterCheck(num);
      if (!num.startsWith("0") || num.length()!= 10 || containLetter ) {
        return false;
      }
      return true;
    }
    
    // to check if user mistakenly inputs letter in number section
    public static boolean letterCheck(String num) {
      for (int i = 0; i<num.length(); i++) {
        if (!Character.isDigit(num.charAt(i))) {
          return true;
        }
      }
      return false;
    }
  
    // to check if the given password meets the criteria
    public static boolean passwordValid(String password) {
      char first = password.charAt(0);
      char last = password.charAt(password.length()-1);
      boolean aderate=password.contains("@");
      boolean ampersend=password.contains("&");
      if (!Character.isLetter(first) || !Character.isDigit(last) || (!aderate && !ampersend)) {
        return false;
      }  
      return true;
    }

    // to check if the give date of birth is in correct format
    public static boolean dobValid(String dob){
    String arr[]=dob.split("/");
    int day=Integer.parseInt(arr[0]);
    int month=Integer.parseInt(arr[1]);
    int year=Integer.parseInt(arr[2]);
    LocalDate today = LocalDate.now();
    int yearToday=today.getYear();
    int age=yearToday-year;
    if(!(day>0 && day<=30) || !(month>0 && month<=12) || !(age>=20 && age<120)){
         return false;
    }
    return true;
    }


    // to clear the terminal 
    public static void clear() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }

    // to display user data
    public static void display(ArrayList<String> arr) {
      // clear();
      System.out.println("Your name is: " + arr.get(0)+"\nYour mobile number is: " + arr.get(1) +"\nYour password is: " + arr.get(2) + "\nYour date of birth is: " + arr.get(3) + "\n");
    }
} 
  