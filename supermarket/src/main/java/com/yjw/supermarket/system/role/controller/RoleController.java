package com.yjw.supermarket.system.role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjw.supermarket.system.role.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	
	@Autowired
	private RoleService roleService;
	
	
}
