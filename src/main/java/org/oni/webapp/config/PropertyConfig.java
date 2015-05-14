package org.oni.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * property source
 * @author DungTV11
 *
 */
@Configuration
@PropertySource("classpath:config.properties")
public class PropertyConfig {
	
    @Bean
    public PropertySourcesPlaceholderConfigurer propertyConfigurer() {
    	PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
    	propertyPlaceholderConfigurer.setLocations(new Resource[]{new ClassPathResource("config.properties")});
    	propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true); // The need for those first if you want to load  more than 1 property sources place holder.
    	return propertyPlaceholderConfigurer;
    }
    
   
}
