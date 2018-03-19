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
        return null;
    }

}
