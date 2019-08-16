/*
Thomas Langley: 17215145
Ross Duffy: 17201624
Conor Nolan: 17234239
Hannah McKenna: 17204178
 */

import javax.swing.*;
import java.util.ArrayList;
import static java.lang.Math.sqrt;

public class is17215145
{
    private static int maxRows;
    private static int maxColumns;

    private static int[][] startMatrix;
    private static int[][] endMatrix;


    public static void main(String[] args)
    {
        /** Declaring variables that will be used throughout the program **/
        String startState, endState;
        String pattern = "[0-8]{1}";

        /** Next is the welcome message and then you will be asked to enter the start state of the 8-puzzle **/
        JOptionPane.showMessageDialog(null, "Welcome to our project for Intelligent Systems, where we will solve the 8-puzzle using the A* algorithm!", "Welcome", 1);
        startState =  JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);

        /**
         * Validation for the start state:
         * First of all, this splits the input for the start state by separating between white spaces.
         * Next, it checks if there are any duplicate numbers in the input.
         * If there are duplicates, the program will infinitely loop, until an input with no duplicates is recorded.
         * Next, it checks the input contains exactly 9 numbers, and will loop until a series of 9 valid numbers is inputted.
         * Finally, the program checks if each number is in the range [0, 8], and will loop until this happens.
         */
        String [] elements = startState.split("\\s+");

        for (int i = 0; i < elements.length; i++)
        {
            for (int j = i + 1; j < elements.length; j++)
            {
                if (elements[i].equals(elements[j]))
                {
                    JOptionPane.showMessageDialog(null, "The sequence of numbers in the input contained duplicates.", "Error", 2);
                    startState =  JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
                }
            }
        }

        if (elements.length >  9 || elements.length < 9)
        {
            JOptionPane.showMessageDialog(null, "The input must contain 9 unique numbers between [0, 8]", "Error", 2);
            startState =  JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
        }

