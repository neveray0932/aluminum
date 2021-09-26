package com.aluminum.second.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.aluminum.second.Report;

import com.aluminum.second.domain.CustomerBean;
import com.aluminum.second.domain.MaterialBean;
import com.aluminum.second.domain.MaterialCostBean;
import com.aluminum.second.domain.MaterialCostBean.ConfigId;
import com.aluminum.second.domain.MaterialCostJoin;
import com.aluminum.second.domain.MaterialJoinSpec;
import com.aluminum.second.domain.ProductBean;
import com.aluminum.second.domain.ReportDetailBean;
import com.aluminum.second.domain.ReportDetailJoinAll;
import com.aluminum.second.domain.ReportJoin;
//import com.aluminum.second.domain.ProductBean;
import com.aluminum.second.domain.SpecPriceBean;
import com.aluminum.second.domain.SpecnameBean;
import com.aluminum.second.domain.WebReportBean;
//import com.aluminum.second.repository.ClientDao;
import com.aluminum.second.repository.CustomerRepository;
import com.aluminum.second.repository.MaterialCostRepository;
import com.aluminum.second.repository.MaterialRepository;
import com.aluminum.second.repository.ProductRepository;
//import com.aluminum.second.repository.ProductRepository;
import com.aluminum.second.service.CustomerService;
import com.aluminum.second.service.MaterialCostService;
import com.aluminum.second.service.MaterialService;
import com.aluminum.second.service.ProductService;
import com.aluminum.second.service.ReportDetailService;
//import com.aluminum.second.service.ProductService;
import com.aluminum.second.service.ReportService;
import com.aluminum.second.service.SpecnameService;
import com.aluminum.second.service.WebReportService;


@RestController
@RequestMapping(path = { "/public/api" })
public class PublicAPI {

	@Autowired
	private CustomerRepository custdao;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private MaterialService materialService;

	@Autowired
	private MaterialCostService materialCostService;

	@Autowired
	private SpecnameService specnameService;
	
	@Autowired
	private ReportService reportService;
	@Autowired
	private MaterialCostRepository materialCostRepository;
	@Autowired
	private MaterialRepository materialRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private WebReportService webReportService;
	@Autowired
	private ReportDetailService reportDetailService;

//get
//	@GetMapping("/materialcost/join")
//	public List<MaterialJoinSpec> method() {
//		
//		return materialCostRepository.selectJoin();
//	}
	
	@GetMapping("/materialcost/join/{specid}")
	public List<MaterialCostJoin> materialCostJoin(@PathVariable("specid") String specid) {
		
		return materialCostRepository.materialCostJoin(specid);
	}
	
	
//	@GetMapping("/materialcost/{id}")
//	public Optional<MaterialCostBean> id(@PathVariable("id")Integer id) {
//		ConfigId configId = new ConfigId();
//		configId.setMaterialid(id);
//		
//		return materialCostRepository.findById(configId);
//		
//	}
	
