package Box_Plot;

import java.util.ArrayList;
import java.util.logging.Logger;


/**
 * This is an abstract class of the readers.
 * 
 * @FauTimerReporter
 * @author Isabell Schmitt
 * @version 1.0
 * @19.07.2012
 *
 */

public abstract class Reader {
	protected static Logger logger = Logger.getLogger("Fau-Timer Reporter");

	abstract public void read(ArrayList<Secret> secrets);
	abstract public String getInputFile();

}

