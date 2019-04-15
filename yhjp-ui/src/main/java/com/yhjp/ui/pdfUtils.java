package com.yhjp.ui;

import com.lowagie.text.DocumentException;
import com.yhjp.common.PDFUtils.PdfHelper;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/pdftest")
public class pdfUtils {

    public static void main(String[] args) {
        try {
            Map<Object, Object> o=new HashMap<Object, Object>();
            o.put("name", "http://www.xdemo.org/");
            String path= PdfHelper.getPath();
            generateToFile(path, "WEB-INF/ftl/test.ftl",path+"static/images/", o, "D:\\xdemo.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/bb")
    public  String index1(Model model, ModelMap map){
        System.out.println("say hi ……");

        map.put("name", "kimi");
        return  "index.ftl";
    }
    /**
     * 生成PDF到文件
     * @param ftlPath 模板文件路径（不含文件名）
     * @param ftlName 模板文件吗（不含路径）
     * @param imageDiskPath 图片的磁盘路径
     * @param data 数据
     * @param outputFile 目标文件（全路径名称）
     * @throws Exception
     */
    public static void generateToFile(String ftlPath,String ftlName,String imageDiskPath,Object data,String outputFile) throws Exception {
        String html=PdfHelper.getPdfContent(ftlPath, ftlName, data);
        OutputStream out = null;
        ITextRenderer render = null;
        out = new FileOutputStream(outputFile);
        render = PdfHelper.getRender();
        render.setDocumentFromString(html);
        if(imageDiskPath!=null&&!imageDiskPath.equals("")){
//html中如果有图片，图片的路径则使用这里设置的路径的相对路径，这个是作为根路径
            render.getSharedContext().setBaseURL("file:/"+imageDiskPath);
        }
        render.layout();
        render.createPDF(out);
        render.finishPDF();
        render = null;
        out.close();
    }
    /**
     * 生成PDF到输出流中（ServletOutputStream用于下载PDF）
     * @param ftlPath ftl模板文件的路径（不含文件名）
     * @param ftlName ftl模板文件的名称（不含路径）
     * @param imageDiskPath 如果PDF中要求图片，那么需要传入图片所在位置的磁盘路径
     * @param data 输入到FTL中的数据
     * @param response HttpServletResponse
     * @return
     * @throws TemplateNotFoundException
     * @throws MalformedTemplateNameException
     * @throws ParseException
     * @throws IOException
     * @throws TemplateException
     * @throws DocumentException
     */
    public static OutputStream generateToServletOutputStream(String ftlPath, String ftlName, String imageDiskPath, Object data, HttpServletResponse response) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException, DocumentException {
        String html=PdfHelper.getPdfContent(ftlPath, ftlName, data);
        OutputStream out = null;
        ITextRenderer render = null;
        out = response.getOutputStream();
        render = PdfHelper.getRender();
        render.setDocumentFromString(html);
        if(imageDiskPath!=null&&!imageDiskPath.equals("")){
//html中如果有图片，图片的路径则使用这里设置的路径的相对路径，这个是作为根路径
            render.getSharedContext().setBaseURL("file:/"+imageDiskPath);
        }
        render.layout();
        render.createPDF(out);
        render.finishPDF();
        render = null;
        return out;
    }
}