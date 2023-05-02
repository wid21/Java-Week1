import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner data = new Scanner(System.in);
         //Question 1
        int n1 = 125 ;
        int n2 =24 ;
        int Sum = n1 + n2 ;
        int sub = n1 - n2 ;
        int multi = n1 * n2 ;
        int div = n1/ n2;
        int mod = n1 % n2;
       System.out.println("the sum is " + Sum );
       System.out.println("the subtraction is " + sub);
       System.out.println("the multiplication is " + multi);
       System.out.println("the division is " + div);
       System.out.println("the reminder is " + mod);


       //Question 2
        String word = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        System.out.println(word.toLowerCase());

        //Question 3

        System.out.println("Enter word ");
        String word2  = data.nextLine();
        System.out.println("Enter index ");
        int index = data.nextInt();
        System.out.println(word2.charAt(index));

        // Question 4

        System.out.println("Enter number ");
        int number = data.nextInt();
        if (number % 2 == 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        //Question5
          System.out.println("Enter your role");
          String role = data.nextLine();
         if (role.equalsIgnoreCase("admin")){
             System.out.println(" welcome " + role);
          }
         else if (role.equalsIgnoreCase("superuser"))
         {
             System.out.println( "welcome " + role);
          }
         else
        {
            System.out.println("welcome user");
        }

       // Question 6

         System.out.println("Enter first number");
         int num1 = data.nextInt();
         System.out.println("Enter second number");
         int num2 = data.nextInt();
         System.out.println("Enter third number");
         int num3 = data.nextInt();
         int sum = num1 + num2 ;
         if (sum == num3 )
        {
            System.out.println("the result is true");
        }
         else
        {
            System.out.println("the result is false ");
        }

        //Question 7
        System.out.println("Enter 1st  number");
         int Num1 = data.nextInt();
         System.out.println("Enter 2nd number ");
         int Num2 = data.nextInt();
         System.out.println("Enter 3rd number");
         int Num3 = data.nextInt();
         if (Num1 >= Num2 && Num1 >= Num3)
        {
            System.out.println("The greatest: " + Num1 );
        }
         else if (Num2>= Num1 && Num2 >= Num3)
        {
            System.out.println("The greatest: " + Num2);
        }
         else
         {
             System.out.println("The greatest: " + Num3);
         }

        //Question 8
        System.out.println("Enter number between 1 to 7 to inquirer week days ");
        int n = data.nextInt();
        switch (n)
        {
            case 1 :
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;

            case 6:
                System.out.println("Saturday");
                break;

            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("invalid number try again");
        }
    }
}