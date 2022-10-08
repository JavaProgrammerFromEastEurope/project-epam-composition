package by.epam.composite.entityAction.impl;

import by.epam.composite.application.sort.impl.SortByLengthWord;
import by.epam.composite.application.util.Input;
import by.epam.composite.entity.TextKeeper;
import by.epam.composite.entityAction.ActionTemplate;
import org.apache.logging.log4j.Level;

import java.util.*;

import static by.epam.composite.application.util.Const.PATH_S;
import static by.epam.composite.application.util.Const.logger;
import static by.epam.composite.application.util.TextReader.*;
import static java.lang.System.*;

public class TextActions implements ActionTemplate {

    private final TextKeeper textKeeper;

    public TextActions() {
        this.textKeeper = new TextKeeper();
        initEntity();
    }

    @Override
    public void sortParagraphsAction() {
        List<String> paragraphs = textKeeper.getParagraphs();
        Map<Integer, Integer> extraMap = new HashMap<>();
        int index = 0;
        for (String paragraph : paragraphs) {
            extraMap.put(index++, isSentence.split(paragraph).length);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(extraMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        logger.printf(Level.INFO, "%n Sort By Length");
        list.forEach(value ->
                logger.printf(Level.INFO, "'%s'",
                        paragraphs.get(value.getKey())));
        getInfoForUser();
    }

    @Override
    public void findTheSameWordsAction() {
        List<String> latWords = textKeeper.getLatWords();
        List<String> sentences = textKeeper.getSentences();
        latWords.sort(new SortByLengthWord());
        logger.printf(Level.INFO, "%n Sentences with higher word - '%s'", latWords.get(0));
        sentences.stream()
                .filter(value -> value.contains(latWords.get(0)))
                .forEach(value ->
                        logger.printf(Level.INFO, "'%s'", value));
        getInfoForUser();
    }

    @Override
    public void removeSentencesAction() {
        removeSentencesWithLessWords(
                Input.inputPosition(20, "Please input to remove sentence: "));
        getInfoForUser();
    }

    @Override
    public void findSentencesAction() {
        List<String> latWords = textKeeper.getLatWords();
        countOf(latWords);
        getInfoForUser();
    }

    @Override
    public void vowelsConsonantsAction() {
        textKeeper.setCharacters(
                setCharactersFromString(isLatCharacter));
        Object[] characters = textKeeper.getCharacters();
        textKeeper.setVowels(
                setSpecSymbols(Arrays.toString(characters), isVowels));
        textKeeper.setConsonants(
                setSpecSymbols(Arrays.toString(characters), isNotVowels));
        countOf(List.of(textKeeper.getVowels()));
        countOf(List.of(textKeeper.getConsonants()));
        getInfoForUser();
    }

    private void initEntity() {
        readFileText(PATH_S);
        textKeeper.setParagraphs(setParagraphOrWordFromString(isParagraph));
        textKeeper.setLatWords(setParagraphOrWordFromString(isLatWords));
        textKeeper.setSentences(setSentencesFromString());
    }


    private void removeSentencesWithLessWords(int count) {
        Map<Integer, Integer> extraMap = new HashMap<>();
        List<String> sentences = textKeeper.getSentences();
        int index = 0;
        for (String sentence : sentences) {
            extraMap.put(index++, isLatWords.split(sentence).length);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(extraMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        logger.printf(Level.INFO, "%n Remove Sentences if less %s", count);
        list.forEach(value -> {
            logger.printf(Level.INFO, "'%s' has %s words",
                    sentences.get(value.getKey()), value.getValue());
            if (value.getValue() < count) {
                logger.printf(Level.INFO, " %n sentence is removed ");
            }
        });
    }

    private void countOf(List<String> list) {
        TreeMap<Object, Integer> treeMap = new TreeMap<>();
        TreeSet<Object> sortedElementsSet;
        sortedElementsSet = new TreeSet<>(
                Arrays.asList(list.toArray()).subList(0, list.size()));
        int localBound = sortedElementsSet.size();
        for (int index = 0; index < localBound; index++) {
            treeMap.put(sortedElementsSet.pollFirst(), 0);
        }
        for (String s : list) {
            treeMap.put(s, treeMap.get(s) + 1);
        }
        logger.printf(Level.INFO, "%n Count of elements:");
        treeMap.forEach((key, value) ->
                logger.printf(Level.INFO,
                        " '%s' - %s counts", key, value));
    }

    private void getInfoForUser() {
        String warning = ("The Result of Action logged to the file.\n");
        out.println(warning);
    }
}