package com.yhjp.ui;

import com.lowagie.text.pdf.BaseFont;
import org.dom4j.io.HTMLWriter;
import org.dom4j.io.OutputFormat;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.simple.PDFRenderer;
import org.xml.sax.InputSource;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FilenameFilter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/ee")
    public String index(Model model) {
        return "index";
    }
    @RequestMapping("/bb")
    public String index1(Model model, ModelMap map) {
        System.out.println("say hi ……");

        map.put("name", "kimi");
        return "index.ftl";
    }
    @RequestMapping("/indexs")
    public String indexs(Model model, ModelMap map) {
        return "indexs.ftl";
    }

    @ResponseBody
    @RequestMapping(value = "/savePdfV2", method = RequestMethod.POST)
    public void savePdfV2(Model model, @RequestBody String allHtml, HttpServletRequest request, HttpServletResponse response) {
        String fileName = "测试PDF111";
        String body ="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n" +
                "\"http://www.w3.org/TR/html4/loose.dtd\">"+
                "<html>"
                + allHtml + "</body></html>";
        try {
            Document doc = Jsoup.parse(body,"UTF-8");
            org.jsoup.helper.W3CDom w3cDom = new W3CDom();
            org.w3c.dom.Document xhtmlContent = w3cDom.fromJsoup(doc);
            ServletOutputStream sos = null;
            ITextRenderer renderer = new ITextRenderer();
            ITextFontResolver fontResolver = (ITextFontResolver) renderer
                    .getSharedContext().getFontResolver();
            URL ur = TestController.class.getClassLoader().getResource("../../WEB-INF/static/font");
            File f = new File(ur.toURI());
            if (f.isDirectory()) {
                File[] files = f.listFiles(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        String lower = name.toLowerCase();
                        return lower.endsWith(".otf") || lower.endsWith(".ttf") || lower.endsWith(".ttc");
                    }
                });
                for (int i = 0; i < files.length; i++) {
                    fontResolver.addFont(files[i].getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
                }
            }
            renderer.setDocument(xhtmlContent, "");
            renderer.layout();
            response.setContentType("application/pdf;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + ".pdf" + "\"");
            sos = response.getOutputStream();
            renderer.createPDF(sos);
            renderer.finishPDF();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
