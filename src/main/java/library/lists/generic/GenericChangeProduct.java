package library.lists.generic;

import java.io.IOException;

public interface GenericChangeProduct<T> {
    void add(T product) throws IOException, ClassNotFoundException;

    void delete(int libraryId) throws IOException;
}
