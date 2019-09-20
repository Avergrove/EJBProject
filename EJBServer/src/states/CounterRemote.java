package states;

import javax.ejb.Remote;

@Remote
public interface CounterRemote {
    public int count();
    public int increment();
    public int reset();
}
