

public class MessageImplementation implements Message {
	
	public int charCount = 0;
	public int digCount = 0;
	public String clientMessage;
	
	@Override
public void setCounts(String userInput) {
	clientMessage = userInput;
	
	for (int i = 0; i < userInput.length(); i++) {
		if (Character.isDigit(userInput.charAt(i))){
			digCount++;  
		}
		if (Character.isLetter(userInput.charAt(i))){
		    charCount++;  
		}
	}
		
	return;
}

	@Override
public int getCharacterCount() {
	return charCount;
}

	@Override
public int getDigitCount() {
	return digCount;
}

	@Override
public String getClientMessage() {
	return clientMessage;
}

}
