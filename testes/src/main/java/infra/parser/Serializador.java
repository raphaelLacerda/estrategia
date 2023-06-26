package infra.parser;

public interface Serializador {
    String toString(Object objeto);

    <T> T fromString(String jsonAsString, Class<T> clazz);
}
