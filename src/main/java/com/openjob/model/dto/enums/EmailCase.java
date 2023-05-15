package com.openjob.model.dto.enums;

public enum EmailCase {
    COMPANY_ACCOUNT_CREATED("company_account_creation_mail.ftlh"),
    JOB_UPDATED("job_updated_mail.ftlh"),
    JOB_DEACTIVATED("job_deactivated_mail.ftlh"),
    JOB_REACTIVATED("job_reactivated_mail.ftlh"),
    FORGOT_PASSWORD("forgot_password.ftlh");

    private final String template;
    public String getTemplate(){
        return template;
    }
    EmailCase(String s) {
        this.template = s;
    }
}
