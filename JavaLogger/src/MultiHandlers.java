import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.MemoryHandler;
import java.util.logging.XMLFormatter;

public class MultiHandlers {
	private static Logger logger = Logger.getLogger(MultiHandlers.class.getSimpleName());
	
	static {
		// logger.setLevel(Level.ALL);
	}
	
	public static void main(String[] args) {
		// logger.setUseParentHandlers(false);
		
		// addConsoleHandler();
		
		logger.fine("This is FINE level message");
		
		// addFileHandler();
		
		logger.warning("This is WARNING level message");
		logger.finest("This is FINEST level message");
		
		// addMemoryHandler();
		logger.log(Level.SEVERE, "This is SERVER level message 1");
		logger.log(Level.SEVERE, "This is SERVER level message 2");
	}

	private static void addConsoleHandler() {
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.FINE);
		// consoleHandler.setFormatter(new XMLFormatter());
		logger.addHandler(consoleHandler);
	}
	
	private static void addFileHandler() {
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("javaLogger1.txt");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (fileHandler != null) {
			fileHandler.setLevel(Level.WARNING);
			logger.addHandler(fileHandler);
		}
	}
	
	private static void addMemoryHandler() {
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("javaLogger2.txt");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (fileHandler != null) {
			// fileHandler.setFormatter(new SimpleFormatter());
			MemoryHandler memoryconsoleHandler = new MemoryHandler(fileHandler, 3, Level.SEVERE);
			logger.addHandler(memoryconsoleHandler);
		}
	}
}
