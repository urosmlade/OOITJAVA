package geometry;

public class Test {

	public static void main(String[] args) {

		Point p = new Point();
		p.setX(10);
		p.setY(20);
		//p.setSelected(true);
		double result = p.distance(44, 103);
		
		System.out.println("X coordinate of point p is: " + p.getX() + 
				" ,Y coordinate of point p is: " + p.getY() + 
				" , point p is selected: " + p.isSelected());
		
		// System.out.println("Distance between these points is " + result);
		System.out.println("Distance is " + p.distance(103, 67));
		
		Point p1 = new Point();
		p1.setX(10);
		p1.setY(30);
		System.out.println("X coordiante of point p1 is " + p1.getX() + '\n' +
				"Y coordinate of point p1 is " + p1.getY());
		
		// 1. Inicijalizovati x koordinatu tacke p
		// na vrednost y koordinate tacke p1	
		
		// 2. Postaviti za pocetnu tacku linije l1 tacku p, a 
		// za krajnju tacku linije l1 tacku p1	
		
		// 3. Postaviti y koordinatu krajnje tacke l1 na 23
		
		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1
		// na vrednost y koordinate krajnje tacke linije l1
		
		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y 
		// koordinate pocetne tacke linije
		
		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15
		
		Rectangle r1 = new Rectangle();
		r1.setUpperLeftPoint(p); 
		
		// 7. Postaviti centar kruga c1 na koordinate tacke 
		// gore levo od r1
		
		// 8. Postaviti x koordinatu centra kruga na vrednost razlike
		//povrsine pravougaonika i y koordinate pocetne tacke linije l1
	}

}
