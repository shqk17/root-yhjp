package com.yhjp.common.PDFUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FtlUtil {
    private static final Logger logger = LoggerFactory.getLogger(FtlUtil.class);

    public static Template getTemplateFTL(String tempName) throws Exception {
//       URL ur = FtlUtil.class.getClassLoader().getResource("../../WEB-INF/ftl");
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        String templatePath = FtlUtil.class.getResource("/../ftl/").getPath();
        logger.info("FreemarkerUtil template  = " + tempName);
        logger.debug("templatePath = " + templatePath);
        cfg.setDirectoryForTemplateLoading(new File(templatePath));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        return cfg.getTemplate(tempName);
    }

    public static String getTempHtml(Map root, Template temp) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        temp.process(root, stringWriter);
        return stringWriter.toString();
    }
}
