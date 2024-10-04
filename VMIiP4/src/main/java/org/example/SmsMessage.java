package org.example;

import lombok.Data;

@Data
class SmsMessage {
    private final String phoneNumber;
    private final String message;
}