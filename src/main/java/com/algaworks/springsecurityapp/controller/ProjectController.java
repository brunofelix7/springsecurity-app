package com.algaworks.springsecurityapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {

	@RequestMapping(path = "/projects", method = RequestMethod.GET)
	public String project(){
		return "project/projects";
	}
	
	@RequestMapping(path = "/cost-reports", method = RequestMethod.GET)
	public String costReports(){
		return "report/cost-reports";
	}
	
	@RequestMapping(path = "/team-reports", method = RequestMethod.GET)
	public String teamReports(){
		return "report/team-reports";
	}
	
}
