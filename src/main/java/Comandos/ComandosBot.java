package Comandos;
import Bot.Datos;
import Scraping.Anime;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import java.awt.*;
import java.util.ArrayList;

public class ComandosBot extends ListenerAdapter {
    static ArrayList<Anime> animes = new ArrayList<>();

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        Datos datos = new Datos();
        Anime anime;
        animes = datos.obtenerDatos();
        String nombres = "";
        for (int i = 0; i < animes.size(); i++) {
            nombres += animes.get(i).getNombreAnime() + "\n";
        }
        //comando listar animes
        if (event.getName().equals("listaranimes")) { //comando uno
            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle("Listado Animes")
                    .setDescription("" + nombres)
                    .setColor(new Color(218, 200, 69));
            event.replyEmbeds(embed.build()).queue();
        }//fin comando uno


        Anime animeRandom = new Anime();
        animes = datos.obtenerDatos();
        animeRandom = animeRandom.animeAleatorio(animes);

        if (event.getName().equals("animerandom")) {
            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle(animeRandom.getNombreAnime())
                    .setFooter("Ranking: " + animeRandom.getRankedAnime() + "\n" + animeRandom.getLinkAnime() + "\n" + animeRandom.getEpisodiosAnime())
                    .setImage(animeRandom.getUrlImagen())
                    .setColor(new Color(218));
            event.replyEmbeds(embed.build()).queue();
        }
        if (event.getName().equals("anime")) {
            String buscaAnime = event.getOption("nombre").getAsString();
            for (int i = 0; i < animes.size(); i++) {
                if (buscaAnime.equals(animes.get(i).getNombreAnime())) {
                    anime = animes.get(i);
                    EmbedBuilder embed = new EmbedBuilder()
                            .setTitle(anime.getNombreAnime())
                            .setFooter("Ranking: " + anime.getRankedAnime() + "\n" + anime.getLinkAnime() + "\n" + anime.getEpisodiosAnime())
                            .setImage(anime.getUrlImagen())
                            .setColor(new Color(0xFF0000));
                    event.replyEmbeds(embed.build()).queue();
                }
            }
            /*if (event.getOption("nombre").getAsString().equals(anime.getNombreAnime())){
                EmbedBuilder embed=new EmbedBuilder()
                        .setTitle(anime.getNombreAnime())
                        .setFooter("Ranking: "+anime.getRankedAnime()+"\n"+ anime.getLinkAnime()+"\n"+ anime.getEpisodiosAnime())
                        .setImage(anime.getUrlImagen())
                        .setColor(new Color(0xFF0000));
                event.replyEmbeds(embed.build()).queue();
            }*/

        } else {
            event.reply("Error al ejecutar el comando.").queue();

        }
    }





     /*   if (event.getName().equals("hola")){
            event.reply("``` hola ```").queue(); // agregar .queque a todos lo comandos que realizen una accion
        } else if (event.getName().equals("nombre")) {
            OptionMapping option =  event.getOption("nombre");

            if (option == null){
                event.reply("por alguna razon, no se encontro el nombre del anime");
                return;
            }
            String nameAnime = option.getAsString();
            event.reply(" ``` Anime: ``` " + nameAnime).queue();
        } else if (event.getName().equals("anime")) {
            OptionMapping option =  event.getOption("nombre");
            if (option == null){
                event.reply("ERROR");
                return;
            }*/

            //String nameAnime = option.getAsString();
           // String nameAnime = anime.getNombreAnime();

           // event.reply("Nombre Anime: "+nameAnime).queue();



    }


    /*
   @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (!event.getAuthor().equals("$$hola")){
            //String messageSend = event.getMessage().getContentRaw();
            event.getTextChannel().sendMessage("Hola bro").queue();

        }
    }
    */







