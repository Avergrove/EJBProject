import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.util.Properties;

public class EJBClient {
    public static void main(String[] args) throws NamingException {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
        props.put(Context.PROVIDER_URL, "ejbd://127.0.0.1:4201");
        Context ctx = new InitialContext(props);
        Object ref = ctx.lookup("GreetingBeanRemote");
        Greeting h = (Greeting) PortableRemoteObject.narrow(ref, Greeting.class);
        String result = h.sayHello();
        System.out.println(result);
    }
}