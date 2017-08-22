package com.bing.myserver.rest.r2Client;

import java.util.Collections;

import com.bing.myserver.rest.resources.R2ClientResource;
import com.linkedin.r2.transport.common.bridge.client.TransportClientAdapter;
import com.linkedin.r2.transport.http.client.HttpClientFactory;
import com.linkedin.restli.client.*;
import nam.e.spa.ce.Abc;
import nam.e.spa.ce.AbcRequestBuilders;


/**
 * Created by bingzhang on 8/21/17.
 */
public class R2Client {

    final String str = "http://localhost:7077/myserver-backend/";
    HttpClientFactory http;
    TransportClientAdapter r2Client;
    RestClient _restClient;

    public R2Client(){
        http = new HttpClientFactory();
        r2Client = new TransportClientAdapter(http.getClient(Collections.<String, String>emptyMap()));
        _restClient = new RestClient(r2Client, str);
    }

    public Abc get(String longUrl) throws Exception{
        //return _dataBase.get(longUrl);

        GetRequest<Abc> request = new AbcRequestBuilders()
                .get()
                .id(longUrl)
                .build();
        Abc abc = _restClient.sendRequest(request).getResponse().getEntity();
        return abc;

    }

    public void create(Abc abc) throws Exception{
    //    _dataBase.put(abc.getLongUrl(), abc);


        CreateIdRequest<String, Abc> requestCreate = new AbcRequestBuilders()
                .create()
                .input(new Abc().setLongUrl(abc.getLongUrl()).setShortUrl(abc.getShortUrl()))
                .build();
        _restClient.sendRequest(requestCreate).getResponse();

    }

    public void delete(String longUrl) throws Exception{
     //   _dataBase.remove(longUrl);


        DeleteRequest<Abc> requestDelete = new AbcRequestBuilders().delete()
                .id(longUrl)
                .build();
        _restClient.sendRequest(requestDelete).getResponse();

    }

    public void update(String longUrl, Abc abc) throws Exception{
     //   _dataBase.put(longUrl, abc);

        UpdateRequest<Abc> requestUpdate = new AbcRequestBuilders()
                .update()
                .id(longUrl)
                .input(new Abc().setLongUrl(longUrl).setShortUrl(abc.getShortUrl()))
                .build();
        _restClient.sendRequest(requestUpdate).getResponse();
    }

//        final String longUrl = "asdfghjkl";
//        // get
//        GetRequest<Abc> request = new AbcRequestBuilders()
//                .get()
//                .id(longUrl)
//                .build();
//        Abc abc = _restClient.sendRequest(request).getResponse().getEntity();
//
//        // create
//        CreateIdRequest<String, Abc> requestCreate = new AbcRequestBuilders()
//                .create()
//                .input(new Abc().setLongUrl(longUrl).setShortUrl("abcd"))
//                .build();
//        _restClient.sendRequest(requestCreate).getResponse();
//
//        // update
//        UpdateRequest<Abc> requestUpdate = new AbcRequestBuilders()
//                .update()
//                .id(longUrl)
//                .input(new Abc().setLongUrl(longUrl).setShortUrl("aaaaaa"))
//                .build();
//        _restClient.sendRequest(requestUpdate).getResponse();
//
//        // delete
//        DeleteRequest<Abc> requestDelete = new AbcRequestBuilders().delete()
//                .id(longUrl)
//                .build();
//        _restClient.sendRequest(requestDelete).getResponse();

}
