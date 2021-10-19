package com.aluminum.second;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;

public class Report {

	/**
	 * 下載excel
	 *
	 * @author Wu JiaXin
	 * @date 2018年12月6日
	 * @param sourcePath	模板路徑
	 * @param beanParams	excel內容
	 * @return
	 * @throws ParsePropertyException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public static ResponseEntity<byte[]> downLoadExcel(String sourcePath, Map<String, Object> beanParams)
			throws ParsePropertyException, InvalidFormatException, IOException {
	ByteArrayOutputStream os = new ByteArrayOutputStream();
	//讀取模板
	InputStream is =Report.class.getClassLoader().getResourceAsStream(sourcePath);
	System.out.println(is);
	XLSTransformer transformer = new XLSTransformer();
	//向模板中寫入內容
	Workbook workbook = transformer.transformXLS(is, beanParams);
	
	//寫入成功後轉化爲輸出流
	workbook.write(os);
	//配置Response信息
	HttpHeaders headers = new HttpHeaders();
	String downloadFileName = UUID.randomUUID().toString() + ".xls";
	//防止中文名亂碼
	downloadFileName = new String(downloadFileName.getBytes("UTF-8"), "ISO-8859-1");
	headers.setContentDispositionFormData("attachment", downloadFileName);
	headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	//返回
	return new ResponseEntity<byte[]>(os.toByteArray(), headers, HttpStatus.CREATED);
}
}