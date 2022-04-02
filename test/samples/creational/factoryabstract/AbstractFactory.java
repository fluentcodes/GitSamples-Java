package samples.creational.factoryabstract;

public interface AbstractFactory<T> {
  T create(final String type);
}
