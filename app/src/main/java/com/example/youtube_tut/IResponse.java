package com.example.youtube_tut;

import java.util.List;

public interface IResponse {
    public void onSuccess(List<Domeniu> list);
    public void onError(String errorMes);
}
