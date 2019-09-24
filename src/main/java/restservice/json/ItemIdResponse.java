package restservice.json;

import restservice.entity.Item;

public class ItemIdResponse {

    private final String id;

    public ItemIdResponse(String id) {
        this.id = id;
    }

    public ItemIdResponse(Item item) {
        this.id = item.getItemId();
    }

    public String getId() {
        return id;
    }
}
