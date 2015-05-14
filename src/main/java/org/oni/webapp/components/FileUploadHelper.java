package org.oni.webapp.components;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.oni.webapp.constants.Constants;
import org.oni.webapp.exception.ErrorType;
import org.oni.webapp.exception.OniException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	@Autowired
	private ServletContext servletContext;
		
	public String upload(MultipartFile file) {
		if (servletContext == null) throw new OniException(ErrorType.UNKNOW_ERROR);
		if (file != null && file.getSize() >0) {
			String fileName = file.getOriginalFilename();			
            String extension = fileName.substring(fileName.lastIndexOf("."));
            StringBuilder sb = new StringBuilder();
            String namfile = UUID.randomUUID().toString();
            sb.append(namfile).append(extension);
            String uploadUrl = sb.toString();
            String filePath = servletContext.getRealPath("/")+Constants.IMAGES_PATH_UPLOAD;
            File obj = new File(filePath + uploadUrl);
            if (!obj.exists()) {
                FileOutputStream fos = null;
                ByteArrayInputStream bis = null;
                try {
                    fos = new FileOutputStream(obj);
                    bis = new ByteArrayInputStream(IOUtils.toByteArray(file.getInputStream()));
                    int i;
                    while ((i = bis.read()) != -1) {
                        fos.write(i);
                    }
                    fos.flush();
                    fos.close();                                    
                    return uploadUrl;
                }catch (Exception e) {          
                    e.printStackTrace();
                } finally {
                    if (bis != null)
                    try {
                        bis.close();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                    if (fos != null)
                    try {
                        fos.close();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }    
        }
		return null;
	}
}
