package DataStructures;
import java.util.Scanner;

public class towerOfHanoiRecursion{
	
	//recursive function
		public static void hanoitower(int num,char s,char a,char d) {
		
			//Base case
			if(num == 1) {
				System.out.println("Move disk 1 from rod " +s+ " to rod " +d);
				return;
			}
			
			//Move n-1 disks from source to auxiliary
			hanoitower(num-1, s,d,a);
			System.out.println("Move disk " +num+ " from rod " +s+ " to rod " +d);
			
			//Move n-1 disks from auxiliary to destination
			hanoitower(num-1,a,s,d);
		}

		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			String res;
			
			do {
			System.out.println("Enter number of disks: ");
			int n = in.nextInt();
			hanoitower(n,'A','B','C');
			System.out.println("\nTry with a different number: Yes/No");
			res = in.next();
			System.out.println();
			}while(res.charAt(0) == 'Y' || res.charAt(0) == 'y');

		}

	}
