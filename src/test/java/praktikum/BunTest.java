package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    Bun bun;

    @Before
    public void setUp(){
        bun = new Bun("bun", 95.5f);
    }

    @Test
    public void getName() {
        Assert.assertEquals(bun.getName(),"bun");
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(bun.getPrice(),95.5f,0);
    }
}