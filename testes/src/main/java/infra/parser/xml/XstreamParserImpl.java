package infra.parser.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import infra.parser.Serializador;

public class XstreamParserImpl implements Serializador {
    private static XStream xstream;

    static {
        xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
    }

    @Override
    public String toString(Object objeto) {
        return xstream.toXML(objeto);
    }

    @Override
    public <T> T fromString(String jsonAsString, Class<T> clazz) {
        return (T) xstream.fromXML(jsonAsString);
    }
}
