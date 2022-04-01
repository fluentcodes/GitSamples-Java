package samples.stuctural.bridge.shape;

import org.junit.Test;

public class BridgeShapeTest {
	@Test
	    public  void  call(){
	        Shape[] shapes = new Shape[] {
	            new CircleShape(1, 2, 3, new DrawingAPI1()),
	            new CircleShape(5, 7, 11, new DrawingAPI2())
	        };

	        for (Shape shape : shapes) {
	            shape.resizeByPercentage(2.5);
	            shape.draw();
	        }
	}
}
