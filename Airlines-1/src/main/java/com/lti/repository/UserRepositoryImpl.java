package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public long addAUser(User user) {
		User userNew=em.merge(user);
		return userNew.getUserId();
	}
	
	public User findUserById(long userId) {
		return em.find(User.class, userId);
	}

}
