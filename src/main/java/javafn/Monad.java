package javafn;

import java.util.function.*;

public interface Monad<T> extends Functor<T> {
  
  public <R> Monad<R> chain(Function<T, ? extends Monad<R>> f);
  
}

