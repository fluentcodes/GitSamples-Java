package samples.stream.stream.collect;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;
import static samples.TestBasics.info;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;
import samples.models.Person;

public class CollectToMapTest {
    private static final Map<String,String> input = createMap();

    private static final Map<String,Map<String,Object>> inputMap = createMapMap();

    List<Map<String,Map<String,Object>>> inputList = createListMap();

    private static Map<String,String> createMap () {
        Map<String,String > result = new HashMap<>();
        result.put("key1","41");
        result.put("key2","42");
        return result;
    }

    private static Map<String,Map<String,Object>> createMapMap () {
        Map<String,Map<String,Object>> result = new HashMap<>();
        Map<String,Object> entry = new HashMap<>();
        entry.put("en","fortytwo");
        entry.put("de","zweiundvierzig");
        result.put("entry1",entry);
        Map<String,Object> entry2 = new HashMap<>();
        entry2.put("en",3.0);
        entry2.put("de",2.0);
        result.put("entry2",entry2);
        return result;
    }

    private static List<Map<String,Map<String,Object>>> createListMap () {
        List<Map<String,Map<String,Object>>> result = new ArrayList<>();
        result.add(createMapMap());
        return result;
    }

    private void checkResult(Map<String,Integer> result) {
        Assert.assertEquals(41,result.get("key1").intValue());
        Assert.assertEquals(42,result.get("key2").intValue());
        info.log("Tested ok");
    }


    @Test
    public void testModifiying()   {
        info.log("Start examples");
        Function<String,Integer> function = Integer::parseInt;
        Map <String,Integer> result = input
            .keySet()
            .stream()
            .collect(Collectors.toMap(Function.identity(),
                key -> function.apply(input.get(key))));
        checkResult(result);


        info.log("Use primitive foreach");
        Map<String, Integer> output1 = new HashMap<>();
        input.forEach((k, v) -> output1.put(k, function.apply(v)));
        checkResult(result);

        info.log("Use collectors");
        result = input
            .entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    (entry) -> entry.getKey(),
                    (entry) -> function.apply(entry.getValue()
                    )));
        checkResult(result);
        Map<String, Integer> output = new HashMap<>();
        input.forEach((k, v) -> output.put(k, Integer.valueOf(v)));
        checkResult(output);


        info.log("With a anonym collector");
        //My StreamEx library
        //result = EntryStream.of(input).mapValues(Integer::valueOf).toMap();


