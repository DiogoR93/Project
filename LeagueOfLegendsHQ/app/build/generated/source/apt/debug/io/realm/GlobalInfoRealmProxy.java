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

public class GlobalInfoRealmProxy extends drapps.leagueoflegendshq.models.GlobalInfo
    implements RealmObjectProxy, GlobalInfoRealmProxyInterface {

    static final class GlobalInfoColumnInfo extends ColumnInfo {
        long regionIndex;

        GlobalInfoColumnInfo(SharedRealm realm, Table table) {
            super(1);
            this.regionIndex = addColumnDetails(table, "region", RealmFieldType.STRING);
        }

        GlobalInfoColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GlobalInfoColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GlobalInfoColumnInfo src = (GlobalInfoColumnInfo) rawSrc;
            final GlobalInfoColumnInfo dst = (GlobalInfoColumnInfo) rawDst;
            dst.regionIndex = src.regionIndex;
        }
    }

    private GlobalInfoColumnInfo columnInfo;
    private ProxyState<drapps.leagueoflegendshq.models.GlobalInfo> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("region");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    GlobalInfoRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GlobalInfoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<drapps.leagueoflegendshq.models.GlobalInfo>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$region() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.regionIndex);
    }

    @Override
    public void realmSet$region(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.regionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.regionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.regionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.regionIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("GlobalInfo")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("GlobalInfo");
            realmObjectSchema.add("region", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("GlobalInfo");
    }

    public static GlobalInfoColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_GlobalInfo")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'GlobalInfo' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_GlobalInfo");
        final long columnCount = table.getColumnCount();
        if (columnCount != 1) {
            if (columnCount < 1) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 1 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 1 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 1 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final GlobalInfoColumnInfo columnInfo = new GlobalInfoColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("region")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'region' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("region") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'region' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.regionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'region' is required. Either set @Required to field 'region' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_GlobalInfo";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static drapps.leagueoflegendshq.models.GlobalInfo createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        drapps.leagueoflegendshq.models.GlobalInfo obj = realm.createObjectInternal(drapps.leagueoflegendshq.models.GlobalInfo.class, true, excludeFields);
        if (json.has("region")) {
            if (json.isNull("region")) {
                ((GlobalInfoRealmProxyInterface) obj).realmSet$region(null);
            } else {
                ((GlobalInfoRealmProxyInterface) obj).realmSet$region((String) json.getString("region"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static drapps.leagueoflegendshq.models.GlobalInfo createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        drapps.leagueoflegendshq.models.GlobalInfo obj = new drapps.leagueoflegendshq.models.GlobalInfo();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("region")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GlobalInfoRealmProxyInterface) obj).realmSet$region(null);
                } else {
                    ((GlobalInfoRealmProxyInterface) obj).realmSet$region((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static drapps.leagueoflegendshq.models.GlobalInfo copyOrUpdate(Realm realm, drapps.leagueoflegendshq.models.GlobalInfo object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (drapps.leagueoflegendshq.models.GlobalInfo) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static drapps.leagueoflegendshq.models.GlobalInfo copy(Realm realm, drapps.leagueoflegendshq.models.GlobalInfo newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (drapps.leagueoflegendshq.models.GlobalInfo) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            drapps.leagueoflegendshq.models.GlobalInfo realmObject = realm.createObjectInternal(drapps.leagueoflegendshq.models.GlobalInfo.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((GlobalInfoRealmProxyInterface) realmObject).realmSet$region(((GlobalInfoRealmProxyInterface) newObject).realmGet$region());
            return realmObject;
        }
    }

    public static long insert(Realm realm, drapps.leagueoflegendshq.models.GlobalInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(drapps.leagueoflegendshq.models.GlobalInfo.class);
        long tableNativePtr = table.getNativePtr();
        GlobalInfoColumnInfo columnInfo = (GlobalInfoColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.GlobalInfo.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        String realmGet$region = ((GlobalInfoRealmProxyInterface)object).realmGet$region();
        if (realmGet$region != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(drapps.leagueoflegendshq.models.GlobalInfo.class);
        long tableNativePtr = table.getNativePtr();
        GlobalInfoColumnInfo columnInfo = (GlobalInfoColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.GlobalInfo.class);
        drapps.leagueoflegendshq.models.GlobalInfo object = null;
        while (objects.hasNext()) {
            object = (drapps.leagueoflegendshq.models.GlobalInfo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                String realmGet$region = ((GlobalInfoRealmProxyInterface)object).realmGet$region();
                if (realmGet$region != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, drapps.leagueoflegendshq.models.GlobalInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(drapps.leagueoflegendshq.models.GlobalInfo.class);
        long tableNativePtr = table.getNativePtr();
        GlobalInfoColumnInfo columnInfo = (GlobalInfoColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.GlobalInfo.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        String realmGet$region = ((GlobalInfoRealmProxyInterface)object).realmGet$region();
        if (realmGet$region != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.regionIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(drapps.leagueoflegendshq.models.GlobalInfo.class);
        long tableNativePtr = table.getNativePtr();
        GlobalInfoColumnInfo columnInfo = (GlobalInfoColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.GlobalInfo.class);
        drapps.leagueoflegendshq.models.GlobalInfo object = null;
        while (objects.hasNext()) {
            object = (drapps.leagueoflegendshq.models.GlobalInfo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                String realmGet$region = ((GlobalInfoRealmProxyInterface)object).realmGet$region();
                if (realmGet$region != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.regionIndex, rowIndex, realmGet$region, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.regionIndex, rowIndex, false);
                }
            }
        }
    }

    public static drapps.leagueoflegendshq.models.GlobalInfo createDetachedCopy(drapps.leagueoflegendshq.models.GlobalInfo realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        drapps.leagueoflegendshq.models.GlobalInfo unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (drapps.leagueoflegendshq.models.GlobalInfo)cachedObject.object;
            } else {
                unmanagedObject = (drapps.leagueoflegendshq.models.GlobalInfo)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new drapps.leagueoflegendshq.models.GlobalInfo();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((GlobalInfoRealmProxyInterface) unmanagedObject).realmSet$region(((GlobalInfoRealmProxyInterface) realmObject).realmGet$region());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("GlobalInfo = proxy[");
        stringBuilder.append("{region:");
        stringBuilder.append(realmGet$region() != null ? realmGet$region() : "null");
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
        GlobalInfoRealmProxy aGlobalInfo = (GlobalInfoRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGlobalInfo.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGlobalInfo.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGlobalInfo.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
