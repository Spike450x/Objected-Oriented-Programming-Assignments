/*
    Joshua Wood
    Problem 1
    COP 3330 - Fall 2019
    October 19, 2019

    Part 1

The use of computers in education is referred to as computer-assisted instruction (CAI).
Write a program that will help an elementary school student learn multiplication. Use a
SecureRandom object to produce two positive one-digit integers (you will need to look up how to do this).
The program should then prompt the user with a question, such as

        How much is 6 times 7?

The student then inputs the answer. Next, the program checks the student’s answer. If it’s correct,
display the message "Very good!" and ask another multiplication question. If the answer is wrong,
display the message "No. Please try again.>again." and let the student try the same question repeatedly
until the student finally gets it right. A separate method should be used to generate each new question.
This method should be called once when the application begins execution and each time the user answers the
question correctly.

    Part 2

Modify the program from Part 1 so that various comments are displayed for each answer as follows:

Possible responses to a correct answer:

Very good!
Excellent!
Nice work!
Keep up the good work!

Possible responses to an incorrect answer:

No. Please try again.
Wrong. Try once more.
Don’t give up!
No. Keep trying.

Use random-number generation to choose a number from 1 to 4 that will be used to select one of the four
appropriate responses to each correct or incorrect answer. Use a switch statement to issue the responses.

    Part 3

Modify the program from Part 2 to use your question generation method to ask the student 10 different questions.
Give students only one chance at answering each question. Count the number of correct and incorrect responses typed
by the student. After the program has asked 10 questions, and the student types 10 answers, your program should calculate
the percentage that are correct. If the percentage is lower than 75%, display "Please ask your teacher for extra help.",
then reset the program so another student can try it. If the percentage is 75% or higher, display "Congratulations,
you are ready to go to the next level!", then reset the program so another student can try it.

    Part 4

Modify the program from Part 3 to allow the user to enter a difficulty level. At a difficulty level of 1, the program
should use only single-digit numbers in the problems; at a difficulty level of 2, numbers as large as two digits, and
so on. Allow for four levels of difficulty.

    Part 5

Modify the program from Part 4 to allow the user to pick a type of arithmetic problem to study. An option of 1
means addition problems only, 2 means multiplication problems only, 3 means subtraction problems only, 4 means
division problems only and 5 means a random mixture of all these types.

 */
import java.security.SecureRandom;
import java.util.Scanner;

