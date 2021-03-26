package projet.babyShop3.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:validation");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Path uploadDir = Paths.get("./imageBabyShop");
		String uploadPath = uploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/imageBabyShop/**").addResourceLocations("file:/" + uploadPath + "/");
	}

}
