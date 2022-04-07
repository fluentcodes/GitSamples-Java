package samples.interfaces;


public class Color implements ColorBlack, ColorWhite {
    public void writeColor(){
        System.out.println("Default is black");
    };
    public void writeColor2(){
        ColorBlack.super.writeColor();
    };
}
