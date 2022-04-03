package samples.behavioral.iterator.treasure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreasureChest {
  private final List<Treasure> items;


  public TreasureChest() {
    items = Arrays.asList(
        new Treasure(TreasureType.POTION, "Potion of courage"),
        new Treasure(TreasureType.RING, "Ring of shadows"),
        new Treasure(TreasureType.POTION, "Potion of wisdom"),
        new Treasure(TreasureType.POTION, "Potion of blood"),
        new Treasure(TreasureType.WEAPON, "Sword of silver +1"),
        new Treasure(TreasureType.POTION, "Potion of rust"),
        new Treasure(TreasureType.POTION, "Potion of healing"),
        new Treasure(TreasureType.RING, "Ring of armor"),
        new Treasure(TreasureType.WEAPON, "Steel halberd"),
        new Treasure(TreasureType.WEAPON, "Dagger of poison"));
  }

  public TreasureChestIterator createIterator(TreasureType itemType) {
    return new TreasureChestIterator(this, itemType);
  }

  public List<Treasure> getItems() {
    return new ArrayList<>(items);
  }
}
