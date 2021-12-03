import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {
    @Test
    public void testGetLocalNumber(){
        int x=this.getLocalNumber();
        Assert.assertTrue( "number equal 14" ,x==14);
    }
}
