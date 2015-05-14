
package org.oni.webapp.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.oni.webapp.enumeration.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * This is a class that performs the attributes to session
 * @author DungTV
 */
@Component
public class HttpSessionAccessor {

	@Autowired
	private MessageAccessor messageAccessor;
	private static final String ATTR_NAME_RESULT = "oni_result";
	
	public void addProcessResult(ResultType resultType, String messageCode) {
		String msg = this.messageAccessor.getMessage(messageCode);
		this.addProcessResult(resultType.name(), msg);
	}
	
	public void addProcessResult(ResultType resultType, String messageCode, String... params) {
		String msg = this.messageAccessor.getMessage(messageCode,params);
		this.addProcessResult(resultType.name(), msg);
	}
	
	public void addProcessResult(String resultType, String message) {
		HttpSession session = getSession();

        @SuppressWarnings("unchecked")
        Map<String, List<String>> results
                = (Map<String, List<String>>) session.getAttribute(ATTR_NAME_RESULT);
        if (results == null) {
            results = new HashMap<String, List<String>>();
        }

        List<String> msgs = results.get(resultType);
        if (msgs == null) {
            msgs = new ArrayList<String>();
        }
        msgs.add(message);
        results.put(resultType, msgs);

        session.setAttribute(ATTR_NAME_RESULT, results);
	}
	
	public void addProcessResults(Map<String, List<String>> results) {
		HttpSession session = getSession();

        @SuppressWarnings("unchecked")
        Map<String, List<String>> sessionResults
                = (Map<String, List<String>>) session.getAttribute(ATTR_NAME_RESULT);
        if (sessionResults == null) {
        	sessionResults = new HashMap<String, List<String>>();
        }
        
        for (Entry<String, List<String>> entry : results.entrySet()) {
        	List<String> msgs = sessionResults.get(entry.getKey());
            if (msgs == null) {
                msgs = new ArrayList<String>();
            }
            msgs.addAll(entry.getValue());
            sessionResults.put(entry.getKey(), msgs);
		}  
        session.setAttribute(ATTR_NAME_RESULT, sessionResults);
	}
	
	private HttpSession getSession() {

        HttpServletRequest request
                = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                        .getRequest();
        return request.getSession();
    }
}
