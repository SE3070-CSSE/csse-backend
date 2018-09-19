package csse.suppliers;

import org.springframework.data.annotation.Id;

/**
 * @author Damsith Karunaratna(dammakaru@gmail.com) on 9/17/2018.
 */
public class Supplier {

    @Id
    private String _id;

    private String supplierName;
    private String supplierAddress;
    private String supplierContactNumber;

    public Supplier(String supplierName,String supplierAddress,String supplierContactNumber){
        this.supplierName=supplierName;
        this.supplierAddress=supplierAddress;
        this.supplierContactNumber=supplierContactNumber;
    }


}
