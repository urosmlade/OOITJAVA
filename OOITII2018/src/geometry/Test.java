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
				" , point p is selected: " + p.getSelected());
		
		// System.out.println("Distance between these points is " + result);
		System.out.println("Distance is " + p.distance(103, 67));
	}

}
