package restservice.json;

import restservice.entity.Item;

import java.util.Map;

public class ItemInfoResponse {

    private String id;
    private String name;
    private String desc;
    private Map<String, String> params;

    public ItemInfoResponse() {
    }

    public static ItemInfoResponse withId(ItemInfoResponse item) {
        return new ItemInfoResponse(item.name, item.desc, item.params);
    }

    private ItemInfoResponse(String name, String description, Map<String, String> params) {

        this.name = name;
        this.desc = description;
        this.params = params;
    }

    public ItemInfoResponse(Item item) {
        this.id = item.getItemId();
        this.name = item.getName();
        this.desc = item.getDescription();
        this.params = item.getParams();//item.getParams().stream().collect(Collectors.toMap(ItemParameter::getName, ItemParameter::getValue));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
