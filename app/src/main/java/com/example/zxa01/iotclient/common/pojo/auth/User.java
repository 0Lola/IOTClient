package com.example.zxa01.iotclient.common.pojo.auth;

import java.math.BigInteger;

public class User {

    private int id;
    private String account;
    private String password;
    private BigInteger publicKey;
    private BigInteger privateKey;
    private String address;

    public User() {
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public User setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public BigInteger getPublicKey() {
        return publicKey;
    }

    public User setPublicKey(BigInteger publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public BigInteger getPrivateKey() {
        return privateKey;
    }

    public User setPrivateKey(BigInteger privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return account != null ? account.equals(user.account) : user.account == null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", publicKey=" + publicKey +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return account != null ? account.hashCode() : 0;
    }

}
