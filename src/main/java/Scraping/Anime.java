package Scraping;

import java.util.ArrayList;

public class Anime implements AnimeInter {
    private String nombreAnime;
    private String linkAnime;
    private String rankingAnime;
    private String urlImagen;
    private String episodiosAnime;
    private String rankedAnime;

    public Anime(String nombreAnime, String linkAnime, String rankingAnime, String urlImagen, String episodiosAnime, String rankedAnime) {
        this.nombreAnime = nombreAnime;
        this.linkAnime = linkAnime;
        this.rankingAnime = rankingAnime;
        this.urlImagen = urlImagen;
        this.episodiosAnime = episodiosAnime;
        this.rankedAnime = rankedAnime;
    }

    public Anime() {
    }

    public String getLinkAnime() {
        return linkAnime;
    }
    public void setRankedAnime(String rankedAnime) {
        this.rankedAnime = rankedAnime;
    }
    public String getRankedAnime() {
        return rankedAnime;
    }

    public void setNombreAnime(String nombreAnime) {
        this.nombreAnime = nombreAnime;
    }

    public void setLinkAnime(String linkAnime) {
        this.linkAnime = linkAnime;
    }

    public void setRankingAnime(String rankingAnime) {
        this.rankingAnime = rankingAnime;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public void setEpisodiosAnime(String episodiosAnime) {
        this.episodiosAnime = episodiosAnime;
    }

    public String getRankingAnime() {
        return rankingAnime;
    }

    public String getUrlImagen() {return urlImagen;}

    public String getEpisodiosAnime() {
        return episodiosAnime;
    }

    public String getNombreAnime() {
        return nombreAnime;
    }


@Override
    public Anime animeAleatorio(ArrayList<Anime> animes){


        int numero= (int)(Math.random()*50+1);
        Anime anime;
        anime = animes.get(numero);
    return anime;
}
    @Override
    public void mostrarAnimes(ArrayList<Anime>listadoAnimes) {
       listadoAnimes.stream().forEach(n-> System.out.println(n.getNombreAnime()));
    }
    @Override
    public String toString() {
        return "Anime{" +
                "nombreAnime='" + nombreAnime + '\'' +
                ", linkAnime='" + linkAnime + '\'' +
                ", rankingAnime='" + rankingAnime + '\'' +
                ", urlImagen='" + urlImagen + '\'' +
                ", episodiosAnime='" + episodiosAnime + '\'' +
                ", rankedAnime='" + rankedAnime + '\'' +
                '}';
    }

}
