import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {

    @Test
    public void testGetClassString(){
        String[] subStr;
        subStr = this.getClassString().split(",");
        Assert.assertEquals ("String have word Hello ", subStr[0],"Hello");
    }

}
