/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.resource;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author suehara
 */
@Path("Shop")
public class ShopResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ShopResource
     */
    public ShopResource() {
    }

    /**
     * Retrieves representation of an instance of example.resource.ShopResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shop> getJson() {
        List<Shop> shopList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Shop shop = new Shop();
            shop.setShopId(String.valueOf(i));
            shop.setShopName("shopName" + i);
            shopList.add(shop);
        }
        return shopList;
    }


    /**
     * PUT method for updating or creating an instance of ShopResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
