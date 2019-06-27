import MyExceptions.IncompatibleOperation;
import MyExceptions.IncompatibleTypes;
import MyExceptions.MyException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.print("Enter an expression (Num OP Num): ");
                String userIn = br.readLine();
                if (userIn.toUpperCase().trim().equals("EXIT")) break;

                String[] expression = userIn.split("\\s");
                String num1 = expression[0];
                String num2 = expression[2];
                String op = expression[1];

                if (!op.matches("[+-/*]?+")) { // check if operand id incompatible
                    throw new IncompatibleOperation();
                }

                if (Romans.isRoman(num1) && Romans.isRoman(num2)) {
                    System.out.println(Calculator.calculate(expression[0], expression[2], op));

                } else if (!Romans.isRoman(num1) && !Romans.isRoman(num2)) {
                    System.out.println(Calculator.calculate(Integer.parseInt(num1), Integer.parseInt(num2), op));

                } else {
                    throw new IncompatibleTypes();
                }
            }

        } catch (MyException | IOException exc) {
            exc.printStackTrace();
        }
    }

}
