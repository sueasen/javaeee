/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mfacet.mvn_sample.rest.api;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public String getSampleJson(){
        Map<String, Object> ret = new HashMap<>();
        ret.put("response", "Hello, World");
        return "Hello REST world Json";
//        return JSON.encode(ret);
    } 
}
