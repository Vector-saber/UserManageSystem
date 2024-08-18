package nk.lx.ums_backend.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageVO <T>{
    private int page;//分页起始页
    private int size;//每页记录数
    private List<T> data;//返回的记录集合
    private long total;//总记录条数
}
