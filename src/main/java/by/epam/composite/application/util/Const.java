package by.epam.composite.application.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.IntStream;

public final class Const {

    public static final String PATH_F = "files/text1.txt";
    public static final String PATH_S = "files/text2.txt";
    public static final String PATH_T = "files/text3.txt";

    public static Logger logger = LogManager.getLogger("REPORT");

    private static void logListInfo(List<String> arrayList, String info) {
        logger.printf(Level.INFO, "%n%s", info);
        IntStream
                .rangeClosed(0, arrayList.size() - 1)
                .forEach(element ->
                        logger.printf(Level.INFO, "'%s'", arrayList.get(element)));
    }
}
