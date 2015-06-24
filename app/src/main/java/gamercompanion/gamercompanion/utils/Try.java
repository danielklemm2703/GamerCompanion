package gamercompanion.gamercompanion.utils;

import android.support.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractIterator;

import java.io.Serializable;
import java.util.Iterator;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by dklemm on 16.06.15.
 */
public abstract class Try<T> implements Serializable {
    private static final long serialVersionUID = 0;

    Try() {
    }

    /**
     * Returns an {@code Try} instance with no contained reference.
     *
     * @param t
     *            {@link Throwable} which represents the failure content
     * @return new failure instance
     */
    public static <T> Try<T> failure(final Throwable t) {
        return new Failure<T>(t);
    }

    /**
     * Returns a {@link Success} instance if the supplier returns successfully an instance when
     * calling {@code supplier.get()}. If the supplier throws a {@link Throwable} when accessing
     * {@code supplier.get()} a {@link Failure} instance with the corresponding {@link Throwable}
     * will be returned.
     * <p>
     * If the supplier returns {@code null}, a {@link NullPointerException} is thrown.
     *
     * @param supplier
     *            side-effect operation to simulate call-by-name behavior
     * @throws NullPointerException
     *             if the supplier returns {@code null}
     * @return new instance
     */
    @SuppressWarnings("unchecked")
    public static <T> Try<T> of(final Supplier<? extends T> supplier) {
        checkNotNull(supplier);
        try {
            // safe covariant cast
            return (Try<T>) Try.of(supplier.get());
        } catch (Throwable t) {
            return new Failure<T>(t);
        }
    }

    /**
     * Returns an {@code Try} instance containing the given non-null reference.
     *
     * @param reference
     * @return new instance
     */
    public static <T> Try<T> of(final T reference) {
        return new Success<T>(checkNotNull(reference));
    }

    /**
     * Returns the value of each present instance from the supplied {@code optionals}, in order,
     * skipping over occurrences of {@link Try#failure(Throwable)}. Iterators are unmodifiable and
     * are evaluated lazily.
     *
     * @param tries
     *            {@link Iterable} of {@link Try} instances
     * @return success instances
     */
    public static <T> Iterable<T> successInstances(final Iterable<? extends Try<? extends T>> tries) {
        checkNotNull(tries);
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new AbstractIterator<T>() {
                    private final Iterator<? extends Try<? extends T>> iterator = checkNotNull(tries.iterator());

                    @Override
                    protected T computeNext() {
                        while (iterator.hasNext()) {
                            Try<? extends T> optional = iterator.next();
                            if (optional.isSuccess()) {
                                return optional.get();
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    /**
     * Returns {@code true} if {@code object} is an {@code Try} instance, and either the contained
     * references are {@linkplain Object#equals equal} to each other or both are absent. Note that
     * {@code Try} instances of differing parameterized types can be equal.
     */
    @Override
    public abstract boolean equals(@Nullable Object object);

    /**
     * Returns the contained {@link Throwable}, which must be present. If the instance might be
     * absent an exception will be thrown.
     *
     * @throws IllegalStateException
     *             if the {@link Throwable} instance is absent ({@link #isSuccess} returns
     *             {@code true})
     * @return containing exception
     */
    public abstract Throwable failure();

    /**
     * Returns the contained instance, which must be present. If the instance might be absent, use
     * {@link #or(Object)} instead.
     *
     * @throws IllegalStateException
     *             if the instance is absent ({@link #isSuccess} returns {@code false})
     * @return containing reference
     */
    public abstract T get();

    /**
     * Returns a hash code for this instance.
     */
    @Override
    public abstract int hashCode();

    /**
     * Returns {@code true} if this holder contains a {@link Success} instance.
     *
     * @return {@code true} if this holder contains a {@link Success} instance
     */
    public abstract boolean isSuccess();

    /**
     * Returns the contained instance if it is present; {@code defaultValue} otherwise. If no
     * default value should be required because the instance is known to be present, use
     * {@link #get()} instead.
     * <p>
     * Note about generics: The signature {@code public T or(T defaultValue)} is overly restrictive.
     * However, the ideal signature, {@code public <S super T> S or(S)}, is not legal Java. As a
     * result, some sensible operations involving subtypes are compile errors.
     *
     * @param defaultValue
     *            default value
     * @return containing reference or default value
     */
    public abstract T or(T defaultValue);

    /**
     * Returns this {@code Try} if of type {@link Success}; {@code secondChoice} otherwise.
     *
     * @param secondChoice
     *            second choice
     * @return this instance or second choice
     */
    public abstract Try<T> or(Try<? extends T> secondChoice);

    /**
     * Returns a string representation for this instance. The form of this string representation is
     * unspecified.
     */
    @Override
    public abstract String toString();

    /**
     * If the instance is present, it is transformed with the given {@link Function}; otherwise,
     * {@link Try#failure(Throwable)} is returned. If the function returns {@code null}, a
     * {@link NullPointerException} is thrown.
     *
     * @param function
     * @throws NullPointerException
     *             if the function returns {@code null}
     * @return transformed {@link Try}
     */
    public abstract <V> Try<V> transform(Function<? super T, V> function);
}

