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
            for (int i = 0; i < allElements.size(); i++) {
                if (allElements.get(i).getName().equals(value)) {
                    elementsThatMatchSearch.add(allElements.get(i));
                }
            }
        }
        if (fieldName.equals("number")) {
            for (int i = 0; i < allElements.size(); i++) {
                if (allElements.get(i).getNumber() == (int)value) {
                    elementsThatMatchSearch.add(allElements.get(i));
                }
            }
        }
        if (fieldName.equals("phase")) {
            for (int i = 0; i < allElements.size(); i++) {
                if (allElements.get(i).getPhase().equals(value)) {
                    elementsThatMatchSearch.add(allElements.get(i));
                }
            }
        }

        // And etc etc for every other field

        return elementsThatMatchSearch;
    }

}
