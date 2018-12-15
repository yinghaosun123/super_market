package com.yjw.supermarket.system.user.servie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yjw.supermarket.framework.utils.Pagination;
import com.yjw.supermarket.system.user.bo.UserCondition;
import com.yjw.supermarket.system.user.dao.UserMapper;
import com.yjw.supermarket.system.user.po.User;
import com.yjw.supermarket.system.user.po.UserExample;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 条件查找用户列表
	 * @param condition
	 * @return
	 */
	public List<User> findAllByCondition(UserCondition condition){
		List<User> list = new ArrayList<>();
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andDelEqualTo("0");
		criteria.andEnableEqualTo("1");
		if(condition != null) {
			//条件查找
			//判断是否分页
			if(condition.getCurrentPage() != null && condition.getPageSize() != null ) {
				Pagination pagination = new Pagination();
				pagination.setCurrentPage(condition.getCurrentPage());
				pagination.setPageSize(condition.getPageSize());
				example.setPagination(pagination);
			}
			//其他条件
			
		}
		example.setOrderByClause("sort");
		example.isDistinct();
		list = userMapper.selectByExample(example);
		if(list != null) {
			return list;
		}else {
			return null;
		}
	}
	
	
	/**
	 * 条件查找符合条件的数量
	 * @param condition
	 * @return
	 */
	public Integer findCountByCondition(UserCondition condition) {
		List<User> list = new ArrayList<>();
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andDelEqualTo("0");
		criteria.andEnableEqualTo("1");
		if(condition != null) {
			//其他条件
			
		}
		example.isDistinct();
		Integer count = userMapper.countByExample(example);
		if(count != null) {
			return count;
		}else {
			return 0;
		}
	}
	
	

}
