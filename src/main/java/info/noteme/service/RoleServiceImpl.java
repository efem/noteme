package info.noteme.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import info.noteme.dao.RoleDao;
import info.noteme.domain.Role;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements RoleService{

	
	static final Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public Role getRoleById(Long id) {
		return roleDao.findOne(id);
	}

}
