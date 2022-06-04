package problem_2.language;

import problem_2.fonts.Consolas;
import problem_2.fonts.Font;
import problem_2.parser.Parser;
import problem_2.parser.PythonParser;

public class Python implements Language{
    @Override
    public String languageName() {
        return "Python";
    }

    @Override
    public Parser languageParser() {
        return new PythonParser();
    }

    @Override
    public Font languageFont() {
        return new Consolas();
    }
}
