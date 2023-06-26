package infra.parser;

import domain.model.ClientePF;
import infra.parser.json.GsonParserImpl;
import infra.parser.json.JacksonParserImpl;
import infra.parser.xml.XstreamParserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SerializadorTest {

    public static final String CPF = "334.697.880-06";
    public static final String NOME = "rafa";
    private ClientePF cliente;

    @BeforeEach
    public void setUp() {
        cliente = new ClientePF(NOME, CPF);
    }

    @ParameterizedTest
    @ValueSource(classes = {GsonParserImpl.class, JacksonParserImpl.class, XstreamParserImpl.class})
    public void deve_serializar_e_deserializar_objeto(
            Class<Serializador> parserClazz) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Serializador serializador = parserClazz.getConstructor().newInstance();

        String clienteAsString = serializador.toString(cliente);
        assertNotNull(clienteAsString);
        assertTrue(clienteAsString.contains(NOME));
        assertTrue(clienteAsString.contains("nome"));

        ClientePF novoCliente = serializador.fromString(clienteAsString, ClientePF.class);
        assertNotNull(novoCliente);
        assertEquals(NOME, novoCliente.getNome());
        assertEquals(CPF, novoCliente.getCpf());
    }
}