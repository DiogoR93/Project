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

public class SummonerInfoRealmProxy extends drapps.leagueoflegendshq.models.SummonerInfo
    implements RealmObjectProxy, SummonerInfoRealmProxyInterface {

    static final class SummonerInfoColumnInfo extends ColumnInfo {
        long idIndex;
        long profileIconIdIndex;
        long queueTypeIndex;
        long tierIndex;
        long rankIndex;
        long leaguePointsIndex;

        SummonerInfoColumnInfo(SharedRealm realm, Table table) {
            super(6);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.profileIconIdIndex = addColumnDetails(table, "profileIconId", RealmFieldType.INTEGER);
            this.queueTypeIndex = addColumnDetails(table, "queueType", RealmFieldType.STRING);
            this.tierIndex = addColumnDetails(table, "tier", RealmFieldType.STRING);
            this.rankIndex = addColumnDetails(table, "rank", RealmFieldType.STRING);
            this.leaguePointsIndex = addColumnDetails(table, "leaguePoints", RealmFieldType.INTEGER);
        }

        SummonerInfoColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new SummonerInfoColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final SummonerInfoColumnInfo src = (SummonerInfoColumnInfo) rawSrc;
            final SummonerInfoColumnInfo dst = (SummonerInfoColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.profileIconIdIndex = src.profileIconIdIndex;
            dst.queueTypeIndex = src.queueTypeIndex;
            dst.tierIndex = src.tierIndex;
            dst.rankIndex = src.rankIndex;
            dst.leaguePointsIndex = src.leaguePointsIndex;
        }
    }

    private SummonerInfoColumnInfo columnInfo;
    private ProxyState<drapps.leagueoflegendshq.models.SummonerInfo> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("profileIconId");
        fieldNames.add("queueType");
        fieldNames.add("tier");
        fieldNames.add("rank");
        fieldNames.add("leaguePoints");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SummonerInfoRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SummonerInfoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<drapps.leagueoflegendshq.models.SummonerInfo>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$profileIconId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.profileIconIdIndex);
    }

    @Override
    public void realmSet$profileIconId(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.profileIconIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.profileIconIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$queueType() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.queueTypeIndex);
    }

    @Override
    public void realmSet$queueType(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.queueTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.queueTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.queueTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.queueTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$tier() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tierIndex);
    }

    @Override
    public void realmSet$tier(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tierIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tierIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tierIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tierIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$rank() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.rankIndex);
    }

    @Override
    public void realmSet$rank(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.rankIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.rankIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.rankIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.rankIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$leaguePoints() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.leaguePointsIndex);
    }

    @Override
    public void realmSet$leaguePoints(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.leaguePointsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.leaguePointsIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("SummonerInfo")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("SummonerInfo");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("profileIconId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("queueType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("tier", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("rank", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("leaguePoints", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("SummonerInfo");
    }

    public static SummonerInfoColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_SummonerInfo")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'SummonerInfo' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_SummonerInfo");
        final long columnCount = table.getColumnCount();
        if (columnCount != 6) {
            if (columnCount < 6) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 6 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 6 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 6 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final SummonerInfoColumnInfo columnInfo = new SummonerInfoColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'id' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'id' does support null values in the existing Realm file. Use corresponding boxed type for field 'id' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("profileIconId")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'profileIconId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("profileIconId") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'profileIconId' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.profileIconIdIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'profileIconId' does support null values in the existing Realm file. Use corresponding boxed type for field 'profileIconId' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("queueType")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'queueType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("queueType") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'queueType' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.queueTypeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'queueType' is required. Either set @Required to field 'queueType' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("tier")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'tier' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("tier") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'tier' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.tierIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'tier' is required. Either set @Required to field 'tier' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("rank")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'rank' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("rank") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'rank' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.rankIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'rank' is required. Either set @Required to field 'rank' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("leaguePoints")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'leaguePoints' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("leaguePoints") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'leaguePoints' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.leaguePointsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'leaguePoints' does support null values in the existing Realm file. Use corresponding boxed type for field 'leaguePoints' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_SummonerInfo";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static drapps.leagueoflegendshq.models.SummonerInfo createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        drapps.leagueoflegendshq.models.SummonerInfo obj = realm.createObjectInternal(drapps.leagueoflegendshq.models.SummonerInfo.class, true, excludeFields);
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                ((SummonerInfoRealmProxyInterface) obj).realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("profileIconId")) {
            if (json.isNull("profileIconId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'profileIconId' to null.");
            } else {
                ((SummonerInfoRealmProxyInterface) obj).realmSet$profileIconId((int) json.getInt("profileIconId"));
            }
        }
        if (json.has("queueType")) {
            if (json.isNull("queueType")) {
                ((SummonerInfoRealmProxyInterface) obj).realmSet$queueType(null);
            } else {
                ((SummonerInfoRealmProxyInterface) obj).realmSet$queueType((String) json.getString("queueType"));
            }
        }
        if (json.has("tier")) {
            if (json.isNull("tier")) {
                ((SummonerInfoRealmProxyInterface) obj).realmSet$tier(null);
            } else {
                ((SummonerInfoRealmProxyInterface) obj).realmSet$tier((String) json.getString("tier"));
            }
        }
        if (json.has("rank")) {
            if (json.isNull("rank")) {
                ((SummonerInfoRealmProxyInterface) obj).realmSet$rank(null);
            } else {
                ((SummonerInfoRealmProxyInterface) obj).realmSet$rank((String) json.getString("rank"));
            }
        }
        if (json.has("leaguePoints")) {
            if (json.isNull("leaguePoints")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'leaguePoints' to null.");
            } else {
                ((SummonerInfoRealmProxyInterface) obj).realmSet$leaguePoints((int) json.getInt("leaguePoints"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static drapps.leagueoflegendshq.models.SummonerInfo createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        drapps.leagueoflegendshq.models.SummonerInfo obj = new drapps.leagueoflegendshq.models.SummonerInfo();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((SummonerInfoRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
            } else if (name.equals("profileIconId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'profileIconId' to null.");
                } else {
                    ((SummonerInfoRealmProxyInterface) obj).realmSet$profileIconId((int) reader.nextInt());
                }
            } else if (name.equals("queueType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SummonerInfoRealmProxyInterface) obj).realmSet$queueType(null);
                } else {
                    ((SummonerInfoRealmProxyInterface) obj).realmSet$queueType((String) reader.nextString());
                }
            } else if (name.equals("tier")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SummonerInfoRealmProxyInterface) obj).realmSet$tier(null);
                } else {
                    ((SummonerInfoRealmProxyInterface) obj).realmSet$tier((String) reader.nextString());
                }
            } else if (name.equals("rank")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SummonerInfoRealmProxyInterface) obj).realmSet$rank(null);
                } else {
                    ((SummonerInfoRealmProxyInterface) obj).realmSet$rank((String) reader.nextString());
                }
            } else if (name.equals("leaguePoints")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'leaguePoints' to null.");
                } else {
                    ((SummonerInfoRealmProxyInterface) obj).realmSet$leaguePoints((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static drapps.leagueoflegendshq.models.SummonerInfo copyOrUpdate(Realm realm, drapps.leagueoflegendshq.models.SummonerInfo object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (drapps.leagueoflegendshq.models.SummonerInfo) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static drapps.leagueoflegendshq.models.SummonerInfo copy(Realm realm, drapps.leagueoflegendshq.models.SummonerInfo newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (drapps.leagueoflegendshq.models.SummonerInfo) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            drapps.leagueoflegendshq.models.SummonerInfo realmObject = realm.createObjectInternal(drapps.leagueoflegendshq.models.SummonerInfo.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((SummonerInfoRealmProxyInterface) realmObject).realmSet$id(((SummonerInfoRealmProxyInterface) newObject).realmGet$id());
            ((SummonerInfoRealmProxyInterface) realmObject).realmSet$profileIconId(((SummonerInfoRealmProxyInterface) newObject).realmGet$profileIconId());
            ((SummonerInfoRealmProxyInterface) realmObject).realmSet$queueType(((SummonerInfoRealmProxyInterface) newObject).realmGet$queueType());
            ((SummonerInfoRealmProxyInterface) realmObject).realmSet$tier(((SummonerInfoRealmProxyInterface) newObject).realmGet$tier());
            ((SummonerInfoRealmProxyInterface) realmObject).realmSet$rank(((SummonerInfoRealmProxyInterface) newObject).realmGet$rank());
            ((SummonerInfoRealmProxyInterface) realmObject).realmSet$leaguePoints(((SummonerInfoRealmProxyInterface) newObject).realmGet$leaguePoints());
            return realmObject;
        }
    }

    public static long insert(Realm realm, drapps.leagueoflegendshq.models.SummonerInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(drapps.leagueoflegendshq.models.SummonerInfo.class);
        long tableNativePtr = table.getNativePtr();
        SummonerInfoColumnInfo columnInfo = (SummonerInfoColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.SummonerInfo.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((SummonerInfoRealmProxyInterface)object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.profileIconIdIndex, rowIndex, ((SummonerInfoRealmProxyInterface)object).realmGet$profileIconId(), false);
        String realmGet$queueType = ((SummonerInfoRealmProxyInterface)object).realmGet$queueType();
        if (realmGet$queueType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.queueTypeIndex, rowIndex, realmGet$queueType, false);
        }
        String realmGet$tier = ((SummonerInfoRealmProxyInterface)object).realmGet$tier();
        if (realmGet$tier != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tierIndex, rowIndex, realmGet$tier, false);
        }
        String realmGet$rank = ((SummonerInfoRealmProxyInterface)object).realmGet$rank();
        if (realmGet$rank != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rankIndex, rowIndex, realmGet$rank, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.leaguePointsIndex, rowIndex, ((SummonerInfoRealmProxyInterface)object).realmGet$leaguePoints(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(drapps.leagueoflegendshq.models.SummonerInfo.class);
        long tableNativePtr = table.getNativePtr();
        SummonerInfoColumnInfo columnInfo = (SummonerInfoColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.SummonerInfo.class);
        drapps.leagueoflegendshq.models.SummonerInfo object = null;
        while (objects.hasNext()) {
            object = (drapps.leagueoflegendshq.models.SummonerInfo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((SummonerInfoRealmProxyInterface)object).realmGet$id(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.profileIconIdIndex, rowIndex, ((SummonerInfoRealmProxyInterface)object).realmGet$profileIconId(), false);
                String realmGet$queueType = ((SummonerInfoRealmProxyInterface)object).realmGet$queueType();
                if (realmGet$queueType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.queueTypeIndex, rowIndex, realmGet$queueType, false);
                }
                String realmGet$tier = ((SummonerInfoRealmProxyInterface)object).realmGet$tier();
                if (realmGet$tier != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.tierIndex, rowIndex, realmGet$tier, false);
                }
                String realmGet$rank = ((SummonerInfoRealmProxyInterface)object).realmGet$rank();
                if (realmGet$rank != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.rankIndex, rowIndex, realmGet$rank, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.leaguePointsIndex, rowIndex, ((SummonerInfoRealmProxyInterface)object).realmGet$leaguePoints(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, drapps.leagueoflegendshq.models.SummonerInfo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(drapps.leagueoflegendshq.models.SummonerInfo.class);
        long tableNativePtr = table.getNativePtr();
        SummonerInfoColumnInfo columnInfo = (SummonerInfoColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.SummonerInfo.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((SummonerInfoRealmProxyInterface)object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.profileIconIdIndex, rowIndex, ((SummonerInfoRealmProxyInterface)object).realmGet$profileIconId(), false);
        String realmGet$queueType = ((SummonerInfoRealmProxyInterface)object).realmGet$queueType();
        if (realmGet$queueType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.queueTypeIndex, rowIndex, realmGet$queueType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.queueTypeIndex, rowIndex, false);
        }
        String realmGet$tier = ((SummonerInfoRealmProxyInterface)object).realmGet$tier();
        if (realmGet$tier != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tierIndex, rowIndex, realmGet$tier, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tierIndex, rowIndex, false);
        }
        String realmGet$rank = ((SummonerInfoRealmProxyInterface)object).realmGet$rank();
        if (realmGet$rank != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rankIndex, rowIndex, realmGet$rank, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.rankIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.leaguePointsIndex, rowIndex, ((SummonerInfoRealmProxyInterface)object).realmGet$leaguePoints(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(drapps.leagueoflegendshq.models.SummonerInfo.class);
        long tableNativePtr = table.getNativePtr();
        SummonerInfoColumnInfo columnInfo = (SummonerInfoColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.SummonerInfo.class);
        drapps.leagueoflegendshq.models.SummonerInfo object = null;
        while (objects.hasNext()) {
            object = (drapps.leagueoflegendshq.models.SummonerInfo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((SummonerInfoRealmProxyInterface)object).realmGet$id(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.profileIconIdIndex, rowIndex, ((SummonerInfoRealmProxyInterface)object).realmGet$profileIconId(), false);
                String realmGet$queueType = ((SummonerInfoRealmProxyInterface)object).realmGet$queueType();
                if (realmGet$queueType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.queueTypeIndex, rowIndex, realmGet$queueType, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.queueTypeIndex, rowIndex, false);
                }
                String realmGet$tier = ((SummonerInfoRealmProxyInterface)object).realmGet$tier();
                if (realmGet$tier != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.tierIndex, rowIndex, realmGet$tier, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.tierIndex, rowIndex, false);
                }
                String realmGet$rank = ((SummonerInfoRealmProxyInterface)object).realmGet$rank();
                if (realmGet$rank != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.rankIndex, rowIndex, realmGet$rank, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.rankIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.leaguePointsIndex, rowIndex, ((SummonerInfoRealmProxyInterface)object).realmGet$leaguePoints(), false);
            }
        }
    }

    public static drapps.leagueoflegendshq.models.SummonerInfo createDetachedCopy(drapps.leagueoflegendshq.models.SummonerInfo realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        drapps.leagueoflegendshq.models.SummonerInfo unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (drapps.leagueoflegendshq.models.SummonerInfo)cachedObject.object;
            } else {
                unmanagedObject = (drapps.leagueoflegendshq.models.SummonerInfo)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new drapps.leagueoflegendshq.models.SummonerInfo();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((SummonerInfoRealmProxyInterface) unmanagedObject).realmSet$id(((SummonerInfoRealmProxyInterface) realmObject).realmGet$id());
        ((SummonerInfoRealmProxyInterface) unmanagedObject).realmSet$profileIconId(((SummonerInfoRealmProxyInterface) realmObject).realmGet$profileIconId());
        ((SummonerInfoRealmProxyInterface) unmanagedObject).realmSet$queueType(((SummonerInfoRealmProxyInterface) realmObject).realmGet$queueType());
        ((SummonerInfoRealmProxyInterface) unmanagedObject).realmSet$tier(((SummonerInfoRealmProxyInterface) realmObject).realmGet$tier());
        ((SummonerInfoRealmProxyInterface) unmanagedObject).realmSet$rank(((SummonerInfoRealmProxyInterface) realmObject).realmGet$rank());
        ((SummonerInfoRealmProxyInterface) unmanagedObject).realmSet$leaguePoints(((SummonerInfoRealmProxyInterface) realmObject).realmGet$leaguePoints());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SummonerInfo = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{profileIconId:");
        stringBuilder.append(realmGet$profileIconId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{queueType:");
        stringBuilder.append(realmGet$queueType() != null ? realmGet$queueType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tier:");
        stringBuilder.append(realmGet$tier() != null ? realmGet$tier() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rank:");
        stringBuilder.append(realmGet$rank() != null ? realmGet$rank() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{leaguePoints:");
        stringBuilder.append(realmGet$leaguePoints());
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
        SummonerInfoRealmProxy aSummonerInfo = (SummonerInfoRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSummonerInfo.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSummonerInfo.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSummonerInfo.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
