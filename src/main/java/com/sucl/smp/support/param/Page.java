package com.sucl.smp.support.param;

import lombok.Data;

@Data
public class Page {
    private int pageCount;
    private int pageSize;
    private int start;
    private int limit;

    public Page(){}

    public Page(int pageCount,int pageSize){
        this.pageCount = pageCount;
        this.pageSize = pageSize;
        initSL();
    }

    private void initSL(){
        this.start = (pageCount-1)*pageSize;
        this.limit = pageCount*pageSize-1;
    }

}
