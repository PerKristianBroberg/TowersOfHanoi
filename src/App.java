import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Let's create stacks");

        List<Stack> stacks = new ArrayList<>();

        Stack leftStack = new Stack("Left", 1000);
        Stack middleStack = new Stack("Middle", 1000);
        Stack rightStack = new Stack("Right", 1000);

        stacks.add(leftStack);
        stacks.add(middleStack);
        stacks.add(rightStack);

        int numOfDisks = 0;
        do {
            numOfDisks = Integer.parseInt(readInput("\nHow many disks do you want to play with? Minimum 3 disks\n"));
            if (numOfDisks < 3) {
                System.out.println("Please enter a number greater than or equal to 3");
            }
        } while (numOfDisks < 3);

        for (int disk = numOfDisks; disk > 0; disk--) {
            leftStack.push(disk);
        }

        int numOptimalMoves = (int) (Math.pow(2, numOfDisks) - 1);
        System.out.println("\nThe fastest you can solve this game is in " + numOptimalMoves + " moves");

        int numUserMoves = 0;

    while (rightStack.getSize() < numOfDisks) {
        System.out.println("\n\n\n...Current Stacks...");
        for (Stack stack : stacks) {
            System.out.println(stack.getName() + ":");
            printItems(stack);
        }
    
        Stack fromStack;
        Stack toStack;
        do {
            System.out.println("\nWhich stack do you want to move from?");
            fromStack = getInput(stacks);
            System.out.println("\nWhich stack do you want to move to?");
            toStack = getInput(stacks);
    
            if (fromStack.isEmpty()) {
                System.out.println("\n\nInvalid Move. Try Again");
            } else if (toStack.isEmpty() || fromStack.peek() < toStack.peek()) {
                int disk = fromStack.pop();
                toStack.push(disk);
                numUserMoves++;
                break;
            } else {
                System.out.println("\n\nInvalid Move. Try Again");
            }
        } while (true);
    }
    
    System.out.println("\n\nYou completed the game in " + numUserMoves + " moves, and the optimal number of moves is " + numOptimalMoves);
        
    }

    // get input
    public static Stack getInput(List<Stack> stacks) {
        while (true) {
            for (int i = 0; i < stacks.size(); i++) {
                Stack stack = stacks.get(i);
                String name = stack.getName();
                char letter = name.charAt(0);
                System.out.println("Enter " + letter + " for " + name);
            }
            String userInput = sc.nextLine().toUpperCase();
            for (int i = 0; i < stacks.size(); i++) {
                Stack stack = stacks.get(i);
                char choice = stack.getName().charAt(0);
                if (userInput.equals(Character.toString(choice))) {
                    return stack;
                }
            }
            System.out.println("Invalid input. Please try again.");
        }
    }

    /**
     * Reads input from console with given prompt
     * @param prompt
     * @return string input answer from user
     */
    public static String readInput(String prompt) {
        System.out.println(prompt);
        String userInput = sc.nextLine();
        return userInput;
    }

    // print items in a stack
    public static void printItems(Stack stack) {
        Stack tempStack = new Stack(stack.getName(), stack.getLimit()); // Create a temporary stack
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop()); // Push each element from the original stack to the temporary stack
        }
        // Print the elements from the temporary stack, effectively reversing the order
        while (!tempStack.isEmpty()) {
            int value = tempStack.pop();
            System.out.print(value + " ");
            stack.push(value); // Push the popped value back to the original stack
        }
        System.out.println(); 
    }
    
}