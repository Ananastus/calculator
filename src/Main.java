import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print(calc(scan.nextLine()));
        }catch (NullPointerException | NumberFormatException | ArithmeticException q){
            System.out.println("throws Exception");
        }
    }

    public static String calc(String line){
        int num = 0;
        String s = "throws Exception";
        String [] str = null;

            if (line.indexOf(43) != -1) {
                str = line.split("\\+");
                num = Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
            } else if (line.indexOf(45) != -1) {
                str = line.split("-");
                num = Integer.parseInt(str[0]) - Integer.parseInt(str[1]);
            } else if (line.indexOf(42) != -1) {
                str = line.split("\\*");
                num = Integer.parseInt(str[0]) * Integer.parseInt(str[1]);
            } else if (line.indexOf(47) != -1) {
                str = line.split("/");
                num = Integer.parseInt(str[0]) / Integer.parseInt(str[1]);
            }

            s = Integer.toString(num);

            if (line.length() < 3) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    s = "throws Exception // т.к. строка не является математической операцией";
                }
            } else if (str.length != 2) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    s = "throws Exception // т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
                }
            } else if (Integer.parseInt(str[0]) < 0 || Integer.parseInt(str[0]) > 10 || Integer.parseInt(str[1]) < 0 || Integer.parseInt(str[1]) > 10) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    s = "throws Exception";
                }
            }
        return s;
    }
}