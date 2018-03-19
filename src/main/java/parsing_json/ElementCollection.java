package parsing_json;

import java.util.ArrayList;

public class ElementCollection extends ArrayList<Element>{

    public Element findByAtomicNumber(int atomic_number) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getNumber() == atomic_number) {
                return this.get(i);
            }
        }
        return null;
    }

    public Element findByName(String name) {
        return null;
    }

    public ElementCollection where(String fieldName, Object value) {
        return null;
    }
}
