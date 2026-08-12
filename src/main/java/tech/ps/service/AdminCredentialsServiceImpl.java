package tech.ps.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.ps.Model.Admin;
import tech.ps.dao.AdminDao;

@Service
public class AdminCredentialsServiceImpl implements AdminCredentialsService {

    private AdminDao adminDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public String checkAdminCredentials(String oldUsername, String oldPassword) {
        Optional<Admin> byUsername = adminDao.findByUsername(oldUsername);
        if (byUsername.isPresent()) {
            Admin admin = byUsername.get();
            boolean matches = passwordEncoder.matches(oldPassword, admin.getPassword());
            if (matches) {
                return "SUCCESS";
            } else {
                return "WRONG OLD CREDENTIALS";
            }
        } else {
            return "WRONG OLD CREDENTIALS";
        }
    }

    @Override
    @Transactional
    public String updateAdminCredentials(String newUsername, String newPassword, String oldUsername) {
        int updateCredentials = adminDao.updateCredentials(newUsername, passwordEncoder.encode(newPassword), oldUsername);
        if (updateCredentials == 1) {
            return "CREDENTIALS UPDATED SUCCESSFULLY";
        } else {
            return "FAILED TO UPDATE";
        }
    }
}
