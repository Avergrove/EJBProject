package injection;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DataReaderImpl implements DataReaderLocal, DataReaderRemote{
    @EJB private DataStoreRemote dataStoreRemote;
    @EJB private DataStoreLocal dataStoreLocal;

    @Override
    public String readDataFromLocalStore() {
        return String.format("Local: %s", dataStoreLocal.getData());
    }

    @Override
    public String readDataFromRemoteStore() {
        return String.format("Remote: %s", dataStoreRemote.getData());
    }
}
