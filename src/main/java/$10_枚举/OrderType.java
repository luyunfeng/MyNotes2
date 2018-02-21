package $10_枚举;

/**
 * @author yunfeng.lu
 * @create 2018/1/4.
 */
public enum OrderType {
    /**
     * 余额充值订单
     */
    BALANCE_RECHARGE("BALA_RECHAR"),

    /**
     * 保证金充值
     */
    PLEDGE_RECHARGE("PLED_RECHAR"),

    /**
     * 清分扣款
     */
    TICKET_CHARGE("TICK_CHAR"),

    /**
     * TVM购票
     */
    TVM("TVM_TICKET");


    /** 代码 */
    private String code;

    /**
     * @param code
     */
    private OrderType(String code) {
        this.code = code;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * @param code
     * @return
     */
    public static OrderType getByCode(String code) {
        for (OrderType param : values()) {
            if (param.getCode().equals(code)) {
                return param;
            }
        }
        return null;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

}
