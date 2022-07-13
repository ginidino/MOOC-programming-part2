package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Exercise 35: Two-Direction Dictionary
public class MindfulDictionary {
	private Map<String, String> dict;
	private String file;
	
	public MindfulDictionary() {
		this.dict = new HashMap<String, String>();
	}
	// Exercise 35.3: Loading a File
	public MindfulDictionary(String file) {
		this.file = file;
	}	
	// Exercise 35.1: Forgetful Basic Functionality
	public void add(String word, String translation) {
		// adds a word to the dictionary. Each word has only one translation; if the same word is added twice, nothing happens.
		if (!this.dict.containsKey(word)) {
			this.dict.put(word, translation);
		}
	}
	// Exercise 35.1: Forgetful Basic Functionality
	public String translate(String word) {
		// returns the word translation; if the word isn't recognised, it returns null
		String trnslation = null;
        for(String key : this.dict.keySet()) {
            if (key.equals(key)) {
                trnslation = this.dict.get(key);
            } else if (this.dict.get(key).equals(word)) {
                trnslation = key;
            }
        }
        return trnslation;
	}
	// Exercise 35.2: Removing Words
	public void remove(String word) {
		if (this.dict.containsKey(word)) {
			this.dict.remove(word);
		}
		if (this.dict.containsValue(word)) {
			List<String> keys = new ArrayList<String>();
			for (String key : this.dict.keySet()) {
				if (this.dict.get(key).equals(word)) {
					keys.add(key);
				}
			}
			for (String k : keys) {
				this.dict.remove(k);
			}
		}
	}
	// Exercise 35.3: Loading a File
	public boolean load()  {
		try {
            File f = new File(this.file);
            Scanner fileReader = new Scanner(f, "UTF-8");

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.dict.put(parts[0], parts[1]);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
	}
	// Exercise 35.4: Saving Data
	public boolean save() {
		try {
			FileWriter writer = new FileWriter(this.file);
			for (String key : this.dict.keySet()) {
				writer.write(key + ":" + this.dict.get(key));
				writer.write("\n");
			}
			writer.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
