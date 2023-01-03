package individual;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RecordsRepository {

    private ObjectMapper jackson = new ObjectMapper();

    public void checkFile() throws IOException {
        boolean fileExists = Files.exists(Path.of("records.json"));

        if (!fileExists) {
            Files.createFile(Path.of("records.json"));
            Files.writeString(Path.of("records.json"), "[]");
        }
    }

    public List<Record> readFromFile() throws IOException {
        String recordsJson = Files.readString(Path.of("records.json"));

        TypeReference<List<Record>> recordTypeReference = new TypeReference<>(){};

        List<Record> records = jackson.readValue(recordsJson, recordTypeReference);

        return records;
    }

    public void writeToFile(List<Record> records) throws IOException {
        String recordsJson = jackson.writeValueAsString(records);

        Files.writeString(Path.of("records.json"), recordsJson);
    }
    
}
