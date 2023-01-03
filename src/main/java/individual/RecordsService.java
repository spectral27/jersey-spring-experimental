package individual;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class RecordsService {

    private RecordsRepository recordsRepository;

    public RecordsRepository getRecordsRepository() {
        return this.recordsRepository;
    }

    public void setRecordsRepository(RecordsRepository recordsRepository) {
        this.recordsRepository = recordsRepository;
    }

    public List<Record> getRecords() throws IOException {
        return recordsRepository.readFromFile();
    }

    public void insertRecord(Record record) throws IOException {
        record.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 16));

        List<Record> records = recordsRepository.readFromFile();
        records.add(record);

        recordsRepository.writeToFile(records);
    }

    public void deleteRecord(String id) throws IOException {
        List<Record> records = recordsRepository.readFromFile();
        records.removeIf(r -> r.getId().equals(id));
        
        recordsRepository.writeToFile(records);
    }

}
