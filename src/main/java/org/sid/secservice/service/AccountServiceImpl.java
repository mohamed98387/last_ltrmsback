package org.sid.secservice.service;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.AppUser;
import org.sid.secservice.repo.AppRoleRepository;
import org.sid.secservice.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;

    private AppRoleRepository approleRepository;
    private PasswordEncoder passwordEncoder;
    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository approleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.approleRepository = approleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser addNewUser(AppUser appUser) {
        System.out.println(appUser);
        String pw=appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {

        return approleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        System.out.println(userName);
        AppUser  appUser=appUserRepository.findByUserName(userName);
        AppRole appRole=approleRepository.findByRoleName(roleName);
        System.out.println(appUser);
        System.out.println(appRole);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String userName) {
        return appUserRepository.findByUserName(userName);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
    @Override
    public boolean ifEmailExist(String email) {
        return appUserRepository.existsByEmail(email);
    }

    @Override
    public AppUser getUserByEmail(String mail) {
        return this.appUserRepository.findByEmail(mail);
    }

    @Override
    public AppUser updateUser(AppUser appUser) {


        return  (AppUser) appUserRepository.save(appUser);
    }
    @Override
    public AppUser updateUserTwo(AppUser appUser) {
        AppUser existingUser = appUserRepository.findAppUserById(appUser.getId());
        String pw=existingUser.getPassword();
        System.out.println(pw);
        appUser.setPassword(pw);

        Collection approles =existingUser.getAppRoles();
        appUser.setAppRoles(approles);
        return  (AppUser) appUserRepository.save(appUser);
    }
    @Override
    public void removeUser(Long id) {
        appUserRepository.deleteById(id);
    }
}
