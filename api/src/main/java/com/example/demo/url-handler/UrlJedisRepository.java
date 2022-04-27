/* import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Repository
@RequiredArgsConstructor
public class ProductJedisRepository implements ProductCacheRepository {

    private final Jedis jedis;  

    //private final static String PRODUCTS = "products";
    //private static String keyHash = PRODUCTS.concat(":%s");

    @Override
    public Url save(Url current_url) {
       /* Map<String, String> mapProduct = (Map<String, String>) this.convertValue(product, Map.class);
        this.jedis.hmset(String.format(keyHash, product.getId()), mapProduct);
        this.jedis.sadd(PRODUCTS, product.getId());
        return url;
        
        return current_url;
    }
}
*/