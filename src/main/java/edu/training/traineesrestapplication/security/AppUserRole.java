package edu.training.traineesrestapplication.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static edu.training.traineesrestapplication.security.AppUserPermission.*;


/**
 * AppUserRole enum "class" used to define a set of constants, and they are the roles of the application and permissions
 * And it contains a set of SimpleGrantedAuthority to use permissions in authorization process using @PreAuthorize
 */


public enum AppUserRole {

    // Until now there's only two roles for two users
    ADMIN(Sets.newHashSet(TRAINEE_READ,TRAINEE_ADD,TRAINEE_UPDATE)),
    TRAINER(Sets.newHashSet(TRAINEE_READ,TRAINEE_UPDATE));

    // define a set of permission for each role
    // Here set used to prevent repetition
    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AppUserPermission> getPermissions(){
        return permissions;
    }

    /**
     * This method defined to enable permissions to decide authorization instead of using the Role itself
     * That's done by passing permission such as trainee:read to hasAuthority() inside @PreAuthorized annotation
     * @return the permissions for each Role
     */


    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){

        Set<SimpleGrantedAuthority> permissionsSet = getPermissions().stream().map(
                        permissions-> new SimpleGrantedAuthority(permissions.getPermission()))
                .collect(Collectors.toSet());

        permissionsSet.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissionsSet;
    }
}
