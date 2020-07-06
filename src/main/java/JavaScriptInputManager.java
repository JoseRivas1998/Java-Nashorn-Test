import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class JavaScriptInputManager {

    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        Object o = engine.eval(new FileReader("script.js"));
        Invocable invocable = (Invocable) engine;
        invocable.invokeFunction("runInput", new JavaScriptInputManager());
    }

    public void inputString(String prompt, StringCallback callBack) {
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print(prompt  + ": ");
            String result = scanner.nextLine();
            callBack.callBack(result);
        }).start();
    }

    @FunctionalInterface
    public interface StringCallback {
        void callBack(String result);
    }

}
