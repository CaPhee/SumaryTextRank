package dtu.str.main;

import dtu.str.summary.Summarizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//		String fileName = "resources/XH26.txt";
        String fileName = "resources/caykhe.txt";
        String text = "";
        String line;
        try (BufferedReader buff = new BufferedReader(new FileReader(fileName))) {
            while ((line = buff.readLine()) != null) {
                text += line + " ";
            }
        } catch (Exception e) {
        }
        System.out.println("Nội dung tóm tắt: \n" + new Summarizer(text, 10, 60).getSummary());
        System.out.println("END!");
        System.exit(0);
    }
}
