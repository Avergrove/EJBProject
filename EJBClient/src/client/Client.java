package client;

import injection.DataReaderLocal;
import injection.DataReaderRemote;

import javax.naming.InitialContext;
import java.util.Properties;

public class Client {
    public static void main(String[] args){
        try {
            Properties p = new Properties();
            p.put("java.naming.factory.initial", "org.openejb.client.RemoteInitialContextFactory");
            p.put("java.naming.provider.url", "ejbd://127.0.0.1:4201");
            InitialContext ctx = new InitialContext(p);

            DataReaderRemote local = (DataReaderRemote) ctx.lookup("DataReaderImplRemote");
            local.readDataFromLocalStore();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
