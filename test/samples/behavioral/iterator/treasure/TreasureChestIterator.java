package samples.behavioral.iterator.treasure;

import java.util.Iterator;
import java.util.function.Consumer;

public class TreasureChestIterator implements Iterator<Treasure> {
  private final TreasureChest treasureChest;
  private final TreasureType itemType;
  private int position;

  public TreasureChestIterator(TreasureChest treasureChest, TreasureType itemType) {
    this.treasureChest = treasureChest;
    this.itemType = itemType;
  }

  @Override
  public boolean hasNext() {
    return hasNext(position);
  }


  private boolean hasNext(int myPosition) {
    if (myPosition + 1 == treasureChest.getItems().size()) {
      return false;
    }
    Treasure actualItem = treasureChest.getItems().get(myPosition +1 );
    if (actualItem.getType() == itemType) {
      return true;
    }
    return hasNext(myPosition + 1);
  }

  @Override
  public Treasure next() {
    if (position + 1 == treasureChest.getItems().size()) {
      throw new RuntimeException("Reached end");
    }
    position++;

    Treasure actualItem = treasureChest.getItems().get(position);
    if (actualItem.getType() == itemType) {
      return actualItem;
    }
    return next();
  }



  @Override
  public void remove() {
    treasureChest.getItems().remove(position);
  }

  @Override
  public void forEachRemaining(Consumer<? super Treasure> action) {
    Iterator.super.forEachRemaining(action);
  }
}
