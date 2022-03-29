package samples.behavioral.chainofresponsibility.validator;

public class EmailEmptinessRule implements RegistrationRule {
  @Override
  public void validate(RegistrationData regData) throws Exception {
    if (regData.email == null || regData.email.isEmpty()) {
      throw new Exception("Email is empty");
    }

  }
}
