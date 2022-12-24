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
        Assert.assertEquals("bun",bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(95.5f,bun.getPrice(),0);
    }
}