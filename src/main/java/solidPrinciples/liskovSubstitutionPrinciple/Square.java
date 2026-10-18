package solidPrinciples.liskovSubstitutionPrinciple;

public class Square extends Rectangle {
	    @Override
	    public void setWidth(int w) {
	        width = w;
	        height = w; // forcing square property
	    }

	    @Override
	    public void setHeight(int h) {
	        width = h;
	        height = h; // forcing square property
	    }
}

/*
Rectangle r = new Square();
r.setWidth(5);
r.setHeight(10);

System.out.println(r.getArea()); // Expected: 50	
Loss of Liskov Substitution Principle because Square cannot be substituted for Rectangle without breaking the expected behavior of the area calculation.
 */