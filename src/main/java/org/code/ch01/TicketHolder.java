package org.code.ch01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TicketHolder {
    private String name;
    private int quantity;
}