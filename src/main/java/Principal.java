import Bot.Bot;
import javax.security.auth.login.LoginException;

public class Principal {
    public static void main(String[] args) throws LoginException, InterruptedException {
        Bot bot = new Bot();
        bot.iniciarBot();
    }
}
