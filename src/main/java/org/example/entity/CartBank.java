package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartBank {
    private String cartNumber ;
    private String vcc2;
    private Long inventory;
}
