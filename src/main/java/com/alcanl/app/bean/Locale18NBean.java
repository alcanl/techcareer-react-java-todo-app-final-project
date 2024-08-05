package com.alcanl.app.bean;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Log4j2
@Configuration
public class Locale18NBean extends AcceptHeaderLocaleResolver {

    public void locale18NBeforeBeanMethod()
    {
        log.info("swagger Open Api Before Bean başladı");
        System.out.println("swagger Open Api Before Bean başladı");
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptorBean() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("tr");
        return interceptor;
    }

    List<Locale> localeList = Arrays.asList(new Locale("tr"), new Locale("en"), new Locale("ge"));

    @Override
    public Locale resolveLocale(HttpServletRequest request)
    {
        List<Locale.LanguageRange> list = Locale.LanguageRange.parse(request.getHeader("Accept-Language"));
        //org.springframework.util.StringUtils;
        if (StringUtils.isEmpty(request.getHeader("Accept-Language"))) {
            return Locale.getDefault();
        }
        Locale locale = Locale.lookup(list, localeList);
        return locale;
    }

    public void locale18NAfterBeanMethod() {
        log.info("locale 18N After Bean Method bitti");
        System.out.println("locale 18N After Bean Method bitti");
    }
}
