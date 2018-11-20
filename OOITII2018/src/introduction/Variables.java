package introduction;

public class Variables {

	public static void main(String[] args) {

		double firstNumber;
		firstNumber = 1;
		double secondNumber = 5;
		double result = firstNumber/secondNumber;
		// int result = (int)(firstNumber/secondNumber);
		System.out.println("Result is: " + result);
		
		boolean alwaysTrue = true;
		boolean secondBoolean = false;
		System.out.println(alwaysTrue && secondBoolean);
		System.out.println(alwaysTrue || secondBoolean);
		System.out.println(true || secondBoolean);
		
		// char space = ' ';
		String name = "Petar";
		String lastName = "Petrović";
		System.out.println(name + " " + lastName + " Njegoš");
		
		// IF - ELSE
		if(firstNumber>0)
			System.out.println("Number is positive");
		else if(firstNumber<0)
			System.out.println("Number is negative");
		else
			System.out.println("Number is equal to zero");
		
		// WHILE
		System.out.println("Pomocu while ispisati brojeve od 1 do 10");
		int i = 1;
		while(i<=10) {
			System.out.println(i);
			i++;
		}
		
		System.out.println("Pomocu while ispisati brojeve od 8 do 3");
		i = 8;
		while(i>2) {
			System.out.println(i);
			i--;
		}
		
		System.out.println("Pomocu while 5!");
		int factorial = 1;
		i = 5;
		while(i>0) {
			factorial = factorial * i;
			// factorial *= i;
			i--;
		}
		System.out.println("5! = " + factorial);
		
		// DO - WHILE
		
		System.out.println("Pomocu do - while 5!");
		
		factorial = 1;
		i = 5;
		do {
			factorial = factorial * i;
			i--;
		} while (i>0);
		System.out.println("Do while 5! = " + factorial);
		
		// FOR
		
		System.out.println("Pomocu for brojeve od 8 do 3");
		for (int j = 8; j > 2; j--) {
			System.out.println(j);
		}
		
		System.out.println("Pomocu for neparne brojeve od 1 do 10");
		for (i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				// break;
				continue;
			}
			System.out.println("Number " + i + " is odd.");
		}
		
		System.out.println(cube(5));
	}
	
	public static int cube(int x) {
		return x*x*x;
	}
 
}
