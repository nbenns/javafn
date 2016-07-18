package javafn.examples;

import java.util.List;
import java.util.Arrays;
import java.util.function.*;
import javafn.Functor;
import javafn.functors.Maybe;
import javafn.Ops;
import static javafn.Ops.*;
import static javafn.functors.Maybe.*;

class maybe {
  public static void main(String [] args)  {

    // Setup
    
    Function<List<String>, Maybe> getFirstArg = n -> {
      try {
        return Just(n.get(0));
      } catch (Exception ex) {
        return Nothing();
      }
    };
    
    final Function<List<String>, Functor<String>> concatNLog = compose(
      Ops::mLog,
      map(concat(" was provided")),
      getFirstArg
    );

    // Execute

    concatNLog.apply(Arrays.asList(args));
  }
}
