package dataTypeDetector;

import java.util.Iterator;
import java.util.Set;

/**
 * @author petar
 * 
 */
public class SimpleStringProcessor {

	public static String mkString(Set<String> list, String separator) {
		StringBuilder s = new StringBuilder();
		Iterator<String> it = list.iterator();
		if (it.hasNext()) {
			s.append(it.next());
		}
		while (it.hasNext()) {
			s.append(separator).append(it.next());
		}
		return s.toString();
	}

}
