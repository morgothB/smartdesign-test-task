package testtask.json;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ItemInfo {

    private static AtomicLong cnt = new AtomicLong(0);

    private Long id;
    private String name;
    private String desc;
    private Map<String, String> params;

    public ItemInfo() {
    }

    public static ItemInfo withId(ItemInfo item) {
        return new ItemInfo(item.name, item.desc, item.params);
    }

    private ItemInfo(String name, String description, Map<String, String> params) {
        this.id = cnt.getAndIncrement();
        this.name = name;
        this.desc = description;
        this.params = params;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
