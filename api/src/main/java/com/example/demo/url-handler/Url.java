/* import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

public class Url{
    private int localid;
    private String urlstr;
    private String urlhash; 

    public Url(String urlstr){
        this.urlstr = urlstr;
    }

    public Url save(Url current_url) {
        /* Map<String, String> mapProduct = (Map<String, String>) this.convertValue(product, Map.class);
         this.jedis.hmset(String.format(keyHash, product.getId()), mapProduct);
         this.jedis.sadd(PRODUCTS, product.getId());
         return url;
         
         return current_url;
     } 
}

*/