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
		
		p.setX(p1.getY());
		System.out.println("X of point p is " + p.getX());
		
		// 2. Postaviti za pocetnu tacku linije l1 tacku p, a 
		// za krajnju tacku linije l1 tacku p1	
		
		Line l1 = new Line();
		l1.setStartPoint(p);
		l1.setEndPoint(p1);
		
		// 3. Postaviti y koordinatu krajnje tacke l1 na 23
		
		l1.getEndPoint().setY(23);
		System.out.println("Y of end point of line l1 is " + l1.getEndPoint().getY());
		
		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1
		// na vrednost y koordinate krajnje tacke linije l1
		
		l1.getStartPoint().setX(l1.getEndPoint().getX());
		System.out.println("x of start point of l1 is " + l1.getStartPoint().getX());
		
		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y 
		// koordinate pocetne tacke linije
		
		l1.getEndPoint().setX((int) (l1.length() - (l1.getStartPoint().getX() + l1.getStartPoint().getY())));
		System.out.println("x of end point of l1 is " + l1.getEndPoint().getX());
		
		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15
		
		Rectangle r1 = new Rectangle();
		r1.setUpperLeftPoint(p);
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		System.out.println("X of upper left point of r1 is " + r1.getUpperLeftPoint().getX() + '\n' + 
				"Y of upper left point of r1 is " + r1.getUpperLeftPoint().getY());
		
		// 7. Postaviti centar kruga c1 na koordinate tacke 
		// gore levo od r1
		
		Circle c1 = new Circle();
		c1.setCenter(r1.getUpperLeftPoint());
		
		// 8. Postaviti x koordinatu centra kruga na vrednost razlike
		//povrsine pravougaonika i y koordinate pocetne tacke linije l1
	
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
		System.out.println("x of circle c1 is " + c1.getCenter().getX());
		
		Point p2 = new Point(20, 30);
		
		System.out.println(p2.toString());
		
		System.out.println(p2.equals(p));
		
		System.out.println(p2 == p);
		
		p2 = p;
		
		System.out.println(p2 == p);
		System.out.println(p2.equals(p));
		
		System.out.println(p instanceof Point);
		System.out.println(p instanceof Object);
		
		Line l2 = new Line(p, new Point(40, 30));
		System.out.println(l2.toString());
		
		System.out.println(l2.equals(l1));
		
		System.out.println(r1.equals(p2));
		
		// instancirati objekat klase pravougaonik i inicijalizovati varijable instance
		// pozivom odgovarajuceg konstruktora:
		// x = x koordinata r1 umanjena za vrednost y koordinate krajnje tacke linije l1
		// y = y koordinata pocetne tacke linije l1
		// visina = 25
		// sirina = 25 + X vrednost od p2
		// ispisati povrsinu od r2

		Rectangle r2 = new Rectangle(new Point((r1.getUpperLeftPoint().getX() - l1.getEndPoint().getY()), l1.getStartPoint().getY()), 25, (25 + p2.getX()));
		System.out.println(r2.area());
		System.out.println(r2.toString());
		
		// ispisati 10 puta povrsinu kruga c2 ukoliko je veca od povrsine pravougaoinika
		// r2, a
		// u suprotnom ispisati 5 puta povrsinu pravougaonika r2
		
		Circle c2 = new Circle(new Point(10, 40), 20);
		System.out.println(c2.toString());
		
		if (c2.area() > r2.area()) {
			for (int i = 0; i < 10; i++) {
				System.out.println(c2.area());
			}
		} else {
			for (int i = 0; i < 5; i++) {
				System.out.println(r2.area());
			}
		}
		
	}

}
