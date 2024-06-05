package nl.goose.functions;

public class StringConcat implements Function<String> {
    private String[] arguments;

    @Override
    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public String execute() {
        return StringUtils.concat(arguments);
    }
}
