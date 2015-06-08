package au.org.massive.oauth2_hpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

/**
 * Main application entrypoint
 * @author jrigby
 *
 */
@SpringBootApplication
public class ApplicationEntrypoint {
	
	private static Settings settings = Settings.getInstance();

	/**
	 * Starts the inbuilt Tomcat server
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApplicationEntrypoint.class, args);
	}
	
	/**
	 * Sets the Tomcat server port / protocol according to the configuration file
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerFactory tomcat() {
	    TomcatEmbeddedServletContainerFactory myFactory = new TomcatEmbeddedServletContainerFactory();
	    myFactory.setProtocol(settings.getTomcatProtocol());
	    myFactory.setPort(settings.getTomcatPort());
	    return myFactory;
	}
	
}