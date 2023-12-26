public class StringManipulation {

    public static void main(String[] args) {
        
        System.out.println("--------------------------------------------");
        System.out.println("CamelCase");
        String caseIterative = camelCaseIterative("Welcome to CS 2");
        String caseRecursive = camelCaseRecursive("Welcome to CS 2");
        System.out.println("Recursive: " + caseRecursive + " \nIterative: " + caseIterative);
        
        caseIterative = camelCaseIterative("Elementary Data Structure and Algorithms");
        caseRecursive = camelCaseRecursive("Elementary Data Structure and Algorithms");
        System.out.println("Recursive: " + caseRecursive + " \nIterative: " + caseIterative);
        
        caseIterative = camelCaseIterative("Strings are important and immutable");
        caseRecursive = camelCaseRecursive("Strings are important and immutable");
        System.out.println("Recursive: " + caseRecursive + " \nIterative: " + caseIterative);
        
        System.out.println("--------------------------------------------");
        
        System.out.println("CleanString");
        String cleanIterative = stringCleanIterative("abbbcdd");
        String cleanRecursive = stringCleanRecursive("abbbcdd");
        System.out.println("Recursive: " + cleanRecursive + " \nIterative: " + cleanIterative);
        
        cleanIterative = stringCleanIterative("Bees look cool");
        cleanRecursive = stringCleanRecursive("Bees look cool");
        System.out.println("Recursive: " + cleanRecursive + " \nIterative: " + cleanIterative);
        
        cleanIterative = stringCleanIterative("A cook book");
        cleanRecursive = stringCleanRecursive("A cook book");
        System.out.println("Recursive: " + cleanRecursive + " \nIterative: " + cleanIterative);
        
        System.out.println("--------------------------------------------");
        
        System.out.println("CountHello");
        int helloIterative = countHelloIterative("xhelloxhellox");
        int helloRecursive = countHelloRecursive("xhelloxhellox");
        System.out.println("Recursive: " + helloRecursive + " \nIterative: " + helloIterative);

        helloIterative = countHelloIterative("helloxhelloabcdhelloijklo");
        helloRecursive = countHelloRecursive("helloxhelloabcdhelloijklo");
        System.out.println("Recursive: " + helloRecursive + " \nIterative: " + helloIterative);
  
    }
 
    public static String camelCaseIterative(String word) {
			StringBuilder camelCaseString = new StringBuilder();
      boolean toUpperCase = false;

      for (char currentChar : word.toCharArray()) {
       if (Character.isLetter(currentChar)) {
        if (toUpperCase) {
         camelCaseString.append(Character.toUpperCase(currentChar));
        }
        else {
         camelCaseString.append(Character.toLowerCase(currentChar));
        }
        toUpperCase = !toUpperCase;
        }
        else { // If the character is not a letter, append it as is
        	camelCaseString.append(currentChar);
          toUpperCase = false; // Reset toUpperCase for non-letter characters
        }
      }
      return camelCaseString.toString();
    }

	
	public static String camelCaseRecursive(String word) {
		//if the word is empty, return an empty string
    if (word.isEmpty()) {
        return word;
    }
    char firstChar = Character.toLowerCase(word.charAt(0));
    // Recurse on the rest of the word and get the modified string
    String newStr = camelCaseRecursive(word.substring(1));
		
    // newStr is empty or starts with a space, return the newStr
    if (newStr.isEmpty() || newStr.charAt(0) == ' ') {
        return String.valueOf(firstChar) + newStr;
    } 
    else {
    	// If the first character of newStr is uppercase, convert to lowercase
    	if (Character.isUpperCase(newStr.charAt(0))) {
    		return String.valueOf(firstChar).toLowerCase() + newStr;
    	}
      else {
      	return String.valueOf(firstChar++).toUpperCase() + newStr;
      }
    }
	}
    
	public static String stringCleanIterative(String word) {
    StringBuilder cleanedString = new StringBuilder();
    int i = 0;
    while (i < word.length()) {
        char currentChar = word.charAt(i);
        cleanedString.append(currentChar);
        int j = i + 1;
        while (j < word.length() && word.charAt(j) == currentChar) { // letter matches next letter
            j++; //go to the next character 
        }
        i = j;	//transfer to new string
    }
    return cleanedString.toString();
	}
  
	public static String stringCleanRecursive(String word) {
		// Base case: if the word is empty, return an empty string
    if (word.isEmpty()) {
        return word;
    }

    char firstChar = word.charAt(0);
    // Recurse on the rest of the word and get the modified string
    String modifiedRest = stringCleanRecursive(word.substring(1));

    // Check if the first character is the same as the next character & if it is, skip the current character
    if (modifiedRest.length() > 0 && modifiedRest.charAt(0) == firstChar) {
        return modifiedRest;
    }
    else { // first character with the modified rest of the word
     return firstChar + modifiedRest;
    }
	}

	public static int countHelloIterative(String word) {
    int count = 0;
    for (int i = 0; i <= word.length() - 5; i++) { 
    	if (word.substring(i, i + 5).equalsIgnoreCase("hello")) { //look for hello all throughout
      	count++;
      }
    }
    return count;
  }

	public static int countHelloRecursive(String word) {
		if (word.length() < 5) { //if hello isn't there
            return 0;
    }
    if (word.substring(0, 5).equals("hello")) { //search for hello
    	return 1 + countHelloRecursive(word.substring(5));
    }
    else {
    	return countHelloRecursive(word.substring(1));
    }
  }
}
