import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Collections;

public class ListTest {
    @Test
    public void testList() throws IOException {
        Movie tempList = new Movie();
        tempList.CreateList();

        //Testing if first field of list equals to predefined
        Assert.assertEquals(tempList.CreateList().get(0).getRating(), 9);

        //Testing if last field of list equals to predefined
        Assert.assertEquals(tempList.CreateList().get(9).getRating(), 2);
    }
}
