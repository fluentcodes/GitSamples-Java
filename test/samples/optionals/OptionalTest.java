package samples.optionals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import samples.optionals.flatMap.Inner;
import samples.optionals.flatMap.Nested;
import samples.optionals.flatMap.Outer;

public class OptionalTest {
    private final String someValue = "Some string";
    private final Optional<String> stringOptional = Optional.of(someValue);

    private final String nullValue = null;
    private final Optional<String> emptyOptional = Optional.ofNullable(nullValue);
//    private final Optional<String> emptyOptional = Optional.empty();

    @Test
    public void getInteger() {
        Integer value = Integer.valueOf(2);
        Optional<Integer> optional = Optional.of(value);
        assertTrue(optional.isPresent());
        assertEquals(value, optional.get());
    }

    @Test
    public void getString() {
        Optional<String> optional = Optional.of("hello");
        assertTrue(optional.isPresent());
        assertEquals(Optional.of("hello"), optional);
        assertEquals("hello", optional.get());
    }

    @Test
    public void ifPresentConsumer() {
        Optional<String> optional = Optional.of("hello");
        Consumer<String> consumer = string -> System.out.println("Consumed: " + string);
        optional.ifPresent(consumer); // print out "Consumed: hello"
    }

    @Test
    public void orElseSupplierHello() {
        Optional<String> optional = Optional.of("hello");
        Supplier<String> supplier = () -> "From supplier";
        assertEquals("hello", optional.orElseGet(supplier));
    }

    @Test
    public void orElseSupplierEmpty() {
        Optional<String> optional = Optional.empty();
        Supplier<String> supplier = () -> "From supplier";
        assertEquals("From supplier", optional.orElseGet(supplier));
    }

    @Test(expected = NoSuchElementException.class)
    public void empty() {
        Optional<String> optional = Optional.empty();
        assertFalse(optional.isPresent());
        optional.get();
    }

    @Test(expected = NoSuchElementException.class)
    public void ofNullableInteger() {
        Optional<Integer> optionalNull = Optional.ofNullable(null);
        assertFalse(optionalNull.isPresent());
        assertNull(optionalNull.get()); //(Integer)optionalNull.get();
    }

    @Test
    public void orElseIntegerNull() {
        Optional<Integer> optionalNull = Optional.ofNullable(null);
        assertFalse(optionalNull.isPresent());
        assertEquals(Integer.valueOf(0), optionalNull.orElse(new Integer(0))); //(Integer)optionalNull.get();
    }

    @Test
    public void orElseInteger() {
        Optional<Integer> optional = Optional.of(new Integer(2));
        assertTrue(optional.isPresent());
        assertEquals(Integer.valueOf(2), optional
            .orElse(new Integer(0)));
    }

    @Test
    public void orElseString() throws Exception {
        Assert.assertEquals("value", Optional.of("value")
            .orElse("not set"));
    }

    @Test
    public void orElseStringEmpty() throws Exception {
        Assert.assertEquals("not set", Optional.empty()
            .orElse("not set"));
    }

    @Test
    public void orElseGetStringLamda() throws Exception {
        Assert.assertEquals("value", Optional.of("value")
            .orElseGet(this::slowCalculation));
    }

    @Test
    public void orElseGetEmtyLamda() throws Exception {
        Assert.assertEquals("calculated 1", Optional.empty()
            .orElseGet(this::slowCalculation));
    }

    private int counter = 0;
    private String slowCalculation() {
        return "calculated " + (++counter);
    }

    @Test
    public void orElseThrowString() throws Exception {
        Assert.assertEquals("value", Optional.of("value")
            .orElseThrow(IllegalStateException::new));
    }

    @Test(expected = IllegalStateException.class)
    public void orElseThrowNull() throws Exception {
        Optional.empty()
            .orElseThrow(IllegalStateException::new);
    }

    @Test(expected = NullPointerException.class)
    public void ofNullNullPointerException() throws Exception {
        final Optional<String> unsafe = Optional.of(null);
    }

    @Test
    public void isPresentString() throws Exception {
        Assert.assertTrue(Optional.of("value").isPresent());
    }

    @Test
    public void isPresentNull() throws Exception {
        Assert.assertFalse(Optional.empty().isPresent());
    }

    @Test
    public void ifPresentString() throws Exception {
        Optional.of("value").ifPresent(System.out::println);
    }

    @Test
    public void ifPresentNull() throws Exception {
        Optional.empty().ifPresent(System.out::println);
    }

    private final String[] inputs =
        { "hello world",
            "what the f...",
            "eCube rules the world",
            "hello optional",
            "world wide nepp"
        };

    private Map<String, List<String>> transformNonOptional() {
        final Map<String, List<String>> tokens = new HashMap<>();

        for (final String input : inputs) {
            for (final String token : input.split(" ")) {
                List<String> contexts = tokens.get(token);
                if (contexts == null) {
                    contexts = new ArrayList<>();
                    tokens.put(token, contexts);
                }
                contexts.add(input);
            }
        }
        return tokens;
    }

