/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfacet.mvn_sample.rest.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import net.arnx.jsonic.JSON;

/**
 *
 * @author suehara
 */
@Path("sampleRestApi")
public class SampleRestApi {

    @GET
    @Path("getTextArgs")
    public String getSampleText(@QueryParam("id") String id, @QueryParam("name") String name){
        return "Hello REST world Get : Id:" + id + " : Name:" + name ;
    } 

    @POST
    @Path("postTextArgs")
    public String postSampleText(@FormParam("id") String id,@FormParam("name") String name){
        return "Hello REST world Post : Id:" + id + " : Name:" + name ;
    } 

    @PUT
    @Path("putTextArgs/{id}/{name}")
    public String putSampleText(@PathParam("id") String id, @PathParam("name") String name ){
        return "Hello REST world Put : Id:" + id + " : Name:" + name ;
    } 

    @GET
    @Path("getText")
    public String getSampleText(){
        return "Hello REST world Get";
    } 

    @POST
    @Path("postText")
    public String postSampleText(){
        return "Hello REST world Post";
    } 

    @PUT
    @Path("putText")
    public String putSampleText(){
        return "Hello REST world Put";
    } 

    @DELETE
    @Path("deleteText")
    public String deleteSampleText(){
        return "Hello REST world Delete";
    } 

    @GET
    @Path("getJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shop> getSampleJson(){
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
     * Retrieves representation of an instance of example.resource.ShopResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getJson2")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shop> getJson2() {
       List<Shop> shopList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Shop shop = new Shop();
            shop.setShopId(String.valueOf(i));
            shop.setShopName("shopName" + i);
            shopList.add(shop);
        }
        return shopList;
    }

}
