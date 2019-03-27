package errorcode;

import utils.StringUtils;

/**
 * @author: jingtiancai
 * @date: 2018/9/17 18:15
 * @desc:
 */
public class ErrorCodeC {
    private final String code;
    private String label;
    private String msg;

    public ErrorCodeC(String code, String label, String msg) {
        this.code = code;
        this.label = label;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ErrorCodeC append(String msg){
        if(StringUtils.isNotBlank(this.msg)){
            this.msg+=". "+msg;
        }else{
            this.msg=msg;
        }

        return this;

    }
}
