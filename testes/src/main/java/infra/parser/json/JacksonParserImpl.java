package infra.parser.json;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import infra.parser.Serializador;

public final class JacksonParserImpl implements Serializador {
    private static ObjectMapper objectMapper;


    static {
        objectMapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
                .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true).registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());

    }

    @Override
    public String toString(Object objeto) {

        try {
            return objectMapper.writeValueAsString(objeto);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public <T> T fromString(String jsonAsString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonAsString, clazz);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
