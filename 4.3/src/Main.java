import First_part.EmployeeRepository;
import Second_part.MessagePrinter;
import Second_part.Printable;
import Second_part.Printer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        EmployeeRepository employeeRepo = new EmployeeRepository();
//        System.out.println(Arrays.toString(employeeRepository.getNameAndSurnameOfTop3BySalary()));
        System.out.println("Input a message:");
        Scanner scanner = new Scanner(System.in);
        String userMessage = scanner.nextLine();
        printMenu();

        int optionIndex = scanner.nextInt();
        getResult(userMessage, optionIndex);

    }

    public static void printMenu() {
        System.out.println();
        System.out.println("0 " + "Print message in a custom stream");
        System.out.println("1 " + "Print message in an err stream via lambda expressions");
        System.out.println("2 " + "Print message in a file format");
        System.out.println();
        System.out.println("Choose the option from above:");
    }

    public static void getResult(String msg, int n) {
        MessagePrinter msgPrinter = new MessagePrinter();

        switch (n) {
            case 0 -> {
                Printable streamPrintable = new Printable() {
                    @Override
                    public void print(String msg) throws IOException {
                        System.out.println(msg + " from stream");
                    }
                };
                msgPrinter.print(msg, streamPrintable);
            }
            case 1 -> {
                Printable errStreamPrintable = message -> System.err.println(msg);
                msgPrinter.print(msg, errStreamPrintable);
            }
            case 2 -> {
                Printable filePrintable = Main::writeToTile;
                msgPrinter.print(msg, filePrintable);
            }
        }
    }

    public static void writeToTile(String msg) throws IOException{
        try(PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))){
            pw.println(msg);
        }
    }
}