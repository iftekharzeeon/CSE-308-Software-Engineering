package problem_2.language;

import problem_2.fonts.Font;
import problem_2.fonts.Monaco;
import problem_2.parser.CPPParser;
import problem_2.parser.Parser;

public class CPP implements Language{
    @Override
    public String languageName() {
        return "CPP";
    }

    @Override
    public Parser languageParser() {
        return new CPPParser();
    }

    @Override
    public Font languageFont() {
        return new Monaco();
    }
}
