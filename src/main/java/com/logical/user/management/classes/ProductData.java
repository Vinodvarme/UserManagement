package com.logical.user.management.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductData {
    @Id
    private int productId;
    private String productName;
    private long price;
}
