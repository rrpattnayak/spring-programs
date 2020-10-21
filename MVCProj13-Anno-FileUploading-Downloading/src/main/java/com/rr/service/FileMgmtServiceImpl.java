package com.rr.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("fileMgmtService")
public class FileMgmtServiceImpl implements FileMgmtService {

	public List<String> fetchAllFiles(String uploadStore) {
		//create file object representing uploadStore folder
		File fileStore=new File(uploadStore);
		//get all files and sub folders of uploadStore
		File content[]=fileStore.listFiles();
		List<String> fileNamesList=new ArrayList<String>();
		for(File f:content)
			if(f.isFile())
				fileNamesList.add(f.getName());
		return fileNamesList;
	}
}
