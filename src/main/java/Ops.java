package javafn;

import java.util.function.*;

public class Ops {
	public static <T> T identity(T a) {
		return a;
	}

	// can't use generics as we can't guarentee operator overload of +

	/*public static <T> Function<T, T> add(T b) {
		return (T a) -> a + b;
	}*/

	public static <T> T log(T o) {
		System.out.println(o);
		return o;
	}

	public static Function<Integer, Integer> add(Integer b) {
		return (Integer a) -> a + b;
	}

	public static Function<String, String> add(String b) {
		return (String a) -> a + b;
	}

	public static Function<String, String> concat(String b) {
		return (String a) -> a.concat(b);
	}

	public static <T, R> Function<Functor<T>, Functor<R>> map(Function<T, R> f) {
		return (Functor<T> F) -> F.map(f);
	}

	public static <T> Function<Functor<T>, Functor<T>> chain(Function<T, Functor<T>> f) {
		return (Functor<T> F) -> F.chain(f);
	}

	public static <A, B> Function<A, B> compose(
		Function<A, B> f1
	) {
		return (A a) -> f1.apply(a);
	}

	public static <A, B, C> Function<A, C> compose(
		Function<B, C> f2,
		Function<A, B> f1
	) {
		return (A a) -> f2.apply(
			f1.apply(a)
		);
	}

	public static <A, B, C, D> Function<A, D> compose(
		Function<C, D> f3,
		Function<B, C> f2,
		Function<A, B> f1
	) {
		return (A a) -> f3.apply(
			f2.apply(
				f1.apply(a)
			)
		);
	}

	public static <A, B, C, D, E> Function<A, E> compose(
		Function<D, E> f4,
		Function<C, D> f3,
		Function<B, C> f2,
		Function<A, B> f1
	) {
		return (A a) -> f4.apply(
			f3.apply(
				f2.apply(
					f1.apply(a)
				)
			)
		);
	}

	public static <A, B, C, D, E, F> Function<A, F> compose(
		Function<E, F> f5,
		Function<D, E> f4,
		Function<C, D> f3,
		Function<B, C> f2,
		Function<A, B> f1
	) {
		return (A a) -> f5.apply(
			f4.apply(
				f3.apply(
					f2.apply(
						f1.apply(a)
					)
				)
			)
		);
  }

	public static <A, B, C, D, E, F, G> Function<A, G> compose(
		Function<F, G> f6,
		Function<E, F> f5,
		Function<D, E> f4,
		Function<C, D> f3,
		Function<B, C> f2,
		Function<A, B> f1
	) {
		return (A a) -> f6.apply(
			f5.apply(
				f4.apply(
					f3.apply(
						f2.apply(
							f1.apply(a)
						)
					)
				)
			)
		);
	}
}

