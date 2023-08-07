package org.sid.secservice.service;

import org.sid.secservice.entities.AppRole;
import org.sid.secservice.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String userName ,String roleName);
    AppUser loadUserByUsername(String userName);
    List<AppUser> listUsers();
     boolean ifEmailExist(String email);
     public AppUser getUserByEmail(String mail);
    public AppUser updateUser(AppUser appUser);
    public void removeUser(Long id);
    public AppUser updateUserTwo(AppUser appUser);
}
