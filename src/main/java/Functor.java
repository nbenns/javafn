package javafn;

import java.util.function.*;

public interface Functor<T> {
 
		public Functor<T> chain(Function<T, Functor<T>> f);

		public <R> Functor<R> map(Function<T, R> f);

}
