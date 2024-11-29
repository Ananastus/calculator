import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ScannerException, ScannerException2{
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("ответ "+calc(scan.nextLine()));
        }catch ( NullPointerException | NumberFormatException | ArithmeticException | IOException q){
            System.out.println("throws Exception");
        }catch (ScannerException e) {
            System.out.println("throws Exception // т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }catch (ScannerException2 e) {
            System.out.println("throws Exception // т.к. строка не является математической операцией");
        }
    }

    public static String calc(String line) throws IOException, ScannerException, ScannerException2{
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
                throw new ScannerException2();
            } else if (str.length != 2) {
                throw new ScannerException();
            } else if (Integer.parseInt(str[0]) <= 0 || Integer.parseInt(str[0]) > 10 || Integer.parseInt(str[1]) <= 0 || Integer.parseInt(str[1]) > 10) {
                throw new IOException();
            }
        return s;
    }
}