package mjg

import java.util.logging.Level;
import java.util.logging.Logger;

@Category(Logger)
class AnnotationSlangCategory {
	String fyi(String msg) {
		this.log(new CustomLevel('FYI',Level.INFO.intValue()), msg)
	}
}

Logger.class.mixin AnnotationSlangCategory
// or even just Logger.mixin AnnotationSlangCategory
Logger log = Logger.getLogger(this.class.name)
log.fyi 'this seems okay'