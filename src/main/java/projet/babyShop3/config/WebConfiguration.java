package projet.babyShop3.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        // Load file: validation.properties
        messageSource.setBasename("classpath:validation");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
	
	  @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        exposeDirectory("imageBabyShop", registry);
	    }
	     
	    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
	        Path uploadDir = Paths.get(dirName);
	        String uploadPath = uploadDir.toFile().getAbsolutePath();
	         
	        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
	         
	        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
	    }

}
