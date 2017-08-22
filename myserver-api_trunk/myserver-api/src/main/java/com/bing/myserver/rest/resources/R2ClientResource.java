package com.bing.myserver.rest.resources;

import com.bing.myserver.rest.services.R2ClientService;

import com.bing.myserver.rest.services.R2ClientServiceFactory;
import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.UpdateResponse;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.CollectionResourceTemplate;
import nam.e.spa.ce.Abc;
import org.apache.http.HttpResponse;

/**
 * Created by bingzhang on 8/21/17.
 */
@RestLiCollection(name = "abc", namespace = "nam.e.spa.ce")
public class R2ClientResource extends CollectionResourceTemplate<String, Abc> {

    private R2ClientService _abcService = R2ClientServiceFactory.createInstance();


    @Override
    public Abc get(String longUrl){
        Abc res = new Abc();
        try {
            res = _abcService.get(longUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    // new stuff
    @Override
    public CreateResponse create(Abc abc){
        try {
            return _abcService.create(abc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CreateResponse(HttpStatus.S_500_INTERNAL_SERVER_ERROR);
    }

    @Override
    public UpdateResponse delete(String longUrl) {
        try {
            return _abcService.delete(longUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new UpdateResponse(HttpStatus.S_500_INTERNAL_SERVER_ERROR);
    }

    @Override
    public UpdateResponse update(String longUrl, Abc abc) {
        try {
            return _abcService.update(longUrl, abc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new UpdateResponse(HttpStatus.S_500_INTERNAL_SERVER_ERROR);
    }
}
