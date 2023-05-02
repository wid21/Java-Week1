import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);

        //Question 1
        for (int i =0 ; i<=100 ; i++){
           if (i % 3 ==0){
               System.out.println("Fizz");
           }
            if (i % 5 ==0 ){
               System.out.println("Buzz");
           }
           if (i % 3 ==0 && i % 5 ==0){
               System.out.println("FizzBuzz");
           }
           else
           {
               System.out.println(i);;
           }
        }
//########################################################
        //Question 2
        String str = ("The quick brown fox");
        String str2= "";
        for (int i=str.length()-1; i>=0 ;i--){
            str2+=str.charAt(i);
        }
        System.out.println(str2);
//########################################################
        //Question 3
   System.out.println("enter number to show the multiplication table ");
    int b = data.nextInt();
    for(int i=0; i<10 ; i++){
       System.out.println(b+ " X " + (i+1) + " = " + b * (i+1));
      }
//########################################################
        //Question 4
        System.out.println("enter a num");
        int u = data.nextInt();
        int fac = 1;
        int i  ;
        for ( i =1 ; i <= u ; i++){
            fac *= i;
        }
      System.out.println("Factorial of the the number " + (i-1) + " is " + fac);
//########################################################
        //Question 5
        int c=1;
        System.out.println("enter first number");
        int a = data.nextInt();
        System.out.println("enter second number");
        int d = data.nextInt();
        while (d !=0){
           c  *= a ;
           d--;
        }
        System.out.println("the result of exponential number "+ a +" is " + c);
//#######################################################
        // Question 6
        int k ;
        int m =0 ;
        int even =0;
        int odd=0;
        while (m != -1 ){
            System.out.println("enter number or -1 tp quit ");
            k=data.nextInt();
            if (k==-1){
                break;
            }
            if (k % 2==0){
               even = even+ k;
            }
            else if  (k % 2 !=0){
                odd=odd+k;   }
                 m++;
        }
  System.out.println("the sum of even numbers are : "+ even );
  System.out.println("the sum of odd numbers are : " +odd );
//#############################################################

        //Question 7
        int count = 0;
        System.out.println("Enter postive number ");
        int num = data.nextInt();
        while (num < 0) {
            System.out.println("Wrong input try again !!!");
             num = data.nextInt();
        }  if (num >0 ) {
            for (int in = 1; in <= num; in++) {
                if (num % in == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.printf(num + " It is a prime number ");
            } else {
                System.out.printf(num + " It is not a prime number ");
            }
        }
//########################################################
       // Question 8
     int p =0;  int n=0;  int z=0;
     boolean en = true;
         while (en){
       System.out.println("Enter number ");
         int  j = data.nextInt();
               if (j > 0) {
                    p++;
                } else if (j < 0) {
                    n++;
                } else {
                    z++;
                }
           System.out.println("Enter y to continue");
             String choice = data.nextLine();
             choice=data.next();
             en = choice.equalsIgnoreCase("y");
            }
         System.out.println("postive number are " + p);
         System.out.println("negative number are " + n);
         System.out.println("zero number are " + z);

//########################################################
        //Question 9
        for (int x=1; x<=4 ; x++){
            System.out.println("Week"+ x);
            for (int j =1 ; j <= 7; j++){
                System.out.println("Day"+ j);
            }
        }
//########################################################

        //Question 10
        System.out.print("Enter a word: ");
        String word = data.nextLine().toLowerCase();
        boolean isPalindrome = true;
        for (int g = 0, j = word.length() - 1; g < j; g++, j--) {
            if (word.charAt(g) != word.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println(word + " is a palindrome!");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
//###########################################################
    }
}