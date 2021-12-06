import java.net.ConnectException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;

// A Java program for Dijkstra's
// single source shortest path
// algorithm. The program is for
// adjacency matrix representation
// of the graph.

class Algorithm {
    static Scanner input = new Scanner(System.in);
    private static final int NO_PARENT = -1;

    // Function that implements Dijkstra's
    // single source shortest path
    // algorithm for a graph represented
    // using adjacency matrix
    // representation
    private static void shortDistance(int[][] adjacencyMatrix, int startVertex, int endVertex) {
        int nVertices = adjacencyMatrix[0].length;

        // shortestDistances[i] will hold the
        // shortest distance from src to i
        int[] shortestDistances = new int[nVertices];

        // added[i] will true if vertex i is
        // included / in shortest path tree
        // or shortest distance from src to
        // i is finalized
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as
        // INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        // Distance of source vertex from
        // itself is always 0
        shortestDistances[startVertex] = 0;

        // Parent array to store shortest
        // path tree
        int[] parents = new int[nVertices];

        // The starting vertex does not
        // have a parent
        parents[startVertex] = NO_PARENT;

        // Find shortest path for all
        // vertices
        for (int i = 1; i < nVertices; i++) {

            // Pick the minimum distance vertex
            // from the set of vertices not yet
            // processed. nearestVertex is
            // always equal to startNode in
            // first iteration.
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            // Mark the picked vertex as
            // processed
            added[nearestVertex] = true;

            // Update dist value of the
            // adjacent vertices of the
            // picked vertex.
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }

        printSolution(startVertex, shortestDistances, parents, endVertex);
    }

    // A utility function to print
    // the constructed distances
    // array and shortest paths
    private static void printSolution(int startVertex, int[] distances, int[] parents, int endVertex) {
        int nVertices = distances.length;
        System.out.print("\n\nJourney");
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {

            String start = place(startVertex);
            String end = place(vertexIndex);
            if (vertexIndex != startVertex && vertexIndex == endVertex) {
                double convert = distances[vertexIndex];
                System.out.print("\n" + start + " -> ");
                System.out.print(end);
                System.out.print("\n\nTotal Distance\n" + convert / 1000 + " km");
                System.out.print("\n\nPath\n");
                printPath(vertexIndex, parents);

            }
        }
    }

    // Assign Locations
    private static String place(int index) {
        String value = "";
        if (index == 0) {
            value = "School Gate";
        } else if (index == 1) {
            value = "School of Info. Studies";
        } else if (index == 2) {
            value = "JQB";
        } else if (index == 3) {
            value = "Int. Programme Office";
        } else if (index == 4) {
            value = "Pent";
        } else if (index == 5) {
            value = "Comp. Sci. Dept.";
        } else if (index == 6) {
            value = "Sch. of Law";
        } else if (index == 7) {
            value = "Math Dept.";
        } else if (index == 8) {
            value = "UGCS";
        } else if (index == 9) {
            value = "Volta Hall";
        } else if (index == 10) {
            value = "Commonwealth Hall";
        } else if (index == 11) {
            value = "Viannis Bistro";
        } else if (index == 12) {
            value = "Sch of Economics";
        } else if (index == 13) {
            value = "Balme Library";
        } else if (index == 14) {
            value = "KAB";
        } else if (index == 15) {
            value = "Akuafo Hall";
        } else if (index == 16) {
            value = "Atlethic Oval";
        } else if (index == 17) {
            value = "Sarbah Hall";
        } else if (index == 18) {
            value = "Sarbah Annex";
        } else if (index == 19) {
            value = "Dept Of Music";
        } else if (index == 20) {
            value = "CEGENSA";
        } else if (index == 21) {
            value = "Bush Canteen";
        } else if (index == 22) {
            value = "Leg Barbeque Joint";
        } else if (index == 23) {
            value = "Legon Hall";
        } else if (index == 24) {
            value = "Fire Service";
        } else if (index == 25) {
            value = "Dept. Of Earth Science";
        } else if (index == 26) {
            value = "Chemistry Dept.";
        } else if (index == 27) {
            value = "Central Cafeteria";
        }
        return value;
    }

