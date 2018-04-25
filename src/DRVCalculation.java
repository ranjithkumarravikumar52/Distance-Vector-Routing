//name: Ranjith Kumar Ravikumar
//ID: 800937157
import java.io.*;

public class DRVCalculation {
	static int size_of_network;
	static float[][] routing_table;
	static float infinity = Float.POSITIVE_INFINITY;
	static float[] vector,send_vector,receiving_vector;
	static float cost;
	static int sending_row1, receiving_row2;
	static float[] temp;
	
	public static void main(String[] args) {
		
		
		// ask user for the size of nodes in N
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input the total number of routers in the network N: ");
		try{
			size_of_network = Integer.parseInt(br.readLine());
		}
		catch (Exception E){
			
		}
		
		//creating the routing table
		routing_table = new float[size_of_network][size_of_network];
		
		//initializing infinity to all values in the table
		for(int i=0;i<size_of_network;i++){
			for(int j=0;j<size_of_network;j++){
				routing_table[i][j] = infinity;
			}
		}
		
		//asking user to input values into the matrix
		try{
			System.out.println("---------Input the initial values into the routing table: Input -1 for whose costs are not known--------");
			for(int i=0;i<size_of_network;i++){
				for(int j=0;j<size_of_network;j++){
					System.out.println("Enter value for "+i+" row "+" column "+j);
					float temp = Float.parseFloat(br.readLine());
					if(temp !=-1){
						routing_table[i][j] = temp;
					}
					
				}
			}
		}
		catch(Exception E){
			
		}
		
		//create vector matrix
		vector = new float[size_of_network];

		
		//debugging
		//System.out.println("The size of nodes in N: "+size_of_network);
		System.out.println();
		System.out.println("-------------The values in the routing_table are------------- ");
		for(int i=0;i<size_of_network;i++){
			for(int j=0;j<size_of_network;j++){
				System.out.print(" "+routing_table[i][j]);
			}
			System.out.println();
		}
		

		

		
		//update algo
		//assuming the covergence reaches in size_of_network*size_of_network
		message_passing();
		System.out.println();
		System.out.println("***********Convergence Reached in the Network***********");
		System.out.println();
		
		//Link cost Change Implementation
		try{
			System.out.println("------------Entering Link Cost Change Section--------------");
			System.out.println("Input the link cost change in terms of the routing table by mentioning the row, column and new cost");
			System.out.println("Input the row number or enter -1 to exit this section");
			int change_row = Integer.parseInt(br.readLine()); 
			if(change_row !=-1){
				System.out.println("Input the column number");
				int change_column = Integer.parseInt(br.readLine()); 
				System.out.println("Input the change in cost");
				float new_cost = Float.parseFloat(br.readLine());
				routing_table[change_row-1][change_column-1] = new_cost;
				routing_table[change_column-1][change_row-1] = new_cost;
				System.out.println("-------------The values in the routing_table after Link Cost Change------------- ");
				for(int i=0;i<size_of_network;i++){
					for(int j=0;j<size_of_network;j++){
						System.out.print(" "+routing_table[i][j]);
					}
					System.out.println();
				}
				message_passing();
				System.out.println();
				System.out.println("***********Convergence Reached in the Network***********");
				System.out.println();
			}
			if(change_row ==-1){
				System.out.println("***********Convergence Reached in the Network (No link cost in the Network)***********");
			}
		}
		catch(Exception E){
			
		}

	}
	public static void updateAlgo(int sending_row1, int receiving_row2){
		//sending_row1 tells receiving_row2
		
		//finding cost cost<- row2th value in row1
		//going to row2th element in row1
		cost = routing_table[sending_row1-1][receiving_row2-1];
		System.out.println("Distance from sending router to receiving roouter "+cost);
		
		//adding cost to the sending_row2 vector and assign to temp vector
		//creating temp vector send_vector and receiving vector
		temp = new float[size_of_network];
		send_vector = new float[size_of_network];
		receiving_vector = new float[size_of_network];		

		//assigning send_vector
		for(int i=0;i<size_of_network;i++){
			send_vector[i] = routing_table[sending_row1-1][i];
		}

		System.out.println();
		
		//assigning receiving_vector
		for(int i=0;i<size_of_network;i++){
			receiving_vector[i] = routing_table[receiving_row2-1][i];
		}
		
		//adding cost
		for(int i=0;i<size_of_network;i++){
			temp[i] = cost + send_vector[i];
		}
		
		//comparing receiving vector and temp vector for min and assigning it to receiving vector
		//receiving vector <- min(receiving vector, temp_vector)
		for(int i=0;i<size_of_network;i++){
			//System.out.println("Comparing "+receiving_vector[i]+"  "+temp[i]);
			receiving_vector[i] = Math.min(receiving_vector[i], temp[i]);
		}
		
		//updating routing table with receiving vector
		for(int i=0;i<size_of_network;i++){
			routing_table[receiving_row2-1][i] = receiving_vector[i];
		}
		
		
		//Debugging
		/*System.out.println("The values inside send_vector: ");
		for(int i=0;i<size_of_network;i++){
			System.out.print(" "+send_vector[i]);
		}
		System.out.println();
		System.out.println("The values inside receiving_vector ");
		for(int i=0;i<size_of_network;i++){
			System.out.print(" "+receiving_vector[i]);
		}
		System.out.println();
		System.out.println("The values inside the temp_vector ");
		for(int i=0;i<size_of_network;i++){
			System.out.print(" "+temp[i]);
		}
		System.out.println();
		System.out.println("-----Value of receiving vector after finding min------- ");
		for(int i=0;i<size_of_network;i++){
			System.out.print(" "+receiving_vector[i]);
		}
		System.out.println();*/
		
		System.out.println("-------------The values in the routing_table after message passing is------------- ");
		for(int i=0;i<size_of_network;i++){
			for(int j=0;j<size_of_network;j++){
				System.out.print(" "+routing_table[i][j]);
			}
			System.out.println();
		}
		
		
	}
	public static void message_passing(){
		for(int i=0;i<size_of_network*size_of_network;i++){
			//System.out.println("Inside the run loop: "+i);
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println();
				System.out.println("----Input which router_row sends message to the receiving router_row----- ");
				System.out.println("Input sending routing row number from routing table ");
				sending_row1= Integer.parseInt(br.readLine());
				System.out.println("Input receiving routing row number from routing table ");
				receiving_row2= Integer.parseInt(br.readLine());
				updateAlgo(sending_row1,receiving_row2);
				
			}
			catch(Exception E){
				
			}
		}
		
	}
}
		
		



