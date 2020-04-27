package com.abakar.primefaces.service;

import com.abakar.primefaces.model.Role;
import com.abakar.primefaces.model.Utilisateur;
import com.abakar.primefaces.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
//ou @Component
public class CustumUserDetailsService implements UserDetailsService {
	@Autowired
	private UtilisateurRepository userDAO ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Utilisateur user = userDAO.findByLogin(username);
		if(user != null)
		{
			 User u = new User(((Utilisateur) user).getLogin(),user.getPwd(),
					 true,true,true,true,  getAuthorities(user.getRoles()));

			 return u ;
		}

		return null;
	}

	private Collection getAuthorities(List roles) {
		List authorities = new ArrayList();
		for(Object role : roles)
		{
			Role l = (Role)role;
			authorities.add(new SimpleGrantedAuthority(l.getLibRole()));
		}
		return authorities ;
	}

}
