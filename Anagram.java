/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		boolean checker = false;
		int count=0;
		if(str1.length()!=str2.length())
		return false;
		    for (int i =0; i<str2.length() ; i++ ){

                    while(checker==false && count<str2.length()){
	                   if(str2.charAt(i)==str1.charAt(count)){
						str1 =str1.substring(0,count) + str1.substring(count+1);
						checker=true;
						break;
					   }
					   count++;
                       
					}
				   if(checker==false)
				   return false;
				   checker=false;
				   count=0;
				   
			}
		return true; 
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String temp = str.toLowerCase();
		String back ="";
		for(int i =0 ; i<str.length() ; i++ ){
              if(('a' <=temp.charAt(i) && temp.charAt(i)<='z' ))
			  back = back + temp.charAt(i);
		}
		return back;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int count=0;
		String neww = "";
		int num;
		int u =str.length();
        while(str.length()!=0){
			 num = (int)(Math.random()*(str.length()));
			 neww = neww +str.charAt(num);
			 str=str.substring(0, num) + str.substring(num+1);
			 count++;
		}
		return neww;
	}
}
