package ru.orbot90.pojos;

/**
 * Created by plevako on 10.06.2016.
 */
public class StoredEntity {
    private String stringProp;
    private Long longProp;
    private Integer intProp;
    private Boolean boolProp;

    public String getStringProp() {
        return stringProp;
    }

    public Long getLongProp() {
        return longProp;
    }

    public Integer getIntProp() {
        return intProp;
    }

    public Boolean getBoolProp() {
        return boolProp;
    }

    public void setStringProp(String stringProp) {
        this.stringProp = stringProp;
    }

    public void setLongProp(Long longProp) {
        this.longProp = longProp;
    }

    public void setIntProp(Integer intProp) {
        this.intProp = intProp;
    }

    public void setBoolProp(Boolean boolProp) {
        this.boolProp = boolProp;
    }
}
