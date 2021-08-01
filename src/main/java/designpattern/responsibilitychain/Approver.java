package designpattern.responsibilitychain;

/**
 * Approver
 *
 * @author Alicia
 * @description
 * @date 2021/4/11
 */
public abstract class Approver {
    Java
    Approver approver;
    String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver){
        this.approver = approver;
    }

    // 处理审批请求的方法，得到一个请求，处理是子类完成，该方法抽象
    public abstract void processRequest(PurchaseRequest purchaseRequest);

}
