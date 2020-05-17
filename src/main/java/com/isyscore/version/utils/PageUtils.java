package com.isyscore.version.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageUtils {

    public static PagedGridResult setterPagedGrid(List<?> resultList, Integer page){
        PageInfo<?> pageList = new PageInfo<>(resultList);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(resultList);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());

        return grid;

    }
}
