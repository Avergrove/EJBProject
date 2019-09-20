package test;


import injection.DataReaderRemote;
import org.junit.BeforeClass;
import org.junit.Test;
import stateful.CounterRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Tests {

    private static InitialContext ctx;

    @BeforeClass
    public static void setup() throws NamingException {
        Properties p = new Properties();
        p.put("java.naming.factory.initial", "org.openejb.client.RemoteInitialContextFactory");
        p.put("java.naming.provider.url", "ejbd://127.0.0.1:4201");
        ctx = new InitialContext(p);
    }

    @Test
    public void injection() throws NamingException {
        DataReaderRemote local = (DataReaderRemote) ctx.lookup("DataReaderImplRemote");
        System.out.println(local.readDataFromLocalStore());
        System.out.println(local.readDataFromRemoteStore());

    }

    @Test
    public void testStatelessStateful() throws NamingException {
        CounterRemote statefulCounter = (CounterRemote) ctx.lookup("StatefulCounterRemote");
        CounterRemote stupidCounter = (CounterRemote) ctx.lookup("StupidCounterRemote");

        for(int i = 0; i < 3; i++){
            statefulCounter.increment();
            stupidCounter.increment(); // Try running the test multiple times, observe the stupidity
        }
        System.out.println(String.format("Stateful: %s", statefulCounter.count()));
        System.out.println(String.format("Stupid: %s",stupidCounter.count()));
        System.out.println(String.format("Stupid Call 2: %s",stupidCounter.count()));
    }
}
