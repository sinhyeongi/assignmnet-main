package Utils;

import java.io.File;
import java.io.IOException;

public class FileManager {
  // cart.txt
	// user.txt
	// item.txt
	private FileManager() {
		CheckFile();
	}
	private static FileManager instance;
	public final String PATH = "src/"+this.getClass().getPackageName().toString()+"/";
	private File cart = new File(PATH+"cart.txt");
	private File user = new File(PATH+"user.txt");
	private File item = new File(PATH+"item.txt");
	public static FileManager getInstance() {
		if(instance == null) 
			instance = new FileManager();
		return instance;
	}
	
	private void CheckFile() {
		try {
			if(cart.exists() == false)
				cart.createNewFile();
			if(user.exists() == false)
				user.createNewFile();
			if(item.exists() == false)
				item.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
