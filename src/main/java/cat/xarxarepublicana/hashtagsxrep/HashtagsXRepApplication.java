package cat.xarxarepublicana.hashtagsxrep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.Collections;
import java.util.TimeZone;

@SpringBootApplication
public class HashtagsXRepApplication {

	public HashtagsXRepApplication(FreeMarkerConfigurer freeMarkerConfigurer) {
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
		freeMarkerConfigurer.getTaglibFactory().setClasspathTlds(Collections.singletonList("/META-INF/security.tld"));
	}


	public static void main(String[] args) {
		SpringApplication.run(HashtagsXRepApplication.class, args);
	}
}