public class Application {
    // Print menu for the user
    private static void printMenu () {
        System.out.println();
        System.out.println("Difficulty Levels");
        System.out.println("1). Single Digits");
        System.out.println("2). Double Digits");
        System.out.println("3). Three Digits");
        System.out.println("4). Four Digits");
        System.out.println();
        System.out.println();
        System.out.println("Types of Arithmetic");
        System.out.println("1). Addition");
        System.out.println("2). Multiplication");
        System.out.println("3). Subtraction");
        System.out.println("4). Division");
        System.out.println("5). Mix");
    }
    // Prompt user to input the difficulty level
    private static void promptDifficultyLevel() {
        System.out.println("\n\nPlease choose your difficulty level (1 - 4)");
        System.out.print("Answer -> ");
    }
    // Prompt user to input the type of arithmetic
    private static void promptArithmetic() {
        System.out.println("\n\nWhich kind of arithmetic would you like to test (1 - 5)");
        System.out.print("Answer -> ");
    }
    // Scan in the difficulty level and remind the user of what level they chose
    private static int getDifficultyLevel(Scanner scan) {
        int userChoice;
        userChoice = scan.nextInt();
        System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("\nYou chose level ");

        if (userChoice == 1) {
            System.out.println(userChoice + "!");
            System.out.println("\nLevel One includes single digits!");
        }

        if (userChoice == 2) {
            System.out.println(userChoice + "!");
            System.out.println("\nLevel Two includes double digits!");
        }

        if (userChoice == 3) {
            System.out.println(userChoice + "!");
            System.out.println("\nLevel Three includes triple digits!");
        }

        if (userChoice == 4) {
            System.out.println(userChoice + "!");
            System.out.println("\nLevel Four includes four digits!");
        }
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return userChoice;
    }
    // Scan in the type of arithmetic and remind user of what type they chose
    private static int getArithmetic (Scanner scan) {
        int userChoice;
        userChoice = scan.nextInt();
        System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("\nYou chose ");

        if (userChoice == 1) {
            System.out.println("Addition!");
        }

        if (userChoice == 2) {
            System.out.println("Multiplication!");
        }

        if (userChoice == 3) {
            System.out.println("Subtraction!");
        }
        // Warns user to enter their answer rounded to two decimals
        if (userChoice == 4) {
            System.out.println("Division! \n\n** NOTE **\nPLEASE ENTER EXACT ANSWER ROUNDED TO TWO DECIMAL PLACES");
        }

        if (userChoice == 5) {
            System.out.println("a mix of everything! \n\n** NOTE **\nFOR ANY DIVISION PROBLEMS, ENTER EXACT ANSWER ROUND TO TWO DECIMAL PLACES");
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return userChoice;
    }
    // Let user know that the session is starting
    private static void startSession() {
        System.out.println();
        System.out.println("====================");
        System.out.println("START SESSION");
        System.out.println("====================");
    }
    // Assign answer of random number to the proper arithmetic type
    private static double decideArithmetic(int random, int userChoice, int randOne, int randTwo) {
        double ans = 0;
        if (userChoice == 1) {
            ans = getSum(randOne, randTwo);
        }

        if (userChoice == 2) {
            ans = getProduct(randOne, randTwo);
        }

        if (userChoice == 3) {
            ans = getDifference(randOne, randTwo);
        }

        if (userChoice == 4) {
            ans = getDivision(randOne, randTwo);
        }

        if (userChoice == 5) {
            switch (random) {
                case 1:
                    ans = getSum(randOne, randTwo);
                    break;
                case 2:
                    ans = getProduct(randOne, randTwo);
                    break;
                case 3:
                    ans = getDifference(randOne, randTwo);
                    break;
                case 4:
                    ans = getDivision(randOne, randTwo);
                    break;
                default:
                    System.out.println("Invalid!");
                    break;
            }
        }
        return ans;
    }
    // Assign random number to the proper range
    private static int decideDifficultyRangeOne(int diffLevel, SecureRandom rand) {
        int randomOne = 0;

        if (diffLevel == 1)
            randomOne = getRandomSingleOne(rand);

        if (diffLevel == 2)
            randomOne = getRandomDoubleOne(rand);

        if (diffLevel == 3)
            randomOne = getRandomTripleOne(rand);

        if (diffLevel == 4)
            randomOne = getRandomQuadOne(rand);

        return randomOne;
    }
    // Assign random number to the proper range
    private static int decideDifficultyRangeTwo(int diffLevel, SecureRandom rand) {
        int randomTwo = 0;

        if (diffLevel == 1)
            randomTwo = getRandomSingleTwo(rand);

        if (diffLevel == 2)
            randomTwo = getRandomDoubleTwo(rand);

        if (diffLevel == 3)
            randomTwo = getRandomTripleTwo(rand);

        if (diffLevel == 4)
            randomTwo = getRandomQuadTwo(rand);

        return randomTwo;
    }
    // Provide user with the proper number corresponding to the proper question
    private static void printQuestionNumber (int start) {
        System.out.print("\n(" + (start + 1) + ") ");
    }
    // Ask user each question with corresponding arithmetic type
    private static void askQuestion(int rand, int arithmetic, int randOne, int randTwo) {
        System.out.print("How much is ");

        switch (arithmetic) {
            case 1:
                System.out.println(randOne + " plus " + randTwo + "?");
                break;

            case 2:
                System.out.println(randOne + " times " + randTwo + "?");
                break;

            case 3:
                System.out.println(randOne + " subtracted by " + randTwo + "?");
                break;

            case 4:
                System.out.println(randOne + " divided by " + randTwo + "?");
                break;

            case 5:
                switch (rand) {
                    case 1:
                        System.out.println(randOne + " plus " + randTwo + "?");
                        break;

                    case 2:
                        System.out.println(randOne + " times " + randTwo + "?");
                        break;

                    case 3:
                        System.out.println(randOne + " subtracted by " + randTwo + "?");
                        break;
                    case 4:
                        System.out.println(randOne + " divided by " + randTwo + "?");
                        break;
                    default:
                        System.out.println("Invalid!");
                        break;
                }
        }
        System.out.print("Answer -> ");
    }
    // Set random number one for single digit numbers
    private static int getRandomSingleOne(SecureRandom rand) {
        int randNumOne;
        randNumOne = rand.nextInt(9) + 1;
        return randNumOne;
    }
    // Set random number one for double digit numbers
    private static int getRandomDoubleOne(SecureRandom rand) {
        int randNumOne;
        randNumOne = rand.nextInt(99) + 1;
        return randNumOne;
    }
    // Set random number one for triple digit numbers
    private static int getRandomTripleOne(SecureRandom rand) {
        int randNumOne;
        randNumOne = rand.nextInt(999) + 1;
        return randNumOne;
    }
    // Set random number two for four digit numbers
    private static int getRandomQuadOne(SecureRandom rand) {
        int randNumOne;
        randNumOne = rand.nextInt(9999) + 1;
        return randNumOne;
    }
    // Set random number two for single digit numbers
    private static int getRandomSingleTwo(SecureRandom rand) {
        int randNumTwo;
        randNumTwo = rand.nextInt(9) + 1;
        return randNumTwo;
    }
    // Set random number two for double digit numbers
    private static int getRandomDoubleTwo(SecureRandom rand) {
        int randNumTwo;
        randNumTwo = rand.nextInt(99) + 1;
        return randNumTwo;
    }
    // Set random number two for triple digit numbers
    private static int getRandomTripleTwo(SecureRandom rand) {
        int randNumTwo;
        randNumTwo = rand.nextInt(999) + 1;
        return randNumTwo;
    }
    // Set random number two for four digit numbers
    private static int getRandomQuadTwo(SecureRandom rand) {
        int randNumTwo;
        randNumTwo = rand.nextInt(9999) + 1;
        return randNumTwo;
    }
    // Multiply random number one and two
    private static int getProduct(int randOne, int randTwo) {
        int product;
        product = randOne * randTwo;
        return product;
    }
    // Add random number one and two
    private static int getSum(int randOne, int randTwo) {
        int sum;
        sum = randOne + randTwo;
        return sum;
    }
    // Subtract number one and two
    private static int getDifference(int randOne, int randTwo) {
        int diff;
        diff = randOne - randTwo;
        return diff;
    }
    // Divide number one and two
    private static double getDivision(int randOne, int randTwo) {
        double div = 0;
        div = (double)randOne/(double)randTwo;
        return Math.round(div * 100.0) / 100.0;
    }
    // Print random message if the user answers correctly
    private static void printCorrectMessage(SecureRandom rand) {
        int randomNumber;
        randomNumber = rand.nextInt(4) + 1;

        switch (randomNumber) {
            case 1:
                System.out.println("\nVery Good!");
                break;
            case 2:
                System.out.println("\nExcellent!");
                break;
            case 3:
                System.out.println("\nNice Work!");
                break;
            case 4:
                System.out.println("\nKeep up the good work!");
                break;
            default:
                System.out.println("\nGreat job!");
        }
    }
    // Print random message if the user answers incorrectly
    private static void printWrongMessage(SecureRandom rand) {
        int random;
        random = rand.nextInt(4) + 1;

        switch (random) {
            case 1:
                System.out.println("\nNo. Please try again.");
                break;
            case 2:
                System.out.println("\nWrong. Try once more.");
                break;
            case 3:
                System.out.println("\nDon't give up!");
                break;
            case 4:
                System.out.println("\nNo. Keep trying.");
                break;
            default:
                System.out.println("\nIt's okay, you got this!");
        }
    }
    // Get the number of correct answers
    private static int getCorrect(int wrong, int end) {
        int correct;
        correct = end - wrong;
        return correct;
    }
    // Calculate the average
    private static double getAvg(int correct, int end) {
        double avg;
        double moveDecimalNum = 100;
        avg = ((double) correct / end) * moveDecimalNum;
        return avg;
    }
    // Print the final report for a student
    private static void printReport(int correct, int wrong, double avg) {
        System.out.println("\n############################");
        System.out.printf("Your average is %%%.0f!\n", avg);
        System.out.println("You got " + correct + " correct!");
        System.out.println("You got " + wrong + " wrong!");
        System.out.println("############################");
    }
    // If the user has a bad average, warn them to seek help. Otherwise, congratulate them
    private static void printWarningOrAdvice(double average) {
        if ((average < 75.0) && (average >= 0.0))
            System.out.println("\nPlease ask your teacher for extra help.");
        else if ((average > 75.0) && (average <= 100.0))
            System.out.println("\nCongratulations, you are ready to go to the next level!");
    }
    // Prompt restart for the user
    private static void promptRestart() {
        System.out.println("\nRestart? (Y/N)");
        System.out.print("Answer -> ");
    }
    // If the user wants to start a new session, the program restarts. Otherwise, exit
    private static int restartProgram(char choice) {
        int restart;
        if ((choice == 'y') || (choice == 'Y')) {
            restart = 0;
        } else {
            restart = 1;
            System.out.println("\nGoodbye! Have a great day!");
        }
        return restart;
    }
    // Main Method
    public static void main(String args[]) {
        int restart = 0;

        while (restart == 0) {
            SecureRandom random = new SecureRandom();
            Scanner scan = new Scanner(System.in);
            int randNumOne;
            int randNumTwo;
            int rand;
            int diffLevel;
            double userAnswer;
            int arithmeticChoice;
            double arithmeticType;
            int correct;
            int start = 0;
            int end = 10;
            int wrong = 0;
            double avg;
            char choice;

            printMenu();
            promptDifficultyLevel();
            diffLevel = getDifficultyLevel(scan);
            promptArithmetic();
            arithmeticChoice = getArithmetic(scan);
            startSession();

            while (start < end) {
                randNumOne = decideDifficultyRangeOne(diffLevel, random);
                randNumTwo = decideDifficultyRangeTwo(diffLevel, random);
                rand = random.nextInt(4) + 1;
                arithmeticType = decideArithmetic(rand, arithmeticChoice, randNumOne, randNumTwo);
                printQuestionNumber(start);
                askQuestion(rand, arithmeticChoice, randNumOne, randNumTwo);
                userAnswer = scan.nextDouble();

                if (userAnswer == arithmeticType) {
                    printCorrectMessage(random);
                    start++;
                } else {
                    while (arithmeticType != userAnswer) {
                        printWrongMessage(random);
                        wrong = wrong + 1;
                        start = start + 1;

                        if (start >= 10) break;

                        printQuestionNumber(start);
                        askQuestion(rand, arithmeticChoice, randNumOne, randNumTwo);
                        userAnswer = scan.nextDouble();

                        if (arithmeticType == userAnswer) {
                            printCorrectMessage(random);
                            start = start + 1;
                        }
                    }
                }
            }
            correct = getCorrect(wrong, end);
            avg = getAvg(correct, end);
            printReport(correct, wrong, avg);
            printWarningOrAdvice(avg);
            promptRestart();
            choice = scan.next().charAt(0);
            restart = restartProgram(choice);
        }
    }
}


