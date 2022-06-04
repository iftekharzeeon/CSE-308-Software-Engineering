package problem_2;

import problem_2.language.Language;

public class CodeEditor {

    private static CodeEditor editor = null;
    private static Language language = null;
    private CodeEditor() {

    }

    public static CodeEditor getInstance() {
        if (editor == null) {
            editor = new CodeEditor();
        }
        return editor;
    }

    public static void open(String fileName) {
        editor = getInstance();

        String fileExtension = fileName.split("\\.")[fileName.split("\\.").length - 1];

        language = LanguageFactory.getLanguage(fileExtension);

        if (language == null) {
            System.out.println("File not supported.");
        } else {
            loadSetting();
        }

    }

    public static void loadSetting() {
        if (language != null) {
            System.out.println("Language Detected: " + language.languageName());
            System.out.println("Font selected for the language: " + language.languageFont().fontName());
            language.languageParser().parse();
        } else {
            System.out.println("No file opened yet");
        }
    }
}
