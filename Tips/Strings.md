1. Check if a letter is an alphabet
    - Character.isLetter(char)
    - (char <= 'z' && char >= 'a') || (char <= 'Z' && char >= 'A')
  
2. Get the position of an alphabet
    - int index = char - 'A'
    if char = 'A', index would be 0
  
3. Check if a letter is vowel
    - "AEIOUaeiou".indexOf(c) != -1
  
4. Get a hang of String manipulation functions
    - string.split("\\\s");
    - string.substring(1) OR string.substring(2,8)
    - char[] arr = s.toCharArray()
  
5. if chars are repeating in the string try to find the pattern, xor may help
    - char res = 0; 
    res ^= str.charAt(i); 
   
6. when an int is converted to String using "" + 10 the underlying operation is,
    new StringBuffer().append(“”).append(10).toString()
    
7. Use String builder when returning a new String as result

8. Sort a String
   - Arrays.sort(s.toCharArray())
   
9. Convert char array back to String
    - String s = new String(charArray);
    
10. Convert String number to Integer
    - int num = Integer.parseInt(stringNum)
    
11. Convert Integer to String
    - String s = Integer.toString(num);
