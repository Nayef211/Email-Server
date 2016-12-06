/*****************************************************
  * Name: Nayef Ahmed
  * Date: November 11/2015
  * Course: ICS4U0
  * Assignment: Utils
  * ****************************************************/

public class Utils {
  
  public static void main (String args[]){
     //leftPad method
    /*
     System.out.println(leftPad("Cat", 5, 'B'));
     System.out.println(leftPad("House", 3, 'A'));
     System.out.println(leftPad("", 4, 'F'));
     System.out.println(leftPad("Phone", 10, '*'));
     */
    /*
    //removeChars method
    System.out.println(removeChars("This is first", 'i'));
    System.out.println(removeChars("Long day", 'h'));
    System.out.println(removeChars("416-464-2622", '-')); 
    */
  }
  
  public static String leftPad(String text, int desiredLength, char paddingItem){
    String paddedText = "";
    
    if (text.length() < desiredLength){
      for (int i = text.length(); i<desiredLength; i++)
        paddedText += paddingItem;
      
      paddedText += text;
    } 
    else if (text.length() > desiredLength){
      paddedText = text;
    }
    
    return paddedText;
  }
  
  public static String removeChars(String text, char c){
    String editedString = "";
      
    for (int i = 0; i<text.length(); i++){
      if (text.charAt(i)!= c)
        editedString+=text.charAt(i);
    }
    
      return editedString;
  }
  
  //*******Networking and Data Transfer********                  
  
  public static String longToBytesStr(long number){
    
    return "" + (char)(number  >> 56) +
                (char) ((number & 0xFF000000000000L) >> 48) +
                (char) ((number & 0xFF0000000000L) >> 40) +
                (char) ((number & 0xFF00000000L) >> 32 )+
                (char) ((number & 0xFF000000L) >> 24) +
                (char) ((number & 0xFF0000L) >> 16) +
                (char) ((number & 0xFF00L) >> 8) +
                (char)  (number & 0xFFL);            
  }
  
  public static long bytesStrToLong(String s) {
    String strValue = "";
       
    for (int i = 0; i<s.length(); i++){
      strValue += Integer.toHexString((int) (s.charAt(i)));
    }
    
  return Long.parseLong(strValue,16);
  }
  
  public static String intToBytesStr(int n){
        return "" + (char)(n  >> 24) +
                (char) ((n & 0xFF0000L) >> 16) +
                (char) ((n & 0xFF00L) >> 8) +
                (char)  (n & 0xFFL);
  }
  
  public static long bytesStrToInt(String s) {
    String strValue = "";
    
    for (int i = 0; i<s.length(); i++){
      strValue += Integer.toHexString((int) (s.charAt(i)));
    }
    
    return Integer.parseInt(strValue,16);
  }
  
  public static String setReceivingTime(String request){
    return request.substring(0,Globals.DATE_TIME_POS) + longToBytesStr(System.currentTimeMillis()) + request.substring(Globals.MARKER_POS);
  }

  
}