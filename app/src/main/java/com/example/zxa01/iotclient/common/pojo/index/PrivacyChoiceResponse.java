package com.example.zxa01.iotclient.common.pojo.index;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyContent;


public class PrivacyChoiceResponse {

    private long id;
    private String localDateTime;
    private PrivacyContent privacyContent;

    public PrivacyChoiceResponse(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public PrivacyContent getPrivacyContent() {
        return privacyContent;
    }

    public void setPrivacyContent(PrivacyContent privacyContent) {
        this.privacyContent = privacyContent;
    }
}
