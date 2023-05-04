import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner data = new Scanner (System.in);

 // print odd number
//        for (int i = 0 ; i <= 100 ; i++)
//        {
//            if (i % 2 != 0)
//                System.out.println(i);
//        }
 // print even number from 100
//        for (int j=100; j >= 1 ; j--)
//        {
//            if (j % 2 ==0 )
//                System.out.println(j);
//        }


//        System.out.println(" enter number ");
//
//        int sum =0 ;
//        int n =0;
//        while (n != -1) {
//            n = data.nextInt();
//            sum = sum + n;
//        }
//
//        System.out.println(sum);

//        for (int i = 0 ; i <= 100 ; i++){
//            if (i % 2 ==0 ){
//                continue;
//            }
//            System.out.println(i);
//            if  (i == 61) {
//                break;
//            }
//
//        }
//        int i=1;
//        do {
//
//
//            System.out.println("w");
//
//            i++;
//
//
//        } while(i<=5);
 // #################################################

        int [] n = new int[4];
        n[0]=1;
        n[1]=2;
        n[2]=3;
        n[3]=4;
           for (int j =0 ; j<n.length;j++){
               System.out.println(n[j]);
           }

        String [] array = {"apple ", "orange", "pineapple"};
             for (int i=0 ; i< array.length;i++){
               System.out.println(array[i]);
    }




























    }
}