package javafn.examples;

import java.util.List;
import java.util.Arrays;
import java.util.function.*;
import javafn.Monad;
import javafn.functors.Either;
import javafn.Ops;

class either {
	public static void main(String [] args)  {

		// Setup

		Function<List<String>, Either> getFirstArg = n -> {
			try {
				return Either.right(n.get(0));
			} catch (Exception ex) {
				return Either.left(ex.toString());
			}
		};

		final Function<List<String>, Monad> concatNLog = Ops.compose(
			Ops::log,
			Ops.chain(x -> Either.left("meow")),
			Ops.map(Ops.concat(" was provided")),
			getFirstArg
		);

		// Execute

		concatNLog.apply(Arrays.asList(args));
	}
}