    @Test
    public void inputTransformNonOptional() throws Exception {
        final Map<String, List<String>> tokens = transformNonOptional();

        final List<String> helloContexts = tokens.get("hello");
        Assert.assertEquals(2, helloContexts != null ? helloContexts.size() : 0);
        Assert.assertEquals(3, tokens.containsKey("world") ? tokens.get("world").size() : 0);
    }

    private Map<String, List<String>> transformOptional() {
        final Map<String, List<String>> tokens = new HashMap<>();

        for (final String input : inputs) {
            for (final String token : input.split(" ")) {
                Optional
                    .ofNullable(tokens.get(token))
                    .orElseGet(() -> {
                        final List<String> list = new ArrayList<>();
                        tokens.put(token, list);
                        return list;
                    })
                    .add(input);
            }
        }
        return tokens;
    }

    @Test
    public void inputTransformOptional() throws Exception {
        final Map<String, List<String>> tokens = transformOptional();

        Assert.assertEquals(2, Optional.
            ofNullable(tokens.get("hello"))
            .orElseGet(Collections::emptyList)
            .size());
        Assert.assertEquals(3, Optional
            .ofNullable(tokens.get("world"))
            .orElseGet(Collections::emptyList)
            .size());
    }


    @Test
    public void inputTransformOptionalAndForeach() throws Exception {
        final Map<String, List<String>> tokens = new HashMap<>();

        Arrays.asList(inputs)
            .forEach(input ->
                Arrays.asList(input.split(" "))
                    .forEach(token ->
                        Optional
                            .ofNullable(tokens.get(token))
                            .orElseGet(() -> {
                                final List<String> list = new ArrayList<>();
                                tokens.put(token, list);
                                return list;
                            }).add(input)
                )
        );

        Assert.assertEquals(2, Optional.ofNullable(tokens.get("hello")).orElseGet(Collections::emptyList).size());
        Assert.assertEquals(3, Optional.ofNullable(tokens.get("world")).orElseGet(Collections::emptyList).size());
    }

    @Test
    public void filterString() throws Exception {
        final Optional<String> anotherOptional = Optional.of("more stuff");

        stringOptional.filter(s -> s.startsWith("Some")).ifPresent(System.out::println);
        anotherOptional.filter(s -> s.startsWith("Some")).ifPresent(System.out::println);
        emptyOptional.filter(s -> s.startsWith("Some")).ifPresent(System.out::println);
    }

    @Test
    public void filterStringFound() throws Exception {
        Optional.of("Some stuff")
            .filter(s -> s.startsWith("Some"))
            .ifPresent(System.out::println);
    }

    @Test
    public void filterStringNotFound() throws Exception {
        Optional.of("value")
            .filter(s -> s.startsWith("Some"))
            .ifPresent(System.out::println);
    }

    @Test
    public void filterNull() throws Exception {
        Optional.empty()
            .filter(s -> ((String)s).startsWith("Some"))
            .ifPresent(System.out::println);
    }

    @Test
    public void mapOrElseStringLength() throws Exception {
        Assert.assertEquals(5,
            Optional.of("value")
            .map(String::length)
            .orElse(0).longValue());
    }

    @Test
    public void mapOrElseNullLength() throws Exception {
        Assert.assertEquals(0,
            Optional.empty()
            .map(s->((String)s).length())
            .orElse(0).longValue());
    }

    @Test
    public void mapOrElseStringQueued() {
        Optional<Outer> optional = Optional.of(new Outer("value"));
        assertEquals("value", optional
            .map(Outer::getOptional)
            .orElse(Optional.empty())
            .map(Nested::getOptional)
            .orElse(Optional.empty())
            .map(Inner::getFoo)
            .orElse("foo"));
    }

    @Test
    public void mapOrElseEmptyQueued() {
        Optional<Outer> optional = Optional.of(new Outer());
        assertEquals("foo", optional
            .map(Outer::getOptional)
            .orElse(Optional.empty())
            .map(Nested::getOptional)
            .orElse(Optional.empty())
            .map(Inner::getFoo)
            .orElse("foo"));
    }

    @Test
    public void mapOrElseEmptyQueued2() {
        Optional<Outer> optional = Optional.of(new Outer());
        assertEquals("foo", optional
            .map(Outer::getNested)
            .map(Nested::getInner)
            .map(Inner::getFoo)
            .orElse("foo"));
    }

    @Test
    public void mapOrElseStringQueued2() {
        Optional<Outer> optional = Optional.of(new Outer("value"));
        assertEquals("value", optional
            .map(Outer::getNested)
            .map(Nested::getInner)
            .map(Inner::getFoo)
            .orElse("foo"));
    }
}
