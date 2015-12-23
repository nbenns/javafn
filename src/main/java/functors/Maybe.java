package javafn.functors;

import java.util.function.*;
import javafn.Functor;
import javafn.Monad;

public abstract class Maybe<T> implements Monad<T> {
	private static class Just<T> extends Maybe<T> {
		private T val;

		public Just(final T val) {
			this.val = val;
		}
	
		public <R> Maybe<R> chain(final Function<T, ? extends Monad<R>> f) {
			return (Maybe<R>)f.apply(this.val);
		}

		public <R> Just<R> map(final Function<T, R> f) {
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

	private static class Nothing<T> extends Maybe<T> {
		public Nothing() {}

		public <R> Maybe<R> chain(final Function<T, ? extends Monad<R>> f) {
			return new Nothing<R>();
		}

		public <R> Nothing<R> map(final Function<T, R> f) {
			return new Nothing<R>();
		}

		@Override
		public String toString() {
			return "Nothing()";
		}
	}
 
	private Maybe() { }

	public static <T> Maybe<T> just(final T t) {
		return new Just<T>(t);
	}
	
	public static <T> Maybe<T> nothing() {
		return new Nothing<T>();
	}
}
