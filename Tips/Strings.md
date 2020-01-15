1. Check if a letter is an alphabet
    - Character.isLetter(char)
    - (char <= 'a' && char >= 'z') || (char <= 'A' && char >= 'Z')
  
2. Get the position of an alphabet
    - int index = char - 'A'
    if char = 'A', index would be 0
  
3. Check if a letter is vowel
    - "AEIOUaeiou".indexOf(c) != -1
  
4. Get a hang of String manipulation functions
    - string.split("\\s");
    - string.substring(1) OR string.substring(2,8)
  
5. if chars are repeating in the string try to find the pattern, xor may help
    - char res = 0; 
    res ^= str.charAt(i); 
   
6. when an int is converted to String using "" + 10 the underlying operation is,
    new StringBuffer().append(“”).append(10).toString()
    
7. Use String builder when returning a new String as result

8. Sort a String
   - Arrays.sort(s.toCharArray())