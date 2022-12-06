package Bot;

import Scraping.Anime;

import java.util.ArrayList;

public interface DatosFirebase {

    void subirDatosAnime(String link, String nombreAnime, String episodiosAnime, String ranking, String URLimagen,String rankedAnime);
    ArrayList<Anime> obtenerDatos();



}
