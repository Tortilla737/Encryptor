
public class Caesar implements Encryptor{
	int c = 20;
	
	public String encrypt(String text) {
		c = Math.abs(c);
		return caesar(text);
	}

	public String decrypt(String text) {
		c = -c;
		return caesar(text);
	}
	
	String caesar(String text) {
		String ausgabe = "";
		text = text.toUpperCase();
		char[] textArray = text.toCharArray();
		for(char ch: textArray){
			ch = (char) (ch - 65);
			ch = (char) ((ch + c +26) % 26);	// weil Java kein Modulo bei negativen Zahlen rechnen kann
			ch = (char) (ch + 65);
			ausgabe = ausgabe + ch;
		}
		return ausgabe;
	}
}
