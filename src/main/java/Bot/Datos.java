package Bot;

import Scraping.Anime;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static Bot.ConexionFirebase.bd;

public class Datos implements DatosFirebase {

    public Datos() {
        try {
            ConexionFirebase conexionFirebase = new ConexionFirebase();
            conexionFirebase.conectar();
        } catch (Exception e) {
            System.out.println("Error al conectarse");
        }
    }

    @Override
    public void subirDatosAnime(String link, String nombreAnime, String episodiosAnime, String ranking, String URLimagen, String rankedAnime) {
        Map<String, Object> data = new HashMap<>();
        data.put("linkAnime", link);
        data.put("nombreAnime", nombreAnime);
        data.put("episodiosAnime", episodiosAnime);
        data.put("rankingAnime", ranking);
        data.put("urlImagen", URLimagen);
        data.put("rankedAnime", rankedAnime);
        ConexionFirebase conexionFirebase = new ConexionFirebase();
        conexionFirebase.insertarDatosAnime("" + nombreAnime, data);
    }

    @Override
    public ArrayList<Anime> obtenerDatos() {
        ApiFuture<QuerySnapshot> future = bd.collection("Datos Anime").get();
        ArrayList<Anime> animes = new ArrayList<>();
        List<QueryDocumentSnapshot> documents = null;
        try {
            documents = future.get().getDocuments();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        for (QueryDocumentSnapshot document : documents) {
            Anime anime = new Anime(document.getString("nombreAnime"), document.getString("linkAnime"), document.getString("rankingAnime"), document.getString("urlImagen"),
                    document.getString("episodiosAnime"), document.getString("rankedAnime"));
            animes.add(anime);
        }
        return animes;

    }


}
