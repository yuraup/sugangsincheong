package Entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import ValueObject.VDirectory;

public class EDirectory {
	public Vector<VDirectory> getDirectories(String fileName) {
//		System.out.println("eDirectory fileName: " + fileName );
		Vector<VDirectory> vDirectories = new Vector<VDirectory>();
		try {
			Scanner scanner = new Scanner(new File("directory/" + fileName));
			while (scanner.hasNext()) {
				VDirectory vDirectory = new VDirectory();
				vDirectory.read(scanner);
				vDirectories.add(vDirectory);	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return vDirectories;
	}
}
