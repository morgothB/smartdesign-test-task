package restservice.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.IndexedEmbedded;
import restservice.json.ItemInfoResponse;

import javax.persistence.*;
import java.util.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String itemId;

    private String name;

    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @IndexedEmbedded
    private Map<String, String> params = new HashMap<>();

    public Item() {
    }

    public Item(ItemInfoResponse info) {
        this.name = info.getName();
        this.description = info.getDesc();
        this.params = info.getParams();
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}

