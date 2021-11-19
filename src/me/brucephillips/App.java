package me.brucephillips;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        App app = new App();

        app.run();

    }

    private void run() {

        List<TestObject> testObjectList = createList();

        System.out.printf("Created %d TestObjects\n", testObjectList.size());

        TestObject testObject = findMatch(testObjectList, "symbol50");

        assert (testObject.symbol.equals("symbol50"));

        System.out.printf("Found match for symbol50: %s - %d \n", testObject.symbol, testObject.price);

        TestObject testObject2 = findMatch(testObjectList, "symbol1000");

        assert (testObject2.symbol == null);

        System.out.printf("Did not find match for symbol1000: %s - %d", testObject2.symbol, testObject.price);

    }

    private List<TestObject> createList() {

        List<TestObject> testObjectList = new ArrayList<>();

        for (int i = 1; i < 101; i++) {

            TestObject testObject = new TestObject();
            testObject.symbol = "symbol" + i;
            testObject.price = i * 10;

            testObjectList.add(testObject);

        }

        return testObjectList;

    }

    private TestObject findMatch(List<TestObject> testObjectList, String symbol) {

        TestObject testObject = testObjectList.stream().filter(x -> x.symbol.equals(symbol)).
                findAny().orElseGet(TestObject::new);

        return testObject;


    }


}

class TestObject {

    public String symbol;
    public int price;
    public int size;


}
