package samples.behavioral.chainofresponsibility.validator;

public class AgeRule implements RegistrationRule {
  @Override
  public void validate(RegistrationData regData) throws Exception {
    if (regData.age < 18) {
      throw new Exception("Age is smaller than 18: " + regData.age);
    }

  }
}
