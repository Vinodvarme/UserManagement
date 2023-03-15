package com.logical.user.management.entity;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EntityScan
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("UserData")
public class UserData {

    @Id
    public int userId;
    public String userName;
    public String emailId;
    public Address address;
    public int productId;
    public String img;

}
