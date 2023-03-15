package com.logical.user.management.classes;

import com.logical.user.management.entity.UserData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyOrder {
    private UserData userData;
    private ProductData productData;
}
