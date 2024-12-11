import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                    // add your code here
                if (Ex1.isNumber(num1) == true && Ex1.number2Int(num1) != -1) {
                    System.out.println("num1= " + num1 + " is number: " + Ex1.isNumber(num1) + " , value: " + Ex1.number2Int(num1));

                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.next();

                    if (Ex1.isNumber(num2) == true && Ex1.number2Int(num2) != -1) {
                        System.out.println("num2= " + num2 + " is number: " + Ex1.isNumber(num2) + " , value: " + Ex1.number2Int(num2));

                        String  basestr = "";
                        System.out.println("Enter a base for output: (a number [2,16])");
                        basestr = sc.next();
                        int base = Integer.parseInt(basestr);
                        if(base >= 2 && base <= 16) {

                          int x =  Ex1.number2Int(num1) + Ex1.number2Int(num2);
                          String baseplus = Ex1.int2Number(x, base);
                          System.out.println(num1 + " + " + num2 + " = " + baseplus);

                          int y = Ex1.number2Int(num1) * Ex1.number2Int(num2);
                          String basetimes = Ex1.int2Number(y, base);
                          System.out.println(num1 + " * " + num2 + " = " + basetimes);

                          String[] max = {num1, num2,baseplus,basetimes};
                          System.out.println("Max number over [" + num1 + ", " + num2 + "," + basetimes + "," + basetimes + "] is:" + max[Ex1.maxIndex(max)]);
                        }
                        else {
                            System.out.println("ERR: wrong base, should be [2,16], got (" + basestr + ")");
                        }




                    } else {
                        System.out.println("num2= " + num2 + " is number: " + Ex1.isNumber(num2) + " , value: " + Ex1.number2Int(num2));
                        System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                    }
                }
                else {
                    System.out.println("num1= " + num1 + " is number: " + Ex1.isNumber(num1) + " , value: " + Ex1.number2Int(num1));
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                }



            }





                /////////////////////

        }
        System.out.println("quiting now...");
//        System.out.println(Ex1.maxIndex("101b2","222b3"));
//        System.out.println(Ex1.int2Number(100,16));


    }
}
