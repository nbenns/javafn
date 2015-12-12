package javafn.functors;

import java.util.function.*;
import javafn.Functor;

public class Either {
	private static class Right<T> implements Functor<T> {
		private T val;

		public Right(T val) {
			this.val = val;
		}
	
		public Functor<T> chain(Function<T, Functor<T>> f) {
			return f.apply(this.val);
		}

		public <R> Functor<R> map(Function<T, R> f) {
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

	private static class Left<T> implements Functor<T> {
		private T val;

		public Left(T val) {
			this.val = val;
		}

		public Functor<T> chain(Function<T, Functor<T>> f) {
			return new Left<T>(this.val);
		}

		public <R> Functor<R> map(Function<T, R> f) {
			return new Left<R>(f.apply(this.val));
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

	public static <T> Function<T, Functor<T>> of(T left) {
		return (T right) -> (right == null) ? new Either.Left<T>(left) : new Either.Right<T>(right);
	}

	public static <S, T> Function<S, Functor<T>> of(Function<S, T> f, T left) {
		return (S right) -> {
			try {
				T val = f.apply(right);

				return (val == null) ? new Either.Left<T>(left) : new Either.Right<T>(val);
			} catch (Exception ex) {
				return new Either.Left<T>(left);
			}
		};
	}
}
