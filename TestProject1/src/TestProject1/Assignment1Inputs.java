// Assignment1Inputs -- This program allows the user to enter 4 integers and then prints out calculations with those integers 
// CSIS 212-001
//Luke Benhase 9/2/2024

package TestProject1;
// import statements
// import for reading in from command line
import java.util.Scanner;


public class Assignment1Inputs {

	public static void main(String[] args) {
		
		// creates a scanner that can read inputs from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("Luke Benhase - Assignment #1!");
		
		//prompt the user for 4 integers and then print them to the screen
		System.out.print("Enter the first integer: ");
		int i1 = input.nextInt(); // get first integer from user
		
		System.out.print("Enter the second integer: ");
		int i2 = input.nextInt(); // get second integer from user
		
		System.out.print("Enter the third integer: ");
		int i3 = input.nextInt(); // get third integer from user
		
		System.out.print("Enter the fourth integer: ");
		int i4 = input.nextInt(); // get fourth integer from user
		
		// prints the numbers inputed to the screen
		System.out.println("Your integers are: " + i1 + " " + i2 + " " + i3 + " " + i4);
		
		// print up the solution to some math problems using these integers
		int sum = i1 + i2 + i3 + i4; // calculate the sum
		System.out.println(i1+" + "+i2+" + "+i3+" + "+i4+" = " + sum);
		
		sum = i1 * i2 - i3 * i4; // calculate the sum
		System.out.println(i1+" * "+i2+" - "+i3+" * "+i4+" = " + sum);
		
		sum = i1 * (i2 + i3) * i4; // calculate the sum
		System.out.println(i1+" * ("+i2+" + "+i3+") * "+i4+" = " + sum);
		
		sum = (i1 + i2 + i3 + i4) % i1; // calculate the sum
		System.out.println("("+i1+" + "+i2+" + "+i3+" + "+i4+") % "+i1+" = " + sum);
		
		// print out the lesser of i1 and i2
		if (i1 > i2) {
		System.out.printf("%d is smaller than %d%n", i2, i1 );
		}
		if (i1 < i2) {
			System.out.printf("%d is smaller than %d%n", i1, i2);
		}
		if (i1 == i2) {
			System.out.printf("%d is the same size as %d%n", i1, i2 );
		}
			
		// print out the greater of i1+i2 and i3*i4
		if ((i1+i2) > (i3*i4)) {
			System.out.printf("%d + %d is greater than %d * %d%n", i1,i2, i3, i4);
		}
		if ((i1+i2) < (i3*i4)) {
				System.out.printf("%d * %d is greater than %d + %d%n", i3,i4, i1,i2);
		}
		if ((i1+i2) == (i3*i4)) {
			System.out.printf("%d + %d is the same size as %d * %d%n", i1,i2, i3,i4);
		}
			
		// determine if i1 is a multiple of i2, i3, or i4
		// determine if i1 is a multiple of i2
		if ((i2 % i1) == 0) {
			System.out.printf("%d is a multiple of %d%n",i1, i2);
		}
		else {
			System.out.printf("%d is NOT a multiple of %d%n",i1, i2);
		}
		
		// determine if i1 is a multiple of i3 
		if ((i3 % i1) == 0) {
			System.out.printf("%d is a multiple of %d%n",i1, i3);
		}
		else {
			System.out.printf("%d is NOT a multiple of %d%n",i1, i3);
		}
		
		// determine if i1 is a multiple of i4
		if ((i4 % i1) == 0) {
			System.out.printf("%d is a multiple of %d%n",i1, i4);
		}
		else {
			System.out.printf("%d is NOT a multiple of %d%n",i1, i4);
		}
		
		// closes the scanner 
		input.close();
		
	
	} // end method main

} // end class Assignment1Inputs
