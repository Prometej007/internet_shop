package com.web.edu.internetshop.service.impl;

import com.web.edu.internetshop.config.email.MailContentBuilder;
import com.web.edu.internetshop.model.User;
import com.web.edu.internetshop.model.buy.Bin;
import com.web.edu.internetshop.model.product.Product;
import com.web.edu.internetshop.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.web.edu.internetshop.dto.utils.builder.Builder.map;


@Service
public class MailServiceImpl implements MailService {


    @Value("${server.url}")
    private String urlServer;

    @Value("${client.url}")
    private String urlClient;

    @Value("${login.confirm.url}")
    private String loginConfirmUrl;

    @Value("${reset.password.confirm.url}")
    private String resetPasswordConfirmUrl;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailContentBuilder mailContentBuilder;


    @Override
    public User sendConfirmRegistration(User user) {
        send(user.getEmail(), "підтвердження реєстрації", "confirm.registration.html", new BuilderMap().put("user", user).build());
        return user;
    }

    @Override
    public User sendAutoRegistration(User user, String password) {
        send(user.getEmail(), "автоматична реєстрації", "auto.registration.html",
                new BuilderMap()
                        .put("user", user)
                        .put("password", password)
                        .build());
        return user;
    }

    @Override
    public Bin sendInfoNewBinStatus(Bin bin) {
        send(bin.getUser().getEmail(), "у вашого замовлення новий статус", "auto.registration.html",
                new BuilderMap()
                        .put("bin", bin)
                        .build());
        return bin;
    }

    private void send(String mail, String title, String template, Map<String, Object> model) {
        mailSender.send(mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
            messageHelper.setTo(mail);
            messageHelper.setSubject(title);
            messageHelper.setText(mailContentBuilder.getTemplate(template, model), true);
        });
    }


    private class BuilderMap {
        private List<Entry> entries = new ArrayList<>();

        private BuilderMap() {
            this.put("urlClient", urlClient);
            this.put("urlServer", urlServer);
            this.put("loginConfirmUrl", loginConfirmUrl);
            this.put("resetPasswordConfirmUrl", resetPasswordConfirmUrl);
        }

        private BuilderMap put(String s, Object o) {
            entries.add(new Entry().setValue(o).setKey(s));
            return this;
        }

        private Map<String, Object> build() {
            Map<String, Object> map = new HashMap<>();
            for (Entry o1 :
                    entries) {
                map.put(o1.key, o1.value);
            }
            return map;
        }

        private class Entry {
            private String key;
            private Object value;

            public String getKey() {
                return key;
            }

            public Entry setKey(String key) {
                this.key = key;
                return this;
            }

            public Object getValue() {
                return value;
            }

            public Entry setValue(Object value) {
                this.value = value;
                return this;
            }
        }

    }
}
