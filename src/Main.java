import java.io.*;
import java.util.Scanner;

public class Main {

//    The program should decorate the object dynamically:
//
//    When the program runs, it should prompt for a file to read. (It’s up to you whether to read the contents of the file at this time, or wait until the decorator chain is created. I think it’s a lot easier to wait, then process the file a line at a time.)
//    It then presents a menu of the desired decorations to apply.
//    a. The user can select multiple decorations; they will be applied in order.
//    b. If the user selects TeeOutput, prompt for a file name to direct the Tee output to.
//    c. If the user selects FilterOutput, give the user a choice of at least two predicates to choose from.
//    Then produce the decorated output.

    public static void main(String[] args) throws IOException {

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please enter the path of the file you wish to use: ");
        String fileName = inputScanner.nextLine().trim();

        Output streamOutput = new StreamOutput(new PrintWriter(System.out));

        String input = "";
        while (!input.equals("f")) {
            System.out.println("Please enter the number for the decorator you would like to add and press enter: ");
            System.out.println("\t1. LineOutput: adds a newline with every write");
            System.out.println("\t2. EnumeratedOutput: adds a line number and newline with ever write");
            System.out.println("\t3. TeeOutput: writes to two streams at a time");
            System.out.println("\t4. FilterOutput: writes only those objects that satisfy a certain condition");
            System.out.println("\tF. Finished adding decorators");

            input = inputScanner.nextLine().trim().toLowerCase();

            if (input.equals("1")) {
                streamOutput = new LineOutput(streamOutput);
            } else if (input.equals("2")) {
                streamOutput = new EnumeratedOutput(streamOutput);
            } else if (input.equals("3")) {
                System.out.print("Please enter a file name: ");
                String userFile = inputScanner.nextLine().trim();
                streamOutput = new TeeOutput(streamOutput, userFile);
                System.out.println("\n");
            } else if (input.equals("4")) {
                System.out.println("\nPredicate options:");
                System.out.println("\t1. The line contains a number");
                System.out.println("\t2. The line has a special character");
                String predicateSelection = inputScanner.nextLine().trim();
                if (predicateSelection.equals("1")) {
                    streamOutput = new FilterOutput(streamOutput);
                } else if (predicateSelection.equals("2")) {
                    streamOutput = new SpecialCharOutput(streamOutput);
                } else {
                    System.out.println("Invalid selection.\n");
                }
            } else if (input.equals("f")) {
                System.out.println();
                System.out.println("Preparing your output.\n");
            } else {
                System.out.println();
                System.out.println("Invalid input, please try again.\n");
            }
        }
        inputScanner.close();

        // Open the file
        FileInputStream fstream = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
//        Output streamOutput = new TeeOutput(new EnumeratedOutput(new LineOutput(new StreamOutput(new PrintWriter(System.out)))), "Test");
        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            streamOutput.write(strLine);
        }
        //Close the input stream
        br.close();
    }
}
