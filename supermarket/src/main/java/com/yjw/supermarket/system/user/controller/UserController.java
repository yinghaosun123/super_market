package com.yjw.supermarket.system.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yjw.supermarket.framework.utils.ResultJson;
import com.yjw.supermarket.system.user.bo.UserCondition;
import com.yjw.supermarket.system.user.po.User;
import com.yjw.supermarket.system.user.servie.UserService;
import com.yjw.supermarket.system.user.vo.UserVo;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 条件查找用户
	 * @return
	 */
	@RequestMapping(value = "/list" , method = {RequestMethod.GET})
	public ResultJson findAllByCondition(@RequestBody UserCondition userCondition) {
		ResultJson result = new ResultJson();
		try {
			//分页+条件	查找数据
			List<User> userList = userService.findAllByCondition(userCondition);
			if(userCondition != null) {
				if(userCondition.getCurrentPage() != null && userCondition.getPageSize() != null) {
					//查找分页相关信息
					int totalCount = userService.findCountByCondition(userCondition);
					result.setCurrentPage(userCondition.getCurrentPage());
					result.setPageSize(userCondition.getPageSize());
					result.setTotalCount(totalCount);
					if(totalCount % userCondition.getPageSize() == 0) {
						result.setTotalPage(totalCount / userCondition.getPageSize());
					}else {
						result.setTotalPage(totalCount / userCondition.getPageSize() + 1);
					}
				}
			}
			List<UserVo> list = new ArrayList<>();
			if(userList != null && userList.size() > 0) {
				for(User user :  userList) {
					UserVo vo = new UserVo();
					BeanUtils.copyProperties(user , vo);
					list.add(vo);
				}
			}
			result.setRet("200");
			result.setMsg("SUCCESS");
			result.setDataList(list);
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			result.setRet("201");
			result.setMsg("查找所有的用户失败");
			return result;
		}
	}
	
	
}
