package nl.goose.functions;

public class StringUtils {

    public static String concat(String ...args) {
        var str = "";
        for (var s : args) {
            str += s;
        }
        return str;
    }
}