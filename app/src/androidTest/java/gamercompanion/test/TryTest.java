package gamercompanion.test;

import android.test.InstrumentationTestCase;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

import java.io.OptionalDataException;

import gamercompanion.src.utils.tryUtil.Try;

/**
 * Created by dklemm on 24.06.15.
 */
public class TryTest extends InstrumentationTestCase {
    public void testFailure() throws Exception {
        Try<String> tryOfFailure = Try.of(new Supplier<String>() {
            @Override
            public String get() {
                throw new RuntimeException("error");
            }
        });
        assertFalse(tryOfFailure.isSuccess());
        assertEquals(tryOfFailure.failure().getClass(), RuntimeException.class);
        assertEquals(tryOfFailure.failure().getMessage(), "error");
    }

    public void testOf_supplier() throws Exception {
        Try<String> tryOfSuccess = Try.of(new Supplier<String>() {
            @Override
            public String get() {
                return "success";
            }
        });
        assertTrue(tryOfSuccess.isSuccess());
        assertEquals(tryOfSuccess.get(), "success");
    }

    public void testOf_reference() throws Exception {
        Try<String> trySuccess = Try.of("success");
        assertTrue(trySuccess.isSuccess());
        assertEquals(trySuccess.get(), "success");
    }

    public void testSuccessInstances() throws Exception {
        Try<String> try1 = Try.of("String");
        Try<String> try2 = Try.of(new Supplier<String>() {
            @Override
            public String get() {
                throw new RuntimeException("failure");
            }
        });
        Try<String> try3 = Try.of("String");
        ImmutableList<Try<String>> tryList = ImmutableList.of(try1, try2, try3);
        Iterable<String> optionalTries = Try.successInstances(tryList);
        //TODO seems not to work correctly
    }

    public void testTransform() throws Exception {
        Try<String> tryOfSuccess = Try.of(new Supplier<String>() {
            @Override
            public String get() {
                return "success";
            }
        });
        Try<String> transformedTry = tryOfSuccess.transform(new Function<String, String>() {
            @Override
            public String apply(String input) {
                return "" + input.length();
            }
        });
        assertTrue(transformedTry.isSuccess());
        assertEquals(transformedTry.get(),"7");
    }
}
