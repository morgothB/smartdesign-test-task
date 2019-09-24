package restservice.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restservice.json.*;
import restservice.service.MarketService;

import java.util.List;
import java.util.Map;

@RestController
public class MarketController {

    @Autowired
    private MarketService marketService;

    @Autowired
    private Logger logger;

    @PostMapping("/item")
    public ItemIdResponse createItem(
            @RequestBody ItemInfoResponse itemInfoResponse) throws Exception{
        return marketService.createItem(itemInfoResponse);
    }

    @GetMapping("/item")
    public ItemInfoResponse getItemInfo(@RequestParam(name = "id") String id) throws Exception {
        return marketService.getItem(id);
    }

    @GetMapping("/item/find")
    public List<ItemIdResponse> findItems(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam Map<String, String> params) throws Exception {
        params.remove("name");
        return marketService.findItem(name, params);

    }
}
