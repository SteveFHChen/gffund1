package com.ycnet.dbank.gateway;

import com.ycnet.dbank.gateway.data.common.BaseRequest;
import com.ycnet.dbank.gateway.data.common.BaseResponse;
import com.ycnet.mirage.integration.http.Http;
import com.ycnet.mirage.integration.http.HttpRequest;
import com.ycnet.mirage.integration.json.Json;

/**
 * User: guozp
 * Date: 14-4-20
 * Time: 下午3:15
 */
@Http(url="${gateway.host}")
@Json
public interface DbankGateway {

    @HttpRequest(path="/service/test",method = "GET")
    public BaseResponse testGet(BaseRequest request);

}
