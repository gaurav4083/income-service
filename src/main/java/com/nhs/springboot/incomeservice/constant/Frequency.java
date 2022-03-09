package com.nhs.springboot.incomeservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Frequency Enum
 */
@AllArgsConstructor
public enum Frequency {
    WEEK(1),
    TWO_WEEK(2),
    FOUR_WEEK(4),
    MONTH(1),
    QUARTER(13),
    YEAR(52);

    @Getter
    private Integer value;

}
