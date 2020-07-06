import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertNull;

public class NashornTest {

    private ScriptEngine engine;

    @Before
    public void setup() {
        engine = new ScriptEngineManager().getEngineByName("nashorn");
    }

    @Test
    public void canRunJavaScript() throws ScriptException {
        Object o = engine.eval("print(\"Hello World!\");");
        assertNull(o);
    }

    @Test
    public void canRunJavaScriptFile() throws ScriptException, IOException {
        Object o = engine.eval(new FileReader("script.js"));
        assertNull(o);
    }

    @Test
    public void canRunFunctionFromJavaScriptFile() throws FileNotFoundException, ScriptException, NoSuchMethodException {
        Object o = engine.eval(new FileReader("script.js"));
        Invocable invocable = (Invocable) engine;
        Object result = invocable.invokeFunction("helloTo", "Jose");
        assertNull(result);
    }

}
