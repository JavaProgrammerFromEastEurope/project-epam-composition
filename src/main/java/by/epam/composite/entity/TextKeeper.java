package by.epam.composite.entity;

import java.util.*;

public class TextKeeper {

    private List<String> paragraphs;
    private List<String> sentences;
    private List<String> latWords;
    private List<String> rusWords;
    private Object[] characters;
    private String[] vowels;
    private String[] consonants;

    public void setParagraphs(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

    public void setLatWords(List<String> latWords) {
        this.latWords = latWords;
    }

    public void setRusWords(List<String> rusWords) {
        this.rusWords = rusWords;
    }

    public void setCharacters(Object[] characters) {
        this.characters = characters;
    }

    public void setVowels(String[] vowels) {
        this.vowels = vowels;
    }

    public void setConsonants(String[] consonants) {
        this.consonants = consonants;
    }

    public List<String> getParagraphs() {
        return paragraphs;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public List<String> getLatWords() {
        return latWords;
    }

    public List<String> getRusWords() {
        return rusWords;
    }

    public Object[] getCharacters() {
        return characters;
    }

    public String[] getVowels() {
        return vowels;
    }

    public String[] getConsonants() {
        return consonants;
    }
}