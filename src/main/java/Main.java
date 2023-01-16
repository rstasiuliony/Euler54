import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import domain.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.Dealer;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final String FILE_NAME = "poker.txt";
    private static int firstPlayerWinnerCounter = 0;
    private static String line;

    public static void main(String[] args) {

        logger.info("Starting Euler54 games.");
        Dealer dealer = new Dealer();

        try {
            ClassLoader classLoader = Main.class.getClassLoader();
            BufferedReader br = new BufferedReader(new FileReader(
                    Objects.requireNonNull(classLoader.getResource(FILE_NAME)).getFile()));
            while ((line = br.readLine()) != null) {
                dealer.startGame(prepareCards());
                if (dealer.isFirstPlayerWinner()) {
                    firstPlayerWinnerCounter++;
                }
            }
            br.close();
            logger.info("First player won " + firstPlayerWinnerCounter + " times.");
        } catch (IOException e) {
            logger.error("Error reading or accessing file.");
        }
    }

    private static List<Card> prepareCards() {
        List<Card> roundCards = new ArrayList<>();
        for (String c : line.split(" ")) {
            roundCards.add(new Card(c));
        }
        return roundCards;
    }
}
