// Garrett Brunsch
// Lab #1
// Due 6/29/25

import java.util.Scanner;

public class MadLibs
{
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        int choice = 0; // Forces default case with invalid input
        boolean continueProgram = true;

        System.out.println("Welcome to Mad Libs");

        while (continueProgram)
        {
            displayMenu();

            if (input.hasNextInt())
            {
                choice = input.nextInt();
                input.nextLine();
            }
            else
            {
                input.nextLine();
            }

            switch (choice)
            {
                case 1:
                    playMadLibs();
                    break;
                case 2:
                    continueProgram = false;
                    System.out.println("Thanks for playing Mad Libs! Now exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1 or 2");
                    break;
            }
        }
    }

    public static int getMenuChoice()
    {
        int choice = 0;

        if (input.hasNextInt())
        {
            choice = input.nextInt();
            input.nextLine();
        }
        else
        {
            input.nextLine();
        }
        return choice;
    }

    public static double getValidDouble(String prompt, String errorMessage)
    {
        double value = 0.0;
        boolean validInput = false;

        System.out.print(prompt);

        while (!validInput)
        {
            if (input.hasNextDouble())
            {
                value = input.nextDouble();
                input.nextLine();
                validInput = true;
            }
            else
            {
                System.out.print(errorMessage);
                input.nextLine();
            }
        }

        return value;
    }

    public static int getValidAge()
    {
        int age = -1;
        System.out.print("Enter an age: ");
        while (!input.hasNextInt())
        {
            System.out.print("Please enter a valid number for age: ");
            input.nextLine();
        }
        age = input.nextInt();
        input.nextLine();

        return age;
    }

    public static String getValidWord(String prompt)
    {
        String value = "n/a";
        do
        {
            System.out.print(prompt);
            value = input.nextLine().trim();

            if (value.isEmpty())
            {
                System.out.println("Input cannot be empty. Please try again");
            }
            else if (!value.matches("[a-zA-Z]+"))
            {
                System.out.println("Invalid input. Please enter only letters");
            }
        } while (value.isEmpty() || !value.matches("[a-zA-Z]+"));

        return value;
    }


    public static void displayMenu()
    {
        System.out.println("\n\n=== Mad Libs Menu ===");
        System.out.println("1. Play Mad Libs");
        System.out.println("2. Quit");
        System.out.print("Enter your choice (1 or 2): ");
    }

    public static void playMadLibs()
    {
        System.out.println("Please answer a few questions that will be used to create the story\n");

        MadLibsData data = collectUserInput();
        displayStory(data);
        playAgain();
    }

    static MadLibsData collectUserInput()
    {
        MadLibsData data = new MadLibsData();

        data.adjective = getValidWord("Enter an adjective: ");
        data.noun = getValidWord("Enter a noun: ");
        data.age = getValidAge();
        data.height = getValidDouble("Enter a decimal number: ",
                "Please enter a valid decimal number: ");

        return data;
    }

    static void displayStory(MadLibsData data)
    {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("          MAD LIBS STORY");
        System.out.println("=".repeat(50));

        System.out.println("Once upon a time, there was a " + data.adjective + " wizard who was");
        System.out.println("searching to find the fabled " + data.noun + " of Camelot! This");
        System.out.println("wizard was " + data.age + " years old and was a staggering " + data.height + " ft tall.");
        System.out.println("After what felt like a lifetime of searching, the fabled " +data.noun+ " ");
        System.out.println("had finally been found! Now that the wizard's dream of finding the legendary " + data.noun + " ");
        System.out.println("was over they returned with the " +data.noun + " in hand and retired to the countryside!");

        System.out.println("=".repeat(50));
    }

    public static void playAgain()
    {
        String playAgainChoice;
        boolean validChoice = false;

        while (!validChoice)
        {
            System.out.print("\nWould you like to create another story?: ");
            playAgainChoice = input.nextLine().toLowerCase();

            if (playAgainChoice.equals("y") || playAgainChoice.equals("yes"))
            {
                playMadLibs();
                validChoice = true;
            }
            else if (playAgainChoice.equals("n") || playAgainChoice.equals("no"))
            {
                System.out.println("Returning to main menu...");
                validChoice = true;
            }
            else
            {
                System.out.println("Please enter 'y' for yes or 'n' for no");
            }
        }
    }
}

class MadLibsData
{
    public String adjective;
    public String noun;
    public int age;
    public double height;
}

/*
Welcome to Mad Libs


--- Mad Libs Menu ---
1. Play Mad Libs
2. Quit
Enter your choice (1 or 2): g
Invalid choice! Please select 1 or 2


--- Mad Libs Menu ---
1. Play Mad Libs
2. Quit
Enter your choice (1 or 2): 1
Please answer a few questions that will be used to create the story

Enter an adjective: TIRED
Enter a noun: Coffee
Enter an age: 25
Enter a decimal number: 13.2

==================================================
          MAD LIBS STORY
==================================================
Once upon a time, there was a TIRED wizard who was
searching to find the fabled Coffee of Camelot! This
wizard was 25 years old and was a staggering 13.2 ft tall.
After what felt like a lifetime of searching, the fabled Coffee
had finally been found! Now that the wizard's dream of finding the legendary Coffee
was over they returned with the Coffee in hand and retired to the countryside!
==================================================

Would you like to create another story?: y
Please answer a few questions that will be used to create the story

Enter an adjective: 7
Invalid input. Please enter only letters
Enter an adjective: TEst
Enter a noun: 15
Invalid input. Please enter only letters
Enter a noun: succeSS
Enter an age: seven
Please enter a valid number for age: 5
Enter a decimal number: twelve
Please enter a valid decimal number: 12

==================================================
          MAD LIBS STORY
==================================================
Once upon a time, there was a TEst wizard who was
searching to find the fabled succeSS of Camelot! This
wizard was 5 years old and was a staggering 12.0 ft tall.
After what felt like a lifetime of searching, the fabled succeSS
had finally been found! Now that the wizard's dream of finding the legendary succeSS
was over they returned with the succeSS in hand and retired to the countryside!
==================================================

Would you like to create another story?: NO
Returning to main menu...


--- Mad Libs Menu ---
1. Play Mad Libs
2. Quit
Enter your choice (1 or 2): 2
Thanks for playing Mad Libs! Now exiting program...

Process finished with exit code 0

 */
