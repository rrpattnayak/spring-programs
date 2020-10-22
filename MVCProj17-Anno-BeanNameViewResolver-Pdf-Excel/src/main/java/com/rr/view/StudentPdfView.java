package com.rr.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.rr.dto.StudentDTO;

@Component("pdfview")
public class StudentPdfView extends AbstractPdfView{
	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, 
			PdfWriter writer,HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<StudentDTO> listDTO=null;
		Paragraph para=null;
		listDTO=(List<StudentDTO>) model.get("studentsInfo");
		//create and add paragraph
		para=new Paragraph("Student Details Report",new Font(Font.HELVETICA,26,Font.BOLDITALIC));
		document.add(para);
		
		//add table
		Table t=new Table(4,listDTO.size());  // cols ,rows
		//add col names..
		t.addCell("sno"); t.addCell("sname"); t.addCell("sadd"); t.addCell("avg");
		for(StudentDTO dto:listDTO){
			t.addCell(String.valueOf(dto.getSno()));
			t.addCell(dto.getSname());
			t.addCell(dto.getSadd());
			t.addCell(String.valueOf(dto.getSavg()));
		}
	  document.add(t);
	}
}
