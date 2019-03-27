package controller.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @desc: 带有分页信息的数据
 */
public class BasePageData<D> extends BasePageInfo {
    private Long total;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<D> list;


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }


    public List<D> getList() {
        return list;
    }

    public void setList(List<D> list) {
        this.list = list;
    }
}
