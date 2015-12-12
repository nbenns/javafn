package javafn.examples;

import java.util.List;
import java.util.Arrays;
import java.util.function.*;
import javafn.Functor;
import javafn.functors.Either;
import javafn.Ops;

class either {
	public static void main(String [] args)  {

		// Setup

		final Function<List<String>, Functor<String>> multAndInc = Ops.compose(
			Ops::log,
			Ops.map(Ops.concat(" was provided")),
			Either.of(a -> a.get(0), "nothing provided")
		);

		// Execute

		multAndInc.apply(Arrays.asList(args));
	}
}
