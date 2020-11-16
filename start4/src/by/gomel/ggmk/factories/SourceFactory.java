package by.gomel.ggmk.factories;

import by.gomel.ggmk.exceptions.SourceException;
import by.gomel.ggmk.interfaces.ReaderDAO;
import by.gomel.ggmk.readers.CsvReaderImpl;
import by.gomel.ggmk.readers.DbReaderImpl;

import java.util.ResourceBundle;

public class SourceFactory {
    private static final String READER_KEY = "reader";
    private enum Source{
        DB{
            public ReaderDAO getReader(ResourceBundle rb) throws SourceException{
                return new DbReaderImpl(rb);
            }
        },
        CSV{
            public ReaderDAO getReader(ResourceBundle rb) throws SourceException{
                return new CsvReaderImpl(rb);
            }
        };
        abstract ReaderDAO getReader(ResourceBundle rb) throws SourceException;
    }

    public static ReaderDAO getReaderFromFactory(ResourceBundle rb) throws SourceException{
        Source kind = Source.valueOf(rb.getString(READER_KEY).toUpperCase());
        return kind.getReader(rb);
       // return Source.DB.getReader(rb);
    }

}
