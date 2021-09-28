package com.aluminum.second.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.aluminum.second.domain.CustomerBean;
import com.aluminum.second.domain.ReportDetailJoinAll;
import com.aluminum.second.repository.CustomerRepository;
import com.aluminum.second.repository.WebReportRepository;

//import net.sf.jasperreports.engine.JRAbstractExporter;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.export.JRPdfExporter;
//import net.sf.jasperreports.engine.export.JRXlsExporter;

//import net.sf.jasperreports.engine.design.JasperDesign;

@Service
public class ReportService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ReportDetailService reportDetailService;
	@Autowired
	WebReportRepository webReportRepository;
	
	

	public ResponseEntity<byte[]> exportReport(String reportFormat, String reportid) throws Exception {
		ByteArrayOutputStream oStream = new ByteArrayOutputStream();
		HttpHeaders headers = new HttpHeaders();
//		JRAbstractExporter exporter = null;
//		String path = "C:\\jasperReport";
		
		List<ReportDetailJoinAll> result = reportDetailService.ReportDetailJoinAll(reportid);
		
		if(webReportRepository.existsById(reportid)) {
			if(!result.isEmpty()) {
			// Load file and compile
//			File file = ResourceUtils.getFile("classpath:report2.jrxml");
			
			
			InputStream is =ReportService.class.getClassLoader().getResourceAsStream("static/excel/report2.jrxml");
			System.out.println(is);
//			BufferedReader br=new BufferedReader(new InputStreamReader(is));  
//	        String s="";  
//	        while((s=br.readLine())!=null)  
//	            System.out.println(s); 
//			String test =ReportService.class.getClassLoader().getResource("report2.jrxml").getPath();
			
			
		
			
//			File pdf = File.createTempFile("output.", ".pdf");
//			JasperDesign jasperDesign;
//			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			JasperReport jasperReport = JasperCompileManager.compileReport(is);
			
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(result);
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("createdBy", "Java Customer");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
			if (reportFormat.equalsIgnoreCase("html")) {
				String downloadFileName = UUID.randomUUID().toString() + ".html";
				downloadFileName = new String(downloadFileName.getBytes("UTF-8"), "ISO-8859-1");
				headers.setContentDispositionFormData("attachment", downloadFileName);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//				JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\customer.html");
				JasperExportManager.exportReportToPdfStream(jasperPrint, oStream);
				
			}
			if (reportFormat.equalsIgnoreCase("pdf")) {
				String downloadFileName = UUID.randomUUID().toString() + ".pdf";
				downloadFileName = new String(downloadFileName.getBytes("UTF-8"), "ISO-8859-1");
				headers.setContentDispositionFormData("attachment", downloadFileName);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//				JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\customer.pdf");
				JasperExportManager.exportReportToPdfStream(jasperPrint, oStream);
			}
		}
		}
		
		


		return new ResponseEntity<byte[]>(oStream.toByteArray(), headers, HttpStatus.CREATED);

	}
}
