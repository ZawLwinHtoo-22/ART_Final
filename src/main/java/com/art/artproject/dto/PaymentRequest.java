package com.art.artproject.dto;

import com.art.artproject.entity.Payment;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private Double amount;
    private Long card_ID;

}
