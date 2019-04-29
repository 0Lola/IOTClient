package com.example.zxa01.iotclient.common.pojo.privacy;

import com.example.zxa01.iotclient.common.pojo.device.Device;

import java.util.LinkedList;
import java.util.List;

public class PrivacyPolicyReport {

    private String id;
    private String version;
    private String description;
    private Device device;
    private List<PrivacyPolicy> policies = new LinkedList<>();

    public String getId() {
        return id;
    }

    public PrivacyPolicyReport setId(String id) {
        this.id = id;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public PrivacyPolicyReport setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PrivacyPolicyReport setDescription(String description) {
        this.description = description;
        return this;
    }

    public Device getDevice() {
        return device;
    }

    public PrivacyPolicyReport setDevice(Device device) {
        this.device = device;
        return this;
    }
    public List<PrivacyPolicy> getPolicies() {
        return policies;
    }

    public PrivacyPolicyReport setPolicies(List<PrivacyPolicy> policies) {
        this.policies = policies;
        return this;
    }

    public PrivacyPolicyReport addPrivacyPolicy(PrivacyPolicy policy) {
        if (null != policies) this.policies.add(policy);
        return this;
    }

    @Override
    public String toString() {
        return "PrivacyPolicyReport{" +
                "id='" + id + '\'' +
                ", version='" + version + '\'' +
                ", description='" + description + '\'' +
                ", device=" + device +
                ", policies=" + policies +
                '}';
    }
}
