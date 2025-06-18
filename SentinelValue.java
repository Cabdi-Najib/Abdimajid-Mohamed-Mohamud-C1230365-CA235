import java.util.Scanner;

public class SentinelValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;

        while (true) {
            System.out.print("Enter an integer (enter 'n' to end): ");

            if (input.hasNextInt()) {
                int data = input.nextInt();
                sum += data;
            } else {
                String userInput = input.next();
                if (userInput.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Invalid input");
                }
            }
        }

        System.out.println("The sum is " + sum);
    }
}