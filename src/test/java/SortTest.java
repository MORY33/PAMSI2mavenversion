import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest {
    @Test
    public void testSort(){
        Bubble bubbling = new Bubble();
        MergeSort merging = new MergeSort();
        OtherSort othering = new OtherSort();

        Assert.assertEquals(bubbling.bubble(), "sorting bubble...");
        Assert.assertEquals(merging.mergeSort(), "Merge sorting...");
        Assert.assertEquals(othering.other(), "Other sorting...");

    }
}
