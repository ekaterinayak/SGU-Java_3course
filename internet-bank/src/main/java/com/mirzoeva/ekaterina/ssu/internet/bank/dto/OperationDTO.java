package com.mirzoeva.ekaterina.ssu.internet.bank.dto;

import lombok.Data;

/**
 * @author mirzoeva.ekaterina
 */
@Data
public class OperationDTO {

    private Long amount;
    private Long senderId;
    private Long receiverId;
}
