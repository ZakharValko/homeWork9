import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TableTest {

    @InjectMocks
    private Table table;

    @Before
    public void setup() {
        table.setHorse('A', (byte) 1);
    }

    @Test
    public void moveHorse_nominal_possible() {
        boolean actual = table.moveHorse('C', (byte) 2);

        Assert.assertTrue(actual);
    }

    @Test
    public void moveHorse_nominal_impossible() {
        boolean actual = table.moveHorse('D', (byte) 3);

        Assert.assertFalse(actual);
    }

}
