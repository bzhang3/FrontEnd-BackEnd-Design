package com.bing.unmannedVehicle.rest.services;

import com.bing.unmannedVehicle.rest.db.AbcDao;
import com.linkedin.restli.common.HttpStatus;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.UpdateResponse;
import nam.e.spa.ce.Abc;

/**
 * Created by bingzhang on 8/18/17.
 */
public class AbcService {
    private AbcDao _abcDao;

    public AbcService(AbcDao abcDao){
        _abcDao = abcDao;
    }

    public Abc get(String longUrl){
        Abc abc = _abcDao.get(longUrl);
        if(abc == null){
            abc = calculateAbc(longUrl);
        }
        return abc;
    }

    private Abc calculateAbc(String longUrl){
        Abc abc = new Abc()
                .setLongUrl(longUrl)
                .setShortUrl(new StringBuilder(longUrl).reverse().toString());
        return abc;

    }

    public CreateResponse create(Abc abc){
        _abcDao.insert(abc);
        return new CreateResponse(HttpStatus.S_201_CREATED);
    }

    public UpdateResponse delete(String longUrl){
         _abcDao.delete(longUrl);
         return new UpdateResponse(HttpStatus.S_200_OK);
    }

    public UpdateResponse update(String longUrl, Abc abc){
        _abcDao.update(longUrl, abc);
        return new UpdateResponse(HttpStatus.S_200_OK);
    }



}
