package samples.structural.adapter;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class MenuAdapterTest {
  List<MenuAdapter> menus = Arrays.asList(new Menu1Adapter(), new Menu2Adapter(), new Menu3Adapter(), new Menu4Adapter());
  @Test
  public void test() {
    for (MenuAdapter menu: menus) {
      menu.show();
    }
  }
}