//        Collector <Map<String,String>,Map<String,Integer>> myCollector = Collector.of
//                (
//                        ()-> new HashMap<String,Integer>(),
//                        (mutableMap,entryItem)-> mutableMap.put(entryItem.getKey(),Integer.parseInt(entryItem.getValue())),
//                        (map1,map2)->{ map1.putAll(map2); return map1;}
//                );
//
        Map<String,Integer> newMap = input.
            entrySet().
            stream()
            .collect(
                Collector.of
                    (
                        ()-> new HashMap<String,Integer>(),
                        (mutableMap,entryItem)-> mutableMap.put(entryItem.getKey(),Integer.parseInt(entryItem.getValue())),
                        (map1,map2) -> { map1.putAll(map2); return map1;}
                    ));
        checkResult(newMap);
    }

    @Test
    public void testMapMap() {

        Map<String,Object> result = inputMap
            .entrySet()
            .stream()
            .collect(Collectors.toMap(
                (entry) -> entry.getKey(),
                (entry) -> entry.getValue().get("en")

            ));
        result.forEach((key,val)->info.log(key + " " + val));
    }


    @Test
    public void testListMap() {

        List<Map<String,Object>> result = inputList
            .stream()
            .map(
                fieldsMap->fieldsMap
                    .entrySet()
                    .stream()
                    .collect(
                        Collectors.toMap(
                            (mapEntry) -> mapEntry.getKey(),
                            (mapEntry) -> mapEntry.getValue().get("en")
                        )
                    )
            )
            .collect(Collectors.toList()
            );
        info.log("Finished mapping");
        //result.forEach((key,val)->info.log(key + " " + val));

        Function <Map<String,Map<String,Object>>,Map<String,Object>> reduceToLocaleValues = fieldsMap->fieldsMap
            .entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    (mapEntry) -> mapEntry.getKey(),
                    (mapEntry) -> mapEntry.getValue().get("en")
                )
            );


        result = inputList
            .stream()
            .map(reduceToLocaleValues)
            .collect(Collectors.toList()
            );
        info.log("Finished mapping");

        result = inputList
            .stream()
            .map((x)->this.reduceToLocaleValues(x,new Locale("en")))
            .collect(Collectors.toList()
            );
        info.log("Finished mapping");
    }

    private Map<String,Object> reduceToLocaleValues(Map<String,Map<String,Object>> fieldsMap,Locale locale) {
        return fieldsMap
            .entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    (mapEntry) -> mapEntry.getKey(),
                    (mapEntry) -> mapEntry.getValue().get(locale.getLanguage())
                )
            );
    }

    @Test
    public void groupingByLength() {
        Stream<String> stream = Stream.of("Stefan", "Ralph", "Andi");
        Function<String, Integer> function = String::length;
        Map<Integer, List<String>> mapByLength = stream
            .collect(groupingBy(function));
        assertEquals("Andi", mapByLength.get(4).get(0));
    }

    @Test
    public void partitioningByLengthGreater4() {
        Stream<String> stream = Stream.of("Stefan", "Ralph", "Andi");
        Predicate<String> predicate = str -> str.length() > 4;
        Map<Boolean, List<String>> mapGreater4 = stream
            .collect(Collectors.partitioningBy(predicate));
        assertEquals("Andi", mapGreater4.get(false).get(0));
    }

    @Test
    public void groupingPersonByAge() {
        Stream<Person> stream = Person.getPersonList().stream();
        Function<Person, Integer> function = p -> p.getAge();
        Map<Integer, List<Person>> personsByAge = stream
            .collect(
                Collectors.groupingBy(function)
            );

        assertEquals(42, personsByAge.get(42).get(0).getAge());
    }

    @Test
    public void groupingByPersonCity() {
        Function<Person, String> functionCity = Person::getCity;

        Stream<Person> stream = Person.getPersonList().stream();

        Map<String, List<Person>> collect = stream
            .collect(
                Collectors.groupingBy(functionCity)
            );

        assertEquals("christian", collect.get("munich").get(0).getName());
    }

    @Test
    public void groupingByPersonCityNameSet() {
        Function<Person, String> functionCity = p -> p.getCity();
        Function<Person, String> functionName = Person::getName;

        Stream<Person> stream = Person.getPersonList().stream();

        Map<String, Set<String>> collect = stream
            .collect(
                Collectors.groupingBy(
                    functionCity,
                    Collectors.mapping(functionName, Collectors.toSet())
                )
            );
        assertEquals(1, collect.get("munich").size());
    }

    @Test
    public void groupingByPersonCityNameList() {
        Function<Person, String> functionCity = p -> p.getCity();
        Function<Person, String> functionName = Person::getName;

        Stream<Person> stream = Person.getPersonList().stream();

        Map<String, List<String>> collect = stream
            .collect(
                Collectors
                    .groupingBy(functionCity,
                        Collectors.mapping(functionName, Collectors.toList())
                    )
            );
        assertEquals(2, collect.get("munich").size());
        assertEquals("christian", collect.get("munich").get(0));
    }

    @Test
    public void toMapPersonByAge() {
        Stream<Person> stream = Person.getPersonList().stream();
        Function<Person, Integer> function = p -> p.getAge();
        Function<Person, String> functionName = p -> p.getName();
        BinaryOperator<String> operator = (name1, name2) -> name1 + ";" + name2;
        Map<Integer, String> personsByAge = stream
            .collect(
                Collectors.toMap(
                    function,
                    functionName,
                    operator)
            );

        assertEquals("sing", personsByAge.get(42));
    }

    @Test
    public void collector() {
        Stream<Person> stream = Person.getPersonList().stream();
        Function<Person, Integer> function = p -> p.getAge();
        Function<Person, String> functionName = p -> p.getName();
        BinaryOperator<String> operator = (name1, name2) -> name1 + ";" + name2;
        Map<Integer, String> personsByAge = stream
            .collect(
                Collectors.toMap(
                    function,
                    functionName,
                    operator)
            );

        assertEquals("sing", personsByAge.get(42));
    }


    @Test
    public void testCollectToMap()  {
        Stream<String> stream = Arrays.asList("A","B","C").stream();
        Map<String, String> map = stream
                .collect(HashMap::new,
                    (Map<String, String> m, String s) -> m.put(s, s.toLowerCase(Locale.getDefault())),
                    Map::putAll);
    }

}
