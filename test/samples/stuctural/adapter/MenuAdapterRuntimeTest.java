package samples.stuctural.adapter;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import samples.stuctural.adapter.strangepath.Menu4;

public class MenuAdapterRuntimeTest {
  List<Object> menus = Arrays.asList(new Menu1(), new Menu2(), new Menu3(), new Menu4());
  @Test
  public void test() {
    for (Object menu: menus) {
      new MenuAdapterRuntime().show(menu);
    }
  }
}
