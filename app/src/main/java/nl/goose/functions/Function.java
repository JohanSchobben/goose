package nl.goose.functions;

public interface Function<T> {
    void setArguments(String[] items);
    T execute();
}
