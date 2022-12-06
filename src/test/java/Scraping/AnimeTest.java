package Scraping;

import Bot.ConexionFirebase;
import Bot.Datos;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnimeTest {

    static Anime anime0Test=new Anime();
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

    @DisplayName("Test para evaluar la no nulidad de la lista animeAleatorio")
    @Test
    void animeAleatorioNotNullTest() {
        assertNotNull(animeListTest.get(animeListTest.size()-1));
    }

    @DisplayName("Test para evaluar no nulidad de toString")
    @Test
    void toStringTest(){
        assertNotNull(anime0Test.toString());
        System.out.println("El to string no es nulo!");
    }

    @DisplayName("Test para evaluar si la lista corresponde")
    @Test
    void animeAleatorioNameTest(){
        String animeTest=anime0Test.animeAleatorio(animeListTest).getNombreAnime();
        System.out.println("anime aleatorio es= "+animeTest);
        for (int i = 0; i < animeListTest.size(); i++) {
            if (animeTest.equals(animeListTest.get(i).getNombreAnime())){
                assertEquals(animeTest,animeListTest.get(i).getNombreAnime());
                System.out.println("Resultado de la prueba los animes son compatible= "+animeListTest.get(i).getNombreAnime());
            }
        }
    }



}