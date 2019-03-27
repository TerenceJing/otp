package controller.dto.base;

/**
 * @author: jingtiancai
 * @date: 2018/9/17 18:23
 * @desc:
 */
public class BasePageInfo {
    private Long pageNo;
    private Long pageSize;

    public Long getPageNo() {
        return pageNo;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
