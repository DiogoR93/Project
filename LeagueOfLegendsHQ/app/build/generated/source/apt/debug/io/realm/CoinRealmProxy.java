package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.OsObject;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CoinRealmProxy extends drapps.leagueoflegendshq.coinlist.Coin
    implements RealmObjectProxy, CoinRealmProxyInterface {

    static final class CoinColumnInfo extends ColumnInfo {
        long fiatIndex;
        long nameIndex;
        long symbolIndex;
        long routeIndex;

        CoinColumnInfo(SharedRealm realm, Table table) {
            super(4);
            this.fiatIndex = addColumnDetails(table, "fiat", RealmFieldType.BOOLEAN);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.symbolIndex = addColumnDetails(table, "symbol", RealmFieldType.STRING);
            this.routeIndex = addColumnDetails(table, "route", RealmFieldType.STRING);
        }

        CoinColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CoinColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CoinColumnInfo src = (CoinColumnInfo) rawSrc;
            final CoinColumnInfo dst = (CoinColumnInfo) rawDst;
            dst.fiatIndex = src.fiatIndex;
            dst.nameIndex = src.nameIndex;
            dst.symbolIndex = src.symbolIndex;
            dst.routeIndex = src.routeIndex;
        }
    }

    private CoinColumnInfo columnInfo;
    private ProxyState<drapps.leagueoflegendshq.coinlist.Coin> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("fiat");
        fieldNames.add("name");
        fieldNames.add("symbol");
        fieldNames.add("route");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CoinRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CoinColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<drapps.leagueoflegendshq.coinlist.Coin>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$fiat() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.fiatIndex);
    }

    @Override
    public void realmSet$fiat(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.fiatIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.fiatIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$symbol() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.symbolIndex);
    }

    @Override
    public void realmSet$symbol(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.symbolIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.symbolIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.symbolIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.symbolIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$route() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.routeIndex);
    }

    @Override
    public void realmSet$route(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.routeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.routeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.routeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.routeIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Coin")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Coin");
            realmObjectSchema.add("fiat", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("symbol", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("route", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Coin");
    }

    public static CoinColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Coin")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Coin' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Coin");
        final long columnCount = table.getColumnCount();
        if (columnCount != 4) {
            if (columnCount < 4) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 4 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 4 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 4 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final CoinColumnInfo columnInfo = new CoinColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("fiat")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fiat' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("fiat") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'fiat' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.fiatIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fiat' does support null values in the existing Realm file. Use corresponding boxed type for field 'fiat' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("name")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("name") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("symbol")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'symbol' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("symbol") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'symbol' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.symbolIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'symbol' is required. Either set @Required to field 'symbol' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("route")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'route' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("route") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'route' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.routeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'route' is required. Either set @Required to field 'route' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Coin";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static drapps.leagueoflegendshq.coinlist.Coin createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        drapps.leagueoflegendshq.coinlist.Coin obj = realm.createObjectInternal(drapps.leagueoflegendshq.coinlist.Coin.class, true, excludeFields);
        if (json.has("fiat")) {
            if (json.isNull("fiat")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'fiat' to null.");
            } else {
                ((CoinRealmProxyInterface) obj).realmSet$fiat((boolean) json.getBoolean("fiat"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((CoinRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((CoinRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("symbol")) {
            if (json.isNull("symbol")) {
                ((CoinRealmProxyInterface) obj).realmSet$symbol(null);
            } else {
                ((CoinRealmProxyInterface) obj).realmSet$symbol((String) json.getString("symbol"));
            }
        }
        if (json.has("route")) {
            if (json.isNull("route")) {
                ((CoinRealmProxyInterface) obj).realmSet$route(null);
            } else {
                ((CoinRealmProxyInterface) obj).realmSet$route((String) json.getString("route"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static drapps.leagueoflegendshq.coinlist.Coin createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        drapps.leagueoflegendshq.coinlist.Coin obj = new drapps.leagueoflegendshq.coinlist.Coin();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("fiat")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'fiat' to null.");
                } else {
                    ((CoinRealmProxyInterface) obj).realmSet$fiat((boolean) reader.nextBoolean());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CoinRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((CoinRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("symbol")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CoinRealmProxyInterface) obj).realmSet$symbol(null);
                } else {
                    ((CoinRealmProxyInterface) obj).realmSet$symbol((String) reader.nextString());
                }
            } else if (name.equals("route")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CoinRealmProxyInterface) obj).realmSet$route(null);
                } else {
                    ((CoinRealmProxyInterface) obj).realmSet$route((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static drapps.leagueoflegendshq.coinlist.Coin copyOrUpdate(Realm realm, drapps.leagueoflegendshq.coinlist.Coin object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (drapps.leagueoflegendshq.coinlist.Coin) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static drapps.leagueoflegendshq.coinlist.Coin copy(Realm realm, drapps.leagueoflegendshq.coinlist.Coin newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (drapps.leagueoflegendshq.coinlist.Coin) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            drapps.leagueoflegendshq.coinlist.Coin realmObject = realm.createObjectInternal(drapps.leagueoflegendshq.coinlist.Coin.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CoinRealmProxyInterface) realmObject).realmSet$fiat(((CoinRealmProxyInterface) newObject).realmGet$fiat());
            ((CoinRealmProxyInterface) realmObject).realmSet$name(((CoinRealmProxyInterface) newObject).realmGet$name());
            ((CoinRealmProxyInterface) realmObject).realmSet$symbol(((CoinRealmProxyInterface) newObject).realmGet$symbol());
            ((CoinRealmProxyInterface) realmObject).realmSet$route(((CoinRealmProxyInterface) newObject).realmGet$route());
            return realmObject;
        }
    }

    public static long insert(Realm realm, drapps.leagueoflegendshq.coinlist.Coin object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(drapps.leagueoflegendshq.coinlist.Coin.class);
        long tableNativePtr = table.getNativePtr();
        CoinColumnInfo columnInfo = (CoinColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.coinlist.Coin.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.fiatIndex, rowIndex, ((CoinRealmProxyInterface)object).realmGet$fiat(), false);
        String realmGet$name = ((CoinRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$symbol = ((CoinRealmProxyInterface)object).realmGet$symbol();
        if (realmGet$symbol != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.symbolIndex, rowIndex, realmGet$symbol, false);
        }
        String realmGet$route = ((CoinRealmProxyInterface)object).realmGet$route();
        if (realmGet$route != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.routeIndex, rowIndex, realmGet$route, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(drapps.leagueoflegendshq.coinlist.Coin.class);
        long tableNativePtr = table.getNativePtr();
        CoinColumnInfo columnInfo = (CoinColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.coinlist.Coin.class);
        drapps.leagueoflegendshq.coinlist.Coin object = null;
        while (objects.hasNext()) {
            object = (drapps.leagueoflegendshq.coinlist.Coin) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.fiatIndex, rowIndex, ((CoinRealmProxyInterface)object).realmGet$fiat(), false);
                String realmGet$name = ((CoinRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$symbol = ((CoinRealmProxyInterface)object).realmGet$symbol();
                if (realmGet$symbol != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.symbolIndex, rowIndex, realmGet$symbol, false);
                }
                String realmGet$route = ((CoinRealmProxyInterface)object).realmGet$route();
                if (realmGet$route != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.routeIndex, rowIndex, realmGet$route, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, drapps.leagueoflegendshq.coinlist.Coin object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(drapps.leagueoflegendshq.coinlist.Coin.class);
        long tableNativePtr = table.getNativePtr();
        CoinColumnInfo columnInfo = (CoinColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.coinlist.Coin.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.fiatIndex, rowIndex, ((CoinRealmProxyInterface)object).realmGet$fiat(), false);
        String realmGet$name = ((CoinRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$symbol = ((CoinRealmProxyInterface)object).realmGet$symbol();
        if (realmGet$symbol != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.symbolIndex, rowIndex, realmGet$symbol, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.symbolIndex, rowIndex, false);
        }
        String realmGet$route = ((CoinRealmProxyInterface)object).realmGet$route();
        if (realmGet$route != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.routeIndex, rowIndex, realmGet$route, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.routeIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(drapps.leagueoflegendshq.coinlist.Coin.class);
        long tableNativePtr = table.getNativePtr();
        CoinColumnInfo columnInfo = (CoinColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.coinlist.Coin.class);
        drapps.leagueoflegendshq.coinlist.Coin object = null;
        while (objects.hasNext()) {
            object = (drapps.leagueoflegendshq.coinlist.Coin) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.fiatIndex, rowIndex, ((CoinRealmProxyInterface)object).realmGet$fiat(), false);
                String realmGet$name = ((CoinRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$symbol = ((CoinRealmProxyInterface)object).realmGet$symbol();
                if (realmGet$symbol != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.symbolIndex, rowIndex, realmGet$symbol, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.symbolIndex, rowIndex, false);
                }
                String realmGet$route = ((CoinRealmProxyInterface)object).realmGet$route();
                if (realmGet$route != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.routeIndex, rowIndex, realmGet$route, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.routeIndex, rowIndex, false);
                }
            }
        }
    }

    public static drapps.leagueoflegendshq.coinlist.Coin createDetachedCopy(drapps.leagueoflegendshq.coinlist.Coin realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        drapps.leagueoflegendshq.coinlist.Coin unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (drapps.leagueoflegendshq.coinlist.Coin)cachedObject.object;
            } else {
                unmanagedObject = (drapps.leagueoflegendshq.coinlist.Coin)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new drapps.leagueoflegendshq.coinlist.Coin();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((CoinRealmProxyInterface) unmanagedObject).realmSet$fiat(((CoinRealmProxyInterface) realmObject).realmGet$fiat());
        ((CoinRealmProxyInterface) unmanagedObject).realmSet$name(((CoinRealmProxyInterface) realmObject).realmGet$name());
        ((CoinRealmProxyInterface) unmanagedObject).realmSet$symbol(((CoinRealmProxyInterface) realmObject).realmGet$symbol());
        ((CoinRealmProxyInterface) unmanagedObject).realmSet$route(((CoinRealmProxyInterface) realmObject).realmGet$route());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Coin = proxy[");
        stringBuilder.append("{fiat:");
        stringBuilder.append(realmGet$fiat());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{symbol:");
        stringBuilder.append(realmGet$symbol() != null ? realmGet$symbol() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{route:");
        stringBuilder.append(realmGet$route() != null ? realmGet$route() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinRealmProxy aCoin = (CoinRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCoin.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCoin.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCoin.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
