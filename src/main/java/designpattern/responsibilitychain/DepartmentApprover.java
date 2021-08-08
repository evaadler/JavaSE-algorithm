package designpattern.responsibilitychain;

import java.util.HashMap;

/**
 * DepartmentApprover
 *
 * @author Alicia
 * @description
 * @date 2021/4/11
 */
public class DepartmentApprover extends Approver{

    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 1500){
            System.out.println(" 请求编号 id="+purchaseRequest.getId()+"被"+name+"处理");
        }else {
            approver.processRequest(purchaseRequest);
        }
    }
}
