package com.bing.unmannedVehicle.rest.resources;


import com.bing.unmannedVehicle.rest.db.fake.AbcDaoImpl;
import com.bing.unmannedVehicle.rest.services.AbcService;
import com.bing.unmannedVehicle.rest.services.AbcServiceFactory;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.UpdateResponse;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import nam.e.spa.ce.Abc;


/**
 * Created by bingzhang on 8/18/17.
 */
@RestLiCollection(name = "abc", namespace = "nam.e.spa.ce")
public class AbcResource extends CollectionResourceTemplate<String, Abc> {

    // private AbcService _abcService = new AbcService(new AbcDaoImpl());
    private AbcService _abcService = AbcServiceFactory.createInstance();


    @Override
    public Abc get(String longUrl) {
        return _abcService.get(longUrl);
    }

    // new stuff
    @Override
    public CreateResponse create(Abc abc){
        return _abcService.create(abc);
    }

    @Override
    public UpdateResponse delete(String longUrl){
        return _abcService.delete(longUrl);
    }

    @Override
    public UpdateResponse update(String longUrl, Abc abc){
        return _abcService.update(longUrl, abc);
    }



}
