package injection;

import javax.ejb.Remote;

@Remote
public interface DataReaderRemote {
    public String readDataFromLocalStore();
    public String readDataFromRemoteStore();
}
