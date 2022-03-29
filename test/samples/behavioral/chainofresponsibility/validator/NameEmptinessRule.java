package samples.behavioral.chainofresponsibility.validator;

public class NameEmptinessRule implements RegistrationRule {
  @Override
  public void validate(RegistrationData regData) throws Exception {
    if (regData.name == null || regData.name.isEmpty()) {
      throw new Exception("Name is empty");
    }

  }
}
