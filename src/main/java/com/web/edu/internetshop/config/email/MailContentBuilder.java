package com.web.edu.internetshop.config.email;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

@Service
public class MailContentBuilder {
    @Autowired
    @Qualifier("freemarkerConf")
    private Configuration freemarkerConfiguration;

    private static String processTemplate(Map model, String template)
            throws IOException, TemplateException {
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setDefaultEncoding("UTF-8");
        Template t = new Template("TemplateFromDBName", template, bean.getObject());
        Writer out = new StringWriter();
        t.process(model, out);
        return out.toString();
    }

    public String getFreeMarkerTemplateContent(String templateName, Map<String, Object> model) {
        StringBuilder content = new StringBuilder();
        try {
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(
                    freemarkerConfiguration.getTemplate(templateName), model));
            return content.toString();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getTemplate(String template, Map<String, Object> model) throws IOException, TemplateException {
        return processTemplate(model, template);
    }

}