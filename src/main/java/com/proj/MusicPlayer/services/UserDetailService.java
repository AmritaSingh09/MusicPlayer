package com.proj.MusicPlayer.services;

import com.proj.MusicPlayer.modals.RolesModal;
import com.proj.MusicPlayer.modals.UserDetailModal;
import com.proj.MusicPlayer.repositories.RoleRepo;
import com.proj.MusicPlayer.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MongoTemplate template;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailModal userDetailModal = userRepo.findByEmail(username);
        if (userDetailModal != null ){
            List<GrantedAuthority> grantedAuthorityList = getUserAuthority(userDetailModal.getRoles());
            return buildUserForAuthentication(userDetailModal,grantedAuthorityList);
        }else throw new UsernameNotFoundException("User not found kindly register!");
    }

    public UserDetailModal findUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    private List<GrantedAuthority> getUserAuthority(Set<RolesModal> userRoles){
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role -> roles.add(new SimpleGrantedAuthority(role.getRole()))));
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>(roles);
        return grantedAuthorityList;
    }

    private UserDetails buildUserForAuthentication(UserDetailModal user, List<GrantedAuthority> authorities){
        return new User(user.getEmail(), user.getPassword(), authorities);
    }

    public UserDetailModal loadUserDetail(String username) throws UsernameNotFoundException{
        UserDetailModal userDetailModal = userRepo.findByEmail(username);
        if (userDetailModal != null) return userDetailModal;
        else throw new UsernameNotFoundException("User not found");
    }

    public void saveUser(UserDetailModal userDetailModal) {
        userDetailModal.setPassword(encoder.encode(userDetailModal.getPassword()));
        RolesModal rolesModal = roleRepo.findByRole("ADMIN");
        userDetailModal.setRoles(new HashSet<>(Arrays.asList(rolesModal)));
        userRepo.save(userDetailModal);
    }

}
