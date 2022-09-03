package com.kafka.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserKafkaDTO {

    private int id;
    private String name;
    private String userName;
}
