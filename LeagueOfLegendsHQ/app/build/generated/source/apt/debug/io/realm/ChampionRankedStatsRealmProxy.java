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

public class ChampionRankedStatsRealmProxy extends drapps.leagueoflegendshq.models.ChampionRankedStats
    implements RealmObjectProxy, ChampionRankedStatsRealmProxyInterface {

    static final class ChampionRankedStatsColumnInfo extends ColumnInfo {
        long idIndex;
        long totalSessionsPlayedIndex;
        long totalSessionsWonIndex;
        long totalSessionsLostIndex;
        long totalChampionKillsIndex;
        long totalDamageDealtIndex;
        long totalDamageTakenIndex;
        long mostChampionKillsPerSessionIndex;
        long totalMinionKillsIndex;
        long totalDoubleKillsIndex;
        long totalTripleKillsIndex;
        long totalQuadraKillsIndex;
        long totalPentaKillsIndex;
        long totalDeathsPerSessionIndex;
        long totalGoldEarnedIndex;
        long totalTurretsKilledIndex;
        long totalPhysicalDamageDealtIndex;
        long totalMagicDamageDealtIndex;
        long totalAssistsIndex;
        long maxChampionsKilledIndex;
        long maxNumDeathsIndex;
        long maxTimeSpentLivingIndex;

        ChampionRankedStatsColumnInfo(SharedRealm realm, Table table) {
            super(22);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.totalSessionsPlayedIndex = addColumnDetails(table, "totalSessionsPlayed", RealmFieldType.INTEGER);
            this.totalSessionsWonIndex = addColumnDetails(table, "totalSessionsWon", RealmFieldType.INTEGER);
            this.totalSessionsLostIndex = addColumnDetails(table, "totalSessionsLost", RealmFieldType.INTEGER);
            this.totalChampionKillsIndex = addColumnDetails(table, "totalChampionKills", RealmFieldType.INTEGER);
            this.totalDamageDealtIndex = addColumnDetails(table, "totalDamageDealt", RealmFieldType.INTEGER);
            this.totalDamageTakenIndex = addColumnDetails(table, "totalDamageTaken", RealmFieldType.INTEGER);
            this.mostChampionKillsPerSessionIndex = addColumnDetails(table, "mostChampionKillsPerSession", RealmFieldType.INTEGER);
            this.totalMinionKillsIndex = addColumnDetails(table, "totalMinionKills", RealmFieldType.INTEGER);
            this.totalDoubleKillsIndex = addColumnDetails(table, "totalDoubleKills", RealmFieldType.INTEGER);
            this.totalTripleKillsIndex = addColumnDetails(table, "totalTripleKills", RealmFieldType.INTEGER);
            this.totalQuadraKillsIndex = addColumnDetails(table, "totalQuadraKills", RealmFieldType.INTEGER);
            this.totalPentaKillsIndex = addColumnDetails(table, "totalPentaKills", RealmFieldType.INTEGER);
            this.totalDeathsPerSessionIndex = addColumnDetails(table, "totalDeathsPerSession", RealmFieldType.INTEGER);
            this.totalGoldEarnedIndex = addColumnDetails(table, "totalGoldEarned", RealmFieldType.INTEGER);
            this.totalTurretsKilledIndex = addColumnDetails(table, "totalTurretsKilled", RealmFieldType.INTEGER);
            this.totalPhysicalDamageDealtIndex = addColumnDetails(table, "totalPhysicalDamageDealt", RealmFieldType.INTEGER);
            this.totalMagicDamageDealtIndex = addColumnDetails(table, "totalMagicDamageDealt", RealmFieldType.INTEGER);
            this.totalAssistsIndex = addColumnDetails(table, "totalAssists", RealmFieldType.INTEGER);
            this.maxChampionsKilledIndex = addColumnDetails(table, "maxChampionsKilled", RealmFieldType.INTEGER);
            this.maxNumDeathsIndex = addColumnDetails(table, "maxNumDeaths", RealmFieldType.INTEGER);
            this.maxTimeSpentLivingIndex = addColumnDetails(table, "maxTimeSpentLiving", RealmFieldType.INTEGER);
        }

        ChampionRankedStatsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ChampionRankedStatsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ChampionRankedStatsColumnInfo src = (ChampionRankedStatsColumnInfo) rawSrc;
            final ChampionRankedStatsColumnInfo dst = (ChampionRankedStatsColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.totalSessionsPlayedIndex = src.totalSessionsPlayedIndex;
            dst.totalSessionsWonIndex = src.totalSessionsWonIndex;
            dst.totalSessionsLostIndex = src.totalSessionsLostIndex;
            dst.totalChampionKillsIndex = src.totalChampionKillsIndex;
            dst.totalDamageDealtIndex = src.totalDamageDealtIndex;
            dst.totalDamageTakenIndex = src.totalDamageTakenIndex;
            dst.mostChampionKillsPerSessionIndex = src.mostChampionKillsPerSessionIndex;
            dst.totalMinionKillsIndex = src.totalMinionKillsIndex;
            dst.totalDoubleKillsIndex = src.totalDoubleKillsIndex;
            dst.totalTripleKillsIndex = src.totalTripleKillsIndex;
            dst.totalQuadraKillsIndex = src.totalQuadraKillsIndex;
            dst.totalPentaKillsIndex = src.totalPentaKillsIndex;
            dst.totalDeathsPerSessionIndex = src.totalDeathsPerSessionIndex;
            dst.totalGoldEarnedIndex = src.totalGoldEarnedIndex;
            dst.totalTurretsKilledIndex = src.totalTurretsKilledIndex;
            dst.totalPhysicalDamageDealtIndex = src.totalPhysicalDamageDealtIndex;
            dst.totalMagicDamageDealtIndex = src.totalMagicDamageDealtIndex;
            dst.totalAssistsIndex = src.totalAssistsIndex;
            dst.maxChampionsKilledIndex = src.maxChampionsKilledIndex;
            dst.maxNumDeathsIndex = src.maxNumDeathsIndex;
            dst.maxTimeSpentLivingIndex = src.maxTimeSpentLivingIndex;
        }
    }

    private ChampionRankedStatsColumnInfo columnInfo;
    private ProxyState<drapps.leagueoflegendshq.models.ChampionRankedStats> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("totalSessionsPlayed");
        fieldNames.add("totalSessionsWon");
        fieldNames.add("totalSessionsLost");
        fieldNames.add("totalChampionKills");
        fieldNames.add("totalDamageDealt");
        fieldNames.add("totalDamageTaken");
        fieldNames.add("mostChampionKillsPerSession");
        fieldNames.add("totalMinionKills");
        fieldNames.add("totalDoubleKills");
        fieldNames.add("totalTripleKills");
        fieldNames.add("totalQuadraKills");
        fieldNames.add("totalPentaKills");
        fieldNames.add("totalDeathsPerSession");
        fieldNames.add("totalGoldEarned");
        fieldNames.add("totalTurretsKilled");
        fieldNames.add("totalPhysicalDamageDealt");
        fieldNames.add("totalMagicDamageDealt");
        fieldNames.add("totalAssists");
        fieldNames.add("maxChampionsKilled");
        fieldNames.add("maxNumDeaths");
        fieldNames.add("maxTimeSpentLiving");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ChampionRankedStatsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ChampionRankedStatsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<drapps.leagueoflegendshq.models.ChampionRankedStats>(this);
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
    public int realmGet$totalSessionsPlayed() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalSessionsPlayedIndex);
    }

    @Override
    public void realmSet$totalSessionsPlayed(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalSessionsPlayedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalSessionsPlayedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalSessionsWon() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalSessionsWonIndex);
    }

    @Override
    public void realmSet$totalSessionsWon(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalSessionsWonIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalSessionsWonIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalSessionsLost() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalSessionsLostIndex);
    }

    @Override
    public void realmSet$totalSessionsLost(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalSessionsLostIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalSessionsLostIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalChampionKills() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalChampionKillsIndex);
    }

    @Override
    public void realmSet$totalChampionKills(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalChampionKillsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalChampionKillsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalDamageDealt() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalDamageDealtIndex);
    }

    @Override
    public void realmSet$totalDamageDealt(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalDamageDealtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalDamageDealtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalDamageTaken() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalDamageTakenIndex);
    }

    @Override
    public void realmSet$totalDamageTaken(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalDamageTakenIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalDamageTakenIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$mostChampionKillsPerSession() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.mostChampionKillsPerSessionIndex);
    }

    @Override
    public void realmSet$mostChampionKillsPerSession(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.mostChampionKillsPerSessionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.mostChampionKillsPerSessionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalMinionKills() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalMinionKillsIndex);
    }

    @Override
    public void realmSet$totalMinionKills(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalMinionKillsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalMinionKillsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalDoubleKills() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalDoubleKillsIndex);
    }

    @Override
    public void realmSet$totalDoubleKills(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalDoubleKillsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalDoubleKillsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalTripleKills() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalTripleKillsIndex);
    }

    @Override
    public void realmSet$totalTripleKills(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalTripleKillsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalTripleKillsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalQuadraKills() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalQuadraKillsIndex);
    }

    @Override
    public void realmSet$totalQuadraKills(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalQuadraKillsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalQuadraKillsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalPentaKills() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalPentaKillsIndex);
    }

    @Override
    public void realmSet$totalPentaKills(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalPentaKillsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalPentaKillsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalDeathsPerSession() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalDeathsPerSessionIndex);
    }

    @Override
    public void realmSet$totalDeathsPerSession(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalDeathsPerSessionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalDeathsPerSessionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalGoldEarned() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalGoldEarnedIndex);
    }

    @Override
    public void realmSet$totalGoldEarned(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalGoldEarnedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalGoldEarnedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalTurretsKilled() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalTurretsKilledIndex);
    }

    @Override
    public void realmSet$totalTurretsKilled(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalTurretsKilledIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalTurretsKilledIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalPhysicalDamageDealt() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalPhysicalDamageDealtIndex);
    }

    @Override
    public void realmSet$totalPhysicalDamageDealt(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalPhysicalDamageDealtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalPhysicalDamageDealtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalMagicDamageDealt() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalMagicDamageDealtIndex);
    }

    @Override
    public void realmSet$totalMagicDamageDealt(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalMagicDamageDealtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalMagicDamageDealtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$totalAssists() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalAssistsIndex);
    }

    @Override
    public void realmSet$totalAssists(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.totalAssistsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.totalAssistsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$maxChampionsKilled() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.maxChampionsKilledIndex);
    }

    @Override
    public void realmSet$maxChampionsKilled(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.maxChampionsKilledIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.maxChampionsKilledIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$maxNumDeaths() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.maxNumDeathsIndex);
    }

    @Override
    public void realmSet$maxNumDeaths(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.maxNumDeathsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.maxNumDeathsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$maxTimeSpentLiving() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.maxTimeSpentLivingIndex);
    }

    @Override
    public void realmSet$maxTimeSpentLiving(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.maxTimeSpentLivingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.maxTimeSpentLivingIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("ChampionRankedStats")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("ChampionRankedStats");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalSessionsPlayed", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalSessionsWon", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalSessionsLost", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalChampionKills", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalDamageDealt", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalDamageTaken", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("mostChampionKillsPerSession", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalMinionKills", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalDoubleKills", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalTripleKills", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalQuadraKills", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalPentaKills", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalDeathsPerSession", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalGoldEarned", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalTurretsKilled", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalPhysicalDamageDealt", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalMagicDamageDealt", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("totalAssists", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("maxChampionsKilled", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("maxNumDeaths", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("maxTimeSpentLiving", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("ChampionRankedStats");
    }

    public static ChampionRankedStatsColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_ChampionRankedStats")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ChampionRankedStats' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_ChampionRankedStats");
        final long columnCount = table.getColumnCount();
        if (columnCount != 22) {
            if (columnCount < 22) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 22 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 22 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 22 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final ChampionRankedStatsColumnInfo columnInfo = new ChampionRankedStatsColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("totalSessionsPlayed")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalSessionsPlayed' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalSessionsPlayed") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalSessionsPlayed' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalSessionsPlayedIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalSessionsPlayed' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalSessionsPlayed' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalSessionsWon")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalSessionsWon' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalSessionsWon") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalSessionsWon' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalSessionsWonIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalSessionsWon' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalSessionsWon' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalSessionsLost")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalSessionsLost' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalSessionsLost") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalSessionsLost' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalSessionsLostIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalSessionsLost' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalSessionsLost' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalChampionKills")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalChampionKills' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalChampionKills") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalChampionKills' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalChampionKillsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalChampionKills' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalChampionKills' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalDamageDealt")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalDamageDealt' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalDamageDealt") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalDamageDealt' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalDamageDealtIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalDamageDealt' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalDamageDealt' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalDamageTaken")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalDamageTaken' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalDamageTaken") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalDamageTaken' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalDamageTakenIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalDamageTaken' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalDamageTaken' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("mostChampionKillsPerSession")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mostChampionKillsPerSession' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("mostChampionKillsPerSession") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'mostChampionKillsPerSession' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.mostChampionKillsPerSessionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mostChampionKillsPerSession' does support null values in the existing Realm file. Use corresponding boxed type for field 'mostChampionKillsPerSession' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalMinionKills")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalMinionKills' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalMinionKills") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalMinionKills' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalMinionKillsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalMinionKills' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalMinionKills' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalDoubleKills")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalDoubleKills' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalDoubleKills") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalDoubleKills' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalDoubleKillsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalDoubleKills' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalDoubleKills' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalTripleKills")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalTripleKills' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalTripleKills") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalTripleKills' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalTripleKillsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalTripleKills' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalTripleKills' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalQuadraKills")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalQuadraKills' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalQuadraKills") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalQuadraKills' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalQuadraKillsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalQuadraKills' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalQuadraKills' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalPentaKills")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalPentaKills' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalPentaKills") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalPentaKills' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalPentaKillsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalPentaKills' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalPentaKills' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalDeathsPerSession")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalDeathsPerSession' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalDeathsPerSession") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalDeathsPerSession' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalDeathsPerSessionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalDeathsPerSession' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalDeathsPerSession' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalGoldEarned")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalGoldEarned' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalGoldEarned") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalGoldEarned' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalGoldEarnedIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalGoldEarned' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalGoldEarned' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalTurretsKilled")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalTurretsKilled' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalTurretsKilled") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalTurretsKilled' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalTurretsKilledIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalTurretsKilled' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalTurretsKilled' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalPhysicalDamageDealt")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalPhysicalDamageDealt' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalPhysicalDamageDealt") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalPhysicalDamageDealt' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalPhysicalDamageDealtIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalPhysicalDamageDealt' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalPhysicalDamageDealt' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalMagicDamageDealt")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalMagicDamageDealt' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalMagicDamageDealt") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalMagicDamageDealt' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalMagicDamageDealtIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalMagicDamageDealt' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalMagicDamageDealt' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalAssists")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalAssists' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalAssists") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'totalAssists' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalAssistsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalAssists' does support null values in the existing Realm file. Use corresponding boxed type for field 'totalAssists' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("maxChampionsKilled")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxChampionsKilled' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("maxChampionsKilled") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'maxChampionsKilled' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.maxChampionsKilledIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxChampionsKilled' does support null values in the existing Realm file. Use corresponding boxed type for field 'maxChampionsKilled' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("maxNumDeaths")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxNumDeaths' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("maxNumDeaths") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'maxNumDeaths' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.maxNumDeathsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxNumDeaths' does support null values in the existing Realm file. Use corresponding boxed type for field 'maxNumDeaths' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("maxTimeSpentLiving")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxTimeSpentLiving' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("maxTimeSpentLiving") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'maxTimeSpentLiving' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.maxTimeSpentLivingIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'maxTimeSpentLiving' does support null values in the existing Realm file. Use corresponding boxed type for field 'maxTimeSpentLiving' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_ChampionRankedStats";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static drapps.leagueoflegendshq.models.ChampionRankedStats createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        drapps.leagueoflegendshq.models.ChampionRankedStats obj = realm.createObjectInternal(drapps.leagueoflegendshq.models.ChampionRankedStats.class, true, excludeFields);
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("totalSessionsPlayed")) {
            if (json.isNull("totalSessionsPlayed")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalSessionsPlayed' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalSessionsPlayed((int) json.getInt("totalSessionsPlayed"));
            }
        }
        if (json.has("totalSessionsWon")) {
            if (json.isNull("totalSessionsWon")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalSessionsWon' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalSessionsWon((int) json.getInt("totalSessionsWon"));
            }
        }
        if (json.has("totalSessionsLost")) {
            if (json.isNull("totalSessionsLost")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalSessionsLost' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalSessionsLost((int) json.getInt("totalSessionsLost"));
            }
        }
        if (json.has("totalChampionKills")) {
            if (json.isNull("totalChampionKills")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalChampionKills' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalChampionKills((int) json.getInt("totalChampionKills"));
            }
        }
        if (json.has("totalDamageDealt")) {
            if (json.isNull("totalDamageDealt")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalDamageDealt' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalDamageDealt((int) json.getInt("totalDamageDealt"));
            }
        }
        if (json.has("totalDamageTaken")) {
            if (json.isNull("totalDamageTaken")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalDamageTaken' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalDamageTaken((int) json.getInt("totalDamageTaken"));
            }
        }
        if (json.has("mostChampionKillsPerSession")) {
            if (json.isNull("mostChampionKillsPerSession")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'mostChampionKillsPerSession' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$mostChampionKillsPerSession((int) json.getInt("mostChampionKillsPerSession"));
            }
        }
        if (json.has("totalMinionKills")) {
            if (json.isNull("totalMinionKills")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalMinionKills' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalMinionKills((int) json.getInt("totalMinionKills"));
            }
        }
        if (json.has("totalDoubleKills")) {
            if (json.isNull("totalDoubleKills")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalDoubleKills' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalDoubleKills((int) json.getInt("totalDoubleKills"));
            }
        }
        if (json.has("totalTripleKills")) {
            if (json.isNull("totalTripleKills")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalTripleKills' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalTripleKills((int) json.getInt("totalTripleKills"));
            }
        }
        if (json.has("totalQuadraKills")) {
            if (json.isNull("totalQuadraKills")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalQuadraKills' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalQuadraKills((int) json.getInt("totalQuadraKills"));
            }
        }
        if (json.has("totalPentaKills")) {
            if (json.isNull("totalPentaKills")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalPentaKills' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalPentaKills((int) json.getInt("totalPentaKills"));
            }
        }
        if (json.has("totalDeathsPerSession")) {
            if (json.isNull("totalDeathsPerSession")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalDeathsPerSession' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalDeathsPerSession((int) json.getInt("totalDeathsPerSession"));
            }
        }
        if (json.has("totalGoldEarned")) {
            if (json.isNull("totalGoldEarned")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalGoldEarned' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalGoldEarned((int) json.getInt("totalGoldEarned"));
            }
        }
        if (json.has("totalTurretsKilled")) {
            if (json.isNull("totalTurretsKilled")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalTurretsKilled' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalTurretsKilled((int) json.getInt("totalTurretsKilled"));
            }
        }
        if (json.has("totalPhysicalDamageDealt")) {
            if (json.isNull("totalPhysicalDamageDealt")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalPhysicalDamageDealt' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalPhysicalDamageDealt((int) json.getInt("totalPhysicalDamageDealt"));
            }
        }
        if (json.has("totalMagicDamageDealt")) {
            if (json.isNull("totalMagicDamageDealt")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalMagicDamageDealt' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalMagicDamageDealt((int) json.getInt("totalMagicDamageDealt"));
            }
        }
        if (json.has("totalAssists")) {
            if (json.isNull("totalAssists")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'totalAssists' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalAssists((int) json.getInt("totalAssists"));
            }
        }
        if (json.has("maxChampionsKilled")) {
            if (json.isNull("maxChampionsKilled")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxChampionsKilled' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$maxChampionsKilled((int) json.getInt("maxChampionsKilled"));
            }
        }
        if (json.has("maxNumDeaths")) {
            if (json.isNull("maxNumDeaths")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxNumDeaths' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$maxNumDeaths((int) json.getInt("maxNumDeaths"));
            }
        }
        if (json.has("maxTimeSpentLiving")) {
            if (json.isNull("maxTimeSpentLiving")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'maxTimeSpentLiving' to null.");
            } else {
                ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$maxTimeSpentLiving((int) json.getInt("maxTimeSpentLiving"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static drapps.leagueoflegendshq.models.ChampionRankedStats createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        drapps.leagueoflegendshq.models.ChampionRankedStats obj = new drapps.leagueoflegendshq.models.ChampionRankedStats();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
            } else if (name.equals("totalSessionsPlayed")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalSessionsPlayed' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalSessionsPlayed((int) reader.nextInt());
                }
            } else if (name.equals("totalSessionsWon")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalSessionsWon' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalSessionsWon((int) reader.nextInt());
                }
            } else if (name.equals("totalSessionsLost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalSessionsLost' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalSessionsLost((int) reader.nextInt());
                }
            } else if (name.equals("totalChampionKills")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalChampionKills' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalChampionKills((int) reader.nextInt());
                }
            } else if (name.equals("totalDamageDealt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalDamageDealt' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalDamageDealt((int) reader.nextInt());
                }
            } else if (name.equals("totalDamageTaken")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalDamageTaken' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalDamageTaken((int) reader.nextInt());
                }
            } else if (name.equals("mostChampionKillsPerSession")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'mostChampionKillsPerSession' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$mostChampionKillsPerSession((int) reader.nextInt());
                }
            } else if (name.equals("totalMinionKills")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalMinionKills' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalMinionKills((int) reader.nextInt());
                }
            } else if (name.equals("totalDoubleKills")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalDoubleKills' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalDoubleKills((int) reader.nextInt());
                }
            } else if (name.equals("totalTripleKills")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalTripleKills' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalTripleKills((int) reader.nextInt());
                }
            } else if (name.equals("totalQuadraKills")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalQuadraKills' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalQuadraKills((int) reader.nextInt());
                }
            } else if (name.equals("totalPentaKills")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalPentaKills' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalPentaKills((int) reader.nextInt());
                }
            } else if (name.equals("totalDeathsPerSession")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalDeathsPerSession' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalDeathsPerSession((int) reader.nextInt());
                }
            } else if (name.equals("totalGoldEarned")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalGoldEarned' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalGoldEarned((int) reader.nextInt());
                }
            } else if (name.equals("totalTurretsKilled")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalTurretsKilled' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalTurretsKilled((int) reader.nextInt());
                }
            } else if (name.equals("totalPhysicalDamageDealt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalPhysicalDamageDealt' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalPhysicalDamageDealt((int) reader.nextInt());
                }
            } else if (name.equals("totalMagicDamageDealt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalMagicDamageDealt' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalMagicDamageDealt((int) reader.nextInt());
                }
            } else if (name.equals("totalAssists")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'totalAssists' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$totalAssists((int) reader.nextInt());
                }
            } else if (name.equals("maxChampionsKilled")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxChampionsKilled' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$maxChampionsKilled((int) reader.nextInt());
                }
            } else if (name.equals("maxNumDeaths")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxNumDeaths' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$maxNumDeaths((int) reader.nextInt());
                }
            } else if (name.equals("maxTimeSpentLiving")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'maxTimeSpentLiving' to null.");
                } else {
                    ((ChampionRankedStatsRealmProxyInterface) obj).realmSet$maxTimeSpentLiving((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static drapps.leagueoflegendshq.models.ChampionRankedStats copyOrUpdate(Realm realm, drapps.leagueoflegendshq.models.ChampionRankedStats object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (drapps.leagueoflegendshq.models.ChampionRankedStats) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static drapps.leagueoflegendshq.models.ChampionRankedStats copy(Realm realm, drapps.leagueoflegendshq.models.ChampionRankedStats newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (drapps.leagueoflegendshq.models.ChampionRankedStats) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            drapps.leagueoflegendshq.models.ChampionRankedStats realmObject = realm.createObjectInternal(drapps.leagueoflegendshq.models.ChampionRankedStats.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$id(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$id());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalSessionsPlayed(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalSessionsPlayed());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalSessionsWon(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalSessionsWon());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalSessionsLost(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalSessionsLost());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalChampionKills(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalChampionKills());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalDamageDealt(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalDamageDealt());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalDamageTaken(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalDamageTaken());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$mostChampionKillsPerSession(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$mostChampionKillsPerSession());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalMinionKills(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalMinionKills());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalDoubleKills(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalDoubleKills());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalTripleKills(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalTripleKills());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalQuadraKills(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalQuadraKills());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalPentaKills(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalPentaKills());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalDeathsPerSession(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalDeathsPerSession());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalGoldEarned(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalGoldEarned());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalTurretsKilled(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalTurretsKilled());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalPhysicalDamageDealt(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalPhysicalDamageDealt());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalMagicDamageDealt(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalMagicDamageDealt());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$totalAssists(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$totalAssists());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$maxChampionsKilled(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$maxChampionsKilled());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$maxNumDeaths(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$maxNumDeaths());
            ((ChampionRankedStatsRealmProxyInterface) realmObject).realmSet$maxTimeSpentLiving(((ChampionRankedStatsRealmProxyInterface) newObject).realmGet$maxTimeSpentLiving());
            return realmObject;
        }
    }

    public static long insert(Realm realm, drapps.leagueoflegendshq.models.ChampionRankedStats object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(drapps.leagueoflegendshq.models.ChampionRankedStats.class);
        long tableNativePtr = table.getNativePtr();
        ChampionRankedStatsColumnInfo columnInfo = (ChampionRankedStatsColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.ChampionRankedStats.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalSessionsPlayedIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalSessionsPlayed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalSessionsWonIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalSessionsWon(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalSessionsLostIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalSessionsLost(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalChampionKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalChampionKills(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalDamageDealtIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDamageDealt(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalDamageTakenIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDamageTaken(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.mostChampionKillsPerSessionIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$mostChampionKillsPerSession(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalMinionKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalMinionKills(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalDoubleKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDoubleKills(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalTripleKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalTripleKills(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalQuadraKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalQuadraKills(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalPentaKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalPentaKills(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalDeathsPerSessionIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDeathsPerSession(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalGoldEarnedIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalGoldEarned(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalTurretsKilledIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalTurretsKilled(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalPhysicalDamageDealtIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalPhysicalDamageDealt(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalMagicDamageDealtIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalMagicDamageDealt(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalAssistsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalAssists(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxChampionsKilledIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$maxChampionsKilled(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxNumDeathsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$maxNumDeaths(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxTimeSpentLivingIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$maxTimeSpentLiving(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(drapps.leagueoflegendshq.models.ChampionRankedStats.class);
        long tableNativePtr = table.getNativePtr();
        ChampionRankedStatsColumnInfo columnInfo = (ChampionRankedStatsColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.ChampionRankedStats.class);
        drapps.leagueoflegendshq.models.ChampionRankedStats object = null;
        while (objects.hasNext()) {
            object = (drapps.leagueoflegendshq.models.ChampionRankedStats) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$id(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalSessionsPlayedIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalSessionsPlayed(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalSessionsWonIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalSessionsWon(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalSessionsLostIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalSessionsLost(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalChampionKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalChampionKills(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalDamageDealtIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDamageDealt(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalDamageTakenIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDamageTaken(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.mostChampionKillsPerSessionIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$mostChampionKillsPerSession(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalMinionKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalMinionKills(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalDoubleKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDoubleKills(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalTripleKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalTripleKills(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalQuadraKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalQuadraKills(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalPentaKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalPentaKills(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalDeathsPerSessionIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDeathsPerSession(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalGoldEarnedIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalGoldEarned(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalTurretsKilledIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalTurretsKilled(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalPhysicalDamageDealtIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalPhysicalDamageDealt(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalMagicDamageDealtIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalMagicDamageDealt(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalAssistsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalAssists(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxChampionsKilledIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$maxChampionsKilled(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxNumDeathsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$maxNumDeaths(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxTimeSpentLivingIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$maxTimeSpentLiving(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, drapps.leagueoflegendshq.models.ChampionRankedStats object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(drapps.leagueoflegendshq.models.ChampionRankedStats.class);
        long tableNativePtr = table.getNativePtr();
        ChampionRankedStatsColumnInfo columnInfo = (ChampionRankedStatsColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.ChampionRankedStats.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalSessionsPlayedIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalSessionsPlayed(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalSessionsWonIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalSessionsWon(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalSessionsLostIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalSessionsLost(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalChampionKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalChampionKills(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalDamageDealtIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDamageDealt(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalDamageTakenIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDamageTaken(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.mostChampionKillsPerSessionIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$mostChampionKillsPerSession(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalMinionKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalMinionKills(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalDoubleKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDoubleKills(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalTripleKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalTripleKills(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalQuadraKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalQuadraKills(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalPentaKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalPentaKills(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalDeathsPerSessionIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDeathsPerSession(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalGoldEarnedIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalGoldEarned(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalTurretsKilledIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalTurretsKilled(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalPhysicalDamageDealtIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalPhysicalDamageDealt(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalMagicDamageDealtIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalMagicDamageDealt(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.totalAssistsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalAssists(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxChampionsKilledIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$maxChampionsKilled(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxNumDeathsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$maxNumDeaths(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.maxTimeSpentLivingIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$maxTimeSpentLiving(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(drapps.leagueoflegendshq.models.ChampionRankedStats.class);
        long tableNativePtr = table.getNativePtr();
        ChampionRankedStatsColumnInfo columnInfo = (ChampionRankedStatsColumnInfo) realm.schema.getColumnInfo(drapps.leagueoflegendshq.models.ChampionRankedStats.class);
        drapps.leagueoflegendshq.models.ChampionRankedStats object = null;
        while (objects.hasNext()) {
            object = (drapps.leagueoflegendshq.models.ChampionRankedStats) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$id(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalSessionsPlayedIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalSessionsPlayed(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalSessionsWonIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalSessionsWon(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalSessionsLostIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalSessionsLost(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalChampionKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalChampionKills(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalDamageDealtIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDamageDealt(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalDamageTakenIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDamageTaken(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.mostChampionKillsPerSessionIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$mostChampionKillsPerSession(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalMinionKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalMinionKills(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalDoubleKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDoubleKills(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalTripleKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalTripleKills(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalQuadraKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalQuadraKills(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalPentaKillsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalPentaKills(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalDeathsPerSessionIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalDeathsPerSession(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalGoldEarnedIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalGoldEarned(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalTurretsKilledIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalTurretsKilled(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalPhysicalDamageDealtIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalPhysicalDamageDealt(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalMagicDamageDealtIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalMagicDamageDealt(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.totalAssistsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$totalAssists(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxChampionsKilledIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$maxChampionsKilled(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxNumDeathsIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$maxNumDeaths(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.maxTimeSpentLivingIndex, rowIndex, ((ChampionRankedStatsRealmProxyInterface)object).realmGet$maxTimeSpentLiving(), false);
            }
        }
    }

    public static drapps.leagueoflegendshq.models.ChampionRankedStats createDetachedCopy(drapps.leagueoflegendshq.models.ChampionRankedStats realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        drapps.leagueoflegendshq.models.ChampionRankedStats unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (drapps.leagueoflegendshq.models.ChampionRankedStats)cachedObject.object;
            } else {
                unmanagedObject = (drapps.leagueoflegendshq.models.ChampionRankedStats)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new drapps.leagueoflegendshq.models.ChampionRankedStats();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$id(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$id());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalSessionsPlayed(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalSessionsPlayed());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalSessionsWon(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalSessionsWon());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalSessionsLost(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalSessionsLost());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalChampionKills(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalChampionKills());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalDamageDealt(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalDamageDealt());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalDamageTaken(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalDamageTaken());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$mostChampionKillsPerSession(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$mostChampionKillsPerSession());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalMinionKills(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalMinionKills());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalDoubleKills(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalDoubleKills());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalTripleKills(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalTripleKills());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalQuadraKills(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalQuadraKills());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalPentaKills(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalPentaKills());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalDeathsPerSession(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalDeathsPerSession());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalGoldEarned(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalGoldEarned());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalTurretsKilled(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalTurretsKilled());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalPhysicalDamageDealt(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalPhysicalDamageDealt());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalMagicDamageDealt(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalMagicDamageDealt());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$totalAssists(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$totalAssists());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$maxChampionsKilled(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$maxChampionsKilled());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$maxNumDeaths(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$maxNumDeaths());
        ((ChampionRankedStatsRealmProxyInterface) unmanagedObject).realmSet$maxTimeSpentLiving(((ChampionRankedStatsRealmProxyInterface) realmObject).realmGet$maxTimeSpentLiving());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ChampionRankedStats = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalSessionsPlayed:");
        stringBuilder.append(realmGet$totalSessionsPlayed());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalSessionsWon:");
        stringBuilder.append(realmGet$totalSessionsWon());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalSessionsLost:");
        stringBuilder.append(realmGet$totalSessionsLost());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalChampionKills:");
        stringBuilder.append(realmGet$totalChampionKills());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalDamageDealt:");
        stringBuilder.append(realmGet$totalDamageDealt());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalDamageTaken:");
        stringBuilder.append(realmGet$totalDamageTaken());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mostChampionKillsPerSession:");
        stringBuilder.append(realmGet$mostChampionKillsPerSession());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalMinionKills:");
        stringBuilder.append(realmGet$totalMinionKills());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalDoubleKills:");
        stringBuilder.append(realmGet$totalDoubleKills());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalTripleKills:");
        stringBuilder.append(realmGet$totalTripleKills());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalQuadraKills:");
        stringBuilder.append(realmGet$totalQuadraKills());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalPentaKills:");
        stringBuilder.append(realmGet$totalPentaKills());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalDeathsPerSession:");
        stringBuilder.append(realmGet$totalDeathsPerSession());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalGoldEarned:");
        stringBuilder.append(realmGet$totalGoldEarned());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalTurretsKilled:");
        stringBuilder.append(realmGet$totalTurretsKilled());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalPhysicalDamageDealt:");
        stringBuilder.append(realmGet$totalPhysicalDamageDealt());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalMagicDamageDealt:");
        stringBuilder.append(realmGet$totalMagicDamageDealt());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalAssists:");
        stringBuilder.append(realmGet$totalAssists());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxChampionsKilled:");
        stringBuilder.append(realmGet$maxChampionsKilled());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxNumDeaths:");
        stringBuilder.append(realmGet$maxNumDeaths());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{maxTimeSpentLiving:");
        stringBuilder.append(realmGet$maxTimeSpentLiving());
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
        ChampionRankedStatsRealmProxy aChampionRankedStats = (ChampionRankedStatsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aChampionRankedStats.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aChampionRankedStats.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aChampionRankedStats.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
