import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

    Scanner data = new Scanner (System.in);
        //Question 1 ***
     int [] num = {50, -20, 0, 30, 40, 60, 10};
      System.out.println (num.length >= 2 && num[0] ==  num[num.length-1]);

        //###########################################################
//        //Question 2 ***
        int[] n = new int[] {1, 4, 17, 7, 25, 3, 100};
        int k;
        System.out.println("enter number of k ");
        k=data.nextInt();

        Arrays.sort(n);
        for (int i = 0; i < n.length / 2; i++) {
            int temp = n[i];
            n[i] = n[n.length - 1 - i];
            n[n.length - 1 - i] = temp;
        }

        System.out.println("The " + k + " largest elements in the array are:");
        for (int i = 0; i < k ; i++) {
            System.out.print(n[i] + " ");
        }
        //###########################################################

       //Question 3   ***
        int []number = {1,4,17,7,25,3,100};
        int sum=0;
        for (int i=0; i<number.length;i++){
            sum = sum + number[i]  ;
        }
        int avg = sum / number.length ;
        for (int y : number ){
            if (y > avg )
                System.out.println(y);
        }
        //###########################################################

        //Question 4 ***
         int [] ar = {20, 30, 40};
         int f = ar[0];
         int l = ar[ar.length-1];
              if (f > l ){
                  System.out.println(f);
              }
              else if (l>f){
                  System.out.println(l);
              }
              else {
                  System.out.println("done");
              }

         //###########################################################

        //Question 5 ***
        int[] array = {20, 30, 40};
        int[] newArray = Arrays.copyOf(array, array.length);
        int temp = newArray[0];
        newArray[0] = newArray[newArray.length - 1];
        newArray[newArray.length - 1] = temp;
        System.out.println("New array after swapping the first and last elements: " + Arrays.toString(newArray));

        //###########################################################
        //Question 6  ***
        String[] dictionary = {"cat", "dog", "red", "is", "am"};
        ArrayList<String> list = new ArrayList<>();
        int max = 0;
        for (String word : dictionary){
            if (word.length() > max) {
                max = word.length();
            }
        }
        for(String w : dictionary){
            if(w.length() == max){
                list.add(w);
            }
        }
        System.out.print("result: ");
        for (String q : list){
            System.out.print(q + " ");
        }
        //###########################################################

        //Question 7 ***
        System.out.println("enter number from 1 to 5 ");
        System.out.println("1-Accept elements of an array");
        System.out.println("2-Display elements of an array");
        System.out.println("3-Search the element within array");
        System.out.println("4-Sort the array");
        System.out.println("5-To Stop");
        int [] arr = null;
        boolean stop = false;
        while (!stop) {
            int d = data.nextInt();
            switch (d) {
                case 1:
                    System.out.println("enter the size of array");
                    int size = data.nextInt();
                    arr = new int[size];
                    System.out.println("enter the elements of array");
                    for (int g = 0; g < size; g++) {
                        arr[g] = data.nextInt();
                    }
                    break;
                case 2:
                    if (arr == null) {
                        System.out.println("Array is empty");
                    } else {
                        System.out.println("enter element of array are  : ");
                        for (int e : arr) {
                            System.out.println(e);
                        }
                    }
                    break;
                case 3:
                    if (arr == null) {
                        System.out.println("Array is empty");
                    } else {
                        System.out.println("enter element to serach : ");
                        int se = data.nextInt();
                        boolean found = false;
                        for (int s = 0; s < arr.length; s++) {
                            if (arr[s] == se) {
                                System.out.println("element found at index " + s);
                                found = true;
                                break;
                            }

                        }
                        if (!found) {
                            System.out.println("element not found in array !");
                        }
                    }
                    break;
                case 4:
                    if (arr == null) {
                        System.out.println("Array is empty");
                    } else {
                        Arrays.sort(arr);
                        System.out.println("the sorted array is ");
                        for (int g : arr) {
                            System.out.println(g);
                        }
                    }
                    break;
                case 5:
                    stop = true;
                    break;
                default:
                    System.out.println("Invalied choice ");
                    break;
            }
            }

        //Question 8 ***
        int [] a = {1,1,1,3,3,5};
        int count =0; int x;
        System.out.println("enter number to show the occurrences in array");
        x=data.nextInt();
        for(int b = 0; b <a.length; b++) {
            if (a[b] == x) {
                count++;
            }
        }
        System.out.println( x +" occurs " + count);

        //###########################################################
        //Question 9 ***
        int [] g = {2,3,40,1,5,9,4,10,7};
        int z = g.length;
        int []result = new int [z];
        int odd = 0;
        int even = z-1;
        for (int j =0 ; j<z ; j++){
            if (g[j] % 2 !=0){
                result[odd]=g[j];
                odd++;
            }
            else{
                result[even]=g[j];
                even--;
            }
        }
       for (int y=0; y<z; y++){
           System.out.print(result[y] + " ");
       }

        //###########################################################

        //Question 10  ***
        int [] m = {2,3,4,5,6,7};
        int [] r ={2,3,4,5,6,7};
        if  (Arrays. equals(m, r)){
            System.out.println("true ");
        }
         else
        {
            System.out.println("false");
        }
        //###########################################################

    }
}