package individual;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RecordsService {
    
    public List<Record> getRecords() {
        List<Record> records = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Record r = new Record();
            r.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 16));

            records.add(r);
        }

        return records;
    }

}
