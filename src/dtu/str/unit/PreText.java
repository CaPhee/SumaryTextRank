package dtu.str.unit;

import jvntextpro.JVnTextPro;
import opennlp.tools.sentdetect.SentenceDetectorME;

public class PreText {

	/**
	 * Only use static method
	 */
	private PreText(){

	}

	public static String[] vnTokenList(String text){
		String[] token_list;
		JVnTextPro jVnTextPro = SentenceTokenizer.getJvnTextPro();
		String tokenize =  jVnTextPro.senTokenize(text);
    	String senWordSegmented = jVnTextPro.wordSegment(tokenize);
    	token_list = senWordSegmented.split(" ");
    	return token_list;
	}

	public static String[] getSentencesVN(String text) {
		SentenceDetectorME detectorME = SentenceDetector.getSentenceDetector();
		return detectorME.sentDetect(text);
	}
	
}
