package com.bing.unmannedVehicle.rest.resources;


import com.bing.unmannedVehicle.rest.services.XyzService;
import com.bing.unmannedVehicle.rest.services.XyzServiceFactory;
import com.linkedin.restli.common.ComplexResourceKey;
import com.linkedin.restli.common.EmptyRecord;
import com.linkedin.restli.server.CreateResponse;
import com.linkedin.restli.server.UpdateResponse;
import com.linkedin.restli.server.annotations.RestLiCollection;
import com.linkedin.restli.server.resources.ComplexKeyResourceTemplate;
import nam.e.spa.ce.Xyz;
import nam.e.spa.ce.XyzKey;

/**
 * Created by bingzhang on 8/19/17.
 */
@RestLiCollection(name = "xyz", namespace =  "nam.e.spa.ce")
public class XyzResource extends ComplexKeyResourceTemplate<XyzKey, EmptyRecord, Xyz> {

    private XyzService _xyzService = XyzServiceFactory.createInstance();

    @Override
    public Xyz get(ComplexResourceKey<XyzKey, EmptyRecord> complexKey) {
        // code goes here
        XyzKey xyzKey = complexKey.getKey();
        Xyz xyz = new Xyz();

        xyz.setNumA(xyzKey.getNumA());
        xyz.setNumB(xyzKey.getNumB());

        return _xyzService.get(xyzKey);
    }


    @Override
    public CreateResponse create(Xyz xyz)
    {
        return _xyzService.create(xyz);
    }


    @Override
    public UpdateResponse delete(final ComplexResourceKey<XyzKey, EmptyRecord> key)
    {
        return _xyzService.delete(key.getKey());
    }
    @Override
    public UpdateResponse update(final ComplexResourceKey<XyzKey, EmptyRecord> key, final Xyz entity)
    {
        return _xyzService.update(key.getKey(), entity);
    }
}