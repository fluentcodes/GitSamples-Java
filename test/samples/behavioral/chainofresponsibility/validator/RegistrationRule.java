package samples.behavioral.chainofresponsibility.validator;

public interface RegistrationRule {
  void validate(RegistrationData regData) throws Exception;
}
