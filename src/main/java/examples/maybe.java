package javafn.examples;

import java.util.List;
import java.util.Arrays;
import java.util.function.*;
import javafn.Functor;
import javafn.functors.Maybe;
import javafn.Ops;

class maybe {
	public static void main(String [] args)  {

		// Setup
		
		final Function<List<String>, Functor<String>> multAndInc = Ops.compose(
			Ops::log,
			Ops.map(Ops.concat(" was provided")),
			Maybe.of(a -> a.get(0))
		);

		// Execute

		multAndInc.apply(Arrays.asList(args));
	}
}
