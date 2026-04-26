package solidPrinciples.liskovSubstitutionPrinciple;

public class SquareLiskov implements Shape {
	private int side;

	public void setSide(int s) {
		side = s;
	}

	@Override
	public int getArea() {
		return side * side;
	}
	
	public static void main(String[] args) {
		Shape s = new SquareLiskov();
		((SquareLiskov) s).setSide(5);
		
		System.out.println(s.getArea()); // Expected: 25
	}

}
