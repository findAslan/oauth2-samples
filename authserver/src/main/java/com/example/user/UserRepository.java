package com.example.user;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.user.UserInfo;

@Transactional
public interface UserRepository extends CrudRepository<UserInfo, Long> {

	@Query("SELECT t.custName FROM UserInfo t where t.custId = :id")	
	String findCustNameById(@Param("id") String custId);
	
	UserInfo findByCustId (String custId);

}
