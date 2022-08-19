package com.praxis.dapconnect.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListResponse<T> {
    private T data;
    private int all;
    private int count;
    private int next;

}
