package com.example.transaction.util.code;

public enum ReservationCode {
    /**
     *
     */
    FAIL(-2, "FAIL"),
    CANCELLED(-1, "CANCELLED"),
    WAITING(0, "WAITING"),
    VALIDATE(1, "VALIDATE"),
    FINISHED(2, "FINISHED"),
    //等待失败,交易已经完成
    FAILWAITING(3, "FAILWAITING");

    private final int code;
    private final String desc;

    public static String getDescription(int code){
        try{
            return values()[code+2].toString();
        }catch(Exception e){
            return "";
        }
    }

    ReservationCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}
