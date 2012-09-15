package mjg

import mjg.without_custom_levels
import mjg.use_slang_category
import mjg.use_emc

import java.util.logging.Level;
import java.util.logging.Logger;

class LoggingTests extends GroovyLogTestCase {
    String baseDir = 'src/main/groovy/mjg'
    
    void testWithoutCustomLevel() {
        def result = stringLog(Level.INFO, without_custom_levels.class.name) {
            GroovyShell shell = new GroovyShell()
            shell.evaluate(new File("$baseDir/without_custom_levels.groovy"))
        }
        assert result.contains('INFO: for your information')
        assert result.contains('SEVERE: oh my goodness')
    }
    
    void testSlangCategory() {
        def result = stringLog(Level.INFO, use_slang_category.class.name) {
            GroovyShell shell = new GroovyShell()
            shell.evaluate(new File("$baseDir/use_slang_category.groovy"))
        }
        assert result.contains('FYI: this seems okay')
        assert result.contains('LOL: snicker')
    }

    void testAnnotatedSlangCategory() {
        def result = stringLog(Level.INFO, use_slang_category_annotation.class.name) {
            GroovyShell shell = new GroovyShell()
            shell.evaluate(new File("$baseDir/use_slang_category_annotation.groovy"))
        }
        assert result.contains('FYI: this seems okay')
    }

    void testEMC() {
        def result = stringLog(Level.INFO, use_emc.class.name) {
            GroovyShell shell = new GroovyShell()
            shell.evaluate(new File("$baseDir/use_emc.groovy"))
        }
        assert result.contains('WTF: no effin way')
        assert result.contains('WHOA: dude, seriously')
        assert result.contains("ROFL: you're kidding, right?")
    }

}
