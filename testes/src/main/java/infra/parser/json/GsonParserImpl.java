package infra.parser.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import infra.parser.Serializador;

public final class GsonParserImpl implements Serializador {

    private static Gson gson;

    static {
        gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().setDateFormat("dd/MM/yyyy HH:mm:ss")
                .create();
    }

    @Override
    public String toString(Object objeto) {

        return gson.toJson(objeto);
    }

    @Override
    public <T> T fromString(String jsonAsString, Class<T> clazz) {
        return gson.fromJson(jsonAsString, clazz);
    }


}
