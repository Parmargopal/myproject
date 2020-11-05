package com.prominentpixel;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfReader {
    public static void main(String[] args) throws IOException {
        File file=new File("/home/pp-5/Documents/a.pdf");
        PDDocument doc = PDDocument.load(file);
        PDFTextStripper textStripper=new PDFTextStripper();
        String string=textStripper.getText(doc);
        System.out.println(string);
        doc.close();
    }
}
