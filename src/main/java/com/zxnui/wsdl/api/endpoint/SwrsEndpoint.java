package com.zxnui.wsdl.api.endpoint;

import com.zxnui.wsdl.api.model.BDCCLFService;
import com.zxnui.wsdl.api.model.BDCCLFServiceResponse;
import com.zxnui.wsdl.api.service.SwrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SwrsEndpoint {

    private static final String NAMESPACE = "http://tempuri.org/";

    @Autowired
    private SwrsService swrsService;

    @PayloadRoot(namespace = NAMESPACE, localPart = "SwrsService")
    @ResponsePayload
    public BDCCLFServiceResponse index(@RequestPayload BDCCLFService bdcclfService) {
        BDCCLFServiceResponse bdcclfServiceResponse = new BDCCLFServiceResponse();
        bdcclfServiceResponse.setBDCCLFServiceResult(swrsService.index(bdcclfService.getStrXML()));
        return bdcclfServiceResponse;
    }
}
