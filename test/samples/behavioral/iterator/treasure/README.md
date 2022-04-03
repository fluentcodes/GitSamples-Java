## [GitSamples](/../../tree/master) - [Iterator Pattern](/../../tree/java-design-pattern/test/samples/behavioural/state): Treasure Example

[TreasureChestIterator](TreasureChestIterator.java) 
will iterate over the fixed [Treasure](Treasure.java) entries of
[TreasureChest](TreasureChest.java).

Not shure if this is a good example for iterators. 

[TreasureChestIteratorTest](TreasureChestIteratorTest.java) there is an example using it:

    TreasureChestIterator iterator = new TreasureChest().createIterator(TreasureType.RING);
    while (iterator.hasNext()) {
      Treasure item = iterator.next();
      System.out.println(item.getType() + ": " + item.getName());
    }
has a filtered output for **RING**:

    RING: Ring of shadows
    RING: Ring of armor


### Links
* https://java-design-patterns.com/patterns/iterator/