package Bot;

import java.io.IOException;
import java.util.Map;

public interface Conexion {
    void conectar() throws IOException;
    boolean insertarDatosAnime(String documento,Map<String, Object> data);
}
