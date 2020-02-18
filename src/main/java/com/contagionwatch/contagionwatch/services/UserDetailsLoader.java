package com.contagionwatch.contagionwatch.services;

import com.contagionwatch.contagionwatch.dao.AdminRepository;
import com.contagionwatch.contagionwatch.models.Admin;
import com.contagionwatch.contagionwatch.models.GreaterAdmin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final AdminRepository adminDao;

    public UserDetailsLoader(AdminRepository adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = adminDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        return new GreaterAdmin(user);
    }
}
