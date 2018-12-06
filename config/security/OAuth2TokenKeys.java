package com.beyontec.mol.config.security;

public enum OAuth2TokenKeys {

    USERNAME("username"),
    USER_ID("userId"),
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    COMPANY_ID("companyId"),
    EMAIL("email"),
    MENU("menu"),
    AUTHORITIES("authorities"),
    IS_FIRST_LOGIN("isFirstLogin"),
    USER_GROUPS("userGroups"),
    DATE_FORMAT("dateFormat");

    private final String val;

    private OAuth2TokenKeys(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}
