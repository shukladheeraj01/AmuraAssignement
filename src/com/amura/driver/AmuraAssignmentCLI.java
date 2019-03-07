package com.amura.driver;

import com.amura.subarrayfinder.MaxiMumSubArrayFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AmuraAssignmentCLI {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String options = "\n Options\n" + "start (press : s )\n" + "quit (press :q)\n";

        while ( true ) {
            System.out.println(options);

            String input = scanner.nextLine();
            if ( input.equalsIgnoreCase("s") ) {
                findMaximumSubArray();

            } else if ( input.equalsIgnoreCase("q") ) {
                scanner.close();
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    private static void findMaximumSubArray() throws Exception {
        System.out.println("Enter the array : \n(press any character to end input)");
        List<Integer> arr = new ArrayList<>();
        while ( true ) {
            if ( scanner.hasNextInt() ) {
                int nextInt = scanner.nextInt();
                arr.add(nextInt);
            } else {
                scanner.reset();
                break;
            }
        }
        MaxiMumSubArrayFinder findMaxSubArray = new MaxiMumSubArrayFinder(arr);
        List<Integer> op = findMaxSubArray.getMaxiMumSubArray();
        System.out.println("Largest SubArray");
        System.out.println("Start Index : " + op.get(0));
        System.out.println("Length : " + op.get(1));
        System.out.println("Sum : " + op.get(2));
        System.out.println("Elements : " + arr.subList(op.get(0), (op.get(0)+op.get(1))));
    }

}
