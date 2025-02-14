package com.drools.service;

import com.drools.dto.product.ProductDto;
import com.drools.interfaces.IDrools;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessProductDroolsService implements IDrools<ProductDto> {

    @Autowired
    private KieContainer kieContainer;


    @Override
    public void kieService(ProductDto objet) {

        //TODO : adapt with correct objet
        KieSession kieSession = kieContainer.newKieSession("productRulesSession");
        kieSession.insert(objet);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Override
    public void kieServiceCollection(List<ProductDto> objets) {

        //TODO : adapt with correct objet
        KieSession kieSession = kieContainer.newKieSession("productRulesSession");

        for(ProductDto productDto : objets)
        {
            kieSession.insert(productDto);
        }

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