        if (!(elements[0].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            startState =  JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
        }
        if (!(elements[1].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            startState =  JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
        }
        if (!(elements[2].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            startState =  JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
        }
        if (!(elements[3].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            startState =  JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
        }
        if (!(elements[4].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            startState =  JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
        }
        if (!(elements[5].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            startState =  JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
        }
        if (!(elements[6].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            startState =  JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
        }
        if (!(elements[7].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            startState =  JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
        }
        if (!(elements[8].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            startState =  JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
        }

        /** The user will then be asked to enter and end state.*/
        endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);

        /**
         * Validation for the end state:
         * First of all, this splits the input for the end state by separating between white spaces.
         * Next, it checks if there are any duplicate numbers in the input.
         * If there are duplicates, the program will infinitely loop, until an input with no duplicates is recorded.
         * Next, it checks the input contains exactly 9 numbers, and will loop until a series of 9 valid numbers is inputted.
         * Finally, the program checks if each number is in the range [0, 8], and will loop until this happens.
         */
        String [] goalNumbers = endState.split("\\s+");

        for (int i = 0; i < goalNumbers.length; i++)
        {
            for (int j = i + 1; j < goalNumbers.length; j++)
            {
                if (goalNumbers[i].equals(goalNumbers[j]))
                {
                    JOptionPane.showMessageDialog(null, "The sequence of numbers in the input contained duplicates.", "Error", 2);
                    endState =  JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
                }
            }
        }

        if (goalNumbers.length >  9 || goalNumbers.length < 9)
        {
            JOptionPane.showMessageDialog(null, "The input must contain 9 unique numbers between [0, 8]", "Error", 2);
            endState =  JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
        }

        if (!(goalNumbers[0].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            endState =  JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
        }
        if (!(goalNumbers[1].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            endState =  JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
        }
        if (!(goalNumbers[2].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            endState =  JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
        }
        if (!(goalNumbers[3].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            endState =  JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
        }
        if (!(goalNumbers[4].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            endState =  JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
        }
        if (!(goalNumbers[5].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            endState =  JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
        }
        if (!(goalNumbers[6].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            endState =  JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
        }
        if (!(goalNumbers[7].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            endState =  JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
        }
        if (!(goalNumbers[8].matches(pattern)))
        {
            JOptionPane.showMessageDialog(null, "The input must be in the range [0, 8]", "Error", 2);
            endState =  JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 8], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
        }


        /**
         * This code converts the strings inputted for the start and end statas, and converts them to a 2-dimensional array of integers.
         */
        startMatrix = convertInputToTable(startState);
        endMatrix = convertInputToTable(endState);

        ArrayList<String> moves = movements(startMatrix);
        for (int i = 0; i < moves.size(); i++) {
            System.out.print(moves.get(i));
        }
    }

    public static ArrayList movements(int arr[][]) {
        String returnable = "";
        int zeroCol = 0, zeroRow = 0;
        int toWest , toEast, toNorth, toSouth;
        ArrayList<String> heuristics = new ArrayList<>();
        ArrayList<String> possibleMoves = new ArrayList<>();

        outerloop:                             //finding the empty space
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = arr[i][j];
                if(x == 0) {
                    zeroRow = i;
                    zeroCol = j;
                    break outerloop;
                }
            }
        }

        heuristics = moveHue(arr);

        // Gets ints all around null space, appends string (lots of if statements) then gets heuristics and add it to the stringk.
        if (zeroRow == 0 && zeroCol == 0) {
            toEast = arr[zeroRow][zeroCol+1];
            toSouth = arr[zeroRow+1][zeroCol];
            returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
            possibleMoves.add(returnable);
            returnable = "";

        } else if(zeroRow == 0 && zeroCol == 1) {
            toEast = arr[zeroRow][zeroCol+1];
            toSouth = arr[zeroRow+1][zeroCol];
            toWest = arr[zeroRow][zeroCol-1];
            returnable += "\n(a) " + Integer.toString(toEast) + " to the East"  + ", Heuristic value: " + heuristics.get(0);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(b) " + Integer.toString(toSouth) + " to the South"  + ", Heuristic value: " + heuristics.get(1);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(c) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(2);
            possibleMoves.add(returnable);
            returnable = "";
        } else if (zeroRow == 0 && zeroCol == 2) {
            toWest = arr[zeroRow][zeroCol - 1];
            toSouth = arr[zeroRow + 1][zeroCol];
            returnable += "\n(a) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(0);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
            possibleMoves.add(returnable);
            returnable = "";

        }  else if(zeroRow == 1 && zeroCol == 0) {
            toEast = arr[zeroRow][zeroCol + 1];
            toSouth = arr[zeroRow + 1][zeroCol];
            toNorth = arr[zeroRow-1][zeroCol];
            returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(b) " + Integer.toString(toSouth) + " to the South"  + ", Heuristic value: " + heuristics.get(1);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(c) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(2);
            possibleMoves.add(returnable);
            returnable = "";
        } else if(zeroRow == 1 && zeroCol == 1) {
            toEast = arr[zeroRow][zeroCol + 1];
            toWest = arr[zeroRow-1][zeroCol];
            toSouth = arr[zeroRow + 1][zeroCol];
            toNorth = arr[zeroRow-1][zeroCol];
            returnable += "\n(a) " + Integer.toString(toEast) + " to the East"  + ", Heuristic value: " + heuristics.get(0);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(b) " + Integer.toString(toSouth) + " to the South"  + ", Heuristic value: " + heuristics.get(1);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(c) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(2);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(d) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(3);
            possibleMoves.add(returnable);
            returnable = "";

        } else if(zeroRow == 1 && zeroCol == 2) {
            toWest = arr[zeroRow][zeroCol-1];
            toSouth = arr[zeroRow + 1][zeroCol];
            toNorth = arr[zeroRow-1][zeroCol];
            returnable += "\n(a) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(0);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(b) " + Integer.toString(toSouth) + " to the South"  + ", Heuristic value: " + heuristics.get(1);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(c) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(2);
            possibleMoves.add(returnable);
            returnable = "";

        } else if(zeroRow == 2 && zeroCol == 0) {
            toEast = arr[zeroRow][zeroCol + 1];
            toNorth = arr[zeroRow-1][zeroCol];
            returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(b) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(1);
            possibleMoves.add(returnable);
            returnable = "";
        } else if(zeroRow == 2 && zeroCol == 1) {
            toEast = arr[zeroRow][zeroCol + 1];
            toNorth = arr[zeroRow-1][zeroCol];
            toWest = arr[zeroRow][zeroCol-1];
            returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
            possibleMoves.add(returnable);
            returnable = "";
            returnable +="\n(b) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(1);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(c) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(2);
            possibleMoves.add(returnable);
            returnable = "";

        } else if(zeroRow == 2 && zeroCol == 2) {
            toNorth = arr[zeroRow-1][zeroCol];
            toWest = arr[zeroRow][zeroCol-1];
            returnable += "\n(a) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(0);
            possibleMoves.add(returnable);
            returnable = "";
            returnable += "\n(b) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(1);
            possibleMoves.add(returnable);
        }


        return possibleMoves;

    }

    public static ArrayList moveHue(int arr[][]) {
        int zeroCol = 0, zeroRow = 0;
        int toWest , toEast, toNorth, toSouth;
        ArrayList<int[][]> possibleMatrices = new ArrayList<>();
        ArrayList<String> heuristics = new ArrayList<>();
        int temp[][] = new int[3][3];
        temp = copyMatrix(temp,arr);

        outerloop:                             //finding the empty space
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = arr[i][j];
                if(x == 0) {
                    zeroRow = i;
                    zeroCol = j;
                    break outerloop;
                }
            }
        }
        // Gets ints all around null space, appends string (lots of if statements :( )
        if (zeroRow == 0 && zeroCol == 0) {
            toEast = arr[zeroRow][zeroCol+1];
            toSouth = arr[zeroRow+1][zeroCol];

            temp[zeroRow][zeroCol] = temp[zeroRow][zeroCol+1];
            temp[zeroRow][zeroCol+1] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow+1][zeroCol];
            temp[zeroRow+1][zeroCol] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

        } else if(zeroRow == 0 && zeroCol == 1) {
            toEast = arr[zeroRow][zeroCol+1];
            toSouth = arr[zeroRow+1][zeroCol];
            toWest = arr[zeroRow][zeroCol-1];

            temp[zeroRow][zeroCol] = temp[zeroRow][zeroCol+1];
            temp[zeroRow][zeroCol+1] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow+1][zeroCol];
            temp[zeroRow+1][zeroCol] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow][zeroCol-1];
            temp[zeroRow][zeroCol-1] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

        } else if (zeroRow == 0 && zeroCol == 2) {
            toWest = arr[zeroRow][zeroCol - 1];
            toSouth = arr[zeroRow + 1][zeroCol];

            temp[zeroRow][zeroCol] = temp[zeroRow][zeroCol-1];
            temp[zeroRow][zeroCol-1] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow+1][zeroCol];
            temp[zeroRow+1][zeroCol] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);


        }  else if(zeroRow == 1 && zeroCol == 0) {
            toEast = arr[zeroRow][zeroCol + 1];
            toSouth = arr[zeroRow + 1][zeroCol];
            toNorth = arr[zeroRow-1][zeroCol];

            temp[zeroRow][zeroCol] = temp[zeroRow][zeroCol+1];
            temp[zeroRow][zeroCol+1] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow+1][zeroCol];
            temp[zeroRow+1][zeroCol] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow-1][zeroCol];
            temp[zeroRow-1][zeroCol] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

        } else if(zeroRow == 1 && zeroCol == 1) {
            toEast = arr[zeroRow][zeroCol + 1];
            toWest = arr[zeroRow-1][zeroCol];
            toSouth = arr[zeroRow + 1][zeroCol];
            toNorth = arr[zeroRow-1][zeroCol];

            temp[zeroRow][zeroCol] = temp[zeroRow][zeroCol+1];
            temp[zeroRow][zeroCol+1] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow][zeroCol-1];
            temp[zeroRow][zeroCol-1] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow+1][zeroCol];
            temp[zeroRow+1][zeroCol] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow-1][zeroCol];
            temp[zeroRow-1][zeroCol] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);


        } else if(zeroRow == 1 && zeroCol == 2) {
            toWest = arr[zeroRow][zeroCol-1];
            toSouth = arr[zeroRow + 1][zeroCol];
            toNorth = arr[zeroRow-1][zeroCol];

            temp[zeroRow][zeroCol] = temp[zeroRow][zeroCol-1];
            temp[zeroRow][zeroCol-1] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow+1][zeroCol];
            temp[zeroRow+1][zeroCol] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow-1][zeroCol];
            temp[zeroRow-1][zeroCol] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);


        } else if(zeroRow == 2 && zeroCol == 0) {
            toEast = arr[zeroRow][zeroCol + 1];
            toNorth = arr[zeroRow-1][zeroCol];

            temp[zeroRow][zeroCol] = temp[zeroRow][zeroCol+1];
            temp[zeroRow][zeroCol+1] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow-1][zeroCol];
            temp[zeroRow-1][zeroCol] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);



        } else if(zeroRow == 2 && zeroCol == 1) {
            toEast = arr[zeroRow][zeroCol + 1];
            toNorth = arr[zeroRow-1][zeroCol];
            toWest = arr[zeroRow][zeroCol-1];

            temp[zeroRow][zeroCol] = temp[zeroRow][zeroCol+1];
            temp[zeroRow][zeroCol+1] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow-1][zeroCol];
            temp[zeroRow-1][zeroCol] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow][zeroCol-1];
            temp[zeroRow][zeroCol-1] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);


        } else if(zeroRow == 2 && zeroCol == 2) {
            toNorth = arr[zeroRow-1][zeroCol];
            toWest = arr[zeroRow][zeroCol-1];

            temp[zeroRow][zeroCol] = temp[zeroRow-1][zeroCol];
            temp[zeroRow-1][zeroCol] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

            temp[zeroRow][zeroCol] = temp[zeroRow][zeroCol-1];
            temp[zeroRow][zeroCol-1] = 0;
            possibleMatrices.add(temp);
            temp = copyMatrix(temp,arr);

        }
        for (int i = 0; i < possibleMatrices.size(); i++) {
            //Pass Ross's function possibleMatrices.get(i) & add result to heuristics arraylist, then return arraylist;
            //heuristics.add(Integer.toString(Ross's Function));
            //heuristics.add(Integer.toString(i)); // temp output

            heuristics.add(Integer.toString(heuristic(possibleMatrices.get(i), endMatrix)));
        }

        return heuristics;

    }

    private static int[][] copyMatrix(int[][] old, int[][] replacer) {
        for(int i=0; i<old.length; i++)
            for(int j=0; j<old[i].length; j++)
                old[i][j]=replacer[i][j];
        return old;
    }

    /**
     *
     */
    public static int heuristic(int[][] inState, int[][] endState)
    {
        int heuristic = 0;

        for(int o = 0; o < inState.length; o++)
        {
            for(int p = 0; p < inState[o].length; p++)
            {
                if (inState[o][p] != 0)
                {
                    if ( inState[o][p] != endState[o][p])
                    {
                        heuristic++;
                    }
                }
            }
        }

        return heuristic;
    }

    /**
     * This code accepts a string, and converts it to a 2-dimensional array of integers.
     */
    private static int[][] convertInputToTable(String input)
    {
        ArrayList<Integer> elements = new ArrayList<>();

        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) != ' ')
            {
                elements.add(Integer.parseInt(input.substring(i, i + 1)));
            }
        }

        maxRows = (int) Math.floor(sqrt((input.length() + 1) / 2)); // e.g. A string of 9 elements would be 17 characters long.
        maxColumns = maxRows;
        int[][] matrix = new int[maxRows][maxColumns];

        int n = 0;
        for (int row = 0; row < maxRows; row++)
        {
            for (int column = 0; column < maxColumns; column++)
            {
                matrix[row][column] = elements.get(n);
                n++;
            }
        }

        return matrix;
    }
}
