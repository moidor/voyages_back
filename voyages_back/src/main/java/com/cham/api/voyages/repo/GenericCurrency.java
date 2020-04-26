package com.cham.api.voyages.repo;

public interface GenericCurrency<T> {
    T currency(T entity);
}
