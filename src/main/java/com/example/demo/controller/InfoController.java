package com.example.demo.controller;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;



/**
 * @program: demo *
 * @description: *
 * @author: *
 * @create: 2019-06-13 19:38
 **/
@Controller
public class InfoController {
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	@ResponseBody
	public String sayHello(HttpServletResponse response) throws IOException {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new InfoController().createPdf(DEST);
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] bytes = new byte[1024 * 1024];
		OutputStream out = response.getOutputStream();
		response.setContentType("application/octet-stream");
		String fileName = DEST.substring(DEST.lastIndexOf(File.pathSeparator)+1);
		fileName = new String(fileName.getBytes("UTF-8"),"ISO8859-1");
		response.addHeader("Content-Disposition", "attachment;filename="+fileName);
		int length = 0;
		while((length=fileInputStream.read(bytes))!=-1){
			out.write(bytes,0,length);
		}
		out.flush();
		out.close();
		return "asdf";
	}
	
	public static final String DEST = "results/chapter01/hello_world6中文.pdf";
	
	public void createPdf(String dest) throws IOException {
		//Initialize PDF writer
		PdfWriter writer = new PdfWriter(dest);
		
		//Initialize PDF document
		PdfDocument pdf = new PdfDocument(writer);
		
		// Initialize document
		Document document = new Document(pdf);
		//Add paragraph to the document
		PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H", true);
		Paragraph paragraph = new Paragraph("Hello 中文 World!").add("中文语句").setFont(font);
		document.add(paragraph);
		document.close();
	}
}
