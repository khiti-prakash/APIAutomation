package com.vabro.api.Organization;

public enum StatusResponse {
    ADMIN, CREATE_ORGANIZATION_VERIFY_EMAIL_EXPIRED, ORGANIZATION_MEMBER;

    public String toValue() {
        switch (this) {
            case ADMIN:
                return "admin";
            case CREATE_ORGANIZATION_VERIFY_EMAIL_EXPIRED:
                return "create-organization-verify-email-expired";
            case ORGANIZATION_MEMBER:
                return "organization-member";
        }
        return null;
    }
}
