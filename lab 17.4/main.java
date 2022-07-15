import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       String currentDir = System.getProperty("user.dir");
       String author = System.getProperty("user.name");

       LocalDateTime dateObj = LocalDateTime.now();
       DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss yyyy");
       String date = dateObj.format(formatObj);

       System.out.println("Working Directory: " + currentDir);
       System.out.println("Author: " + author);
       System.out.println(date);

       Scanner sc = new Scanner(System.in);
       String name;
       float budget, expense, total = 0;

       System.out.print("Enter your name: ");
       name = sc.nextLine();

       System.out.print("Enter your budget for the month: ");
       budget = sc.nextFloat();

       while(true) {
           System.out.print("Enter an expense, or a negative number to quit: ");
           expense = sc.nextFloat();
           if (expense < 0){
               break;
           }
           total += expense;
       }

       if (total > budget){
           System.out.printf(name + ", You are OVER budget by $%,.2f", (total - budget));
       } else if (total < budget) {
           System.out.printf(name + ", You are UNDER budget by $%,.2f", (budget - total));
       } else {
           System.out.println(name + ", Good Job! You are on Budget.");
       }

   }
}
