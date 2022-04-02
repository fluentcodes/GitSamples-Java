package samples.behavioral.interpreter.sql;

import java.util.List;

interface Expression {
    List<String> interpret(Context ctx);
}