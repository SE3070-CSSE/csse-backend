package csse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import csse.orders.OrderService;
import csse.orders.PurchaseOrder;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Damsith Karunaratna(dammakaru@gmail.com) on 10/2/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = {"test"})
public class OrderServiceTests {

    @Autowired
    private OrderService orderService;

    private static Logger logger = LoggerFactory.getLogger(OrderServiceTests.class);
    private static PurchaseOrder testOrder, allItemsReceivedOrder;

    @BeforeClass
    public static void setUp() throws IOException {

        // Load dummy order data from json file
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<PurchaseOrder> typeReference = new TypeReference<PurchaseOrder>(){};
        InputStream inputStream1 = TypeReference.class.getResourceAsStream("/json/order.json");
        InputStream inputStream2 = TypeReference.class.getResourceAsStream("/json/allItemsReceivedOrder.json");
        testOrder = mapper.readValue(inputStream1, typeReference);
        allItemsReceivedOrder = mapper.readValue(inputStream2, typeReference);
        logger.info("Loaded dummy order data");
        inputStream1.close();
        inputStream2.close();

    }

    @After
    public void tearDowns() {
        // Clean orders database
        orderService.cleanDatabase();
    }

    @Test
    public void setsOrderIdOnSave() throws Exception {
        logger.info("Running setsOrderIdOnSave()");
        PurchaseOrder savedOrder = orderService.saveOrder(testOrder);
        Assert.assertNotNull("After creation OrderID should not be null", savedOrder.get_id());
    }

    @Test
    public void negativeAllOrdersItemsAreDelivered() throws Exception {
        logger.info("Running negativeAllOrdersItemsAreDelivered()");
        boolean itemsReceived = orderService.allItemsReceived(testOrder);
        Assert.assertFalse("allItemsReceived should return false if " +
                "some items are not delivered", itemsReceived);
    }

    @Test
    public void positiveAllOrdersItemsAreDelivered() throws Exception {
        logger.info("Running positiveAllOrdersItemsAreDelivered()");
        boolean itemsReceived = orderService.allItemsReceived(allItemsReceivedOrder);
        Assert.assertTrue("allItemsReceived should return true if " +
                "all items are delivered", itemsReceived);

    }

}
