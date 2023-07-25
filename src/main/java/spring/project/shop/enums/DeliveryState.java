package spring.project.shop.enums;



public enum DeliveryState {
    CANCEL, OK;

    public String getCode(){
        return this.name();
    }


}
