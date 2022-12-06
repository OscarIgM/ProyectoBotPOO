package Bot;

import Scraping.Anime;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static Bot.ConexionFirebase.bd;
import static org.junit.jupiter.api.Assertions.*;

class DatosTest {

    static Datos datosTest=new Datos();

    static ArrayList<Anime> animeListTest=new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        ConexionFirebase conexion = new ConexionFirebase();
        try {
            conexion.conectar();
        } catch(Exception e){
            System.out.println("no se ha podido conectar");
            System.out.println(e.getMessage());
        }
        animeListTest = datosTest.obtenerDatos();

    }

@DisplayName("Test para evaluar que los datos obtenidos son correctos")
    @Test
    void obtenerDatos() {
        ArrayList<Anime>listaProbar=new ArrayList<>();
        listaProbar=datosTest.obtenerDatos();
        for (int i = 0; i < listaProbar.size(); i++) {
            assertEquals(animeListTest.get(i).getNombreAnime(), listaProbar.get(i).getNombreAnime());
            System.out.println("el indicie de la lista test = "+animeListTest.get(i).getNombreAnime()+" Es igual a = "+listaProbar.get(i));
        }
    }
@DisplayName("Test para evaluar si lo que se subio fue un anime")
    @Test
    void subirDatosAnime() {
ArrayList<Anime>animeTestSubidos=new ArrayList<>();
        animeTestSubidos=datosTest.obtenerDatos();
        assertEquals(animeTestSubidos.getClass(),animeListTest.getClass());
    System.out.println("Si se subio un anime");


    }
}