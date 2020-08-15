package com.human.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.human.domain.EmployeesDto;
import com.human.domain.PageMaker;
import com.human.domain.SearchCriteria;
import com.human.service.EmployeesService;

@Controller
@RequestMapping("/manager2/*")
public class ManagerController {

	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

	public int checklist = 0;
	
	@Inject
	private EmployeesService service;
	
	//출력
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public void employees(@ModelAttribute("cri") SearchCriteria cri,Model model) throws Exception {
		
		logger.info(cri.toString());

		// model.addAttribute("list", service.listCriteria(cri));
		model.addAttribute("employees", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		// pageMaker.setTotalCount(service.listCountCriteria(cri));
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
		
	}


	// 입력

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String employee_insert(@RequestParam("employeeid") int employeeid, @RequestParam("lastname") String lastname,
			@RequestParam("firstname") String firstname, @RequestParam("title") String title,
			@RequestParam("titleofcourtesy") String titleofcourtesy, @RequestParam("birthdate") String birthdate,
			@RequestParam("hiredate") String hiredate, @RequestParam("address") String address,
			@RequestParam("city") String city, @RequestParam("region") String region,
			@RequestParam("postalcode") String postalcode, @RequestParam("country") String country,
			@RequestParam("homephone") String homephone, @RequestParam("extension") String extension,
			@RequestParam("photo") String photo, @RequestParam("notes") String notes,
			@RequestParam("reportsto") int reportsto, @RequestParam("photopath") String photopath) throws Exception {

		service.insert(employeeid, lastname, firstname, title, titleofcourtesy, birthdate, hiredate, address, city,
				region, postalcode, country, homephone, extension, photo, notes, reportsto, photopath);

		return "redirect:/manager2/employees";
	}

	// 변경

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String employee_update(@RequestParam("updateDatalastname") String lastname,
			@RequestParam("updateDatafirstname") String firstname, @RequestParam("updateDatatitle") String title,
			@RequestParam("updateDatatitleofcourtesy") String titleofcourtesy,
			@RequestParam("updateDataaddress") String address, @RequestParam("updateDatacity") String city,
			@RequestParam("updateDataregion") String region, @RequestParam("updateDatapostalcode") String postalcode,
			@RequestParam("updateDatacountry") String country, @RequestParam("updateDatahomephone") String homephone,
			@RequestParam("updateDataextension") String extension, @RequestParam("updateDataphoto") String photo,
			@RequestParam("updateDatanotes") String notes, @RequestParam("updateDatareportsto") int reportsto,
			@RequestParam("updateDataphotopath") String photopath
		
			) throws Exception {
		
		
		
		int employeeid = checklist;
		 service.update(employeeid,lastname,firstname,title,titleofcourtesy,
		 address,city,region,postalcode,country,homephone,extension,photo,notes,
		 reportsto, photopath);
		

		return "redirect:/manager2/employees";
	}

	
	//update 체크박스 값 저장
	@RequestMapping(value = "/updatelist", method = RequestMethod.POST)
	public void employee_updatelist(@RequestParam(value = "valueArrTest[]") List<String> valueArr) throws Exception {
		
		
		 // List -> String[]
        String[] sArrays = valueArr.toArray(new String[valueArr.size()]);
        
		 int employeeid =Integer.parseInt(sArrays[0]); 
		 
		 checklist= employeeid;
		 System.out.println("employeeid = "+employeeid);
		 
		
	}
	
//	//delete 체크박스 값 저장
//		@RequestMapping(value = "/updatelist", method = RequestMethod.POST)
//		public void employee_updatelist(@RequestParam(value = "valueArrTest[]") List<String> valueArr) throws Exception {
//			
//			
//			 // List -> String[]
//	        String[] sArrays = valueArr.toArray(new String[valueArr.size()]);
//	 
//			 int employeeid =Integer.parseInt(sArrays[0]); 
//			 
//			 checklist= employeeid;
//			 System.out.println("employeeid = "+employeeid);
//			 
//			
//		}
	
	//삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String employee_delete(@RequestParam(value = "valueArrTestdel[]") List<String> valueArrdel) throws Exception {
		
		
		 // List -> String[]
        String[] sArrays = valueArrdel.toArray(new String[valueArrdel.size()]);
 
		 int employeeid =Integer.parseInt(sArrays[0]); 
		 
		 service.delete(employeeid);
		 System.out.println("employeeid del = "+employeeid);
		
		 return "redirect:/manager2/employees";
	}
	
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(EmployeesDto board, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info(cri.toString());
		service.modify(board);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/manager2/employees";
	}
	
	
}
