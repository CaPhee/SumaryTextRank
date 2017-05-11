package dtu.str.unit;


public class SentenceTokenizer {

    /*
    public static void main(String[] args) {

    }
    */


    private static final String JVN_SEN_SEGMENT = "models/jvnsensegmenter";
    private static final String JVN_SEGMENT = "models/jvnsegmenter";

    private static jvntextpro.JVnTextPro jvnTextPro;

    public static jvntextpro.JVnTextPro getJvnTextPro(){
        if(jvnTextPro == null){
            try {
                jvnTextPro = new jvntextpro.JVnTextPro();
                jvnTextPro.initSenSegmenter(JVN_SEN_SEGMENT);
                jvnTextPro.initSenTokenization();
                jvnTextPro.initSegmenter(JVN_SEGMENT);
            } catch (Exception e) {
                System.exit(0);
            }
        }
        return jvnTextPro;
    }

    /**
     * only use static method
     */
    private SentenceTokenizer(){

    }
}
