package com.bing.myserver.rest.services;

import com.bing.myserver.rest.r2Client.R2Client;
import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.UpdateResponse;
import jdk.nashorn.internal.runtime.ECMAException;
import nam.e.spa.ce.Abc;

/**
 * Created by bingzhang on 8/21/17.
 */
public class R2ClientService {
    private R2Client _r2Client;

    public R2ClientService(R2Client r2Client){
        _r2Client = r2Client;
    }

    public Abc get(String longUrl) throws Exception{
        return _r2Client.get(longUrl);
    }

    public CreateResponse create(Abc abc) throws Exception{
        _r2Client.create(abc);
        return new CreateResponse(HttpStatus.S_201_CREATED);
    }

    public UpdateResponse delete(String longUrl) throws Exception{
        _r2Client.delete(longUrl);
        return new UpdateResponse(HttpStatus.S_200_OK);
    }

    public UpdateResponse update(String longUrl, Abc abc) throws  Exception{
        _r2Client.update(longUrl, abc);
        return new UpdateResponse(HttpStatus.S_200_OK);
    }
}
