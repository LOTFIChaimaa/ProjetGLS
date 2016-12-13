package prototype;

/**
 * Created by tfaget on 12/12/16.
 */

/** Represent a command typed by the player in the shell
 *
 *
 * PROTOCOL :
 *
 * GLOBAL DISPLAY :
 * afficher joueur objets/connaissances/inventaires
 * afficher joueur detail objet <nom objet> (type String)
 * afficher joueur detail objet <nom connaissance>
 * afficher lieu objets/connaissances/personnes/chemins
 * afficher lieu detail objet <nom objet>
 * afficher lieu detail connaissance <nom connaissance>
 * afficher lieu detail personne <nom personne>
 * afficher lieu detail chemin <nom chemin>
 *
 * GLOBAL ACTION :
 * prendre <nom objet>
 * deposer <nom objet>
 * utiliser <nom chemin>
 *
 * INTERACTION WITH A PERSON :
 * interagir <nom personne>
 * choisir <num choix> (type int)
 */

public class GameCommand {

    private String [] cmd;

    public GameCommand(String msg) {
        cmd = msg.split(" ");
    }

    /** return the word n°i of the comman
     * @param i index
     * @return the word at the index i
     * @throws java.lang.IndexOutOfBoundsException : i >= length
     */
    public String getWord(int i) throws IndexOutOfBoundsException {
        return cmd[i];
    }
}
