package com.example.zxa01.iotclient.common.pojo.index;

import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyChoice;

import java.time.LocalDateTime;

public class PrivacyChoiceIndex {

    private long id;
    private LocalDateTime localDateTime;
    private PrivacyChoice privacyChoice;

    public PrivacyChoiceIndex(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public PrivacyChoice getPrivacyChoice() {
        return privacyChoice;
    }

    public void setPrivacyChoice(PrivacyChoice privacyChoice) {
        this.privacyChoice = privacyChoice;
    }
}
