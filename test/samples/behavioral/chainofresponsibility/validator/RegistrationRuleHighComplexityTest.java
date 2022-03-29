package samples.behavioral.chainofresponsibility.validator;

import org.junit.Test;
import samples.behavioral.chainofresponsibility.validator.AgeRule;
import samples.behavioral.chainofresponsibility.validator.AlphabeticNameRule;
import samples.behavioral.chainofresponsibility.validator.EmailEmptinessRule;
import samples.behavioral.chainofresponsibility.validator.EmailValidatationRule;
import samples.behavioral.chainofresponsibility.validator.ForbiddenEmailDomainsRule;
import samples.behavioral.chainofresponsibility.validator.NameEmptinessRule;
import samples.behavioral.chainofresponsibility.validator.RegistrationData;
import samples.behavioral.chainofresponsibility.validator.RegistrationDataChecker;
import samples.behavioral.chainofresponsibility.validator.RegistrationRule;

/**
 * Example from 
 * https://dzone.com/articles/avoiding-many-if-blocks
 * Not so nice since it just throws Exceptions and is not generic. 
 *
 */
public class RegistrationRuleHighComplexityTest {
	@Test
	public void testInput() throws Exception {
		RegistrationData register = new RegistrationData("name", "x.mail@test.de", 18);
		RegistrationRuleHighComplexity.validate(register);
	}

	@Test(expected = Exception.class)
	public void  wrongAge() throws Exception {
		RegistrationData register = new RegistrationData("name", "x.mail@test.de", 1);
		RegistrationRuleHighComplexity.validate(register);
	}


}
