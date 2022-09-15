package by.epam.composite.application.util;

import org.apache.logging.log4j.Level;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static by.epam.composite.application.util.Const.logger;
import static java.lang.String.format;
import static java.nio.file.Files.newBufferedReader;

/**
 * The <em><b>Init</b></em> class - provides methods for
 * init data arrays from files or random numbers.
 */
public final class TextReader {

    public static final Pattern isParagraph = Pattern.compile("[\\t]");
    public static final Pattern isSentence = Pattern.compile("([!?.]+\\s)");
    public static final Pattern isLatWords = Pattern.compile("(\\W+)");
    public static final Pattern isRusWords = Pattern.compile("(\\p{ASCII}+)");
    public static final Pattern isLatCharacter = Pattern.compile("(\\W+)|");
    public static final Pattern isRusCharacter = Pattern.compile("(\\p{ASCII}+)|");

    public static final Pattern isVowels = Pattern.compile("([AEIOUaeiouАОУЫЭЯЁЮИЕаоуэяёюие])");
    public static final Pattern isNotVowels = Pattern.compile("([^],AEIOUaeiouАОУЫЭЯЁЮИЕаоуэяёюие1-9 ])");

    private static String fileText;

    /**
     * Read all lines from required File - Maven variation
     *
     * @return String From File
     */
    public static String getStringFromFile(String filePath)
            throws IOException, URISyntaxException {
        String stringFromFile;
        URL url = TextReader.class.getResource(format("/%s", filePath));
        Path path = Paths.get(url.toURI());
        try (BufferedReader bufferedReader = newBufferedReader(path)) {
            stringFromFile = bufferedReader.lines()
                    .collect(Collectors.joining(" "));
            return stringFromFile;
        }
    }

    public static void readFileText(String path) {
        try {
            fileText = getStringFromFile(path);
            logger.printf(Level.INFO,
                    "File successfully read with path - '%s'!%n", path);
        } catch (IOException | URISyntaxException e) {
            logger.printf(Level.ERROR,
                    "File with path '%s' cannot be read!", path);
        }
    }

    public static String[] setSpecSymbols(String s, Pattern isSpec) {
        return new Scanner(s).findAll(isSpec)
                .map(MatchResult::group)
                .toArray(String[]::new);
    }
    public static List<String> setParagraphOrWordFromString(Pattern pattern) {
        var arrayList = Arrays.stream(pattern.split(fileText))
                .collect(Collectors.toCollection(ArrayList::new));
        arrayList.remove(0);
        return arrayList;
    }

    public static List<String> setSentencesFromString() {
        return Arrays.stream(isSentence.split(fileText))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static Object[] setCharactersFromString(Pattern isCharacter) {
        var arrayList = Arrays.stream(isCharacter.split(fileText))
                .collect(Collectors.toCollection(ArrayList::new));
        arrayList.remove(0);
        return arrayList.toArray();
    }
}
