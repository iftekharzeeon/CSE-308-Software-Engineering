package problem_2.language;

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
}
