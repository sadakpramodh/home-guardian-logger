package com.mshomeguardian.logger.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/mshomeguardian/logger/data/LocationDao;", "", "getAllLocations", "", "Lcom/mshomeguardian/logger/data/LocationEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLocation", "", "location", "(Lcom/mshomeguardian/logger/data/LocationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface LocationDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertLocation(@org.jetbrains.annotations.NotNull()
    com.mshomeguardian.logger.data.LocationEntity location, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM location_table ORDER BY timestamp DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllLocations(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.mshomeguardian.logger.data.LocationEntity>> $completion);
}