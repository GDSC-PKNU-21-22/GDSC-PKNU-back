package com.gdsc.pknu.backend.domain.member;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.util.Arrays;

public enum Role {
    @SerializedName("ROLE_USER")
    USER("ROLE_USER"),
    @SerializedName("ROLE_ADMIN")
    ADMIN("ROLE_ADMIN");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public static Role of(String name){
        return Arrays.stream(Role.values())
                .filter(role->role.isEqual(name))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getValue() {
        return value;
    }

    public boolean isEqual(String value){
        return getValue().equalsIgnoreCase(value);
    }

}
