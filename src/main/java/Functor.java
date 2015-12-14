package javafn;

import java.util.function.*;

public interface Functor<T> {
 
		public <R> Functor<R> chain(Function<T, Functor<R>> f);

		public <R> Functor<R> map(Function<T, R> f);

}
