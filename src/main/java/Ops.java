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

	public static Function<Functor, Functor> map(Function f) {
		return (Functor F) -> F.map(f);
	}

	public static <T,R> Function<Monad<T>, Monad<R>> chain(Function<T, Monad<R>> f) {
		return (Monad<T> F) -> F.chain(f);
	}

	public static Function compose(
		Function f1
	) {
		return a -> f1.apply(a);
	}

	public static Function compose(
		Function f2,
		Function f1
	) {
		return a -> f2.apply(
			f1.apply(a)
		);
	}

	public static Function compose(
		Function f3,
		Function f2,
		Function f1
	) {
		return a -> f3.apply(
			f2.apply(
				f1.apply(a)
			)
		);
	}

	public static Function compose(
		Function f4,
		Function f3,
		Function f2,
		Function f1
	) {
		return a -> f4.apply(
			f3.apply(
				f2.apply(
					f1.apply(a)
				)
			)
		);
	}

	public static Function compose(
		Function f5,
		Function f4,
		Function f3,
		Function f2,
		Function f1
	) {
		return a -> f5.apply(
			f4.apply(
				f3.apply(
					f2.apply(
						f1.apply(a)
					)
				)
			)
		);
  }

	public static Function compose(
		Function f6,
		Function f5,
		Function f4,
		Function f3,
		Function f2,
		Function f1
	) {
		return a -> f6.apply(
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

