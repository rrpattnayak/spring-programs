package com.rr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rr.dto.EmployeeDTO;
import com.rr.model.Employee;
import com.rr.service.IEmployeeMgmtService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeMgmtService service;
	
	@GetMapping("/welcome.htm")
	public String show_home() {
		//return lvn
		return "home";
	}
	
	@GetMapping("/list_emps.htm")
	public String showEmployees(Map<String,Object> map) {
		List<EmployeeDTO> listDTO=null;
		//use service
		listDTO=service.fetchAllEmployees();
		//keep results in model attribute
		map.put("empsInfo", listDTO);
		return "show_report";
	}
	
	@GetMapping("/saveEmp.htm")
	public String showRegistrationPage(@ModelAttribute("empFrm") Employee emp) {
		return "registration_form";
	}
	
	@PostMapping("/saveEmp.htm")
	public String saveEmployee(RedirectAttributes redirect,@ModelAttribute("empFrm") Employee emp) {
		EmployeeDTO dto=null;
		String result=null;
		//convert model to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(emp, dto);
		//use service
		result=service.registerEmployee(dto);
		//keep in model attribute
		redirect.addFlashAttribute("resultMsg", result);
		//return lvn
		return "redirect:list_emps.htm";
	}
	
	@ModelAttribute("deptsInfo")
	public List<Integer> showAllDeptNos(){
		return service.fetchAllDeptNos();
	}
	
	@GetMapping("/deleteEmp.htm")
	public String removeEmployee(RedirectAttributes redirect,@RequestParam int eno) {
		String result=null;
		//use service
		result=service.removeEmpByNo(eno);
		//add result to flash attribute
		redirect.addFlashAttribute("resultMsg", result);
		return "redirect:list_emps.htm";
	}
	
	@GetMapping("/editEmp.htm")
	public String showUpdateForm(@ModelAttribute Employee emp,@RequestParam int empNo) {
		EmployeeDTO dto=null;
		//use service
		dto=service.fetchEmpByNo(empNo);
		//convert dto to model
		BeanUtils.copyProperties(dto, emp);
		return "update_form";
	}
	
	@PostMapping("/editEmp.htm")
	public String updateEmployee(RedirectAttributes redirect,@ModelAttribute Employee employee) {
		EmployeeDTO dto=null;
		String result=null;
		//convert model to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(employee, dto);
		//use service
		result=service.modifyEmployeeByNo(dto);
		//add flash attribute
		redirect.addFlashAttribute("resultMsg", result);
		//perform redirection
		return "redirect:list_emps.htm";
	}
}
