import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tic_Tac_tok {
	
	static ArrayList<Integer>playerPosition= new ArrayList<Integer>();
	static ArrayList<Integer>cpuPosition= new ArrayList<Integer>();
	public static void main(String[] args) {
		
		char [][] board= {  
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}};
		printBoard(board);
		
		
		while(true) {
			
			Scanner sc= new Scanner(System.in);   // this are getting replaceing 
			System.out.println("entre placemt");
			int plc =sc.nextInt();
			// to avoid sam eplac
			while(playerPosition.contains(plc) ||cpuPosition.contains(plc)) {
				System.out.println("enre correct postion");
				plc=sc.nextInt();
			}
			
			
			System.out.println(plc);
			place(board, plc, "player");
			Random rand=new Random();
			int cpupos =rand.nextInt(9)+1;
			//to avoid repet the same place
			
			while(playerPosition.contains(cpupos) ||cpuPosition.contains(cpupos)) {
				//System.out.println("enre correct postion");
				cpupos=sc.nextInt();}
			
		place(board, cpupos, "cpu"); // randmisation
			printBoard(board);
			 String result=checkwinner() ;
			 System.out.println(result);
		}
	
	}

	private static void printBoard(char[][] board) {
		// TODO Auto-generated method stub
		for(char[]row:board) {for(char c:row) {
			System.out.print(c);
		}System.out.println();
		
	}}
	
	public static void place(char[][]board, int plc ,String user) {
		char sysmbol=' ';
		if(user.equals("player")) {
		sysmbol='X';
		playerPosition.add(plc);
		}
		else if (user.equals("cpu")) {
			sysmbol='O';
			cpuPosition.add(plc);
		}
		
		
		switch (plc) {
		case 1: board [0][0]=sysmbol;
			
			break;
		case 2: board [0][2]=sysmbol;
		
		break;
		case 3: board [0][4]=sysmbol;
		
		break;
		case 4: board [2][0]=sysmbol;
		
		break;
		case 5: board [2][2]=sysmbol;
		
		break;
		case 6: board [2][4]=sysmbol;
		
		break;
		case 7: board [4][0]=sysmbol;
		
		break;
		case 8: board [4][2]=sysmbol;
		
		break;
		case 9: board [4][4]=sysmbol;
		
		break;

		default:
			break;
		}	
	}

	//tracking the input so avoid replacing 
	public static String checkwinner() {
		
		
		List toprow =Arrays.asList(1,2,3);
		List midrow =Arrays.asList(4,5,6);
		List botrow =Arrays.asList(7,8,9);
		List leftcol =Arrays.asList(1,4,7);
		List midcol=Arrays.asList(2,5,8);
		List rightcol =Arrays.asList(3,6,9);
		List cross1 =Arrays.asList(1,5,9);
		List cross2 =Arrays.asList(7,5,3);
		
		
		List<List> winning = new ArrayList<List>();
		winning.add(toprow);
		winning.add(midrow);
		winning.add(botrow);
		winning.add(leftcol);
		winning.add(midcol);
		winning.add(rightcol);
		winning.add(cross1);
		winning.add(cross2);
		for(List l: winning) {
			if(playerPosition.contains(l)) {
				return "congrats you won";			}
		
		else if (cpuPosition.contains(l)) {
			return "cpu wins sorry";
		}	
		else if(playerPosition.size()+ cpuPosition.size()==9) {
			return "CAT ";
		}
		}
		
		return " ";
		
	}
	
	
}
