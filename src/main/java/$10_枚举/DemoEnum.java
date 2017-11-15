package $10_枚举;

/**
 * @author yunfeng.lu
 * @create 2017/11/6.
 */
public enum DemoEnum {
    BALANCE("BALANCE", "余额"),
    CREDIT("CREDIT", "信用"),
    WITHHOLDING("WITHHOLDING", "代扣");

    private String code;
    private String value;

    private DemoEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
