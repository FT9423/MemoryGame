//Stores list and that list to be manipulated
import java.util.ArrayList;
//Functions as a wrapper
import java.util.Collections;
//Takes user input
import java.util.Scanner;

public class memoryGame {

    public static void main (String[] args){
        //Taking user input
        Scanner scanner = new Scanner(System.in);
        //Creating list of card values
        ArrayList<String> cards = new ArrayList<>();
        cards.add("A");
        cards.add("A");
        cards.add("B");
        cards.add("B");
        cards.add("C");
        cards.add("C");
        cards.add("D");
        cards.add("D");
        //Randomize order of cards listed above
        Collections.shuffle(cards);

        //String Array - Board = Size of cards list
        String[] board = new String[cards.size()];
        //Which card is flipped using index - yes or no
        boolean[] flipped = new boolean[cards.size()];
        int pairsFound = 0;

        //Stops game once all 4 pairs are found. Checks if first flipped card == second card flipped
        while (pairsFound < 4) {
            printBoard(board);
            int firstIndex = getCardIndex (
                    scanner, board, flipped, "Enter index of first card flip:");
            board[firstIndex] = cards.get(firstIndex);
            flipped[firstIndex] = true;
            printBoard(board);
            int secondIndex = getCardIndex (
                    scanner, board, flipped, "Enter index of second card flip:");
            board[secondIndex] = cards.get(secondIndex);
            flipped[secondIndex] = true;

            if (cards.get(firstIndex).equals(cards.get(secondIndex))) {
                System.out.println("You found a pair!");
                pairsFound++;
            }
            //Changes value of card from null to "" after cards are flipped without a match being found
            else {
                System.out.println("Sorry, those cards do not match.");
                board[firstIndex] = " ";
                board[secondIndex] = " ";
                flipped[firstIndex] = false;
                flipped[secondIndex] = false;
            }
        }

        System.out.println("Congratulations, you won!");
    }

    //Allowes user to choose card by index while giving errors for duplicate choices and invalid entries
    public static int getCardIndex(Scanner scanner,String[] board,boolean[] flipped,String prompt){
        int index;
        while (true) {
            System.out.println(prompt);
            index = scanner.nextInt();
            if (index < 0 || index >= board.length) {
                System.out.println("Invalid index, try again.");
            }
            else if (flipped[index]) {
                System.out.println("Card already flipped, try again.");
            }
            else {
                break;
            }
        }
        return index;
    }

    //Prints the proper value for each card
    public static void printBoard(String[] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("| " + board[i] + " ");
        }
        System.out.println("|");
    }
}

