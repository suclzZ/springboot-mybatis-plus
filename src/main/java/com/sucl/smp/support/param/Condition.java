package com.sucl.smp.support.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Condition {
    private String property;
    private String operate;
    private String value;
}
