package com.mshomeguardian.logger.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/mshomeguardian/logger/utils/LocationUtils;", "", "()V", "TAG", "", "getLastKnownLocation", "Landroid/location/Location;", "context", "Landroid/content/Context;", "requestSingleLocationUpdate", "app_debug"})
public final class LocationUtils {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "LocationUtils";
    @org.jetbrains.annotations.NotNull()
    public static final com.mshomeguardian.logger.utils.LocationUtils INSTANCE = null;
    
    private LocationUtils() {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @org.jetbrains.annotations.Nullable()
    public final android.location.Location getLastKnownLocation(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final android.location.Location requestSingleLocationUpdate(android.content.Context context) {
        return null;
    }
}