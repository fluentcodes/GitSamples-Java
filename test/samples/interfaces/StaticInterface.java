package samples.interfaces;

public interface StaticInterface {
    static void callStatic(int i){
        System.out.println("StaticInterface.callStatic(): Wert = "+i);
    }
}
