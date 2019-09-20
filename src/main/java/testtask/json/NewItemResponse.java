package testtask.json;

import com.fasterxml.jackson.annotation.JsonInclude;

public class NewItemResponse {

    private final long id;

    public NewItemResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
