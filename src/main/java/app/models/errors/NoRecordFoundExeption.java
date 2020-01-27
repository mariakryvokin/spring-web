package app.models.errors;

import java.util.stream.Stream;

public class NoRecordFoundExeption extends  RuntimeException {

    public NoRecordFoundExeption() {
    }

    public NoRecordFoundExeption(String message){
        super(message);
    }
}
