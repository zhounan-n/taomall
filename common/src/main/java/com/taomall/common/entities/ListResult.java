package com.taomall.common.entities;

import java.util.List;

/**
 * Created by zhoun on 2018/3/18.
 **/
public class ListResult {

    private Integer total;

    private List<?> rows;

    public ListResult() {
        super();
    }

    public ListResult(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
