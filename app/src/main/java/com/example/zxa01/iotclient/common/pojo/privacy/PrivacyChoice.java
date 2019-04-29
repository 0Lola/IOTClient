package com.example.zxa01.iotclient.common.pojo.privacy;

public class PrivacyChoice {

    private PrivacyContent privacyContent;
    private boolean isAccepted;

    public PrivacyChoice() {
    }

    public PrivacyContent getPrivacyContent() {
        return privacyContent;
    }

    public PrivacyChoice setPrivacyContent(PrivacyContent privacyContent) {
        this.privacyContent = privacyContent;
        return this;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public PrivacyChoice setAccepted(boolean accepted) {
        isAccepted = accepted;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivacyChoice choice = (PrivacyChoice) o;

        if (isAccepted != choice.isAccepted) return false;
        return privacyContent != null ? privacyContent.equals(choice.privacyContent) : choice.privacyContent == null;
    }

    @Override
    public int hashCode() {
        int result = privacyContent != null ? privacyContent.hashCode() : 0;
        result = 31 * result + (isAccepted ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PrivacyChoice{" +
                "privacyContent=" + privacyContent +
                ", isAccepted=" + isAccepted +
                '}';
    }
}
