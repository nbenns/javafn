package javafn.functors;

import java.util.function.*;
import javafn.Functor;
import javafn.Monad;

public abstract class Either<T> implements Monad<T> {
  public static class Right<T> extends Either<T> {
    private T val;

    private Right(final T val) {
      this.val = val;
    }
  
    public <R> Either<R> chain(final Function<T, ? extends Monad<R>> f) {
      return (Either<R>)f.apply(this.val);
    }

    public <R> Right<R> map(final Function<T, R> f) {
      return new Right<R>(f.apply(this.val));
    }

    @Override
    public String toString() {
      return "Right<" +
        this.val
        .getClass()
        .toString()
        .split(" ")[1] +
        ">(" + this.val + ")";
    }
  }

  private static class Left<T> extends Either<T> {
    private T val;

    public Left(T val) {
      this.val = val;
    }

    public <R> Either<R> chain(final Function<T, ? extends Monad<R>> f) {
      return new Left<R>((R)this.val);
    }

    public <R> Left<R> map(final Function<T, R> f) {
      return new Left<R>((R)this.val);
    }

    @Override
    public String toString() {
      return "Left<" +
        this.val
        .getClass()
        .toString()
        .split(" ")[1] +
        ">(" + this.val + ")";
    }
  }
 
  private Either() { }
  
  public static <T> Either<T> Right(final T t) {
    return new Right<T>(t);
  }
  
  public static <T> Either<T> Left(final T t) {
    return new Left<T>(t);
  }
}
