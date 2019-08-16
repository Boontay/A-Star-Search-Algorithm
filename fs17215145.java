/*
Thomas Langley: 17215145
Ross Duffy: 17201624
Hannah McKenna: 17204178
Conor Nolan: 17234239
 */

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.*;

public class fs17215145
{
    public static class UserInput
    {
        private String pattern = "[0-8]{1}";
        String startState, endState;

        public UserInput()
        {
            /** Declaring some variables that will be used throughout the program **/
            String pattern1 = "[0-9]{1}";
            String pattern2 = "1" + "[0-5]{1}";

            /** Next is the welcome message and then you will be asked to enter the start state of the 15-puzzle **/


            JOptionPane.showMessageDialog(null, "Welcome to our project for Intelligent Systems, where we will solve the 15-puzzle using the A* algorithm!", "Welcome", 1);
            startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);


            /** Validation for the start state
             * This first of all splits the input for the start state by separating between white spaces
             * Next it checks if there is any duplicate numbers in the input
             * If there's duplicates, the program will infinitely loop until an input with no duplicates is recorded
             * Next it checks that the input contains exactly 16 numbers and will loop until an input of 16 numbers is input
             * Finally, the program checks if each number is in the range [0, 15] and will loop until this happens
             **/


            String[] elements = startState.split("\\s+");

            for (int i = 0; i < elements.length; i++)
            {
                for (int j = i + 1; j < elements.length; j++)
                {
                    if (elements[i].equals(elements[j]))
                    {
                        JOptionPane.showMessageDialog(null, "The sequence of numbers in the input contained duplicates.", "Error", 2);
                        startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
                    }
                }
            }

            if (((elements.length != 9) && (elements.length != 16)))
            {
                JOptionPane.showMessageDialog(null, "The input must contain 16 unique numbers between [0, 15]", "Error", 2);
                startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
            }

