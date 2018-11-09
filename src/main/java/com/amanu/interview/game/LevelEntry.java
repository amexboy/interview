package com.amanu.interview.game;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public class LevelEntry {

    /**
     * The phrase or sentence
     */
    private String phrase;
    /**
     * The translation of the phrase when the object is male
     */
    private String maleTranslation;
    /**
     * The translation of the phrase when the object is female
     */
    private String femaleTranslation;


    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getMaleTranslation() {
        return maleTranslation;
    }

    public void setMaleTranslation(String maleTranslation) {
        this.maleTranslation = maleTranslation;
    }

    public String getFemaleTranslation() {
        return femaleTranslation;
    }

    public void setFemaleTranslation(String femaleTranslation) {
        this.femaleTranslation = femaleTranslation;
    }

    public static LevelEntry of(String phrase, String maleTranslation, String femaleTranslation) {
        LevelEntry entry = new LevelEntry();

        entry.setPhrase(phrase);
        entry.setMaleTranslation(maleTranslation);
        entry.setFemaleTranslation(femaleTranslation);

        return entry;
    }
}
