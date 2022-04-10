package samples.functional.function_bi;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ToDoubleBiFunctionTest {
  final static ToDoubleBiFunction<Integer, Integer> DIV = (a,b) -> a/b;    // lambda expression
  final Point[] pointArray = new Point[]{
      new Point(1.1,2.1),
      new Point(2.1, 1.5)};

  @Test
  public void apply() {
    double divided = DIV.applyAsDouble(50, 5);
    assertEquals(10.0, divided, 0.1);
  }

  //TODO Idea is to make a DoubleStream
  @Test
  public void stringWithInnerClass() {
    ToDoubleBiFunction<Double, Double> square = (a,b) -> a*a + b*b;
    Stream<Point> pointStream = Arrays.stream(pointArray);
    /*DoubleStream doubleStream = pointStream
        .reduce((x,y)  -> square::applyAsDouble);*/
  }

}
