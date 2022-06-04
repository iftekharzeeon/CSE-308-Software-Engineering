package problem_2.language;

import problem_2.fonts.Font;
import problem_2.parser.Parser;

public interface Language {
    String languageName();
    Parser languageParser();
    Font languageFont();
}
