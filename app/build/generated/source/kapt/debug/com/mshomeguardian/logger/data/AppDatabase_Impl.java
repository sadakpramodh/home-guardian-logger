package com.mshomeguardian.logger.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile LocationDao _locationDao;

  private volatile CallLogDao _callLogDao;

  private volatile MessageDao _messageDao;

  private volatile DeviceInfoDao _deviceInfoDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `location_table` (`timestamp` INTEGER NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, PRIMARY KEY(`timestamp`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `call_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `callId` TEXT NOT NULL, `syncTimestamp` INTEGER NOT NULL, `phoneNumber` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `type` INTEGER NOT NULL, `contactName` TEXT, `contactPhotoUri` TEXT, `isRead` INTEGER NOT NULL, `isNew` INTEGER NOT NULL, `deletedLocally` INTEGER NOT NULL, `uploadedToCloud` INTEGER NOT NULL, `uploadTimestamp` INTEGER, `presentationType` INTEGER, `callScreeningAppName` TEXT, `callScreeningComponentName` TEXT, `numberAttributes` TEXT, `geoLocation` TEXT, `phoneAccountId` TEXT, `features` INTEGER, `postDialDigits` TEXT, `viaNumber` TEXT, `deviceId` TEXT NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_call_logs_callId` ON `call_logs` (`callId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_call_logs_phoneNumber` ON `call_logs` (`phoneNumber`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_call_logs_timestamp` ON `call_logs` (`timestamp`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `message_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `messageId` TEXT NOT NULL, `syncTimestamp` INTEGER NOT NULL, `phoneNumber` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `body` TEXT, `type` INTEGER NOT NULL, `subject` TEXT, `messageType` TEXT NOT NULL, `contactName` TEXT, `isRead` INTEGER NOT NULL, `seen` INTEGER NOT NULL, `deliveryStatus` INTEGER, `errorCode` INTEGER, `deletedLocally` INTEGER NOT NULL, `uploadedToCloud` INTEGER NOT NULL, `uploadTimestamp` INTEGER, `thread_id` INTEGER, `person` TEXT, `protocol` INTEGER, `replyPathPresent` INTEGER, `serviceCenter` TEXT, `status` INTEGER, `deviceId` TEXT NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_message_logs_messageId` ON `message_logs` (`messageId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_message_logs_phoneNumber` ON `message_logs` (`phoneNumber`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_message_logs_timestamp` ON `message_logs` (`timestamp`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `device_info` (`deviceId` TEXT NOT NULL, `firstRegistered` INTEGER NOT NULL, `lastUpdated` INTEGER NOT NULL, `manufacturer` TEXT NOT NULL, `brand` TEXT NOT NULL, `model` TEXT NOT NULL, `product` TEXT NOT NULL, `device` TEXT NOT NULL, `hardware` TEXT NOT NULL, `androidVersion` TEXT NOT NULL, `sdkVersion` TEXT NOT NULL, `buildId` TEXT NOT NULL, `androidId` TEXT NOT NULL, `networkOperatorName` TEXT, `networkOperator` TEXT, `networkCountryIso` TEXT, `simOperator` TEXT, `simOperatorName` TEXT, `simCountryIso` TEXT, `imei` TEXT, `phoneType` TEXT, `isActive` INTEGER NOT NULL, `uploadedToCloud` INTEGER NOT NULL, `uploadTimestamp` INTEGER, PRIMARY KEY(`deviceId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1c4d4e96cfd73c78141e58c7f5924139')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `location_table`");
        db.execSQL("DROP TABLE IF EXISTS `call_logs`");
        db.execSQL("DROP TABLE IF EXISTS `message_logs`");
        db.execSQL("DROP TABLE IF EXISTS `device_info`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsLocationTable = new HashMap<String, TableInfo.Column>(3);
        _columnsLocationTable.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationTable.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationTable.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocationTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocationTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocationTable = new TableInfo("location_table", _columnsLocationTable, _foreignKeysLocationTable, _indicesLocationTable);
        final TableInfo _existingLocationTable = TableInfo.read(db, "location_table");
        if (!_infoLocationTable.equals(_existingLocationTable)) {
          return new RoomOpenHelper.ValidationResult(false, "location_table(com.mshomeguardian.logger.data.LocationEntity).\n"
                  + " Expected:\n" + _infoLocationTable + "\n"
                  + " Found:\n" + _existingLocationTable);
        }
        final HashMap<String, TableInfo.Column> _columnsCallLogs = new HashMap<String, TableInfo.Column>(24);
        _columnsCallLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("callId", new TableInfo.Column("callId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("syncTimestamp", new TableInfo.Column("syncTimestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("contactName", new TableInfo.Column("contactName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("contactPhotoUri", new TableInfo.Column("contactPhotoUri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("isRead", new TableInfo.Column("isRead", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("isNew", new TableInfo.Column("isNew", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("deletedLocally", new TableInfo.Column("deletedLocally", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("uploadedToCloud", new TableInfo.Column("uploadedToCloud", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("uploadTimestamp", new TableInfo.Column("uploadTimestamp", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("presentationType", new TableInfo.Column("presentationType", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("callScreeningAppName", new TableInfo.Column("callScreeningAppName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("callScreeningComponentName", new TableInfo.Column("callScreeningComponentName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("numberAttributes", new TableInfo.Column("numberAttributes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("geoLocation", new TableInfo.Column("geoLocation", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("phoneAccountId", new TableInfo.Column("phoneAccountId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("features", new TableInfo.Column("features", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("postDialDigits", new TableInfo.Column("postDialDigits", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("viaNumber", new TableInfo.Column("viaNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCallLogs.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCallLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCallLogs = new HashSet<TableInfo.Index>(3);
        _indicesCallLogs.add(new TableInfo.Index("index_call_logs_callId", true, Arrays.asList("callId"), Arrays.asList("ASC")));
        _indicesCallLogs.add(new TableInfo.Index("index_call_logs_phoneNumber", false, Arrays.asList("phoneNumber"), Arrays.asList("ASC")));
        _indicesCallLogs.add(new TableInfo.Index("index_call_logs_timestamp", false, Arrays.asList("timestamp"), Arrays.asList("ASC")));
        final TableInfo _infoCallLogs = new TableInfo("call_logs", _columnsCallLogs, _foreignKeysCallLogs, _indicesCallLogs);
        final TableInfo _existingCallLogs = TableInfo.read(db, "call_logs");
        if (!_infoCallLogs.equals(_existingCallLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "call_logs(com.mshomeguardian.logger.data.CallLogEntity).\n"
                  + " Expected:\n" + _infoCallLogs + "\n"
                  + " Found:\n" + _existingCallLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsMessageLogs = new HashMap<String, TableInfo.Column>(24);
        _columnsMessageLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("messageId", new TableInfo.Column("messageId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("syncTimestamp", new TableInfo.Column("syncTimestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("body", new TableInfo.Column("body", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("subject", new TableInfo.Column("subject", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("messageType", new TableInfo.Column("messageType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("contactName", new TableInfo.Column("contactName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("isRead", new TableInfo.Column("isRead", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("seen", new TableInfo.Column("seen", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("deliveryStatus", new TableInfo.Column("deliveryStatus", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("errorCode", new TableInfo.Column("errorCode", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("deletedLocally", new TableInfo.Column("deletedLocally", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("uploadedToCloud", new TableInfo.Column("uploadedToCloud", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("uploadTimestamp", new TableInfo.Column("uploadTimestamp", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("thread_id", new TableInfo.Column("thread_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("person", new TableInfo.Column("person", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("protocol", new TableInfo.Column("protocol", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("replyPathPresent", new TableInfo.Column("replyPathPresent", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("serviceCenter", new TableInfo.Column("serviceCenter", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("status", new TableInfo.Column("status", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMessageLogs.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMessageLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMessageLogs = new HashSet<TableInfo.Index>(3);
        _indicesMessageLogs.add(new TableInfo.Index("index_message_logs_messageId", true, Arrays.asList("messageId"), Arrays.asList("ASC")));
        _indicesMessageLogs.add(new TableInfo.Index("index_message_logs_phoneNumber", false, Arrays.asList("phoneNumber"), Arrays.asList("ASC")));
        _indicesMessageLogs.add(new TableInfo.Index("index_message_logs_timestamp", false, Arrays.asList("timestamp"), Arrays.asList("ASC")));
        final TableInfo _infoMessageLogs = new TableInfo("message_logs", _columnsMessageLogs, _foreignKeysMessageLogs, _indicesMessageLogs);
        final TableInfo _existingMessageLogs = TableInfo.read(db, "message_logs");
        if (!_infoMessageLogs.equals(_existingMessageLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "message_logs(com.mshomeguardian.logger.data.MessageEntity).\n"
                  + " Expected:\n" + _infoMessageLogs + "\n"
                  + " Found:\n" + _existingMessageLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsDeviceInfo = new HashMap<String, TableInfo.Column>(24);
        _columnsDeviceInfo.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("firstRegistered", new TableInfo.Column("firstRegistered", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("lastUpdated", new TableInfo.Column("lastUpdated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("manufacturer", new TableInfo.Column("manufacturer", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("brand", new TableInfo.Column("brand", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("model", new TableInfo.Column("model", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("product", new TableInfo.Column("product", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("device", new TableInfo.Column("device", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("hardware", new TableInfo.Column("hardware", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("androidVersion", new TableInfo.Column("androidVersion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("sdkVersion", new TableInfo.Column("sdkVersion", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("buildId", new TableInfo.Column("buildId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("androidId", new TableInfo.Column("androidId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("networkOperatorName", new TableInfo.Column("networkOperatorName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("networkOperator", new TableInfo.Column("networkOperator", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("networkCountryIso", new TableInfo.Column("networkCountryIso", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("simOperator", new TableInfo.Column("simOperator", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("simOperatorName", new TableInfo.Column("simOperatorName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("simCountryIso", new TableInfo.Column("simCountryIso", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("imei", new TableInfo.Column("imei", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("phoneType", new TableInfo.Column("phoneType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("uploadedToCloud", new TableInfo.Column("uploadedToCloud", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDeviceInfo.put("uploadTimestamp", new TableInfo.Column("uploadTimestamp", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDeviceInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDeviceInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDeviceInfo = new TableInfo("device_info", _columnsDeviceInfo, _foreignKeysDeviceInfo, _indicesDeviceInfo);
        final TableInfo _existingDeviceInfo = TableInfo.read(db, "device_info");
        if (!_infoDeviceInfo.equals(_existingDeviceInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "device_info(com.mshomeguardian.logger.data.DeviceInfoEntity).\n"
                  + " Expected:\n" + _infoDeviceInfo + "\n"
                  + " Found:\n" + _existingDeviceInfo);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "1c4d4e96cfd73c78141e58c7f5924139", "77d477946abde60b81a5aefc36219eab");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "location_table","call_logs","message_logs","device_info");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `location_table`");
      _db.execSQL("DELETE FROM `call_logs`");
      _db.execSQL("DELETE FROM `message_logs`");
      _db.execSQL("DELETE FROM `device_info`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(LocationDao.class, LocationDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CallLogDao.class, CallLogDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MessageDao.class, MessageDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DeviceInfoDao.class, DeviceInfoDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public LocationDao locationDao() {
    if (_locationDao != null) {
      return _locationDao;
    } else {
      synchronized(this) {
        if(_locationDao == null) {
          _locationDao = new LocationDao_Impl(this);
        }
        return _locationDao;
      }
    }
  }

  @Override
  public CallLogDao callLogDao() {
    if (_callLogDao != null) {
      return _callLogDao;
    } else {
      synchronized(this) {
        if(_callLogDao == null) {
          _callLogDao = new CallLogDao_Impl(this);
        }
        return _callLogDao;
      }
    }
  }

  @Override
  public MessageDao messageDao() {
    if (_messageDao != null) {
      return _messageDao;
    } else {
      synchronized(this) {
        if(_messageDao == null) {
          _messageDao = new MessageDao_Impl(this);
        }
        return _messageDao;
      }
    }
  }

  @Override
  public DeviceInfoDao deviceInfoDao() {
    if (_deviceInfoDao != null) {
      return _deviceInfoDao;
    } else {
      synchronized(this) {
        if(_deviceInfoDao == null) {
          _deviceInfoDao = new DeviceInfoDao_Impl(this);
        }
        return _deviceInfoDao;
      }
    }
  }
}
