package prototype;

import game.Jeu;
import java.util.Scanner;

/**
 * Created by tfaget on 12/12/16.
 */
public class Main {


    private static void startGame(Jeu jeu) {

        Display display = new Display(jeu.getJoueur()); // Display for the game
        CommandInterpreter ci = new CommandInterpreter(display,jeu.getJoueur()); // The Command Interpreter for input commande
        Scanner sc = new Scanner(System.in); // Input scanner

        System.out.println("Bienvenue dans " + jeu.getName() + " ! Taper \"help\" pour la liste des commandes");

        while(true) {
            GameCommand cmd = new GameCommand( sc.nextLine() ); // Read the input command
            ci.interpret(cmd); // interpret the cmd
        }
    }

    public static void main(String [] args) {
        Jeu jeu = Exemple1.initExample();
        Main.startGame(jeu);
    }


}
