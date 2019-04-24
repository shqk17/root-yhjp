package com.yhjp.ui;

import com.lowagie.text.pdf.BaseFont;
import com.yhjp.bean.ReasultBean;
import com.yhjp.common.PDFUtils.FtlUtil;
import com.yhjp.common.PDFUtils.PdfHelper;
import com.yhjp.service.TestService;
import freemarker.template.Template;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/ee")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/getData")
    @ResponseBody
    public ReasultBean<String> getData(Model model) {
        String result = testService.getTestData();
        return new ReasultBean<>(true, "查询成功", result);
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
    @RequestMapping(value = "/savePdfV3", method = RequestMethod.POST)
    public void savePdfV3(HttpServletRequest request, HttpServletResponse response){
        try {
            Template temp= FtlUtil.getTemplateFTL("test.ftl");
            Map root = new HashMap();
            root.put("name", "Big Joe");
            root.put("names", Arrays.asList("ss","bb"));
            String html = FtlUtil.getTempHtml(root,temp);

//            PdfUtil.getPdfContent()
            System.out.println(html);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @ResponseBody
    @RequestMapping(value = "/savePdfV4", method = RequestMethod.GET)
    public void savePdfV4(HttpServletRequest request, HttpServletResponse response){
        try {
            String fileName = "测试PDF111";

            Map<Object, Object> o=new HashMap<Object, Object>();
            o.put("name", "sdsd");
            String path= PdfHelper.getPath();
            String  ftlPath=path + "ftl";
            String ftlName= "test.ftl";
            //搭载模板
            String html=PdfHelper.getPdfContent(ftlPath, ftlName, o);
            Document doc = Jsoup.parse(html, "UTF-8");
            org.jsoup.helper.W3CDom w3cDom = new W3CDom();
            org.w3c.dom.Document xhtmlContent = w3cDom.fromJsoup(doc);
            ITextRenderer renderer = null;
            //获取PDF
            renderer = PdfHelper.getRender();
            renderer.setDocument(xhtmlContent, "");
//
//            if(imageDiskPath!=null&&!imageDiskPath.equals("")){
//                //html中如果有图片，图片的路径则使用这里设置的路径的相对路径，这个是作为根路径
//                renderer.getSharedContext().setBaseURL("file:/"+imageDiskPath);
//            }

            renderer.layout();
            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1"); // firefox浏览器
            } else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                fileName = URLEncoder.encode(fileName, "UTF-8");// IE浏览器
            } else if (request.getHeader("User-Agent").toUpperCase().indexOf("CHROME") > 0) {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// 谷歌
            }
            ServletOutputStream sos = null;
            response.setContentType("application/pdf;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + ".pdf" + "\"");
            sos = response.getOutputStream();
            renderer.createPDF(sos);
            renderer.finishPDF();
            renderer = null;
            sos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/savePdfV2", method = RequestMethod.GET)
    public void savePdfV2(Model model, @RequestBody String allHtml, HttpServletRequest request, HttpServletResponse response) {
        String fileName = "测试PDF111";
        String body = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n" +
                "\"http://www.w3.org/TR/html4/loose.dtd\">" +
                "<html>"
                + allHtml + "</html>";
        try {
            Document doc = Jsoup.parse(body, "UTF-8");
            org.jsoup.helper.W3CDom w3cDom = new W3CDom();
            org.w3c.dom.Document xhtmlContent = w3cDom.fromJsoup(doc);
            ServletOutputStream sos = null;
            ITextRenderer renderer = new ITextRenderer();
//            Rectangle rectangle = new Rectangle();
//            rectangle.add(420, 297);
            ITextFontResolver fontResolver = (ITextFontResolver) renderer
                    .getSharedContext().getFontResolver();
            URL ur = TestController.class.getClassLoader().getResource("../../WEB-INF/static/font");
//            renderer.getSharedContext().setBaseURL("file://"+Thread.currentThread()
//                    .getContextClassLoader().getResource("//").getPath());
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
            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1"); // firefox浏览器
            } else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                fileName = URLEncoder.encode(fileName, "UTF-8");// IE浏览器
            } else if (request.getHeader("User-Agent").toUpperCase().indexOf("CHROME") > 0) {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// 谷歌
            }
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
