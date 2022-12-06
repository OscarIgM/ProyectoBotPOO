package Bot;

import Comandos.ComandosBot;
import Scraping.Anime;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Bot{
public static JDABuilder jda;

    public static void iniciarBot() throws LoginException, InterruptedException {


         jda = JDABuilder.createDefault("");
         jda.setActivity(Activity.listening("Listando animes"))
                .build().awaitReady();

         JDA shardman;
         jda.addEventListeners(new ComandosBot());
          shardman=jda.build();
sleep(5000);
//Primer Comando el cual lista todos los animes
shardman.getGuildById("")
        .upsertCommand("listaranimes","Muestra los 50 animes")
        .queue();
//Segundo comando el cual lanza un anime aleatorio
shardman.getGuildById("1035291918151720990")
        .upsertCommand("animerandom","Mustra un anime aleatorio")
        .queue();
//tercer comando el cual lanza un anime especificado por el usuario de discord
shardman.getGuildById("1035291918151720990")
        .upsertCommand("anime","Muestra la descripcion del anime que indiques")
        .addOption(OptionType.STRING,"nombre","Nombre del anime",true)
        .queue();
        ConexionFirebase conexion = new ConexionFirebase();
        try {
            conexion.conectar();
        } catch(Exception e){
            System.out.println("no se ha podido conectar");
        }
        //Datos datos = new Datos();
       // ArrayList<Anime>animes=new ArrayList<>();
       // animes=datos.obtenerDatos();
        //Anime a1=new Anime();
        //a1.animeAleatorio(animes);
        //animeList.scanearAnimes();
       // datos.obtenerDatos();

    }



}
