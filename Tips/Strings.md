1. Check if a letter is an alphabet
    - Character.isLetter(char)
    - (char <= 'z' && char >= 'a') || (char <= 'Z' && char >= 'A')
  
2. Get the position of an alphabet
    - int index = char - 'A'
    
    if char = 'A', index would be 0
    
3. - ASCII value of 'A'-'Z' -> 65 - 90

   - ASCII value of 'a'-'z' -> 97 - 112
   
   - Fact to remember: upper case comes first and then lower case
   
4. Get char from ascii value
    - char c = (char)65; // returns 'A'

5. Convert upper case to lower case letter
   - Get upper case position in alphabet sequence
        int s = char - 'A';
   - Get lower case position in alphabet sequence
        char lower = (char)s + 'a';
        
6. Check if a letter is vowel
    - "AEIOUaeiou".indexOf(c) != -1
  
7. Get a hang of String manipulation functions
    - string.split("\\\s");
    - string.substring(1) OR string.substring(2,8)
    - char[] arr = s.toCharArray()
    - str.startsWith(anotherstr)
  
8. if chars are repeating in the string try to find the pattern, xor may help
    - char res = 0; 
    res ^= str.charAt(i); 
   
9. when an int is converted to String using "" + 10 the underlying operation is,
    new StringBuffer().append(“”).append(10).toString()
    
10. Use String builder when returning a new String as result

11. Sort a String
   - Arrays.sort(s.toCharArray())
   
12. Convert char array back to String
    - String s = new String(charArray);
    
13. Convert String number to Integer
    - int num = Integer.parseInt(stringNum)
    
14. Convert Integer to String
    - String s = Integer.toString(num);
