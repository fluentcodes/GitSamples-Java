package samples.behavioral.chainofresponsibility.purchasepower;

import org.junit.Test;

/**
 * Example from https://en.wikipedia.org/wiki/Chain-of-responsibility_pattern
 * @author Werner Diwischek
 *
 */

public class PurchasePowerExampleTest {

	@Test
	public void checkAuthorities() {
        ManagerPPower manager = new ManagerPPower();
        DirectorPPower director = new DirectorPPower();
        VicePresidentPPower vp = new VicePresidentPPower();
        PresidentPPower president = new PresidentPPower();
        
        manager.setSuccessor(director);
        director.setSuccessor(vp);
        vp.setSuccessor(president);
        
        for (int i = 0; i<32; i++) {
            manager.processRequest(new PurchaseRequest(Double.valueOf(i * 1000), "General"));
        }
	}
}
