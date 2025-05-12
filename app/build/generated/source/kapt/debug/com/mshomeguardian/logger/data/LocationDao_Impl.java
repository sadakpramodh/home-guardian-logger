package com.mshomeguardian.logger.data;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class LocationDao_Impl implements LocationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LocationEntity> __insertionAdapterOfLocationEntity;

  public LocationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocationEntity = new EntityInsertionAdapter<LocationEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `location_table` (`timestamp`,`latitude`,`longitude`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocationEntity value) {
        stmt.bindLong(1, value.getTimestamp());
        stmt.bindDouble(2, value.getLatitude());
        stmt.bindDouble(3, value.getLongitude());
      }
    };
  }

  @Override
  public Object insertLocation(final LocationEntity location,
      final Continuation<? super Unit> $completion) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object getAllLocations(final Continuation<? super List<LocationEntity>> $completion) {
    final String _sql = "SELECT * FROM location_table ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    int _argIndex = 1;
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Object _result;
      if(_cursor.moveToFirst()) {
        _result = new Object();
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
