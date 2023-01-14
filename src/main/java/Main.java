import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Starting Euler54 games");
        try {
            ClassLoader classLoader = Main.class.getClassLoader();
            BufferedReader br = new BufferedReader(new FileReader(
                    Objects.requireNonNull(classLoader.getResource("poker.txt")).getFile()));
        } catch (FileNotFoundException e) {
            logger.error("File not found.");
        }
    }
}
