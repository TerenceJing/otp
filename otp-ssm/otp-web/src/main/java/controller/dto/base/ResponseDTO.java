package controller.dto.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import errorcode.ErrorCode;
import errorcode.ErrorCodeC;

/**
 * @author: jingtiancai
 * @date: 2018/9/17 18:10
 * @desc:
 */
public class ResponseDTO<D> extends BaseResInfo {
    //序列化和反序列化类版本
    private static final long serialVersionUID = 1L;

    private D data;

    public ResponseDTO() {
    }

    //不带分页，data为一个对象,
    public ResponseDTO(D d) {
        this.setData(d);
    }

    public static <D> ResponseDTO<D> success(D d) {
        ResponseDTO<D> responseDTO = new ResponseDTO<>();
        responseDTO.setCode(ErrorCode.SUCCESS.getCode());
        responseDTO.setMsg(ErrorCode.SUCCESS.getMsg());
        responseDTO.setData(d);
        return responseDTO;
    }

    public static <T> ResponseDTO<BasePageData<T>> success(Long pageNo, Long pageSize, Long total) {
        ResponseDTO<BasePageData<T>> responseDTO = new ResponseDTO<>();
        responseDTO.setCode(ErrorCode.SUCCESS.getCode());
        responseDTO.setMsg(ErrorCode.SUCCESS.getLabel());
        BasePageData<T> data = new BasePageData<>();
        data.setPageNo(pageNo);
        data.setPageSize(pageSize);
        data.setTotal(total);
        responseDTO.setData(data);
        return responseDTO;
    }

    public static <D> ResponseDTO<D> fail(ErrorCodeC e) {
        ErrorCodeC o = (null == e) ? ErrorCode.UNKNOW_ERROR.ec() : e;
        ResponseDTO<D> responseDTO = new ResponseDTO<>();
        responseDTO.setCode(o.getCode());
        responseDTO.setMsg(o.getLabel());
        return responseDTO;
    }

    public static <D> ResponseDTO<D> fail(ResponseDTO resDTO) {
        ResponseDTO o = (null == resDTO) ? ResponseDTO.fail(ErrorCode.UNKNOW_ERROR.ec()) : resDTO;
        ResponseDTO<D> responseDTO = new ResponseDTO<>();
        responseDTO.setCode(o.getCode());
        responseDTO.setMsg(o.getMsg());
        return responseDTO;
    }

    public static <D> ResponseDTO<D> fail(ErrorCodeC e, String msg) {
        ErrorCodeC o = (null == e) ? ErrorCode.UNKNOW_ERROR.ec() : e;
        ResponseDTO<D> responseDTO = new ResponseDTO<>();
        responseDTO.setCode(o.getCode());
        responseDTO.setMsg(msg);
        return responseDTO;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return ErrorCode.SUCCESS.getCode().equals(this.getCode());
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
