package org.oni.webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


/**
 * Spring configuration file of system 
 * @author DungTV
 *
 */
@ImportResource({
     "classpath:applicationContext.xml"    
    ,"classpath:applicationContext-webmvc.xml"
    ,"classpath:applicationContext-security.xml"
})
@Import({
    PropertyConfig.class
   })
@Configuration
public class SpringConfig{
}
