package com.logical.user.management.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Type;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityScan
@Document("address")
public class Address {
    public String permanentAddress;
    public String country;
    public String state;
    public int pinCode;
}
