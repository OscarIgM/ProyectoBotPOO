package Scraping;

import Bot.Datos;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public abstract class Scrap {


    public String scrapImagen(String link,String className) throws ScrapException{//ingresa a una pagina de imagenes donde obtiene la imagen del anime
        Document document;
        try {
            document = Jsoup.connect(link).get();
        } catch (IOException ignored) {
            System.out.println("no se pudo encontrar na");
            return link;
        }
        Elements elements = document.getElementsByClass(className);
        for (Element element : elements) {
            Element element1 = element.select("a").first();
            String linkImagen = element1.attr("href");
            String imagen = obtenerImagen(linkImagen);
            return imagen;
        }
        throw new ScrapException("No hay imagen");
    }

    public String obtenerImagen(String link) {//obtieen imagen del link imagen
        Document document;
        try {
            document = Jsoup.connect(link).get();

        } catch (IOException ignored) {
            System.out.println("No hay imagenes");
            return link;
        }
        Elements elements = document.getElementsByClass("leftside");
        for (Element element : elements) {
            Element element1 = element.select("img").first();
            String linkImagen = element1.attr("data-src");
            return linkImagen;
        }
        return "";
    }
    public String scrapNombre(String link,String className) throws ScrapException{
        Document document;

        try {
            document = Jsoup.connect(link).get();
        } catch (IOException ignored) {
            System.out.println("NO hay titulo");
            return link;
        }

        Elements elements = document.getElementsByClass(className);
        for (Element element : elements) {
            String titulo = element.text();
            return titulo;
        }

        throw new ScrapException("No hay nombre");
    }

    public String scrapEpisodios(String link) throws ScrapException {
        Document document;
        try {
            document = Jsoup.connect(link).get();
        } catch (IOException ignored) {
            System.out.println("no hay conexion");
            return link;
        }
        Elements elements = document.getElementsContainingOwnText("Episodes:" + " ");
        for (Element element : elements) {
            String episodios = element.text();
            episodios = episodios.replaceFirst("/", "");
            return episodios;
        }
throw new ScrapException("no hay episodios");
    }
    public String scrapRanked(String link){
        Document document;
        try {
            document=Jsoup.connect(link).get();
        }catch (IOException ignored){
            System.out.println("No hay conexion");
            return link;
        }
        Elements elements=document.getElementsByClass(document.className());
        for (Element element:elements) {
            String rankedAnime=element.select("strong").text();
            rankedAnime=rankedAnime.replace("#","").trim();
            return rankedAnime;
        }
        return "";
    }

    public String scrapPuntuacion(String link,String className) {
        Document document;
        try {
            document = Jsoup.connect(link).get();
        } catch (IOException ignored) {
            System.out.println("No se pudo encontrar la puntuacion");
            return link;
        }
        Elements elements = document.getElementsByClass(className);
        for (Element element : elements) {
            String puntuacion = element.text();
            return puntuacion;
        }
        return link;
    }




}
