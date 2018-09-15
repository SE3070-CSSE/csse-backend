package csse.policies.itempolicies;

import csse.items.Item;
import csse.policies.BasePolicyChain;

/**
 * Created by DAMMA on 9/14/2018.
 */
public class BaseNameCheckPolicy extends BasePolicyChain<Item> {

    @Override
    public boolean execute(Item item) {
        System.out.println("BaseNameCheckPolicy called");
        return true;
    }
}
