package individual;

import java.io.IOException;
import java.util.List;

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

}
