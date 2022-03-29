package samples.behavioral.chainofresponsibility.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RegistrationRuleHighComplexity {
  public static void validate(RegistrationData data) {
    validate(data.email, data.name, data.age);
  }
  public static void validate(String email, String name, int age) {
    String EMAIL_PATTERN =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    List<String> forbiddenDomains = Arrays.asList("domain1", "domain2");
    if (email == null || email.trim().equals("")) {
      throw new IllegalArgumentException("Email should not be empty!");
    }

    if (!pattern.matcher(email).matches()) {
      throw new IllegalArgumentException("Email is not a valid email!");
    }

    if (forbiddenDomains.contains(email)) {
      throw new IllegalArgumentException("Email belongs to a forbidden email");
    }

    if (name == null || name.trim().equals("")) {
      throw new IllegalArgumentException("Name should not be empty!");
    }
    if ( !name.matches("[a-zA-Z]+")){
      throw new IllegalArgumentException("Name should contain only characters");
    }
    if ( age <= 18){
      throw new IllegalArgumentException("Age should be greater than 18");
    }
// More code to do the actual registration
  }
}
