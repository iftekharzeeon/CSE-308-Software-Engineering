package problem_2;

import problem_2.language.C;
import problem_2.language.CPP;
import problem_2.language.Language;
import problem_2.language.Python;

public class LanguageFactory {

    public static Language getLanguage(String languageName) {
        if (languageName == null) {
            return null;
        }
        if (languageName.equalsIgnoreCase("c")) {
            return new C();
        }
        if (languageName.equalsIgnoreCase("cpp")) {
            return new CPP();
        }
        if (languageName.equalsIgnoreCase("py")) {
            return new Python();
        }
        return null;
    }
}
