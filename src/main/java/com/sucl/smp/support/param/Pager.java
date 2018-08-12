package com.sucl.smp.support.param;

import lombok.Data;

import java.util.List;

@Data
public class Pager<T> {
    private List<T> records;
    private int total;
}
