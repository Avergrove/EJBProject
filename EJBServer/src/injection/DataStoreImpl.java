package injection;

import javax.ejb.Stateless;

@Stateless
public class DataStoreImpl implements DataStoreLocal, DataStoreRemote {
    @Override
    public String getData() {
        return "42";
    }
}
