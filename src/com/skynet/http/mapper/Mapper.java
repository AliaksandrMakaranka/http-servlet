package com.skynet.http.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);
}
