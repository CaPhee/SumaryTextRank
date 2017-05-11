package dtu.str.unit;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class SentenceDetector {

    /*
    public static void main(String[] args) throws FileNotFoundException {

        SentenceDetectorME sentenceDetector = getSentenceDetector();
        String sentences[] = sentenceDetector.sentDetect(" Công bố kết quả sáng 31/3 sau nửa buổi làm việc, Trưởng ban kiểm phiếu Huỳnh Văn Tý cho biết có 472 đại biểu (95%) tán thành bà Nguyễn Thị Kim Ngân làm Chủ tịch Quốc hội, thay thế ông Nguyễn Sinh Hùng vừa thôi chức chiều qua. Trong 484 đại biểu bỏ phiếu thì có 9 người không đồng tình, 3 phiếu không hợp lệ. ");

        System.out.println("RES");
        for (String sent : sentences) {
            System.out.println("Sent: " + sent);
        }

    }
    */

    private static final String EN_SENT_MODEL = "models/en-sent.bin";

    private static SentenceDetectorME sentenceDetector = null;

    public static SentenceDetectorME getSentenceDetector() {
        if (sentenceDetector == null) {
            InputStream modelIn = null;
            try {
                modelIn = new FileInputStream(EN_SENT_MODEL);
                SentenceModel model = new SentenceModel(modelIn);
                sentenceDetector = new SentenceDetectorME(model);
            } catch (IOException e) {
            } finally {
                if (modelIn != null) {
                    try {
                        modelIn.close();
                    } catch (IOException e) {
                    }
                }
            }

        }
        return sentenceDetector;
    }

    /**
     * only use static method
     */
    private SentenceDetector(){

    }
}