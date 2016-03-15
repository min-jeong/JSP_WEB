package com.ktds.jmj.file.biz;

import com.ktds.jmj.file.dao.FileDAO;
import com.ktds.jmj.file.vo.FileVO;
import com.ktds.jmj.util.web.MultipartHttpServletRequest;
import com.ktds.jmj.util.web.MultipartHttpServletRequest.MultipartFile;

public class FileBiz {
	private FileDAO fileDAO;
	
	public FileBiz() {
		fileDAO = new FileDAO();
	}
	
	/**
	 * file delete
	 */
	public boolean deleteFile ( int articleId ) {
		
		int checkDeleteAction = fileDAO.deleteFile(articleId);
		
		if ( checkDeleteAction > 0 ) {
			return true;
		}
		else{ 
			return false;
		}
		
	}
}
