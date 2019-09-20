package injection;

import javax.ejb.Local;

@Local
public interface DataStoreLocal {
    public String getData();
}
