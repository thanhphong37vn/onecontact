package org.oni.webapp.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

/**
 * This is the class to get the message resources.
 * @author DungTV
 */
@Component
public class MessageAccessor {

    /** Message source */
	
    @Autowired
    private MessageSource source;

    /** Message source accessor */
    private MessageSourceAccessor accessor;
    
    public void setMessageSource(MessageSource messageSource) {
        this.source = messageSource;
        this.accessor = new MessageSourceAccessor(this.source);
    }

    /**
     * get message 
     * @param code message code
     * @return Message
     */
    public String getMessage(String code) {
        return this.accessor.getMessage(code);
    }

    /**
     * get message 
     * @param code code message code
     * @param params parameter
     * @return Message
     */
    public String getMessage(String code, String... params) {
        return this.accessor.getMessage(code, params);
    }
}