	@GetMapping("/materialcost/testupdate")
	public ResponseEntity<MaterialCostBean> test(@RequestBody MaterialCostBean bean) {
		MaterialCostBean result= materialCostService.update(bean);
		return ResponseEntity.ok(result);
	}
	@GetMapping("/materialcost/testupdateall")
	public ResponseEntity<List<MaterialCostBean>> test2(@RequestBody List<MaterialCostBean> bean) {
		List<MaterialCostBean> result= materialCostService.updateAll(bean);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/materialcost/{id1}/{id2}")
	public ResponseEntity<?> id(@PathVariable("id1")String id1,@PathVariable("id2")String id2) {
//		ConfigId configId = new ConfigId();
//		configId.setMaterialid(id);
//		configId.setSpecid(id);
//		return materialCostRepository.findById(configId);
		MaterialCostBean beans = new MaterialCostBean();
		beans.setMaterialid(id1);
		beans.setSpecid(id2);
		boolean result = materialCostService.delete(beans);
		if(result) {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}
		else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}

	
	
	

	
	@GetMapping("/report/{format}/{reportid}")
	public ResponseEntity<byte[]> generateReport(@PathVariable String format,@PathVariable String reportid) throws Exception {
		
		
		
		return reportService.exportReport(format,reportid);
		
	}
	
	@GetMapping("/customer")
	public ResponseEntity<List<CustomerBean>> selectCustAll() {
		List<CustomerBean> result = custdao.findAll();
		
		return ResponseEntity.ok(result);
	}

	@GetMapping("/material")
	public ResponseEntity<List<MaterialBean>> selectMeterialAll() {
		List<MaterialBean> result = materialService.selectAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/product")
	public ResponseEntity<List<ProductBean>> selectProduct() {
		List<ProductBean> result = productService.selectAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/webreport")
	public ResponseEntity<List<WebReportBean>> selectReport() {
		List<WebReportBean> result = webReportService.selectAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/reportdetail")
	public ResponseEntity<List<ReportDetailBean>> selectReportDetail() {
		List<ReportDetailBean> result = reportDetailService.selectAll();
		return ResponseEntity.ok(result);
	}
	
	
	@GetMapping("/specname/{specid}")
	public ResponseEntity<Optional<SpecnameBean>> selectOneSpecname(@PathVariable("specid") String specid) {
		SpecnameBean bean = new SpecnameBean();
		bean.setSpecid(specid);
		Optional<SpecnameBean> result = specnameService.selectOne(bean);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/product/{productid}")
	public ResponseEntity<Optional<ProductBean>> selectOneProduct(@PathVariable("productid") String productid) {
		
		
		Optional<ProductBean> result = productRepository.findById(productid);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/materialcost")
	public ResponseEntity<List<MaterialCostBean>> materialCost() {
		List<MaterialCostBean> result = materialCostService.findAll();
		return ResponseEntity.ok(result);
	}
	
	
	

	@GetMapping("/specprice")
	public ResponseEntity<List<SpecPriceBean>> specPrice() {
		List<SpecPriceBean> result = materialCostService.selectSpecPrice();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/doorleafprice")
	public ResponseEntity<List<SpecPriceBean>> doorleafprice() {
		List<SpecPriceBean> result = materialCostService.selectDoorLeafPrice();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/frameprice")
	public ResponseEntity<List<SpecPriceBean>> frameprice() {
		List<SpecPriceBean> result = materialCostService.selectFramePrice();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/reportjoin")
	public ResponseEntity<List<ReportJoin>> reportjoin() {
		List<ReportJoin> result = reportDetailService.ReportJoin();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/reportdetailjoinall/{reportid}")
	public ResponseEntity<List<ReportDetailJoinAll>> reportdetailjoinall(@PathVariable("reportid") String reportid) {
		List<ReportDetailJoinAll> result = reportDetailService.ReportDetailJoinAll(reportid);
		return ResponseEntity.ok(result);
	}
	
	
	@GetMapping("/specname")
	public ResponseEntity<List<SpecnameBean>> specName() {
		List<SpecnameBean> result = specnameService.selectAll();
		return ResponseEntity.ok(result);
	}
	@GetMapping("/findcustomer/{anythig}")
	public ResponseEntity<List<CustomerBean>> findcustomer(@PathVariable String anythig) {

		if (anythig != " ") {

			List<CustomerBean> result = customerService.findByAnything(anythig);
			return ResponseEntity.ok(result);
		} else {
			List<CustomerBean> result = custdao.findAll();
			return ResponseEntity.ok(result);
		}

	}
	//post
	
	@PostMapping("/customer")
	public ResponseEntity<?> insert(@RequestBody CustomerBean bean) {

		CustomerBean result = customerService.insert(bean);
		if (result != null) {
			ResponseEntity<CustomerBean> entity = ResponseEntity
					.created(URI.create("/public/api/customer/" + result.getCustomerid())).body(result);
			System.out.println(entity);
			return entity;

		} else {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}

	}

	@PostMapping("/specname")
	public ResponseEntity<?> insertSpec(@RequestBody SpecnameBean bean) {

		SpecnameBean result = specnameService.insert(bean);
		if (result != null) {
			ResponseEntity<SpecnameBean> entity = ResponseEntity
					.created(URI.create("/public/api/specname/" + result.getSpecid())).body(result);
			System.out.println(entity);
			return entity;

		} else {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}

	}



	@PostMapping("/material")
	public ResponseEntity<?> insertMaterial(@RequestBody MaterialBean bean) {
		MaterialBean result = materialService.insert(bean);
		if (result != null) {
			ResponseEntity<MaterialBean> entity = ResponseEntity
					.created(URI.create("/public/api/material/" + result.getMaterialid())).body(result);
			return entity;
		} else {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}

	}
	
	@PostMapping("/product")
	public ResponseEntity<?> insertProduct(@RequestBody ProductBean bean) {
		ProductBean result = productService.insert(bean);
		if(result!=null) {
			ResponseEntity<ProductBean> entity = ResponseEntity
					.created(URI.create("/public/api/product"+result.getProdid())).body(result);
			return entity;
		}else {
			ResponseEntity<?> entity=ResponseEntity.noContent().build();
			return entity;
		}
	}
	
	@PostMapping("/webreport")
	public ResponseEntity<?> insertWebReport(@RequestBody WebReportBean bean) {
		WebReportBean result = webReportService.insert(bean);
		if(result!=null) {
			ResponseEntity<WebReportBean> entity = ResponseEntity
					.created(URI.create("/public/api/webreport"+result.getReportid())).body(result);
			return entity;
		}
		else {
			ResponseEntity<?> entity =ResponseEntity.noContent().build();
			return entity;
		}
	}
	
	@PostMapping("/materialcost")
	public ResponseEntity<?> materialcostInsert(@RequestBody List<MaterialCostBean> beans) {

		List<MaterialCostBean> result = materialCostService.insertAll(beans);
		if (result != null) {
			ResponseEntity<List<MaterialCostBean>> entity = ResponseEntity
					.created(URI.create("/public/api/materialcost/" + result.get(0).getMaterialid())).body(result);
//			System.out.println(entity);
			return entity;

		} else {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}

	}
	
	@PostMapping("/reportdetail")
	public ResponseEntity<?> reportdetailInsert(@RequestBody List<ReportDetailBean> beans) {
		List<ReportDetailBean> result = reportDetailService.insertAll(beans);
		if(result!=null) {
			ResponseEntity<List<ReportDetailBean>> entity = ResponseEntity
					.created(URI.create("/public/api/reportdetail"+beans.get(0).getReportid())).body(result);
			return entity;
		}
		else {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}
	}
	
//put
	@PutMapping("/customer/{id}")
	public ResponseEntity<?> CustomerUpdate(@PathVariable("id") Integer id, @RequestBody CustomerBean bean) {
//		System.out.println(id + ":" + bean);
		CustomerBean result = customerService.update(bean);
		if (result != null && id == bean.getCustomerid()) {
			ResponseEntity<CustomerBean> entity = ResponseEntity.ok(result);
			return entity;
		} else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}

	}
	@PutMapping("/material/{id}")
	public ResponseEntity<?> MaterialUpdate(@PathVariable("id") Integer id, @RequestBody MaterialBean bean) {
//		System.out.println(id + ":" + bean);
//		System.out.println(bean);
		MaterialBean result = materialService.update(bean);
		System.out.println(result);
		if (result != null && id.equals(bean.getMaterialid()) ) {
			ResponseEntity<MaterialBean> entity = ResponseEntity.ok(result);
			return entity;
		} else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}

	}
	@PutMapping("/specname/{id}")
	public ResponseEntity<?> SpecnameUpdate(@PathVariable("id") String id, @RequestBody SpecnameBean bean) {
		SpecnameBean result = specnameService.update(bean);
		if(result!=null && id.equals(bean.getSpecid()) ) {
			ResponseEntity<SpecnameBean> entity = ResponseEntity.ok(result);
			return entity;
		}
		else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}
	
	@PutMapping("/webreport/{id}")
	public ResponseEntity<?> WebReportUpdate(@PathVariable("id") String id, @RequestBody WebReportBean bean) {
		WebReportBean result = webReportService.update(bean);
		if(result!=null && id.equals(bean.getReportid())) {
			ResponseEntity<WebReportBean> entity = ResponseEntity.ok(result);
			return entity;
		}
		else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}
	
	
	@PutMapping("/product/{id}")
	public ResponseEntity<?> ProductUpdate(@PathVariable("id") String id, @RequestBody ProductBean bean) {
		System.out.println(bean);
		ProductBean result = productService.update(bean);
		if(result!=null&& id.equals(bean.getProdid())) {
			ResponseEntity<ProductBean> entity = ResponseEntity.ok(result);
			return entity;
		}
		else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}
	
	
	
//delete
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> CustomerRemove(@PathVariable("id") Integer id) {
		CustomerBean bean = new CustomerBean();
		bean.setCustomerid(id);
		boolean result = customerService.delete(bean);
		if (result) {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		} else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}
	@DeleteMapping("/material/{id}")
	public ResponseEntity<?> MaterialRemove(@PathVariable("id") String id){
		MaterialBean bean = new MaterialBean();
		bean.setMaterialid(id);
		boolean result = materialService.delete(bean);
		if(result) {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}
		else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}
	@DeleteMapping("/specname/{specid}")
	public ResponseEntity<?> SpecnameRemove(@PathVariable("specid") String specid){
		SpecnameBean bean = new SpecnameBean();
		bean.setSpecid(specid);
		boolean result = specnameService.delete(bean);
		if(result) {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}
		else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> ProductDelete(@PathVariable("id") String id) {
		ProductBean bean = new ProductBean();
		bean.setProdid(id);
		boolean result = productService.delete(bean);
		if(result) {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}
		else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}
	
	
	@DeleteMapping("/materialcost/deleteall")
	public ResponseEntity<?> materialcostdeletes(@RequestBody List<MaterialCostBean> beans) {
		if(materialCostService.deleteAll(beans)) {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}
		else {
			System.out.println("ok");
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
		


		
	}
	
	@DeleteMapping("/reportdetail/deleteall")
	public ResponseEntity<?> reportdetaildeletes(@RequestBody List<ReportDetailBean> beans) {
		if(reportDetailService.deleteAll(beans)) {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}
		else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
		


		
	}
	
	@DeleteMapping("/webreport/{id}")
	public ResponseEntity<?> WebreportDelete(@PathVariable("id") String id){
		WebReportBean bean = new WebReportBean();
		bean.setReportid(id);
		boolean result = webReportService.delete(bean);
		if(result) {
			ResponseEntity<?> entity = ResponseEntity.noContent().build();
			return entity;
		}
		else {
			ResponseEntity<?> entity = ResponseEntity.notFound().build();
			return entity;
		}
	}
	
	








	@GetMapping("/export1")
	public ResponseEntity<byte[]> exportExcel() throws Exception {
		// 查詢參數
//		Map<String, Object> params = new HashMap<String, Object>();
		// 結果集
		List<MaterialBean> list = materialService.selectAll();

		Map<String, Object> beanParams = new HashMap<String, Object>();
		beanParams.put("createdAt", new Date());
		beanParams.put("materials", list);
		// 下載表格
		return Report.downLoadExcel("static/excel/ccc.xls", beanParams);
	}
//	@GetMapping("/client")
//	public List<Client> method() {
//		return dao.getAllClients();
//	}
}
