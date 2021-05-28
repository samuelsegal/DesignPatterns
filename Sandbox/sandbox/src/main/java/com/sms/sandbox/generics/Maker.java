package com.sms.sandbox.generics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Maker<T> {
  private final Supplier<? extends T> supplier;
  /**
   * We need to store the instance since build must return a new instance.
   * <p>
   * Sadly, we need to rely on type erasure (hence BiConsumer, not BiConsumer<T,V>).
   */
  @SuppressWarnings("rawtypes")
  private final Map<BiConsumer, Object> values = new HashMap<>();

  public Maker(final Supplier<? extends T> supplier) {
    this.supplier = supplier;
  }

  public static <T> Maker<T> create(final Supplier<? extends T> builder) {
    return new Maker<>(builder);
  }

  public <U> Maker<T> set(final BiConsumer<T, U> consumer, final U value) {
    values.put(consumer, value);
    return this;
  }

  @SuppressWarnings("unchecked")
  public T create() {
    final T instance = supplier.get();

    values.forEach((key, value) -> {
      key.accept(instance, value);
    });

    return instance;
  }

  public static void main(final String[] args) {
    final Maker<Data<String>> maker = Maker.create(()-> new Data<>("Great"));

    
    final AtomicInteger generator = new AtomicInteger(0);
    Arrays.asList("Alpha", "Beta", "Gamma").forEach(name -> {
      final Integer id = generator.incrementAndGet();

      maker.set(Data::setData, name);
      final Data foobar = maker.create();

      if (!name.equals(foobar.getData())) {
        throw new AssertionError("expected " + name + ", got " + foobar.getData());
      }

      System.out.println(foobar);

    });

  }          
}