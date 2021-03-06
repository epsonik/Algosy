package LZW;

import java.util.*;
 
public class LZW {
	private static short DSIZE = 256;
	
	public LZW(){};
	
	public static List<Integer> compress(String uncompressed) {
        // Budujemy s�ownik
        int dictSize = DSIZE;
        Map<String,Integer> dictionary = new HashMap<String,Integer>();
        for (int i = 0; i < DSIZE; i++)
            dictionary.put("" + (char)i, i);
 
        String w = "";
        List<Integer> result = new ArrayList<Integer>();
        for (char c : uncompressed.toCharArray()) {
            String wc = w + c;
            if (dictionary.containsKey(wc))
                w = wc;
            else {
                result.add(dictionary.get(w));
                // Dodajemy nowe wyra�enie do s�ownika
                dictionary.put(wc, dictSize++);
                w = "" + c;
            }
        }
 
        // Zapisujemy ostatni� liter�
        if (!w.equals(""))
            result.add(dictionary.get(w));
        return result;
    }
	
    public static String decompress(List<Integer> compressed) {
        // Budujemy s�ownik
        int dictSize = DSIZE;
        Map<Integer,String> dictionary = new HashMap<Integer,String>();
        for (int i = 0; i < DSIZE; i++)
            dictionary.put(i, "" + (char)i);
 
        String w = "" + (char)(int)compressed.remove(0);
        String result = w;
        for (int k : compressed) {
            String entry;
            if (dictionary.containsKey(k))
                entry = dictionary.get(k);
            else if (k == dictSize)
                entry = w + w.charAt(0);
            else
                throw new IllegalArgumentException("Bad compressed k: " + k);
 
            result += entry;
 
            // Dodajemy nowy cz�on do s�ownika
            dictionary.put(dictSize++, w + entry.charAt(0));
 
            w = entry;
        }
        return result;
    }
}