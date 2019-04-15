package com.yhjp.common.PDFUtils;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class htmlToPDF {

    public static void main(String[] args) {

//        FileOutputStream os = null;
//        try {
//            File file = new File(storagePath);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            os = new FileOutputStream(file);
//
//            ITextRenderer renderer = new ITextRenderer();
//            //解决中文支持问题
//            ITextFontResolver resolver = renderer.getFontResolver();
//            resolver.addFont("/static/font/SourceHanSerifSC-Medium.otf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//            renderer.setDocumentFromString(content);
//            // 解决图片的相对路径问题,图片路径必须以file开头
//            // renderer.getSharedContext().setBaseURL("file:/");
//            renderer.layout();
//            renderer.createPDF(os);
//
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (null != os) {
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
