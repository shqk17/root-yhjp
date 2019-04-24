package com.yhjp.common.PDFUtils;

import com.lowagie.text.pdf.BaseFont;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.awt.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.Locale;

public class PdfHelper {

    public static ITextRenderer getRender() throws  Exception {
        ITextRenderer render = new ITextRenderer();
        Rectangle rectangle = new Rectangle();
        rectangle.add(420, 297);
        ITextFontResolver fontResolver = (ITextFontResolver) render
                .getSharedContext().getFontResolver();
        String path = getPath();

        URL ur = PdfHelper.class.getClassLoader().getResource("../../WEB-INF/static/font");
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
        return render;
    }
    //获取要写入PDF的内容
    public static String getPdfContent(String ftlPath, String ftlName, Object o) throws  IOException, TemplateException {
        return useTemplate(ftlPath, ftlName, o);
    }
    //使用freemarker得到html内容
    public static String useTemplate(String ftlPath, String ftlName, Object o) throws  IOException, TemplateException {
        String html = null;
        Template tpl = getFreemarkerConfig(ftlPath).getTemplate(ftlName,"UTF-8");
        StringWriter writer = new StringWriter();
        tpl.process(o, writer);
        writer.flush();
        html = writer.toString();
        return html;
    }
    /**
     * 获取Freemarker配置
     * @param templatePath
     * @return
     * @throws IOException
     */
    private static Configuration getFreemarkerConfig(String templatePath) throws IOException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_27);
        config.setDirectoryForTemplateLoading(new File(templatePath));
        config.setDefaultEncoding("UTF-8");
        config.setLogTemplateExceptions(false);
        config.setWrapUncheckedExceptions(true);
        return config;
    }
    /**
     * 获取类路径
     * @return
     */
    public static String getPath(){
        return PdfHelper.class.getResource("/../").getPath();
    }
}
