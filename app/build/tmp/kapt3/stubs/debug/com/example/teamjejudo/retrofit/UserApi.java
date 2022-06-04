package com.example.teamjejudo.retrofit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J^\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u0006H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/example/teamjejudo/retrofit/UserApi;", "", "getFestivals", "Lretrofit2/Call;", "Lcom/example/teamjejudo/data/NearTour;", "serviceKey", "", "mobileOS", "mobileApp", "type", "areaCode", "numOfRows", "arrange", "contentTypeId", "app_debug"})
public abstract interface UserApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "areaBasedList")
    public abstract retrofit2.Call<com.example.teamjejudo.data.NearTour> getFestivals(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "serviceKey")
    java.lang.String serviceKey, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "MobileOS")
    java.lang.String mobileOS, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "MobileApp")
    java.lang.String mobileApp, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "_type")
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "areaCode")
    java.lang.String areaCode, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "numOfRows")
    java.lang.String numOfRows, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "arrange")
    java.lang.String arrange, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "contentTypeId")
    java.lang.String contentTypeId);
}