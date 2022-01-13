package sn.yaya.billingservice.services.exceptionHandlers;

public class CustomerNotFoundExecption extends RuntimeException {
    public CustomerNotFoundExecption(String messages) {
        super(messages);
    }
}
