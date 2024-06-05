package nl.goose.parsers;

import java.util.HashMap;
import java.util.Map;

import nl.goose.functions.Function;
import nl.goose.functions.StringConcat;

public class FunctionParser {
    private Map<String, Function<?>> functionMap = new HashMap<>();

    public FunctionParser() {
        functionMap.put("text.concat", new StringConcat());
    }

    public Function<?> parse(String formula) {
        for (var functionString : functionMap.keySet()) {
            var index = formula.indexOf(functionString);
            var nextAfterMethod = formula.charAt(index + functionString.length() + 1);
            if (index >= 0 && nextAfterMethod == '(') {
               var argumentsString = formula.substring(nextAfterMethod + 1, formula.indexOf(')'));
               String[] arguments = argumentsString.split(",");
               var method = functionMap.get(functionString);
               method.setArguments(arguments);
               return method;
            }
        }
        return null;
    }
}
