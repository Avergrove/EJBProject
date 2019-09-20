package states;

import javax.ejb.Stateful;

@Stateful
public class StatefulCounter implements CounterRemote, CounterLocal{

    private int count;

    @Override
    public int count() {
        return count;
    }

    @Override
    public int increment() {
        return ++count;
    }

    @Override
    public int reset() {
        return (count = 0);
    }
}
