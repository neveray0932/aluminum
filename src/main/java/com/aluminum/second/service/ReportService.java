package com.aluminum.second.service;


import java.io.File;
import java.io.InputStream;

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

import com.aluminum.second.domain.ReportDetailJoinAll;
import com.aluminum.second.repository.CustomerRepository;
import com.aluminum.second.repository.WebReportRepository;



import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class ReportService {

	
	@Autowired
	private ReportDetailService reportDetailService;
	@Autowired
	private WebReportRepository webReportRepository;
	
	

	public ResponseEntity<byte[]> exportReport(String reportFormat, String reportid, String company) throws Exception {
		ByteArrayOutputStream oStream = new ByteArrayOutputStream();
		HttpHeaders headers = new HttpHeaders();
//		JRAbstractExporter exporter = null;
		
		//設定輸出路徑
		String path = "C:\\jasperReport";
		
		
		List<ReportDetailJoinAll> result = reportDetailService.ReportDetailJoinAll(reportid);
		
		if(webReportRepository.existsById(reportid)) {
			if(!result.isEmpty()) {
			// Load file and compile
//			File file = ResourceUtils.getFile("classpath:report2.jrxml");
			
			
			//打包成war檔時，才可辨識的路徑
			InputStream is =ReportService.class.getClassLoader().getResourceAsStream("static/excel/report2.jrxml");
			System.out.println(is);
//			
//			String test =ReportService.class.getClassLoader().getResource("report2.jrxml").getPath();
			
			
		
			
//			File pdf = File.createTempFile("output.", ".pdf");
//			JasperDesign jasperDesign;
//			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			
			//透過compileReport輸出stream
			JasperReport jasperReport = JasperCompileManager.compileReport(is);
			//讀取資料庫欄位
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(result);
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("Parameter1", company);
			//生成report條件
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
			//辨識是否為html，if true 及輸出html檔
			if (reportFormat.equalsIgnoreCase("html")) {
				String downloadFileName = UUID.randomUUID().toString() + ".html";
				downloadFileName = new String(downloadFileName.getBytes("UTF-8"), "ISO-8859-1");
				headers.setContentDispositionFormData("attachment", downloadFileName);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\"+downloadFileName);
//				JasperExportManager.exportReportToPdfStream(jasperPrint, oStream);
				
			}
			//辨識是否為pdf，if true 及輸出pdf檔
			if (reportFormat.equalsIgnoreCase("pdf")) {
				//生成隨機UUID碼
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
