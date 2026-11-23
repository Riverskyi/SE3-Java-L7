import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Task5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        Iterator<T> iterator = new Iterator<T>() {
            private boolean takeFromFirst = true;

            @Override
            public boolean hasNext() {
                if (takeFromFirst) {
                    return firstIterator.hasNext() && secondIterator.hasNext();
                }
                return secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                if (takeFromFirst) {
                    T value = firstIterator.next();
                    takeFromFirst = false;
                    return value;
                }

                T value = secondIterator.next();
                takeFromFirst = true;
                return value;
            }
        };

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);
    }
}
