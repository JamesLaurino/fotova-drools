package com.drools.interfaces;

import java.util.List;

public interface IDrools<T> {

    public void kieService(T objet);

    public void kieServiceCollection(List<T> objets);

}
