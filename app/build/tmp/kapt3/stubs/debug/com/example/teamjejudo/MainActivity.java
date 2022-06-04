package com.example.teamjejudo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/example/teamjejudo/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "binding", "Lcom/example/teamjejudo/databinding/ActivityMainBinding;", "nearTourDatas", "Ljava/util/ArrayList;", "Lcom/example/teamjejudo/data/NearTourData;", "getNearTourDatas", "()Ljava/util/ArrayList;", "setNearTourDatas", "(Ljava/util/ArrayList;)V", "nearTourItems", "Lcom/example/teamjejudo/data/NearTourItem;", "getNearTourItems", "setNearTourItems", "callNearTour", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.navigation.ui.AppBarConfiguration appBarConfiguration;
    private com.example.teamjejudo.databinding.ActivityMainBinding binding;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.teamjejudo.data.NearTourItem> nearTourItems;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.teamjejudo.data.NearTourData> nearTourDatas;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.teamjejudo.data.NearTourItem> getNearTourItems() {
        return null;
    }
    
    public final void setNearTourItems(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.teamjejudo.data.NearTourItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.teamjejudo.data.NearTourData> getNearTourDatas() {
        return null;
    }
    
    public final void setNearTourDatas(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.teamjejudo.data.NearTourData> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    public final void callNearTour() {
    }
}