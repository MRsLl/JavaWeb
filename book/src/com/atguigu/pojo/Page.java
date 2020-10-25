package com.atguigu.pojo;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE = 4;

    //当前页码
    private Integer pageNo;
    //每页显示几条记录
    private Integer pageSize = PAGE_SIZE;
    //总记录数
    private Integer pageCount;
    //总页码
    private Integer pageTotal;
    //当前页数据
    private List<T> items;
    //分页条中的请求地址
    private String url;

    public Page() {
    }


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        /**
         * 数据有效边界检查
         */
        //如果小于第一页，则显示为第一页
        if (pageNo < 1) {
            pageNo = 1;
        }
        //如果大于最后一页，则显示为最后一页
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", pageTotal=" + pageTotal +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
