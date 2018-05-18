/**
 * Name: Ranjith Kumar Ravikumar
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    static int sizeOfNetwork;
    static float[][] routingTable;
    static float infinity = Float.POSITIVE_INFINITY;
    static float[] vector, send_vector, receiving_vector;
    static float cost;
    static int sending_row1, receiving_row2;
    static float[] temp;

    public static void main(String[] args) {
        BufferedReader br = readNumberOfNodes();
        initializeRoutingTable();
        readUserInput(br);

        //create vector matrix
        vector = new float[sizeOfNetwork];

        printRoutingTable();

        //update algorithm: assuming the convergence reaches in sizeOfNetwork*sizeOfNetwork
        message_passing();

        System.out.println("***********Convergence Reached in the Network***********");


        //Link cost Change Implementation
        try {
            System.out.println("------------Entering Link Cost Change Section--------------");
            System.out.println("Input the link cost change in terms of the routing table by mentioning the row, column and new cost");
            System.out.println("Input the row number or enter -1 to exit this section");
            int change_row = Integer.parseInt(br.readLine());
            if (change_row != -1) {
                System.out.println("Input the column number");
                int change_column = Integer.parseInt(br.readLine());
                System.out.println("Input the change in cost");
                float new_cost = Float.parseFloat(br.readLine());
                routingTable[change_row - 1][change_column - 1] = new_cost;
                routingTable[change_column - 1][change_row - 1] = new_cost;
                System.out.println("-------------The values in the routingTable after Link Cost Change------------- ");
                for (int i = 0; i < sizeOfNetwork; i++) {
                    for (int j = 0; j < sizeOfNetwork; j++) {
                        System.out.print(" " + routingTable[i][j]);
                    }
                    System.out.println();
                }
                message_passing();
                System.out.println();
                System.out.println("***********Convergence Reached in the Network***********");
                System.out.println();
            }
            if (change_row == -1) {
                System.out.println("***********Convergence Reached in the Network (No link cost in the Network)***********");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static BufferedReader readNumberOfNodes() {
        // ask user for the size of nodes in N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input the total number of routers in the network N: ");
        try {
            sizeOfNetwork = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

        routingTable = new float[sizeOfNetwork][sizeOfNetwork];
        return br;
    }

    private static void printRoutingTable() {
        System.out.println("-------------The values in the routingTable are------------- ");
        for (int i = 0; i < sizeOfNetwork; i++) {
            for (int j = 0; j < sizeOfNetwork; j++) {
                System.out.print(" " + routingTable[i][j]);
            }
            System.out.println();
        }
    }

    private static void readUserInput(BufferedReader br) {
        try {
            System.out.println("---------Input the initial values into the routing table: Input -1 for whose costs are not known--------");
            for (int i = 0; i < sizeOfNetwork; i++) {
                for (int j = 0; j < sizeOfNetwork; j++) {
                    System.out.println("Enter value for " + i + " row " + " column " + j);
                    float temp = Float.parseFloat(br.readLine());
                    if (temp != -1) {
                        routingTable[i][j] = temp;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeRoutingTable() {
        for (int i = 0; i < sizeOfNetwork; i++) {
            for (int j = 0; j < sizeOfNetwork; j++) {
                routingTable[i][j] = infinity;
            }
        }
    }

    public static void updateAlgo(int sending_row1, int receiving_row2) {
        //sending_row1 tells receiving_row2

        //finding cost cost<- row2th value in row1
        //going to row2th element in row1
        cost = routingTable[sending_row1 - 1][receiving_row2 - 1];
        System.out.println("Distance from sending router to receiving router " + cost);

        //adding cost to the sending_row2 vector and assign to temp vector
        //creating temp vector send_vector and receiving vector
        temp = new float[sizeOfNetwork];
        send_vector = new float[sizeOfNetwork];
        receiving_vector = new float[sizeOfNetwork];

        //assigning send_vector
        for (int i = 0; i < sizeOfNetwork; i++) {
            send_vector[i] = routingTable[sending_row1 - 1][i];
        }

        System.out.println();

        //assigning receiving_vector
        for (int i = 0; i < sizeOfNetwork; i++) {
            receiving_vector[i] = routingTable[receiving_row2 - 1][i];
        }

        //adding cost
        for (int i = 0; i < sizeOfNetwork; i++) {
            temp[i] = cost + send_vector[i];
        }

        //comparing receiving vector and temp vector for min and assigning it to receiving vector
        //receiving vector <- min(receiving vector, temp_vector)
        for (int i = 0; i < sizeOfNetwork; i++) {
            //System.out.println("Comparing "+receiving_vector[i]+"  "+temp[i]);
            receiving_vector[i] = Math.min(receiving_vector[i], temp[i]);
        }

        //updating routing table with receiving vector
        for (int i = 0; i < sizeOfNetwork; i++) {
            routingTable[receiving_row2 - 1][i] = receiving_vector[i];
        }
        System.out.println("-------------The values in the routingTable after message passing is------------- ");
        for (int i = 0; i < sizeOfNetwork; i++) {
            for (int j = 0; j < sizeOfNetwork; j++) {
                System.out.print(" " + routingTable[i][j]);
            }
            System.out.println();
        }

    }

    public static void message_passing() {
        for (int i = 0; i < sizeOfNetwork * sizeOfNetwork; i++) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println();
                System.out.println("----Input which router_row sends message to the receiving router_row----- ");
                System.out.println("Input sending routing row number from routing table ");
                sending_row1 = Integer.parseInt(br.readLine());
                System.out.println("Input receiving routing row number from routing table ");
                receiving_row2 = Integer.parseInt(br.readLine());
                updateAlgo(sending_row1, receiving_row2);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
