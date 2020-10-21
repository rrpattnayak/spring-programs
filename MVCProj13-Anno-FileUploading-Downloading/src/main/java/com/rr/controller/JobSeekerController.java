package com.rr.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rr.model.JobSeekerInfo;
import com.rr.service.FileMgmtService;

@Controller
public class JobSeekerController {
	
	@Autowired
	private ServletContext sc;
	
	@Autowired
	private FileMgmtService service;
	
	@GetMapping("/upload")
	public String showUploadForm(@ModelAttribute("jsFrm") JobSeekerInfo info) {
		return "jobseeker_form";
	}
	
	@PostMapping("/upload")
	public String uploadFiles(Map<String,Object> map,@ModelAttribute("jsFrm") JobSeekerInfo info) throws Exception  {
		//get upload folder location from the context param of web.xml
		String folderLocation=sc.getInitParameter("uploadStore");
		//check whether that file is available or not, if not then create a new folder
		File file=new File(folderLocation); //makes e:store as file object
		if(!file.exists())  
			file.mkdir();
		//get uploaded file names
		String resumeFileName=info.getResume().getOriginalFilename();
		String photoFileName=info.getPhoto().getOriginalFilename();
		//create input streams pointing to uploaded file content
		InputStream resumeIS=info.getResume().getInputStream();
		InputStream photoIS=info.getPhoto().getInputStream();
		//create output stream pointing to empty destination files
		OutputStream resumeOS=new FileOutputStream(folderLocation+"/"+ resumeFileName);
		OutputStream photoOS=new FileOutputStream(folderLocation+"/"+ photoFileName);
		//copy uploaded file content to destination file
		IOUtils.copy(resumeIS, resumeOS);
		IOUtils.copy(photoIS, photoOS);
		//keep the name of the uploaded files as model attributes
		map.put("resumeFileName", resumeFileName);
		map.put("photoFileName", photoFileName);
		//close stream 
		resumeOS.close();
		resumeIS.close();
		photoOS.close();
		photoIS.close();
		//return lvn
		return "upload_success";
	}
	
	@GetMapping("/list_files")
	public String showAllFiles(Map<String,Object> map) {
		//get uploadstore folder name from web.xml file as context parama value
		String uploadStore=sc.getInitParameter("uploadStore");
		//use service
		List<String> filesList=service.fetchAllFiles(uploadStore);
		//keep results in model attribute
		map.put("filesList", filesList);
		return "show_files";
	}
	
	@GetMapping("/download")
	public String downloadFile(@RequestParam("fname") String fileName,HttpServletResponse res) throws Exception {
		//get path of download file
		String filePath=sc.getInitParameter("uploadStore")+"/"+fileName;
		//create file object pointing to the file to be downloaded
		File file=new File(filePath);
		//set file length as response content length
		res.setContentLengthLong(file.length());
		//set mime type of the file and make it as response content type
		String mimeType=sc.getMimeType(filePath);
		res.setContentType(mimeType==null?"application/octet-stream":mimeType);
		//create InputStream pointing to the flle to be downloaded
		InputStream is=new FileInputStream(filePath);
		//create OutputStream pointing  response obj
		OutputStream os=res.getOutputStream();
		//Give instruction to browser to make the recived content as downloadable 
		res.addHeader("Content-Disposition","attachment;fileName="+fileName);
		//copy file content to response obj
		IOUtils.copy(is, os);
		return null;
	}
}
