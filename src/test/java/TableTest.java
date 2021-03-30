import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TableTest {

    @InjectMocks
    private Table table;

    @Mock
    private Horse horse;

    @Before
    public void setup() {
        horse.setPosition('A', (byte)1);
        //table.setHorse('A', (byte) 1);
    }

    @Test
    public void moveHorse_nominal_possible() {
        when(horse.isPossibleToMove('C', (byte)2)).thenReturn(true);
        boolean actual = table.moveHorse('C', (byte) 2);

        Assert.assertTrue(actual);
    }

    @Test
    public void moveHorse_nominal_impossible_isNotOnTable() {
        table.isOnTable('G', (byte) 12);
        boolean actual = table.moveHorse('G', (byte) 12);

        Assert.assertFalse(actual);
    }

    @Test
    public void moveHorse_nominal_impossible_noRule() {
        when(horse.isPossibleToMove('B', (byte)4)).thenReturn(false);
        boolean actual = table.moveHorse('B', (byte) 4);

        Assert.assertFalse(actual);
    }
}
