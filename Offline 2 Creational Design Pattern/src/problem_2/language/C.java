package problem_2.language;

import problem_2.parser.CParser;
import problem_2.parser.Parser;

public class C implements Language{
    @Override
    public String languageName() {
        return "C";
    }

    @Override
    public Parser languageParser() {
        return new CParser();
    }
}
