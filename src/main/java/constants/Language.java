package constants;

public enum Language {
    en, fr;

    public static Language getLanguageCode(String language) {
        if (language.equals("English"))
            return Language.en;
        else if (language.equals("French"))
            return Language.fr;
        return null;
    }
}
