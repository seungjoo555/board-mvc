package kr.ac.kopo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@ComponentScan(basePackages = {"kr.ac.kopo.controller"})
@EnableWebMvc
@Configuration
public class WebConfig {
	
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("classpath:/templates/"); // 템플릿 파일 경로
		resolver.setSuffix(".html");                 // 파일 확장자
		resolver.setTemplateMode(TemplateMode.HTML); // 템플릿 모드 (HTML5 권장)
		resolver.setCharacterEncoding("UTF-8");      // 인코딩 설정
		resolver.setCacheable(false);                // 개발 시 false, 운영 환경 시 true
        return resolver;
	}
	
	@Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver()); // 앞서 정의한 resolver 등록
        return engine;
    }
	
	@Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine()); // 앞서 정의한 engine 등록
        resolver.setCharacterEncoding("UTF-8");      // 인코딩 설정
        return resolver;
    }
	
}
