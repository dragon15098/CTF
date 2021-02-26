package com.myjavablog.model;

import org.springframework.security.core.context.SecurityContextHolder;

public class Helper {
    private Helper() {
    }

    public static Integer getUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            return ((User) principal).getId();
        }
        return null;
    }

}
