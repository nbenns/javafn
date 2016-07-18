package javafn.examples;

import java.util.List;
import java.util.Arrays;
import java.util.function.*;
import javafn.Monad;
import javafn.functors.Either;
import javafn.Ops;
import static javafn.Ops.*;
import static javafn.functors.Either.*;

class either {
	public static void main(String [] args)  {

		// Setup

		Function<List<String>, Either> getFirstArg = n -> {
			try {
				return Right(n.get(0));
			} catch (Exception ex) {
				return Left(ex.toString());
			}
		};

		final Function<List<String>, Monad> concatNLog = compose(
			Ops::mLog,
			map(concat(" was provided")),
			getFirstArg
		);

		// Execute

		concatNLog.apply(Arrays.asList(args));
	}
}
