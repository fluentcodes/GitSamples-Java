package samples.behavioral.iterator.treasure;

import org.junit.Test;

public class TreasureChestIteratorTest {
  @Test
  public void test() {
    TreasureChestIterator iterator = new TreasureChest().createIterator(TreasureType.RING);
    while (iterator.hasNext()) {
      Treasure item = iterator.next();
      System.out.println(item.getType() + ": " + item.getName());
    }
  }
}
