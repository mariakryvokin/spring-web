package app.config;

import app.config.viewresolvers.JsonViewResolver;
import app.config.viewresolvers.PdfViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ViewConfig {

    @Bean
    public FreeMarkerViewResolver freemarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        //resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        resolver.setOrder(Integer.MIN_VALUE);
        return resolver;
    }

    @Bean
    public ViewResolver internalViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setOrder(Integer.MAX_VALUE);
        return resolver;
    }

   /* @Bean
    public ViewResolver xmlViewResolver() {
        XmlViewResolver resolver = new XmlViewResolver();
        resolver.setLocation(new ClassPathResource("views.xml"));
        resolver.setOrder(Integer.MAX_VALUE-1);
        return resolver;
    }*/

    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/templates/");
        return freeMarkerConfigurer;
    }

    @Bean
    public ViewResolver pdfViewResolver() {
        return new PdfViewResolver();
    }

    @Bean
    public ViewResolver jsonViewResolver(){
        return new JsonViewResolver();
    }

    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        Map<String, MediaType> mediaTypeMap = new HashMap<>();
        mediaTypeMap.put(".pdf", MediaType.APPLICATION_PDF);
        configurer.mediaTypes(mediaTypeMap);
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        List< ViewResolver > resolvers = new ArrayList< ViewResolver >();
        resolvers.add(pdfViewResolver());
        resolvers.add(jsonViewResolver());
        resolver.setViewResolvers(resolvers);
        return resolver;
    }
}
