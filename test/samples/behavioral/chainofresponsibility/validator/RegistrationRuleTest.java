package fluentcodes.sandboxjava.designpattern.misc.validator;

import java.util.Arrays;
import java.util.List;

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
public class RegistrationRuleTest {
	private static final List<RegistrationRule> RULE_LIST = Arrays.asList(
			new EmailEmptinessRule(),
			new EmailValidatationRule(),
			new ForbiddenEmailDomainsRule(),
			new NameEmptinessRule(),
			new AlphabeticNameRule(),
			new AgeRule());

	private static final RegistrationDataChecker CHECKER = new RegistrationDataChecker(RULE_LIST);
	
	@Test
	public void testInput() throws Exception {
		RegistrationData register = new RegistrationData("name", "x.mail@test.de", 18);
		CHECKER.validate(register);
	}

	@Test(expected = Exception.class)
	public void  wrongAge() throws Exception {
		RegistrationData register = new RegistrationData("name", "x.mail@test.de", 1);
		CHECKER.validate(register);
	}


}
