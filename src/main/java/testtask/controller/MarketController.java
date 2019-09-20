package testtask.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import testtask.json.*;
import testtask.service.MarketService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class MarketController {

    @Autowired
    private MarketService marketService;

    @Autowired
    private Logger logger;

    @PostMapping("/item")
    public NewItemResponse createItem(
            @RequestBody ItemInfo itemInfo) {
        return marketService.createItem(itemInfo);
    }

    @GetMapping("/item")
    public ItemInfo getItemInfo(@RequestParam(name = "id") Long id) {
        return marketService.getItem(id);
    }

}
