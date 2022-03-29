package samples.behavioral.chainofresponsibility.validator;

import java.util.List;

public class RegistrationDataChecker {
  private final List<RegistrationRule> ruleList;

  public RegistrationDataChecker(List<RegistrationRule> ruleList) {
    this.ruleList = ruleList;
  }

  public void validate(RegistrationData regData) throws Exception {
    for (RegistrationRule rule : ruleList) {
      rule.validate(regData);
    }
  }
}
