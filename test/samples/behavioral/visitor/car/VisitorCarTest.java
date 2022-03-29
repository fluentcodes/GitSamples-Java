package samples.behavioral.visitor.car;

import org.junit.Test;

/**
 * Example from https://en.wikipedia.org/wiki/Visitor_pattern
 * https://en.wikibooks.org/wiki/Computer_Science_Design_Patterns/Visitor
 * @author Werner Diwischek
 *
 */
public class VisitorCarTest {
	
	@Test
	public void inspect() {
	        final Car car = new Car();
	        car.accept(new CarElementPrintVisitor());
	        car.accept(new CarElementDoVisitor());
	}

}
