package com.josh.BoardBack.config;

import com.querydsl.core.Tuple;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CustomTuple implements Serializable {
    private List<Object> values = new ArrayList<>();

    public CustomTuple(Tuple tuple) {
        for(int i=0; i<tuple.size(); i++) {
            values.add(tuple.get(i, Object.class));
        }
    }

}
