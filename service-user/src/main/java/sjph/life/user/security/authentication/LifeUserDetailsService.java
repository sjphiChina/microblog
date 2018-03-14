package sjph.life.user.security.authentication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sjph.life.user.model.UserState;
import sjph.life.user.model.UserRole;
import sjph.life.user.service.UserService;

/**
 * @author shaohuiguo
 *
 */
//@Service("lifeUserDetailsService")
public class LifeUserDetailsService {
   // public class LifeUserDetailsService implements UserDetailsService {

//    private static final Logger LOGGER = LogManager.getLogger(LifeUserDetailsService.class);
//
//    @Autowired(required = true)
//    private UserService         userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        sjph.life.user.model.User user = userService.findUserByEmail(email);
//        if (user != null) {
//            LOGGER.info("Found User: " + user.toString());
//            LOGGER.info("USER role: " + UserRole.Role.USER.toString());
//        }
//        else {
//            LOGGER.error("User not found");
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        List<GrantedAuthority> result = buildUserAuthority(user.getId());
//        return buildUserForAuthentication(user, result);
//    }
//
//    // private List<GrantedAuthority> buildUserAuthority(Long userId, Set<UserRole> userRoles) {
//    private List<GrantedAuthority> buildUserAuthority(Long userId) {
//        Set<GrantedAuthority> setAuths = new HashSet<>();
//
//        // Build user's authorities
//        // for (UserRole userRole : userRoles) {
//        // setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
//        // }
//        setAuths.add(new SimpleGrantedAuthority("ROLE_" + UserRole.Role.USER.toString()));
//
//        // TODO will refine in the future
//        if (userId == 1) {
//            setAuths.add(new SimpleGrantedAuthority("ROLE_" + UserRole.Role.ADMIN.toString()));
//        }
//        // End
//
//        List<GrantedAuthority> authorities = new ArrayList<>(setAuths);
//        LOGGER.info("authorities : {}", authorities);
//        return authorities;
//    }
//
//    private AuthenticatedUser buildUserForAuthentication(sjph.life.user.model.User user,
//            List<GrantedAuthority> result) {
//        boolean enabled = true;
//        boolean accountNonExpired = true;
//        boolean credentialsNonExpired = true;
//        boolean accountNonLocked = true;
//
//        if (user.getUserState().equals(UserState.INACTIVE)) {
//            enabled = false;
//        }
//        if (user.getUserState().equals(UserState.EXPIRED)) {
//            accountNonExpired = false;
//        }
//        if (user.getUserState().equals(UserState.LOCKED)) {
//            accountNonLocked = false;
//        }
//        if (user.getUserState().equals(UserState.CREDENTIAL_EXPIRED)) {
//            credentialsNonExpired = false;
//        }
//        AuthenticatedUser authenticatedUser = new AuthenticatedUser(user.getEmail(),
//                user.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
//                accountNonLocked, result, user);
//        return authenticatedUser;
//    }
}