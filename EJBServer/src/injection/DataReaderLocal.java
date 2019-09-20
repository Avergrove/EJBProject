package injection;

import javax.ejb.Local;

@Local
public interface DataReaderLocal {
    public String readDataFromLocalStore();
    public String readDataFromRemoteStore();
}
