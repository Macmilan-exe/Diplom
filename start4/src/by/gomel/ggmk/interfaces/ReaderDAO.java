package by.gomel.ggmk.interfaces;

import by.gomel.ggmk.beans.Car;
import by.gomel.ggmk.exceptions.SourceException;

public interface ReaderDAO extends AutoCloseable{
    Car nextCar() throws SourceException;
    boolean hasNext() throws SourceException;
    @Override
    void close();
}
