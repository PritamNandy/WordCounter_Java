package project;
import java.util.*;
import java.io.*; 

public class wordCounter {
	
	public File fl;
	public String st = "";
	public String[] words;
	int special,num,uniqueTotal;
	public String[] uniqueWords;
	
	public wordCounter() {
		     
	}
	
	public wordCounter(File file) throws FileNotFoundException { // Constructor With Parameter
		fl = file;
		
		wordSeparator();      
	}
	
	public void wordSeparator() throws FileNotFoundException { // Constructor Without Parameter
		String st = "";
		Scanner sc = new Scanner(fl); 
		  
	    while (sc.hasNext()) 
	      st+=sc.next() + " "; 
	    
	    words=st.split(" ");
	    
	    symbolCount();
	}
	
	public void symbolCount() { // Count Special Characters and Numbers
		int len = words.length;
		for (int i=0; i<len; i++) 
	    { 
	        String str = words[i];
	        for (int j=0; j<str.length(); j++){
	        	if (Character.isDigit(str.charAt(j))) 
	                num++; 
	        	else if(Character.isAlphabetic(str.charAt(j))) {
	        		
	        	}   
	            else {
	            	special++;
	            	str = str.replaceAll("[^a-zA-Z0-9]", ""); // Removing the special character from word
	            	words[i] = str;
	            }   
	        }
	    }
		//printResult();
		uniqueWords();
	}
	
	public void uniqueWords() { // Count Unique Words
		int i,j;
		boolean isTrue;
		uniqueWords = new String[words.length];
		for(i=0; i<words.length; i++) {
			isTrue = true;
			for(j=0; j<=i ; j++) {
				if(i!=j) {
					String str1,str2;
					str1 = words[j].toLowerCase();
					str2 = words[i].toLowerCase();
					if(str1.equals(str2)) {
						isTrue = false;
						break;
					}
					else {
						isTrue = true;
					}
				}	
			}
			if(isTrue == true) {
				uniqueWords[uniqueTotal] = words[i];
				uniqueTotal++;
			}
		}
		printResult();
	}
	
	public void printResult() {
		System.out.println("Total Number of Words: " + words.length);
		System.out.println("Total Number of Special Characters: " + special);
		System.out.println("Total Number of Numbers: " + num);
		System.out.println("Total Number of Unique Words: " + uniqueTotal);
		System.out.println("Unique Words: ");
		for(int i=0;i<uniqueTotal;i++) {
			if(i!=(uniqueTotal-1))
				System.out.print(uniqueWords[i].toLowerCase() + ", ");
			else
				System.out.print(uniqueWords[i].toLowerCase() + ".");
		}
	}


}

