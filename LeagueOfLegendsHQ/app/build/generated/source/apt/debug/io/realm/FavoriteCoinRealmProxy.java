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

public class FavoriteCoinRealmProxy extends drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin
    implements RealmObjectProxy, FavoriteCoinRealmProxyInterface {

    static final class FavoriteCoinColumnInfo extends ColumnInfo {
        long exchangeNameIndex;
        long coinNameIndex;
        long coinSymbolIndex;

        FavoriteCoinColumnInfo(SharedRealm realm, Table table) {
            super(3);
            this.exchangeNameIndex = addColumnDetails(table, "exchangeName", RealmFieldType.STRING);
            this.coinNameIndex = addColumnDetails(table, "coinName", RealmFieldType.STRING);
            this.coinSymbolIndex = addColumnDetails(table, "coinSymbol", RealmFieldType.STRING);
        }

        FavoriteCoinColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new FavoriteCoinColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final FavoriteCoinColumnInfo src = (FavoriteCoinColumnInfo) rawSrc;
            final FavoriteCoinColumnInfo dst = (FavoriteCoinColumnInfo) rawDst;
            dst.exchangeNameIndex = src.exchangeNameIndex;
            dst.coinNameIndex = src.coinNameIndex;
            dst.coinSymbolIndex = src.coinSymbolIndex;
        }
    }

    private FavoriteCoinColumnInfo columnInfo;
    private ProxyState<drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("exchangeName");
        fieldNames.add("coinName");
        fieldNames.add("coinSymbol");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    FavoriteCoinRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (FavoriteCoinColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$exchangeName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.exchangeNameIndex);
    }

    @Override
    public void realmSet$exchangeName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.exchangeNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.exchangeNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.exchangeNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.exchangeNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$coinName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.coinNameIndex);
    }

    @Override
    public void realmSet$coinName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.coinNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.coinNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.coinNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.coinNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$coinSymbol() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.coinSymbolIndex);
    }

    @Override
    public void realmSet$coinSymbol(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.coinSymbolIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.coinSymbolIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.coinSymbolIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.coinSymbolIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("FavoriteCoin")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("FavoriteCoin");
            realmObjectSchema.add("exchangeName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("coinName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("coinSymbol", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("FavoriteCoin");
    }

    public static FavoriteCoinColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_FavoriteCoin")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'FavoriteCoin' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_FavoriteCoin");
        final long columnCount = table.getColumnCount();
        if (columnCount != 3) {
            if (columnCount < 3) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 3 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 3 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 3 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final FavoriteCoinColumnInfo columnInfo = new FavoriteCoinColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("exchangeName")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'exchangeName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("exchangeName") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'exchangeName' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.exchangeNameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'exchangeName' is required. Either set @Required to field 'exchangeName' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("coinName")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'coinName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("coinName") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'coinName' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.coinNameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'coinName' is required. Either set @Required to field 'coinName' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("coinSymbol")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'coinSymbol' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("coinSymbol") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'coinSymbol' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.coinSymbolIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'coinSymbol' is required. Either set @Required to field 'coinSymbol' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_FavoriteCoin";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin obj = realm.createObjectInternal(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class, true, excludeFields);
        if (json.has("exchangeName")) {
            if (json.isNull("exchangeName")) {
                ((FavoriteCoinRealmProxyInterface) obj).realmSet$exchangeName(null);
            } else {
                ((FavoriteCoinRealmProxyInterface) obj).realmSet$exchangeName((String) json.getString("exchangeName"));
            }
        }
        if (json.has("coinName")) {
            if (json.isNull("coinName")) {
                ((FavoriteCoinRealmProxyInterface) obj).realmSet$coinName(null);
            } else {
                ((FavoriteCoinRealmProxyInterface) obj).realmSet$coinName((String) json.getString("coinName"));
            }
        }
        if (json.has("coinSymbol")) {
            if (json.isNull("coinSymbol")) {
                ((FavoriteCoinRealmProxyInterface) obj).realmSet$coinSymbol(null);
            } else {
                ((FavoriteCoinRealmProxyInterface) obj).realmSet$coinSymbol((String) json.getString("coinSymbol"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin obj = new drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("exchangeName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FavoriteCoinRealmProxyInterface) obj).realmSet$exchangeName(null);
                } else {
                    ((FavoriteCoinRealmProxyInterface) obj).realmSet$exchangeName((String) reader.nextString());
                }
            } else if (name.equals("coinName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FavoriteCoinRealmProxyInterface) obj).realmSet$coinName(null);
                } else {
                    ((FavoriteCoinRealmProxyInterface) obj).realmSet$coinName((String) reader.nextString());
                }
            } else if (name.equals("coinSymbol")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FavoriteCoinRealmProxyInterface) obj).realmSet$coinSymbol(null);
                } else {
                    ((FavoriteCoinRealmProxyInterface) obj).realmSet$coinSymbol((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin copyOrUpdate(Realm realm, drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin copy(Realm realm, drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin realmObject = realm.createObjectInternal(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((FavoriteCoinRealmProxyInterface) realmObject).realmSet$exchangeName(((FavoriteCoinRealmProxyInterface) newObject).realmGet$exchangeName());
            ((FavoriteCoinRealmProxyInterface) realmObject).realmSet$coinName(((FavoriteCoinRealmProxyInterface) newObject).realmGet$coinName());
            ((FavoriteCoinRealmProxyInterface) realmObject).realmSet$coinSymbol(((FavoriteCoinRealmProxyInterface) newObject).realmGet$coinSymbol());
            return realmObject;
        }
    }

    public static long insert(Realm realm, drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class);
        long tableNativePtr = table.getNativePtr();
        FavoriteCoinColumnInfo columnInfo = (FavoriteCoinColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        String realmGet$exchangeName = ((FavoriteCoinRealmProxyInterface)object).realmGet$exchangeName();
        if (realmGet$exchangeName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.exchangeNameIndex, rowIndex, realmGet$exchangeName, false);
        }
        String realmGet$coinName = ((FavoriteCoinRealmProxyInterface)object).realmGet$coinName();
        if (realmGet$coinName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coinNameIndex, rowIndex, realmGet$coinName, false);
        }
        String realmGet$coinSymbol = ((FavoriteCoinRealmProxyInterface)object).realmGet$coinSymbol();
        if (realmGet$coinSymbol != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coinSymbolIndex, rowIndex, realmGet$coinSymbol, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class);
        long tableNativePtr = table.getNativePtr();
        FavoriteCoinColumnInfo columnInfo = (FavoriteCoinColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class);
        drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin object = null;
        while (objects.hasNext()) {
            object = (drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                String realmGet$exchangeName = ((FavoriteCoinRealmProxyInterface)object).realmGet$exchangeName();
                if (realmGet$exchangeName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.exchangeNameIndex, rowIndex, realmGet$exchangeName, false);
                }
                String realmGet$coinName = ((FavoriteCoinRealmProxyInterface)object).realmGet$coinName();
                if (realmGet$coinName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.coinNameIndex, rowIndex, realmGet$coinName, false);
                }
                String realmGet$coinSymbol = ((FavoriteCoinRealmProxyInterface)object).realmGet$coinSymbol();
                if (realmGet$coinSymbol != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.coinSymbolIndex, rowIndex, realmGet$coinSymbol, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class);
        long tableNativePtr = table.getNativePtr();
        FavoriteCoinColumnInfo columnInfo = (FavoriteCoinColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        String realmGet$exchangeName = ((FavoriteCoinRealmProxyInterface)object).realmGet$exchangeName();
        if (realmGet$exchangeName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.exchangeNameIndex, rowIndex, realmGet$exchangeName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.exchangeNameIndex, rowIndex, false);
        }
        String realmGet$coinName = ((FavoriteCoinRealmProxyInterface)object).realmGet$coinName();
        if (realmGet$coinName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coinNameIndex, rowIndex, realmGet$coinName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.coinNameIndex, rowIndex, false);
        }
        String realmGet$coinSymbol = ((FavoriteCoinRealmProxyInterface)object).realmGet$coinSymbol();
        if (realmGet$coinSymbol != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coinSymbolIndex, rowIndex, realmGet$coinSymbol, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.coinSymbolIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class);
        long tableNativePtr = table.getNativePtr();
        FavoriteCoinColumnInfo columnInfo = (FavoriteCoinColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class);
        drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin object = null;
        while (objects.hasNext()) {
            object = (drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                String realmGet$exchangeName = ((FavoriteCoinRealmProxyInterface)object).realmGet$exchangeName();
                if (realmGet$exchangeName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.exchangeNameIndex, rowIndex, realmGet$exchangeName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.exchangeNameIndex, rowIndex, false);
                }
                String realmGet$coinName = ((FavoriteCoinRealmProxyInterface)object).realmGet$coinName();
                if (realmGet$coinName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.coinNameIndex, rowIndex, realmGet$coinName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.coinNameIndex, rowIndex, false);
                }
                String realmGet$coinSymbol = ((FavoriteCoinRealmProxyInterface)object).realmGet$coinSymbol();
                if (realmGet$coinSymbol != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.coinSymbolIndex, rowIndex, realmGet$coinSymbol, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.coinSymbolIndex, rowIndex, false);
                }
            }
        }
    }

    public static drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin createDetachedCopy(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin)cachedObject.object;
            } else {
                unmanagedObject = (drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((FavoriteCoinRealmProxyInterface) unmanagedObject).realmSet$exchangeName(((FavoriteCoinRealmProxyInterface) realmObject).realmGet$exchangeName());
        ((FavoriteCoinRealmProxyInterface) unmanagedObject).realmSet$coinName(((FavoriteCoinRealmProxyInterface) realmObject).realmGet$coinName());
        ((FavoriteCoinRealmProxyInterface) unmanagedObject).realmSet$coinSymbol(((FavoriteCoinRealmProxyInterface) realmObject).realmGet$coinSymbol());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("FavoriteCoin = proxy[");
        stringBuilder.append("{exchangeName:");
        stringBuilder.append(realmGet$exchangeName() != null ? realmGet$exchangeName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{coinName:");
        stringBuilder.append(realmGet$coinName() != null ? realmGet$coinName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{coinSymbol:");
        stringBuilder.append(realmGet$coinSymbol() != null ? realmGet$coinSymbol() : "null");
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
        FavoriteCoinRealmProxy aFavoriteCoin = (FavoriteCoinRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aFavoriteCoin.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aFavoriteCoin.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aFavoriteCoin.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
