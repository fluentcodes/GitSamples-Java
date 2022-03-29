package samples.solid.dependencyinversion;

public class SwitchWrong {
    private LampWrong lamp;
    private boolean switched;

    public SwitchWrong(LampWrong lamp) {
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
