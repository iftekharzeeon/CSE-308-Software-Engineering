package problem_2;

public class CodeEditor {

    private static CodeEditor editor = null;
    private CodeEditor() {

    }

    public static CodeEditor getInstance() {
        if (editor == null) {
            editor = new CodeEditor();
        }
        return editor;
    }
}
