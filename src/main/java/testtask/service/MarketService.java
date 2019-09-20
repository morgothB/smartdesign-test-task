package testtask.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testtask.json.ItemInfo;
import testtask.json.NewItemResponse;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class MarketService {

    @Autowired
    private Logger logger;



    private ConcurrentHashMap<Long, ItemInfo> data = new ConcurrentHashMap<>();

    public NewItemResponse createItem(ItemInfo item) {
        ItemInfo newItem = ItemInfo.withId(item);
        data.put(newItem.getId(), newItem);
        return new NewItemResponse(newItem.getId());
    }

    public ItemInfo getItem(Long id) {
        return data.get(id);
    }

}
