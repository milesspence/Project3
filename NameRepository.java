package project3;

import java.util.ArrayList;

/**
 * @author Miles Spence
 */
public class NameRepository implements Container {

    public ArrayList<NameRepository> names = new ArrayList<>();

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {

            if (index < names.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                return names.get(index++);
            }
            return null;
        }
    }
}
