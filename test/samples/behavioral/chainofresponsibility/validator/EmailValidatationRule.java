package samples.behavioral.chainofresponsibility.validator;

import java.util.regex.Pattern;

public class EmailValidatationRule implements RegistrationRule {
  //private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
  private static final String EMAIL_PATTERN = "^.+@+.+\\..+$";
  private final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

  @Override
  public void validate(RegistrationData regData) throws Exception {
    if (!(regData.email.matches(EMAIL_PATTERN))) {
      throw new IllegalArgumentException("Email is not a valid email! " + regData.email);
    }
     /*if ( !pattern.matcher(regData.email).matches()) {
       throw new IllegalArgumentException("Email is not a valid email! " + regData.email);
     }*/
  }
}
