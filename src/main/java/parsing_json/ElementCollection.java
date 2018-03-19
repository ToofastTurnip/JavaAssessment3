package parsing_json;

import java.util.ArrayList;

public class ElementCollection extends ArrayList<Element>{

    public Element findByAtomicNumber(int atomic_number) {
        for (Element element : this) {
            if (element.getNumber() == atomic_number) {
                return element;
            }
        }
        return null;
    }

    public Element findByName(String name) {
        for (Element element : this) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    public ElementCollection where(String fieldName, Object value) {

        // Surely there's an easier way to do this but I don't know it so here you go :^)

        ElementCollection allElements = ElementCollectionInitializer.generate();
        ElementCollection elementsThatMatchSearch = new ElementCollection();
        if (fieldName.equals("name")) {
            for (Element allElement : allElements) {
                if (allElement.getName().equals(value)) {
                    elementsThatMatchSearch.add(allElement);
                }
            }
        }
        if (fieldName.equals("number")) {
            for (Element allElement : allElements) {
                if (allElement.getNumber() == (int) value) {
                    elementsThatMatchSearch.add(allElement);
                }
            }
        }
        if (fieldName.equals("phase")) {
            for (Element allElement : allElements) {
                if (allElement.getPhase().equals(value)) {
                    elementsThatMatchSearch.add(allElement);
                }
            }
        }

        // And etc etc for every other field

        return elementsThatMatchSearch;
    }

}
