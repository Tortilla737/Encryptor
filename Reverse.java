
public class Reverse implements Encryptor{
	public String encrypt(String text) {
		return reverse(text);
	}
	
	public String decrypt(String text) {
		return reverse(text);
	}
	
	String reverse(String text){
		String ausgabe = "";
		char[] textBuffer = text.toCharArray(); 
		for(int i = textBuffer.length-1; i >= 0; i--)
			ausgabe = ausgabe + textBuffer[i];
		return ausgabe;
	}
}
