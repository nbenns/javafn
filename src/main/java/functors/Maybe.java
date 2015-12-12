package javafn.functors;

import java.util.function.*;
import javafn.Functor;

public class Maybe {
	private static class Just<T> implements Functor<T> {
		private T val;

		public Just(T val) {
			this.val = val;
		}
	
		public Functor<T> chain(Function<T, Functor<T>> f) {
			return f.apply(this.val);
		}

		public <R> Functor<R> map(Function<T, R> f) {
			return new Just<R>(f.apply(this.val));
		}

		@Override
		public String toString() {
			return "Just<" +
      	this.val
        	.getClass()
        	.toString()
        	.split(" ")[1] +
      	">(" + this.val + ")";
		}
	}

	private static class Nothing<T> implements Functor<T> {
		public Nothing(T val) {}

		public Functor<T> chain(Function<T, Functor<T>> f) {
			return new Nothing<T>(null);
		}

		public <R> Functor<R> map(Function<T, R> f) {
			return new Nothing<R>(null);
		}

		@Override
		public String toString() {
			return "Nothing()";
		}
	}
 
	private Maybe() { }

	public static <T> Functor<T> of(T val) {
		return (val == null) ? new Maybe.Nothing<T>(val) : new Maybe.Just<T>(val);
	}

	public static <S, T> Function<S, Functor<T>> of(Function<S, T> f) {
		return (S s) -> {
			try {
				T val = f.apply(s);

				return (val == null) ? new Maybe.Nothing<T>(val) : new Maybe.Just<T>(val);
			} catch (Exception ex) {
				return new Maybe.Nothing<T>(null);
			}
		};
	}
}
