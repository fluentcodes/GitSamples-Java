package samples.behavioral.iterator.treasure;

public class Treasure {

  private final TreasureType type;
  private final String name;

  public Treasure(TreasureType type, String name) {
    this.type = type;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public TreasureType getType() {
    return type;
  }

}
