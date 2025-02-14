package com.drools.service;

import com.drools.dto.comment.CommentDto;
import com.drools.interfaces.IDrools;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessCommentDroolsService implements IDrools<CommentDto> {

    @Autowired
    private KieContainer kieContainer;

    @Override
    public void kieService(CommentDto objet) {

        //TODO : add mapping with entity
        KieSession kieSession = kieContainer.newKieSession("commentRulesSession");
        kieSession.insert(objet);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Override
    public void kieServiceCollection(List<CommentDto> objets) {

        //TODO : add mapping with entity
        KieSession kieSession = kieContainer.newKieSession("commentRulesSession");

        for(CommentDto comment : objets)
        {
            kieSession.insert(comment);
        }

        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