    // locations
    private static void printLocation() {
        System.out.println("== School Gate --> 0 ==");
        System.out.println("== School of Info. Studies --> 1 ==");
        System.out.println("== JQB --> 2 ==");
        System.out.println("== Int. Programme Office --> 3 ==");
        System.out.println("== Pent --> 4 ==");
        System.out.println("== Comp. Sci. Dept. --> 5 ==");
        System.out.println("== Sch. of Law --> 6 ==");
        System.out.println("== Math Dept. --> 7 ==");
        System.out.println("== UGCS --> 8 ==");
        System.out.println("== Volta Hall --> 9 ==");
        System.out.println("== Commonwealth Hall --> 10 ==");
        System.out.println("== Viannis Bistro --> 11 ==");
        System.out.println("== Sch of Economics --> 12 ==");
        System.out.println("== Balme Library --> 13 ==");
        System.out.println("== KAB --> 14 ==");
        System.out.println("== Akuafo Hall --> 15 ==");
        System.out.println("== Atlethic Oval --> 16 ==");
        System.out.println("== Sarbah Hall --> 17 ==");
        System.out.println("== Sarbah Annex --> 18 ==");
        System.out.println("== Dept Of Music --> 19 ==");
        System.out.println("== CEGENSA --> 20 ==");
        System.out.println("== Bush Canteen --> 21 ==");
        System.out.println("== Leg Barbeque Joint --> 22 ==");
        System.out.println("== Legon Hall --> 23 ==");
        System.out.println("== Fire Service --> 24 ==");
        System.out.println("== Dept. Of Earth Science--> 25 ==");
        System.out.println("== Chemistry Dept. --> 26 ==");
        System.out.println("== Central Cafeteria --> 27 ==");
    }

