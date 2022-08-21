package edu.training.traineesrestapplication.security;

/**
 * AppUserPermission used to specify permissions for each user Role
 * In other words specify what the user can access and done in trainees application
 */


public enum AppUserPermission {

    // Create a set of simple permission on the http request ( application services )
    TRAINEE_READ("trainee:read"),
    TRAINEE_ADD("trainee:add"),
    TRAINEE_UPDATE("trainee:update");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    /**
     * Used to get permission
     * @return permission
     */
    public String getPermission() {
        return permission;
    }
}
