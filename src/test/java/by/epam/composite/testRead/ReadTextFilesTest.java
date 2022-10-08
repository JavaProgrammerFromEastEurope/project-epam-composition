package by.epam.composite.testRead;

import by.epam.composite.application.sort.impl.SortByLengthWord;
import org.apache.logging.log4j.Level;
import org.junit.jupiter.api.Test;

import java.util.*;

import static by.epam.composite.application.util.Const.*;
import static by.epam.composite.application.util.TextReader.*;

public class ReadTextFilesTest {
    private List<String> paragraphs;
    private List<String> sentences;
    private List<String> latWords;
    private List<String> rusWords;
    private Object[] characters;
    private String[] vowels;
    private String[] consonants;

    private void sortByEntrySet() {
        Map<Integer, Integer> extraMap = new HashMap<>();
        int index = 0;
        for (String paragraph : paragraphs) {
            extraMap.put(index++, isSentence.split(paragraph).length);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(extraMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        logger.printf(Level.INFO, "%n Sort By Length");
        list.forEach(value ->
                logger.printf(Level.INFO, "'%s'", paragraphs.get(value.getKey())));
    }

    private void findHigherWord() {
        latWords.sort(new SortByLengthWord());
        logger.printf(Level.INFO, "%n Sentences with higher word - '%s'", latWords.get(0));
        sentences.forEach(value ->
        {
            if (value.contains(latWords.get(0))) {
                logger.printf(Level.INFO, "'%s'", value);
            }
        });
    }

    private void removeSentencesWithLessWords(int count) {
        Map<Integer, Integer> extraMap = new HashMap<>();
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
        sortedElementsSet = new TreeSet<>(list);
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

    @Test
    void ReadFirstFile() {
        readFileText(PATH_F);
        paragraphs = setParagraphOrWordFromString(isParagraph);
        latWords   = setParagraphOrWordFromString(isLatWords);
        sentences  = setSentencesFromString();
        sortByEntrySet();
        findHigherWord();
        removeSentencesWithLessWords(5);
        characters = setCharactersFromString(isLatCharacter);
        vowels     = setSpecSymbols(Arrays.toString(characters), isVowels);
        consonants = setSpecSymbols(Arrays.toString(characters), isNotVowels);
        countOf(latWords);
        countOf(List.of(vowels));
        countOf(List.of(consonants));
    }

    @Test
    void ReadSecondFile() {
        readFileText(PATH_S);
        paragraphs = setParagraphOrWordFromString(isParagraph);
        latWords   = setParagraphOrWordFromString(isLatWords);
        sentences  = setSentencesFromString();
        sortByEntrySet();
        findHigherWord();
        removeSentencesWithLessWords(7);
        characters = setCharactersFromString(isLatCharacter);
        vowels     = setSpecSymbols(Arrays.toString(characters), isVowels);
        consonants = setSpecSymbols(Arrays.toString(characters), isNotVowels);
        countOf(latWords);
        countOf(List.of(vowels));
        countOf(List.of(consonants));
    }

    @Test
    void ReadThirdFile() {
        readFileText(PATH_T);
        paragraphs = setParagraphOrWordFromString(isParagraph);
        latWords   = setParagraphOrWordFromString(isLatWords);
        sentences  = setSentencesFromString();
        sortByEntrySet();
        findHigherWord();
        removeSentencesWithLessWords(11);
        characters = setCharactersFromString(isLatCharacter);
        vowels     = setSpecSymbols(Arrays.toString(characters), isVowels);
        consonants = setSpecSymbols(Arrays.toString(characters), isNotVowels);
        countOf(latWords);
        countOf(List.of(vowels));
        countOf(List.of(consonants));
    }
}
