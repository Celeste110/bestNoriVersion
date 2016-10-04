package com.norialertapp.service;
import com.norialertapp.entity.Product;
import com.norialertapp.entity.Products;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by katherine_celeste on 9/29/16.
 */

@Service
public class ShopifyService {

    @Value("${shopify.api.address}") //The @Value annotation tells Spring where to find the correct value
    private String apiAddress;

    @Value("${shopify.api.key}")
    private String apiToken;

    @Value("${shopify.api.password}")
    private String apiPassword;

    // This method uses a class named RestTemplate to make a get request to an API endpoint URL at Shopify.
    // The resulting JSON is translated into an array of Product objects, which is, in turn, turned into a List.
    public List<Product> listProducts(){
        RestTemplate restTemplate = new RestTemplate();
       // https://apikey:password@hostname/admin/resource.json
        Products forObject = restTemplate.getForObject("https://platafina.myshopify.com/admin/products.json?client_id=08f01f4ed31bbc19ed17134527176a54&access_token=d5c07e911caee6aaa59ed1ec2f6e2d2a", Products.class);
        return Arrays.asList(forObject.getProducts());
    }

}