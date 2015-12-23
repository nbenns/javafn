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
		
		Function<List<String>, Maybe> getFirstArg = n -> {
			try {
				return Maybe.just(n.get(0));
			} catch (Exception ex) {
				return Maybe.nothing();
			}
		};
		
		final Function<List<String>, Functor<String>> concatNLog = Ops.compose(
			Ops::log,
			Ops.map(Ops.concat(" was provided")),
			getFirstArg
		);

		// Execute

		concatNLog.apply(Arrays.asList(args));
	}
}
