import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean working = true;
        int counter = 0;
        int option;

        while(working) {
            showMenu();

            try {
                while (!scanner.hasNextInt()) {
                    System.out.println("Input is not a number");
                    scanner.nextLine();
                }

                option = scanner.nextInt();
                switch (option) {
                    case 0:
                        System.out.println("Thank you for your time :)");
                        working = false;
                        break;
                    case 1:
                        helloWorld();
                        break;
                    case 2:
                        showUserInput(scanner);
                        break;
                    case 3:
                        changeColor(counter);
                        counter++;
                        break;
                    case 4:
                        showDate();
                        break;
                    case 5:
                        numbersComparator(scanner);
                        break;
                    case 6:
                        randomNumberGuessing(scanner,random);
                        break;
                    case 7:
                        saveTextFile(scanner);
                        break;
                    case 8:
                        readTextFile();
                        break;
                    case 9:
                        multiplyNumber(scanner);
                        break;
                    case 10:
                        multiplicationTable();
                        break;
                    case 11:
                        createOrderedList(5);
                        break;
                    case 12:
                        isPalindrome();
                        break;
                    case 13:
                        showNumbersInBetween(scanner);
                        break;
                    case 14:
                        sortAndPrintOddAndOdd(scanner);
                        break;
                    case 15:
                        addAndPrintNumbers(scanner);
                        break;
                    case 16:
                        createGame(scanner); // dziwnie wyswietla result
                        break;

                    default:
                        working = false;
                        System.out.println("You didn't choose anything");
                        break;
                }
            }
            catch (InputMismatchException e) {
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void showMenu() {
        System.out.println(Dictionary.mainMenu);
    }

    public static void helloWorld() {
        System.out.println("Hello World");
    }

    public static void showUserInput(Scanner scanner) {
        System.out.println("Write your name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Write your lastname: ");
        String lastName = scanner.nextLine();
        System.out.println("Write your age");
        int age = scanner.nextInt();
        System.out.println("Your input was: " + name + " " + lastName + " " + age);
    }

    public static void changeColor(int counter) {
        if (counter % 2 == 0) {
            final String TEXT_GREEN = "\u001B[32m";
            System.out.println(TEXT_GREEN);
        } else {
            final String TEXT_RESET = "\u001B[0m";
            System.out.println(TEXT_RESET);
        }
    }

    public static void showDate() {
        LocalDate date = LocalDate.now();
        System.out.println("Today is: " + date);
    }

    public static void numbersComparator(Scanner scanner) {
        System.out.println("choose first number: ");
        Integer firstNumber = scanner.nextInt();
        System.out.println("choose second number: ");
        Integer secondNumber = scanner.nextInt();

        if(firstNumber.equals(secondNumber)) {
            System.out.println(firstNumber + " and " + secondNumber + " are equal.");
        } else if (firstNumber < secondNumber){
            System.out.println("second number: " + secondNumber + " is higher than " + firstNumber + ".");

        } else {
            System.out.println("first number: " + firstNumber + " is higher than " + secondNumber + ".");
        }
    }

    public static void randomNumberGuessing(Scanner scanner, Random random) {
        int ans, guess, guessNum = 0;
        String playAgain = "y";

        ans = random.nextInt(101) + 1;

        while (playAgain.equals("y") || playAgain.equals("Y")) {
            System.out.println("Hey Welcome to the game \nGuess a number between 1 and 100");

            guess = scanner.nextInt();
            guessNum = 0;
            while (guess != 0)
            {
                guessNum++;
                if (guess == ans) {
                    System.out.println("Perfect! You got it Right! \nYou won in: "+guessNum+" rounds");
                    break;
                } else if (guess < ans)
                    System.out.println("Opss! Your guess was too LOW, try some higher numbers");
                else {
                    System.out.println("Opps! Your guess was too HIGH, Try some lower numbers");
                }
                System.out.println("Enter your guess or press 0 to quit:");
                guess = scanner.nextInt();
            }
            System.out.println("Want to Play again?(y/n)");
            playAgain = scanner.next();
        }
        System.out.println("Thanks for playing!");
    }

    public static void readTextFile() {
        Path pathToFile = Path.of("Files/TextFile.rtf");
        System.out.println("Reading a file from "+pathToFile);
        System.out.println(pathToFile.getFileName());

        try (Stream<String> stream = lines(pathToFile)){
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTextFile(Scanner scanner) throws FileNotFoundException {
        scanner.nextLine();
        System.out.println("Write your text here: ");
        String text = scanner.nextLine();
        PrintWriter saveText = new PrintWriter("file.txt");
        saveText.println(text);
        saveText.close();
        System.out.println("Your text file is saved! ");
    }

    public static void multiplyNumber (Scanner scanner) {
        System.out.println("Write a number to multiply");
        int userInput = scanner.nextInt();
        int inputMultiBy2 = userInput * 2;
        int inputMultiBy10 = userInput * 10;
        System.out.println("Your number * 2 = " +inputMultiBy2+ "\nYour number * 10 = " +inputMultiBy10);
    }

    public static void multiplicationTable() {
        int a = 1;
        while (a <= 10)
        {
            int b = 1;
            while (b <= 9)
            {
                System.out.print(a*b + "    ");
                b++;
            }
            System.out.println(a*b);
            a++;
        }
    }

    public static void createOrderedList(int listSize) {
        Random random = new Random();
        int[] numbers = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            numbers[i] = random.nextInt(100);
        }
        System.out.println("Random:");
        Arrays.stream(numbers).forEach(value -> System.out.print(value + ", "));
        System.out.println();

        for(int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    int temp = numbers [i];
                    numbers[i] = numbers [j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println("Sorted:");
        Arrays.stream(numbers).forEach(value -> System.out.print(value + ", "));
        System.out.println();
    }

    public static void showNumbersInBetween(Scanner scanner) {
        System.out.println("Write first number: ");
        int first = scanner.nextInt();
        System.out.println("Write second number: ");
        int second = scanner.nextInt();

        if(second > first) {
            System.out.println("Solution:");

            for (int i = first + 1; i < second; i++)
                System.out.println(i + " ");
        } else {
            System.out.println("Solution:");

            for (int i = second + 1; i < first; i++)
                System.out.println(i + " ");
        }
    }

    public static void isPalindrome() {
        String x;
        StringBuilder y = new StringBuilder();
        Scanner a = new Scanner(System.in);
        System.out.println("Enter your text: ");
        x = a.nextLine();
        int i = x.length();

        for(int k = i - 1; k >= 0; k--) {
            y.append(x.charAt(k));
        }
        if(x.equalsIgnoreCase(y.toString())) {
            System.out.println("The string is palindrome.");
        } else {
            System. out.println("The string is not a palindrome.");
        }
    }

    public static void sortAndPrintOddAndOdd(Scanner scanner) {

        System.out.println("Write any numbers separated by a comma.");
        scanner.nextLine();
        String userInput = scanner.nextLine();
        String[] splitResult = userInput.split(",");
        for (String s : splitResult) {
            int numbers = Integer.parseInt(s);

            if (numbers % 2 == 0) {
                System.out.println("even: " + numbers);
            } else {
                System.out.println("odd: " + numbers);
            }
        }
    }

    public static void addAndPrintNumbers(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Write the numbers, separating them with a comma to get the result their sum.");
        String userInput = scanner.nextLine();
        String[] splitResult = userInput.split(",");
        int sum = 0;

        for (String s : splitResult) {
            int numbers = Integer.parseInt(s);
            sum = sum + numbers;
        }
        System.out.println("Reseult is: " + sum);
    }

    public static void createGame (Scanner scanner) {
        scanner.nextLine();
        System.out.println("Type your characters name: ");
        String yourName = scanner.nextLine();
        System.out.println("Type your opponents name: ");
        String opponentName = scanner.nextLine();

        Character yourCharacter = new Character(yourName);
        Character opponent = new Character(opponentName);

        System.out.println("Your character " +yourCharacter.getName()+ "'s stats are: health "+yourCharacter.getHealth()+", "+
                "strength " +yourCharacter.strength+", " + "luck " + yourCharacter.getLuck()+".");
        System.out.println("--------------------------------------");
        System.out.println("Your opponents " +opponent.getName()+ "'s stats are: health "+opponent.getHealth()+", "+
                "strength " +opponent.strength+", " + "luck " + opponent.getLuck()+".");
    }
}