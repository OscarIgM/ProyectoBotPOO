package Scraping;

import Bot.Datos;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyAnimeList extends Scrap{
    private Map<String, String> items;

    public MyAnimeList() {
        items = new HashMap<>();
        scanearAnimes();
    }

    protected static final String WEBSITE = "https://myanimelist.net/topanime.php";//ingresar a la url

    Datos datos = new Datos();

    public void scanearAnimes() {
        Document document;
        try {
            document = Jsoup.connect(MyAnimeList.WEBSITE + "/MyAnimeListTop50").get();
        } catch (IOException ignored) {
            System.out.println("No se pudieron scanear los animes");
            return;
        }
        Elements elements = document.getElementsByClass("hoverinfo_trigger fl-l ml12 mr8");
        for (Element element : elements) {
            String link = element.attributes().get("href");
            //metodo para subir datos a firebase
            try {
                datos.subirDatosAnime(link
                        ,scrapNombre(link,"title-name h1_bold_none")
                        ,scrapEpisodios(link)
                        ,scrapPuntuacion(link,"fl-l score")
                        ,scrapImagen(link,"leftside")
                        ,scrapRanked(link));
            } catch (ScrapException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
