package com.codegym.mailsettings.model;

public class MailSettings {
    private String language;
    private int pageSize;
    private boolean enableSpamFilter;
    private String signature;

    // getters and setters
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public int getPageSize() { return pageSize; }
    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

    public boolean isEnableSpamFilter() { return enableSpamFilter; }
    public void setEnableSpamFilter(boolean enableSpamFilter) { this.enableSpamFilter = enableSpamFilter; }

    public String getSignature() { return signature; }
    public void setSignature(String signature) { this.signature = signature; }
}
