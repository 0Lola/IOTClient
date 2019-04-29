package com.example.zxa01.iotclient.common.pojo.privacy;

import com.example.zxa01.iotclient.common.pojo.auth.User;
import com.example.zxa01.iotclient.common.pojo.device.Device;

import java.util.Objects;

public class PrivacyContent {

    private User user;
    private Device device;
    private PrivacyPolicy policy;

    public PrivacyContent() {
    }

    public User getUser() {
        return user;
    }

    public PrivacyContent setUser(User user) {
        this.user = user;
        return this;
    }

    public Device getDevice() {
        return device;
    }

    public PrivacyContent setDevice(Device device) {
        this.device = device;
        return this;
    }

    public PrivacyPolicy getPolicy() {
        return policy;
    }

    public PrivacyContent setPolicy(PrivacyPolicy policy) {
        this.policy = policy;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivacyContent that = (PrivacyContent) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(device, that.device) &&
                Objects.equals(policy, that.policy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, device, policy);
    }

    @Override
    public String toString() {
        return "PrivacyContent{" +
                "user=" + user +
                ", device=" + device +
                ", policy=" + policy +
                '}';
    }

}
