package bigcookingdata_engine.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sofiane-hamiti
 *
 */
public class SgfUtils {

	/**
	 * Method pour lire une ligne bien spécifique
	 * 
	 * @param line
	 *            numéro de la ligne
	 */

	public String readLine(int line) {

		try {

			return Files.readAllLines(Paths.get("data/da")).get(0);

		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Ecrire dans une ligne bien spécifique
	 * 
	 * @param line
	 *            numero de la ligne (id uer)
	 * @param value
	 *            la valeur
	 */
	public void writeLine(int line, String value) {

		List<String> lines = null;

		File f = new File("data/da");

		try {

			lines = Files.readAllLines(f.toPath());

			lines.set(line, value);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	/**
	 * Methode pour initialiser le veteur à 0
	 * 
	 * @param name
	 *            nom du fichier
	 */
	public void initFile(String name) {

		List<String> zero = new ArrayList<String>();

		for (int i = 1; i < 1312; i++) {

			zero.add("0");

		}

		try {

			Files.write(Paths.get("data/" + name + ".txt"), zero, Charset.forName("UTF-8"));

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
