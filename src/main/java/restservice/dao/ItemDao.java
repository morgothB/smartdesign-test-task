package restservice.dao;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import restservice.entity.Item;
import restservice.json.ItemInfoResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.TransactionManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ItemDao {

    @Autowired
    private TransactionManager transactionManager;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private Logger logger;

    public String createItem(ItemInfoResponse info) throws Exception{
        transactionManager.begin();
        EntityManager em = entityManagerFactory.createEntityManager();
        Item item = new Item(info);
        em.persist(item);
        em.flush();
        em.close();
        transactionManager.commit();
        return item.getItemId();
    }

    public Item findItem(String id) throws Exception {
        transactionManager.begin();
        EntityManager em = entityManagerFactory.createEntityManager();
        Item item = em.find(Item.class, id);
        em.flush();
        em.close();
        transactionManager.commit();
        return item;
    }

    public List<Item> findItems(String name, Map<String, String> params) throws Exception {
        transactionManager.begin();
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Map.Entry<String, String>> mapEntries = new ArrayList<>(params.entrySet());
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("{");
        if (name != null) {
            queryBuilder.append("name : \"").append(name).append("\"");
        }
        if (params.size() > 0) {
            if (queryBuilder.length() > 1) queryBuilder.append(", ");
            queryBuilder.append("\"params.").append(mapEntries.get(0).getKey()).append("\" : ").append("\"").append(mapEntries.get(0).getValue()).append("\"");
        }
        queryBuilder.append("}");
        String query = queryBuilder.toString();
        logger.info("Mongodb find query: " + query);
        List<Item> items = em.createNativeQuery(query, Item.class).getResultList();
        transactionManager.commit();
        return items;
    }

}
