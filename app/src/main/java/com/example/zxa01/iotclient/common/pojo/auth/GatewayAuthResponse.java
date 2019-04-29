package com.example.zxa01.iotclient.common.pojo.auth;

public class GatewayAuthResponse {

    private String sequence;
    private String encryptedData;
    private String gatewayId;
    private String publicKey;

    public GatewayAuthResponse() {
    }

    public String getSequence() {
        return sequence;
    }

    public GatewayAuthResponse setSequence(String sequence) {
        this.sequence = sequence;
        return this;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public GatewayAuthResponse setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
        return this;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public GatewayAuthResponse setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
        return this;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public GatewayAuthResponse setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    @Override
    public String toString() {
        return "GatewayAuthResponse{" +
                "sequence='" + sequence + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                ", gatewayId='" + gatewayId + '\'' +
                ", publicKey='" + publicKey + '\'' +
                '}';
    }

}
