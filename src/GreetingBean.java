import javax.ejb.Stateless;

@Stateless
public class GreetingBean implements Greeting{

    @Override
    public String sayHello() {
        return "Hai!!!!!";
    }
}
