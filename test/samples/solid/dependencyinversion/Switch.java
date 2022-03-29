package samples.solid.dependencyinversion;

public class Switch {
    private LampInterface lamp;
    private boolean switched;

    public Switch(LampInterface lamp) {
      this.lamp = lamp;
    }

    public void doSwitch() {
      switched = !switched;
      if(switched) {
        lamp.switchOn();
      } else {
        lamp.switchOff();
      }
    }
  }
