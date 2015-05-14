/**
 * 
 */
package org.oni.webapp.exception;


/**
 * This is Exception class of application
 * @author DungTV
 *
 */
public final class OniException extends RuntimeException{

	private static final long serialVersionUID = 7271650122596112103L;
	
	private static final int MAX_PARAMS = 5;
	@SuppressWarnings("unused")
	private final ErrorType errorType;
	private final String[] params = new String[MAX_PARAMS];
	
	public OniException(ErrorType errorType) {
		this(errorType, null, "");
	}
	
	public OniException(ErrorType errorType, Throwable th) {
        this(errorType, th, "");
    }
	
	public OniException(ErrorType errorType, Throwable th, String... params) {
		super();
		this.errorType = errorType;
		for (int i = 0; i < MAX_PARAMS; i++) {
            if (params != null && i < params.length) {
                this.params[i] = (params[i] != null ? new String(params[i]) : null);
            } else {
                this.params[i] = "";
            }
        }
	}
}
