package csse.orders;

import java.util.List;

/**
 * @author Damsith Karunaratna(dammakaru@gmail.com) on 9/27/2018.
 */
public interface IOrderFacade {

    PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder);
    List<PurchaseOrder> getAllOrders();
}