            if (!(elements[0].matches(pattern1)) && !(elements[0].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
            }
            if (!(elements[1].matches(pattern1)) && !(elements[1].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
            }
            if (!(elements[2].matches(pattern1)) && !(elements[2].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
            }
            if (!(elements[3].matches(pattern1)) && !(elements[3].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
            }
            if (!(elements[4].matches(pattern1)) && !(elements[4].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
            }
            if (!(elements[5].matches(pattern1)) && !(elements[5].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
            }
            if (!(elements[6].matches(pattern1)) && !(elements[6].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
            }
            if (!(elements[7].matches(pattern1)) && !(elements[7].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
            }
            if (!(elements[8].matches(pattern1)) && !(elements[8].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
            }

            if (elements.length > 9)
            {
                if (!(elements[9].matches(pattern1)) && !(elements[9].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
                }
                if (!(elements[10].matches(pattern1)) && !(elements[10].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
                }
                if (!(elements[11].matches(pattern1)) && !(elements[11].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
                }
                if (!(elements[12].matches(pattern1)) && !(elements[12].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
                }
                if (!(elements[13].matches(pattern1)) && !(elements[13].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
                }
                if (!(elements[14].matches(pattern1)) && !(elements[14].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
                }
                if (!(elements[15].matches(pattern1)) && !(elements[15].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    startState = JOptionPane.showInputDialog(null, "Please enter the start state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "Start State", 1);
                }
            }


            /** The user will then be asked to enter an end state **/


            endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 16], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);


            /** Validation for the end state
             * This works exactly the same way as the validation for the start state
             * This first of all splits the input for the end state by separating between white spaces
             * Next it checks if there is any duplicate numbers in the input
             * If there's duplicates, the program will infinitely loop until an input with no duplicates is recorded
             * Next it checks that the input contains exactly 16 numbers and will loop until an input of 16 numbers is input
             * Finally, the program checks if each number is in the range [0, 15] and will loop until this happens
             **/


            String[] goalNumbers = endState.split("\\s+");

            for (int i = 0; i < goalNumbers.length; i++)
            {
                for (int j = i + 1; j < goalNumbers.length; j++)
                {
                    if (goalNumbers[i].equals(goalNumbers[j]))
                    {
                        JOptionPane.showMessageDialog(null, "The sequence of numbers in the input contained duplicates.", "Error", 2);
                        endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
                    }
                }
            }

            if (goalNumbers.length != 9 && goalNumbers.length != 16)
            {
                JOptionPane.showMessageDialog(null, "The input must contain 9 unique numbers between [0, 15]", "Error", 2);
                endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
            }

            if (!(goalNumbers[0].matches(pattern1)) && !(goalNumbers[0].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
            }
            if (!(goalNumbers[1].matches(pattern1)) && !(goalNumbers[1].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
            }
            if (!(goalNumbers[2].matches(pattern1)) && !(goalNumbers[2].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
            }
            if (!(goalNumbers[3].matches(pattern1)) && !(goalNumbers[3].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
            }
            if (!(goalNumbers[4].matches(pattern1)) && !(goalNumbers[4].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
            }
            if (!(goalNumbers[5].matches(pattern1)) && !(goalNumbers[5].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
            }
            if (!(goalNumbers[6].matches(pattern1)) && !(goalNumbers[6].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
            }
            if (!(goalNumbers[7].matches(pattern1)) && !(goalNumbers[7].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
            }
            if (!(goalNumbers[8].matches(pattern1)) && !(goalNumbers[8].matches(pattern2)))
            {
                JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
            }
            if (goalNumbers.length > 9)
            {
                if (!(goalNumbers[9].matches(pattern1)) && !(goalNumbers[9].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
                }
                if (!(goalNumbers[10].matches(pattern1)) && !(goalNumbers[10].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
                }
                if (!(goalNumbers[11].matches(pattern1)) && !(goalNumbers[11].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
                }
                if (!(goalNumbers[12].matches(pattern1)) && !(goalNumbers[12].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
                }
                if (!(goalNumbers[13].matches(pattern1)) && !(goalNumbers[13].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
                }
                if (!(goalNumbers[14].matches(pattern1)) && !(goalNumbers[14].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
                }
                if (!(goalNumbers[15].matches(pattern1)) && !(goalNumbers[15].matches(pattern2)))
                {
                    JOptionPane.showMessageDialog(null, "The input must be in the range [0, 15]", "Error", 2);
                    endState = JOptionPane.showInputDialog(null, "Please enter the end state as a sequence of numbers between [0, 15], where 0 indicates the empty tile. \nNumbers are separated by space.", "End State", 1);
                }
            }
        }

        public String getStartStateString()
        {
            return startState;
        }

        public String getEndStateString()
        {
            return endState;
        }

        /**
         * This code accepts a string, and converts it to a 2-dimensional array of integers.
         */
        private int[][] convertInputToTable(String input)
        {
            String[] numbers = input.split(" ");

            maxRows = (int) Math.floor(sqrt((numbers.length)));
            //maxRows = (int) Math.floor(sqrt((numbers.length + 1) / 2));
            maxColumns = maxRows;

            int[][] matrix = new int[maxRows][maxColumns];

            int n = 0;
            for (int row = 0; row < maxRows; row++)
            {
                for (int column = 0; column < maxColumns; column++)
                {
                    matrix[row][column] = Integer.parseInt(numbers[n]);
                    n++;
                }
            }

            return matrix;
        }
    }

    public static class Node
    {
        private boolean visited;
        private int[][] matrix;
        private ArrayList<Node> children;
        private Node parent;
        private int distanceCost;
        private int estimatedCostToGoal;
        private int totalCost;
        private int depth;
        private int zeroRow;
        private int zeroCol;

        public void printMatrix()
        {
            for (int i = 0; i < matrix.length; i++)
            {
                for (int j = 0; j < matrix[i].length; j++)
                {
                    int n = matrix[i][j];

                    if (n < 10)
                    {
                        System.out.print("| " + n);
                    }
                    else
                    {
                        System.out.print("|" + n);
                    }
                }

                System.out.print("|");
                System.out.println();
            }
        }

        public int getZeroRow()
        {
            return zeroRow;
        }

        public int getZeroCol()
        {
            return zeroCol;
        }

        public int[][] getMatrix()
        {
            return matrix;
        }

        public void setMatrix(int[][] matrix)
        {
            this.matrix = matrix;
        }

        public boolean isVisited()
        {
            return visited;
        }

        public void setVisited(boolean visited)
        {
            this.visited = visited;
        }

        public ArrayList<Node> getChildren()
        {
            return children;
        }

        public void setChildren(ArrayList<Node> children)
        {
            this.children = children;
        }

        public Node getParent()
        {
            return parent;
        }

        public void setParent(Node parent)
        {
            this.parent = parent;
            this.depth = parent.getDepth() + 1;
        }

        public int getDistanceCost()
        {
            return distanceCost;
        }

        public void setDistanceCost(int distanceCost)
        {
            this.distanceCost = distanceCost;
        }

        public int getEstimatedCostToGoal()
        {
            return estimatedCostToGoal;
        }

        public void setEstimatedCostToGoal(int estimatedCostToGoal)
        {
            this.estimatedCostToGoal = estimatedCostToGoal;
        }

        public int getTotalCost()
        {
            return totalCost;
        }

        public void setTotalCost(int totalCost, int estimatedCostToGoal)
        {
            this.totalCost = totalCost + estimatedCostToGoal;
        }

        public void setTotalCost(int totalCost)
        {
            this.totalCost = totalCost;
        }

        public int getDepth()
        {
            return depth;
        }

        public void setDepth(int depth)
        {
            this.depth = depth;
        }

        public void addChild(Node child)
        {
            children.add(child);
        }

        public Node()
        {
            children = new ArrayList<>();
        }

        public Node(int[][] matrix)
        {
            this.matrix = matrix;
            children = new ArrayList<>();
        }

        public void deepCopy(Node n)
        {
            visited = n.isVisited();
            matrix = n.getMatrix();
            children = n.getChildren();
            parent = n.parent;
            distanceCost = n.distanceCost;
            estimatedCostToGoal = n.getEstimatedCostToGoal();
            totalCost = n.getTotalCost();
            depth = n.getDepth();
        }

        public boolean equals(Node n)
        {
            if (matrix == n.getMatrix())
            {
                return true;
            } else
            {
                return false;
            }
        }

        public boolean isFoundIn(ArrayList<Node> nodes)
        {
            for (int i = 0; i < nodes.size(); i++)
            {
                if (matrix.equals(nodes.get(i).getMatrix()))
                {
                    return true;
                }
            }

            return false;
        }

        public void setBlankPos()
        {
            for (int i = 0; i < matrix.length; i++)
            {
                for (int j = 0; j < matrix[i].length; j++)
                {
                    if (matrix[i][j] == 0)
                    {
                        zeroRow = i;
                        zeroCol = j;
                    }
                }
            }
        }
    }

    public static class PriorityComparator implements Comparator<Node>
    {
        @Override
        public int compare(Node x, Node y)
        {
            if (x.getTotalCost() < y.getTotalCost())
            {
                return -1;
            }
            if (x.getTotalCost() > y.getTotalCost())
            {
                return 1;
            }
            return 0;
        }
    }

    public static class SearchTree
    {
        private Node root;
        private Node goalState;

        public SearchTree(Node root, Node goalState)
        {
            this.root = root;
            this.goalState = goalState;
        }

        public void aStar()
        {
            ArrayList<Node> states = new ArrayList<>();

            Node node = root;
            node.deepCopy(root);
            node.setTotalCost(0);

            Node currentNode = node;
            currentNode.deepCopy(node);

            states.add(currentNode);

            while (!Arrays.deepEquals(currentNode.getMatrix(), goalState.getMatrix()))
            {
                ArrayList<int[][]> successors = moveHue(currentNode.getMatrix(), 1);
                ArrayList<Node> children = new ArrayList<>();

                for (int[][] n : successors)
                {
                    /*
                    if (states.contains(n))
                    {
                        continue;
                    }
                    */

                    Node child = new Node(n);
                    child.setTotalCost(
                            0,
                            heuristic(child, goalState)
                    );
                    child.setParent(currentNode);

                    /*
                    if (!states.contains(child))
                    {
                        children.add(child);
                    }
                    */

                    if (!child.isFoundIn(children))
                    {
                        children.add(child);
                    }
                }

                for (int i = 0; i < children.size() - 1; i++)
                {
                    for (int j = 0; j < children.size() - 1; j++)
                    {
                        if (children.get(i).getTotalCost() < children.get(j).getTotalCost())
                        {
                            Node temp = new Node();
                            temp.deepCopy(children.get(j));

                            children.get(j).deepCopy(children.get(i));
                            children.get(i).deepCopy(temp);
                        }
                    }
                }

                currentNode.deepCopy(children.get(0));

                if (!children.get(0).isFoundIn(states))
                {
                    states.add(children.get(0));
                }
            }

            for (int i = 0; i < states.size(); i++)
            {
                states.get(i).printMatrix();
                System.out.println();
            }
        }

        public void printSolution(Node goalNode, Node root, ArrayList<Node> pathToFollow)
        {
            Stack<Node> solutionStack = new Stack<Node>();
            solutionStack.push(goalNode);
            while (!goalNode.getMatrix().equals(root.getMatrix()))
            {
                solutionStack.push(goalNode.getParent());
                goalNode = goalNode.getParent();
            }

            Node sourceState = root;
            Node destinationState;

            int totalCost = 0;
            int cost = 0;

            for (int i = solutionStack.size() - 1; i >= 0; i--)
            {
                destinationState = pathToFollow.get(i);

                if (!(sourceState.equals(destinationState.getMatrix())))
                {
                    int[][] mat = destinationState.getMatrix();
                    System.out.println("Move: " + mat[destinationState.getZeroRow()][destinationState.getZeroCol()] + "  " + findTransition(sourceState, destinationState));
                    cost = destinationState.getZeroCol() + destinationState.getZeroRow();
                    totalCost += cost;
                }

                sourceState = destinationState;
                System.out.println("Movement cost: " + cost);
                System.out.println();
                pathToFollow.get(i).printMatrix();
                System.out.println();
            }
        }

        public String findTransition(Node source, Node destination)
        {
            int sourceZeroRow = source.getZeroRow(), sourceZeroCol = source.getZeroCol();
            int destZeroRow = destination.getZeroRow(), destZeroCol = destination.getZeroCol();

            int zeroPosDifference = (destZeroCol + destZeroRow) - (sourceZeroRow + sourceZeroCol);

            switch (zeroPosDifference)
            {
                case -3:
                    return "DOWN";

                case 3:
                    return "UP";

                case 1:
                    return "LEFT";

                case -1:
                    return "RIGHT";

            }

            return null;
        }

        public int heuristic(Node inState, Node endState)
        {
            int[][] inMatrix = inState.getMatrix();
            int[][] endMatrix = endState.getMatrix();

            int heuristic = 0;

            for (int o = 0; o < inMatrix.length; o++)
            {
                for (int p = 0; p < inMatrix[o].length; p++)
                {
                    if (inMatrix[o][p] != 0)
                    {
                        if (inMatrix[o][p] != endMatrix[o][p])
                        {
                            heuristic++;
                        }
                    }
                }
            }

            return heuristic;
        }

        public ArrayList movements(Node currentMove)
        {
            int arr[][] = currentMove.getMatrix();
            int eightORfifteen = 0;
            if (arr.length == 3)
            {
                eightORfifteen = 8;
            } else eightORfifteen = 15;
            String returnable = "";
            int zeroCol = 0, zeroRow = 0;
            int toWest, toEast, toNorth, toSouth;
            ArrayList<String> heuristics = new ArrayList<>();
            ArrayList<String> possibleMoves = new ArrayList<>();
            int sizeOfMat = 0;
            if (eightORfifteen == 8)
            {
                sizeOfMat = 3;
            } else sizeOfMat = 4;

            outerloop:
            //finding the empty space
            for (int i = 0; i < sizeOfMat; i++)
            {
                for (int j = 0; j < sizeOfMat; j++)
                {
                    int x = arr[i][j];
                    if (x == 0)
                    {
                        zeroRow = i;
                        zeroCol = j;
                        break outerloop;
                    }
                }
            }

            //heuristics = moveHue(arr, 0);

            // Gets ints all around null space, appends string (lots of if statements) then gets heuristics and add it to the string.
            if (eightORfifteen == 8)
            {
                if (zeroRow == 0 && zeroCol == 0)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";

                } else if (zeroRow == 0 && zeroCol == 1)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toWest = arr[zeroRow][zeroCol - 1];
                    returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(c) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(2);
                    possibleMoves.add(returnable);
                    returnable = "";
                } else if (zeroRow == 0 && zeroCol == 2)
                {
                    toWest = arr[zeroRow][zeroCol - 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    returnable += "\n(a) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";

                } else if (zeroRow == 1 && zeroCol == 0)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toNorth = arr[zeroRow - 1][zeroCol];
                    returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(c) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(2);
                    possibleMoves.add(returnable);
                    returnable = "";
                } else if (zeroRow == 1 && zeroCol == 1)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toWest = arr[zeroRow - 1][zeroCol];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toNorth = arr[zeroRow - 1][zeroCol];
                    returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(c) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(2);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(d) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(3);
                    possibleMoves.add(returnable);
                    returnable = "";

                } else if (zeroRow == 1 && zeroCol == 2)
                {
                    toWest = arr[zeroRow][zeroCol - 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toNorth = arr[zeroRow - 1][zeroCol];
                    returnable += "\n(a) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(c) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(2);
                    possibleMoves.add(returnable);
                    returnable = "";

                } else if (zeroRow == 2 && zeroCol == 0)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toNorth = arr[zeroRow - 1][zeroCol];
                    returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";
                } else if (zeroRow == 2 && zeroCol == 1)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toNorth = arr[zeroRow - 1][zeroCol];
                    toWest = arr[zeroRow][zeroCol - 1];
                    returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(c) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(2);
                    possibleMoves.add(returnable);
                    returnable = "";

                } else if (zeroRow == 2 && zeroCol == 2)
                {
                    toNorth = arr[zeroRow - 1][zeroCol];
                    toWest = arr[zeroRow][zeroCol - 1];
                    returnable += "\n(a) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                }
            } else if (eightORfifteen == 15)
            {

                if (zeroRow == 0 && zeroCol == 0)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";

                } else if ((zeroRow == 0 && zeroCol == 1) || (zeroRow == 0 && zeroCol == 2))
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toWest = arr[zeroRow][zeroCol - 1];
                    returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(c) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(2);
                    possibleMoves.add(returnable);
                    returnable = "";
                } else if (zeroRow == 0 && zeroCol == 3)
                {
                    toWest = arr[zeroRow][zeroCol - 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    returnable += "\n(a) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";

                } else if ((zeroRow == 1 && zeroCol == 0) || (zeroRow == 2 && zeroCol == 0))
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toNorth = arr[zeroRow - 1][zeroCol];
                    returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(c) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(2);
                    possibleMoves.add(returnable);
                    returnable = "";
                } else if ((zeroRow == 1 && zeroCol == 1) || (zeroRow == 1 && zeroCol == 2) || (zeroRow == 2 && zeroCol == 1) || (zeroRow == 2 && zeroCol == 2))
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toWest = arr[zeroRow - 1][zeroCol];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toNorth = arr[zeroRow - 1][zeroCol];
                    returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(c) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(2);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(d) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(3);
                    possibleMoves.add(returnable);
                    returnable = "";

                } else if ((zeroRow == 1 && zeroCol == 3) || (zeroRow == 2 && zeroCol == 3))
                {
                    toWest = arr[zeroRow][zeroCol - 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toNorth = arr[zeroRow - 1][zeroCol];
                    returnable += "\n(a) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toSouth) + " to the South" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(c) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(2);
                    possibleMoves.add(returnable);
                    returnable = "";

                } else if (zeroRow == 3 && zeroCol == 0)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toNorth = arr[zeroRow - 1][zeroCol];
                    returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";
                } else if ((zeroRow == 3 && zeroCol == 1) || (zeroRow == 3 && zeroCol == 2))
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toNorth = arr[zeroRow - 1][zeroCol];
                    toWest = arr[zeroRow][zeroCol - 1];
                    returnable += "\n(a) " + Integer.toString(toEast) + " to the East" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(c) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(2);
                    possibleMoves.add(returnable);
                    returnable = "";

                } else if (zeroRow == 3 && zeroCol == 3)
                {
                    toNorth = arr[zeroRow - 1][zeroCol];
                    toWest = arr[zeroRow][zeroCol - 1];
                    returnable += "\n(a) " + Integer.toString(toWest) + " to the West" + ", Heuristic value: " + heuristics.get(0);
                    possibleMoves.add(returnable);
                    returnable = "";
                    returnable += "\n(b) " + Integer.toString(toNorth) + " to the North" + ", Heuristic value: " + heuristics.get(1);
                    possibleMoves.add(returnable);
                }
            }


            return possibleMoves;
        }

        public ArrayList<int[][]> moveHue(int arr[][], int matrixORstring)
        {
            int zeroCol = 0, zeroRow = 0;
            int temp1[][] = new int[arr.length][arr[0].length];
            int temp2[][] = new int[arr.length][arr[0].length];
            int temp3[][] = new int[arr.length][arr[0].length];
            int temp4[][] = new int[arr.length][arr[0].length];

            int toWest, toEast, toNorth, toSouth;
            int eightORfifteen = 0;
            if (arr.length == 3)
            {
                eightORfifteen = 8;
            } else eightORfifteen = 15;
            ArrayList<int[][]> possibleMatrices = new ArrayList<>();
            ArrayList<String> heuristics = new ArrayList<>();
            int sizeOfMat = 0;
            if (arr.length == 3)
            {
                sizeOfMat = 3;
            } else
            {
                sizeOfMat = 4;
            }

            temp1 = copyMatrix(temp1, arr);
            temp2 = copyMatrix(temp2, arr);
            temp3 = copyMatrix(temp3, arr);
            temp4 = copyMatrix(temp4, arr);

            outerloop:
            //finding the empty space
            for (int i = 0; i < sizeOfMat; i++)
            {
                for (int j = 0; j < sizeOfMat; j++)
                {
                    int x = arr[i][j];
                    if (x == 0)
                    {
                        zeroRow = i;
                        zeroCol = j;
                        break outerloop;
                    }
                }
            }
            // Gets ints all around null space, appends string (lots of if statements :( )
            if (eightORfifteen == 15)
            {
                if (zeroRow == 0 && zeroCol == 0)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toSouth = arr[zeroRow + 1][zeroCol];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol + 1];
                    temp1[zeroRow][zeroCol + 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow + 1][zeroCol];
                    temp2[zeroRow + 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                } else if ((zeroRow == 0 && zeroCol == 1) || (zeroRow == 0 && zeroCol == 2))
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toWest = arr[zeroRow][zeroCol - 1];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol + 1];
                    temp1[zeroRow][zeroCol + 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow + 1][zeroCol];
                    temp2[zeroRow + 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                    temp3[zeroRow][zeroCol] = temp3[zeroRow][zeroCol - 1];
                    temp3[zeroRow][zeroCol - 1] = 0;
                    possibleMatrices.add(temp3);


                } else if (zeroRow == 0 && zeroCol == 3)
                {
                    toWest = arr[zeroRow][zeroCol - 1];
                    toSouth = arr[zeroRow + 1][zeroCol];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol - 1];
                    temp1[zeroRow][zeroCol - 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow + 1][zeroCol];
                    temp2[zeroRow + 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                } else if ((zeroRow == 1 && zeroCol == 0) || (zeroRow == 2 && zeroCol == 0))
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toNorth = arr[zeroRow - 1][zeroCol];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol + 1];
                    temp1[zeroRow][zeroCol + 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow + 1][zeroCol];
                    temp2[zeroRow + 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                    temp3[zeroRow][zeroCol] = temp3[zeroRow - 1][zeroCol];
                    temp3[zeroRow - 1][zeroCol] = 0;
                    possibleMatrices.add(temp3);


                } else if ((zeroRow == 1 && zeroCol == 1) || (zeroRow == 1 && zeroCol == 2) || (zeroRow == 2 && zeroCol == 1) || (zeroRow == 2 && zeroCol == 2))
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toWest = arr[zeroRow - 1][zeroCol];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toNorth = arr[zeroRow - 1][zeroCol];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol + 1];
                    temp1[zeroRow][zeroCol + 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow][zeroCol - 1];
                    temp2[zeroRow][zeroCol - 1] = 0;
                    possibleMatrices.add(temp2);


                    temp3[zeroRow][zeroCol] = temp3[zeroRow + 1][zeroCol];
                    temp3[zeroRow + 1][zeroCol] = 0;
                    possibleMatrices.add(temp3);


                    temp4[zeroRow][zeroCol] = temp4[zeroRow - 1][zeroCol];
                    temp4[zeroRow - 1][zeroCol] = 0;
                    possibleMatrices.add(temp4);


                } else if ((zeroRow == 1 && zeroCol == 3) || (zeroRow == 2 && zeroCol == 3))
                {
                    toWest = arr[zeroRow][zeroCol - 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toNorth = arr[zeroRow - 1][zeroCol];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol - 1];
                    temp1[zeroRow][zeroCol - 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow + 1][zeroCol];
                    temp2[zeroRow + 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                    temp3[zeroRow][zeroCol] = temp3[zeroRow - 1][zeroCol];
                    temp3[zeroRow - 1][zeroCol] = 0;
                    possibleMatrices.add(temp3);


                } else if (zeroRow == 3 && zeroCol == 0)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toNorth = arr[zeroRow - 1][zeroCol];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol + 1];
                    temp1[zeroRow][zeroCol + 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow - 1][zeroCol];
                    temp2[zeroRow - 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                } else if ((zeroRow == 3 && zeroCol == 1) || (zeroRow == 3 && zeroCol == 2))
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toNorth = arr[zeroRow - 1][zeroCol];
                    toWest = arr[zeroRow][zeroCol - 1];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol + 1];
                    temp1[zeroRow][zeroCol + 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow - 1][zeroCol];
                    temp2[zeroRow - 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                    temp3[zeroRow][zeroCol] = temp3[zeroRow][zeroCol - 1];
                    temp3[zeroRow][zeroCol - 1] = 0;
                    possibleMatrices.add(temp3);


                } else if (zeroRow == 3 && zeroCol == 3)
                {
                    toNorth = arr[zeroRow - 1][zeroCol];
                    toWest = arr[zeroRow][zeroCol - 1];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow - 1][zeroCol];
                    temp1[zeroRow - 1][zeroCol] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow][zeroCol - 1];
                    temp2[zeroRow][zeroCol - 1] = 0;
                    possibleMatrices.add(temp2);


                }
            } else if (eightORfifteen == 8)
            {
                if (zeroRow == 0 && zeroCol == 0)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toSouth = arr[zeroRow + 1][zeroCol];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol + 1];
                    temp1[zeroRow][zeroCol + 1] = 0;
                    possibleMatrices.add(temp1);

                    temp2[zeroRow][zeroCol] = temp2[zeroRow + 1][zeroCol];
                    temp2[zeroRow + 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                } else if (zeroRow == 0 && zeroCol == 1)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toWest = arr[zeroRow][zeroCol - 1];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol + 1];
                    temp1[zeroRow][zeroCol + 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow + 1][zeroCol];
                    temp2[zeroRow + 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                    temp3[zeroRow][zeroCol] = temp3[zeroRow][zeroCol - 1];
                    temp3[zeroRow][zeroCol - 1] = 0;
                    possibleMatrices.add(temp3);


                } else if (zeroRow == 0 && zeroCol == 2)
                {
                    toWest = arr[zeroRow][zeroCol - 1];
                    toSouth = arr[zeroRow + 1][zeroCol];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol - 1];
                    temp1[zeroRow][zeroCol - 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow + 1][zeroCol];
                    temp2[zeroRow + 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                } else if (zeroRow == 1 && zeroCol == 0)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toNorth = arr[zeroRow - 1][zeroCol];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol + 1];
                    temp1[zeroRow][zeroCol + 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow + 1][zeroCol];
                    temp2[zeroRow + 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                    temp3[zeroRow][zeroCol] = temp3[zeroRow - 1][zeroCol];
                    temp3[zeroRow - 1][zeroCol] = 0;
                    possibleMatrices.add(temp3);


                } else if (zeroRow == 1 && zeroCol == 1)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toWest = arr[zeroRow - 1][zeroCol];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toNorth = arr[zeroRow - 1][zeroCol];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol + 1];
                    temp1[zeroRow][zeroCol + 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow][zeroCol - 1];
                    temp2[zeroRow][zeroCol - 1] = 0;
                    possibleMatrices.add(temp2);


                    temp3[zeroRow][zeroCol] = temp3[zeroRow + 1][zeroCol];
                    temp3[zeroRow + 1][zeroCol] = 0;
                    possibleMatrices.add(temp3);


                    temp4[zeroRow][zeroCol] = temp4[zeroRow - 1][zeroCol];
                    temp4[zeroRow - 1][zeroCol] = 0;
                    possibleMatrices.add(temp4);


                } else if (zeroRow == 1 && zeroCol == 2)
                {
                    toWest = arr[zeroRow][zeroCol - 1];
                    toSouth = arr[zeroRow + 1][zeroCol];
                    toNorth = arr[zeroRow - 1][zeroCol];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol - 1];
                    temp1[zeroRow][zeroCol - 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow + 1][zeroCol];
                    temp2[zeroRow + 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                    temp3[zeroRow][zeroCol] = temp3[zeroRow - 1][zeroCol];
                    temp3[zeroRow - 1][zeroCol] = 0;
                    possibleMatrices.add(temp3);


                } else if (zeroRow == 2 && zeroCol == 0)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toNorth = arr[zeroRow - 1][zeroCol];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol + 1];
                    temp1[zeroRow][zeroCol + 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow - 1][zeroCol];
                    temp2[zeroRow - 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                } else if (zeroRow == 2 && zeroCol == 1)
                {
                    toEast = arr[zeroRow][zeroCol + 1];
                    toNorth = arr[zeroRow - 1][zeroCol];
                    toWest = arr[zeroRow][zeroCol - 1];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow][zeroCol + 1];
                    temp1[zeroRow][zeroCol + 1] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow - 1][zeroCol];
                    temp2[zeroRow - 1][zeroCol] = 0;
                    possibleMatrices.add(temp2);


                    temp3[zeroRow][zeroCol] = temp3[zeroRow][zeroCol - 1];
                    temp3[zeroRow][zeroCol - 1] = 0;
                    possibleMatrices.add(temp3);


                } else if (zeroRow == 2 && zeroCol == 2)
                {
                    toNorth = arr[zeroRow - 1][zeroCol];
                    toWest = arr[zeroRow][zeroCol - 1];

                    temp1[zeroRow][zeroCol] = temp1[zeroRow - 1][zeroCol];
                    temp1[zeroRow - 1][zeroCol] = 0;
                    possibleMatrices.add(temp1);


                    temp2[zeroRow][zeroCol] = temp2[zeroRow][zeroCol - 1];
                    temp2[zeroRow][zeroCol - 1] = 0;
                    possibleMatrices.add(temp2);


                }
            }
            /*
            if (matrixORstring == 0) {
                for (int i = 0; i < possibleMatrices.size(); i++) {
                    //Pass Ross's function possibleMatrices.get(i) & add result to heuristics arraylist, then return arraylist;
                    //heuristics.add(Integer.toString(Ross's Function));
                    //heuristics.add(Integer.toString(i)); // temp output

                    //heuristics.add(Integer.toString(heuristic(possibleMatrices.get(i), endMatrix)));
                    heuristics.add("2");
                }
                return heuristics;
            }
            elseif (matrixORstring == 1) {
                return possibleMatrices;
            }
            */
            //return heuristics;

            return possibleMatrices;
        }

        private static int[][] copyMatrix(int[][] old, int[][] replacer)
        {
            for (int i = 0; i < old.length; i++)
                for (int j = 0; j < old[i].length; j++)
                    old[i][j] = replacer[i][j];
            return old;
        }

        private void choosingMoves(Node currentMove)
        {
            int arr[][] = currentMove.getMatrix();
            ArrayList<int[][]> possibleMatrices;
            int fValue = 0; // replace this with a global variable
            ArrayList hValue = moveHue(arr, 0);
            int[] lowestHeuArray = lowestH(hValue);
            int lowestH = lowestHeuArray[1];
            fValue = fValue + lowestH;
            possibleMatrices = moveHue(arr, 1);
            for (int i = 0; i < possibleMatrices.size(); i++)
            {
                Node temp = new Node(possibleMatrices.get(i));
                currentMove.addChild(temp);
            }
        }

        private int[] lowestH(ArrayList<String> hValue)
        {
            int[] data = new int[2];
            if (hValue.size() == 2)
            {
                if (Integer.parseInt(hValue.get(0)) <= Integer.parseInt(hValue.get(1)))
                {
                    data[1] = Integer.parseInt(hValue.get(0));
                    data[0] = 0;
                    return data;
                } else return data;
            } else if (hValue.size() == 3)
            {
                if (Integer.parseInt(hValue.get(0)) < Integer.parseInt(hValue.get(1)))
                {
                    if (Integer.parseInt(hValue.get(0)) < Integer.parseInt(hValue.get(2)))
                    {
                        data[1] = Integer.parseInt(hValue.get(0));
                        data[0] = 0;
                        return data;
                    }
                } else if (Integer.parseInt(hValue.get(1)) < Integer.parseInt(hValue.get(2)))
                {
                    data[1] = Integer.parseInt(hValue.get(1));
                    data[0] = 1;
                    return data;
                } else data[1] = Integer.parseInt(hValue.get(2));
                data[0] = 2;
                return data;
            } else if (hValue.size() == 4)
            {
                if (Integer.parseInt(hValue.get(0)) < Integer.parseInt(hValue.get(1)))
                {
                    if (Integer.parseInt(hValue.get(0)) < Integer.parseInt(hValue.get(2)))
                    {
                        if (Integer.parseInt(hValue.get(0)) < Integer.parseInt(hValue.get(3)))
                        {
                            data[1] = Integer.parseInt(hValue.get(0));
                            data[0] = 0;
                            return data;
                        }
                    }
                } else if (Integer.parseInt(hValue.get(1)) < Integer.parseInt(hValue.get(2)))
                {
                    if (Integer.parseInt(hValue.get(1)) < Integer.parseInt(hValue.get(3)))
                    {
                        data[1] = Integer.parseInt(hValue.get(1));
                        data[0] = 1;
                        return data;
                    }
                } else if (Integer.parseInt(hValue.get(2)) < Integer.parseInt(hValue.get(3)))
                {
                    data[1] = Integer.parseInt(hValue.get(2));
                    data[0] = 2;
                    return data;
                } else
                {
                    data[1] = Integer.parseInt(hValue.get(3));
                    data[0] = 3;
                    return data;
                }

            }
            return data;
        }
    }

    private static Node startState;
    private static Node endState;

    private static int maxRows;
    private static int maxColumns;

    public static void main(String[] args)
    {
        UserInput input = new UserInput();

        startState = new Node(
                input.convertInputToTable(input.getStartStateString())
        );

        endState = new Node(
                input.convertInputToTable(input.getEndStateString())
        );

        SearchTree st = new SearchTree(startState, endState);
        st.aStar();
    }
}
