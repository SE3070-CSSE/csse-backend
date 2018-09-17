package csse.policies.itempolicies;

import com.fasterxml.jackson.databind.ObjectMapper;
import csse.items.Item;
import csse.common.ResponseWrapper;
import org.springframework.http.HttpMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Damsith Karunaratna(dammakaru@gmail.com)
 */
public class PreApprovedSupplierFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest, responseWrapper);

        if(HttpMethod.GET.equals(httpRequest.getMethod())) {

            System.out.println("METHOD : " + httpRequest.getMethod());
            String responseContent = new String(responseWrapper.getDataStream());
            List<Item> itemList = getResponseItems(responseContent);

            /**
             * Filter out item list response to include items from registered suppliers only
             */
            itemList.add(new Item("dsa", "itemnamehooha", null, "cat1", 0.1, "desc"));
            byte[] responseToSend = createByteArray(itemList);
            servletResponse.getOutputStream().write(responseToSend);

        }

    }

    @Override
    public void destroy() {

    }

    private List<Item> getResponseItems(String responseContent) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Item[] items = objectMapper.readValue(responseContent, Item[].class);
        List<Item> itemList = new ArrayList<>();

        for (Item item : items) {
            itemList.add(item);
        }

        return itemList;
    }

    private byte[] createByteArray(Object response) throws IOException {
        String serialized = new ObjectMapper().writeValueAsString(response);
        return serialized.getBytes();
    }

}
