package injection;

import javax.ejb.Remote;

@Remote
public interface DataStoreRemote {
    public String getData();
}
