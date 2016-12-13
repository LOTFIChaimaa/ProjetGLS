package prototype;

import game.Jeu;
import java.util.Scanner;

/**
 * Created by tfaget on 12/12/16.
 */
public class MainLoop {


    private static void startGame(Jeu jeu) {

        Display display = new Display(jeu.getJoueur());
        CommandInterpreter ci = new CommandInterpreter(display,jeu.getJoueur());
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue dans " + jeu.getName() + " ! Taper \"help\" pour la liste des commandes");

        while(true) {
            GameCommand cmd = new GameCommand( sc.nextLine() );
            ci.interpret(cmd);
        }
    }

    public static void main(String [] args) {
        Jeu jeu = Exemple1.initExample();
        startGame(jeu);
    }


}
