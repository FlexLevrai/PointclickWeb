package com.winnertech.point_click.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.winnertech.point_click.security.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("select r from Role r where r.name=:x")
	public Role findByName( @Param("x") String roleName);
	
	
}
