package csse.policies;

/**
 * Created by DAMMA on 9/14/2018.
 */
public abstract class BasePolicyChain<T> {

    private BasePolicyChain nextInChain;

    public void add(BasePolicyChain next) {
        if(nextInChain == null) {
            nextInChain = next;
        } else {
            nextInChain.add(next);
        }
    }

    public abstract boolean execute(T t);

}