    // Function to print shortest path
    // from source to currentVertex
    // using parents array
    private static void printPath(int currentVertex, int[] parents) {

        // Base case : Source node has
        // been processed
        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents);
        String path = "";
        path = place(currentVertex);
        System.out.print(path + "---->");
    }

    // main function to take locations and print distance and path
    private static void inputs(int[][] adjacencyMatrix) {
        while (true) {
            try {
                
                System.out.println("\n\n\nEnter 1 to continue or 0 to Quit or 2 to print locations again");
                int choice = input.nextInt();
                int startingPlace = 0;
                int endingPlace = 0;
                if (choice == 0) {
                    break;
                } else if (choice == 1) {
                    boolean checked = true;
                    System.out.println("\n\n\nEnter The Index Of Your Start Point");
                    startingPlace = input.nextInt();
                    checked = check(startingPlace);
                    if (checked == false) {
                        throw new InputMismatchException();
                    }
                    input.nextLine();
                    System.out.println("\nEnter The Index Of Your End Point");
                    endingPlace = input.nextInt();
                    checked = check(endingPlace);
                    if (checked == false) {
                        throw new InputMismatchException();
                    }
                    

                    shortDistance(adjacencyMatrix, startingPlace, endingPlace);
                } else if (choice == 2) {
                    printLocation();
                } else {
                    System.out.println("\n\nWrong Input. Try Again!");
                }
            } catch (InputMismatchException ex) {
                input.next();
                System.out.println("\n\nWrong Input. Try Again!");
            }
        }
    }

    //checks if location exists
    private static boolean check(int number) {
        if (number >= 0 && number <= 27) {
            return true;
        } else {
            System.out.println("\n\nLocation Does Not Exist\nEnter Any Key");
            return false;
        }
    }


    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                { 0, 150, 0, 0, 900, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 250, 0, 400, 0, 0, 230, 0, 0, 0 },
                { 150, 0, 140, 350, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 600, 0, 0, 0, 400, 0, 0, 0, 0, 350, 400, 0, 0 },
                { 0, 140, 0, 200, 0, 0, 350, 450, 0, 0, 0, 0, 0, 0, 99, 700, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0 },
                { 0, 350, 200, 0, 500, 0, 240, 0, 0, 0, 0, 0, 0, 0, 96, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0 },
                { 900, 0, 0, 500, 0, 500, 650, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 500, 0, 500, 160, 750, 0, 0, 0, 0, 750, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 350, 0 },
                { 0, 0, 350, 240, 650, 500, 0, 400, 0, 0, 0, 0, 0, 900, 350, 750, 0, 0, 0, 0, 0, 0, 0, 0, 0, 600, 500,
                        0 },
                { 0, 0, 450, 0, 0, 160, 400, 0, 350, 0, 0, 0, 0, 600, 350, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 190,
                        0 },
                { 0, 0, 0, 0, 0, 750, 0, 350, 0, 350, 0, 0, 71, 200, 0, 0, 0, 0, 0, 0, 0, 0, 290, 0, 0, 0, 350, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 350, 0, 450, 250, 280, 0, 0, 0, 0, 0, 0, 0, 0, 0, 94, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 450, 0, 210, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 450, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 250, 210, 0, 0, 550, 0, 550, 0, 0, 0, 0, 0, 0, 250, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 71, 280, 0, 0, 0, 130, 0, 0, 0, 0, 0, 0, 0, 0, 220, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 750, 900, 600, 200, 0, 0, 550, 130, 0, 750, 270, 0, 0, 0, 0, 0, 0, 300, 350, 0, 450,
                        400, 0 },
                { 0, 0, 99, 96, 0, 0, 350, 350, 0, 0, 0, 0, 0, 750, 0, 600, 0, 0, 0, 0, 0, 0, 1000, 0, 0, 450, 350,
                        1100 },
                { 500, 600, 700, 700, 0, 0, 750, 500, 0, 0, 0, 550, 0, 270, 600, 0, 500, 750, 0, 750, 650, 0, 350, 300,
                        650, 190, 450, 700 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 300, 0, 0, 0, 0, 450, 220, 0, 0, 0, 200 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 750, 300, 0, 350, 0, 700, 0, 750, 600, 0, 0, 0, 290 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 350, 0, 0, 800, 0, 0, 0, 0, 0, 0, 400 },
                { 250, 400, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 750, 0, 0, 0, 0, 700, 650, 0, 0, 450, 0, 0, 1300 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 650, 0, 700, 800, 700, 0, 550, 0, 0, 0, 0, 0, 600 },
                { 400, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 650, 550, 0, 0, 0, 170, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 290, 94, 450, 250, 220, 300, 1000, 350, 450, 750, 0, 0, 0, 0, 0, 43, 0, 0, 0,
                        650 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 350, 0, 300, 220, 600, 0, 0, 0, 0, 43, 0, 0, 0, 0, 0 },
                { 230, 350, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 650, 0, 0, 0, 450, 0, 170, 0, 0, 0, 0, 0, 0 },
                { 0, 400, 500, 500, 0, 0, 600, 500, 0, 0, 0, 0, 0, 450, 450, 190, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 450,
                        0 },
                { 0, 0, 0, 0, 0, 250, 500, 190, 350, 0, 0, 0, 0, 400, 350, 450, 0, 0, 0, 0, 0, 0, 0, 0, 0, 450, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1100, 700, 200, 290, 400, 1300, 600, 0, 650, 0, 0, 0, 0,
                        0 }, };

        System.out.println("---------------------Welcome To UG Shortest Path Finder---------------------");
        System.out.println("\n**Please Locate Your Start Point and End Point with Thier Indexes**\n");

        printLocation();
        inputs(adjacencyMatrix);

    }
}
