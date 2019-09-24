package restservice.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restservice.dao.ItemDao;
import restservice.json.ItemInfoResponse;
import restservice.json.ItemIdResponse;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Service
public class MarketService {

    @Autowired
    private Logger logger;

    @Autowired
    private ItemDao itemDao;


    public ItemIdResponse createItem(ItemInfoResponse item) throws Exception{
        return new ItemIdResponse(itemDao.createItem(item));
    }

    public ItemInfoResponse getItem(String id) throws Exception{
        return new ItemInfoResponse(itemDao.findItem(id));
    }

    public List<ItemIdResponse> findItem(String name, Map<String, String> params) throws Exception {
        return itemDao.findItems(name, params).stream().map(ItemIdResponse::new).collect(Collectors.toList());
    }

}
