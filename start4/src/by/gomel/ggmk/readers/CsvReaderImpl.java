package by.gomel.ggmk.readers;

import by.gomel.ggmk.beans.Car;
import by.gomel.ggmk.exceptions.SourceException;
import by.gomel.ggmk.factories.CarFactory;
import by.gomel.ggmk.interfaces.ReaderDAO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CsvReaderImpl implements ReaderDAO {
    private Scanner sc;
    private static final String FILE_PATH_KEY = "path_csv";

    public CsvReaderImpl(ResourceBundle rb) throws SourceException {
        try {
            sc = new Scanner(new FileReader(rb.getString(FILE_PATH_KEY)));
        } catch (FileNotFoundException e) {
            throw new SourceException();
        }
    }

    @Override
    public Car nextCar() throws SourceException {
        return CarFactory.getCarFromFactory(sc.nextLine());
    }

    @Override
    public void close() {
        if (sc != null) {
            sc.close();
        }
    }

    @Override
    public boolean hasNext() throws SourceException {
        return sc.hasNextLine();
    }
}
