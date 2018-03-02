package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(drapps.leagueoflegendshq.models.ChampionSimple.class);
        modelClasses.add(drapps.leagueoflegendshq.models.ChampionRankedStats.class);
        modelClasses.add(drapps.leagueoflegendshq.models.SummonerInfo.class);
        modelClasses.add(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class);
        modelClasses.add(drapps.leagueoflegendshq.coinlist.Coin.class);
        modelClasses.add(drapps.leagueoflegendshq.models.GlobalInfo.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
            return io.realm.ChampionSimpleRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
            return io.realm.ChampionRankedStatsRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
            return io.realm.SummonerInfoRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
            return io.realm.FavoriteCoinRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
            return io.realm.CoinRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
            return io.realm.GlobalInfoRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
            return io.realm.ChampionSimpleRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
            return io.realm.ChampionRankedStatsRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
            return io.realm.SummonerInfoRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
            return io.realm.FavoriteCoinRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
            return io.realm.CoinRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
            return io.realm.GlobalInfoRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
            return io.realm.ChampionSimpleRealmProxy.getFieldNames();
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
            return io.realm.ChampionRankedStatsRealmProxy.getFieldNames();
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
            return io.realm.SummonerInfoRealmProxy.getFieldNames();
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
            return io.realm.FavoriteCoinRealmProxy.getFieldNames();
        }
        if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
            return io.realm.CoinRealmProxy.getFieldNames();
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
            return io.realm.GlobalInfoRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
            return io.realm.ChampionSimpleRealmProxy.getTableName();
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
            return io.realm.ChampionRankedStatsRealmProxy.getTableName();
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
            return io.realm.SummonerInfoRealmProxy.getTableName();
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
            return io.realm.FavoriteCoinRealmProxy.getTableName();
        }
        if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
            return io.realm.CoinRealmProxy.getTableName();
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
            return io.realm.GlobalInfoRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
                return clazz.cast(new io.realm.ChampionSimpleRealmProxy());
            }
            if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
                return clazz.cast(new io.realm.ChampionRankedStatsRealmProxy());
            }
            if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
                return clazz.cast(new io.realm.SummonerInfoRealmProxy());
            }
            if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
                return clazz.cast(new io.realm.FavoriteCoinRealmProxy());
            }
            if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
                return clazz.cast(new io.realm.CoinRealmProxy());
            }
            if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
                return clazz.cast(new io.realm.GlobalInfoRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
            return clazz.cast(io.realm.ChampionSimpleRealmProxy.copyOrUpdate(realm, (drapps.leagueoflegendshq.models.ChampionSimple) obj, update, cache));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
            return clazz.cast(io.realm.ChampionRankedStatsRealmProxy.copyOrUpdate(realm, (drapps.leagueoflegendshq.models.ChampionRankedStats) obj, update, cache));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
            return clazz.cast(io.realm.SummonerInfoRealmProxy.copyOrUpdate(realm, (drapps.leagueoflegendshq.models.SummonerInfo) obj, update, cache));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
            return clazz.cast(io.realm.FavoriteCoinRealmProxy.copyOrUpdate(realm, (drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin) obj, update, cache));
        }
        if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
            return clazz.cast(io.realm.CoinRealmProxy.copyOrUpdate(realm, (drapps.leagueoflegendshq.coinlist.Coin) obj, update, cache));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
            return clazz.cast(io.realm.GlobalInfoRealmProxy.copyOrUpdate(realm, (drapps.leagueoflegendshq.models.GlobalInfo) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
            io.realm.ChampionSimpleRealmProxy.insert(realm, (drapps.leagueoflegendshq.models.ChampionSimple) object, cache);
        } else if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
            io.realm.ChampionRankedStatsRealmProxy.insert(realm, (drapps.leagueoflegendshq.models.ChampionRankedStats) object, cache);
        } else if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
            io.realm.SummonerInfoRealmProxy.insert(realm, (drapps.leagueoflegendshq.models.SummonerInfo) object, cache);
        } else if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
            io.realm.FavoriteCoinRealmProxy.insert(realm, (drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin) object, cache);
        } else if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
            io.realm.CoinRealmProxy.insert(realm, (drapps.leagueoflegendshq.coinlist.Coin) object, cache);
        } else if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
            io.realm.GlobalInfoRealmProxy.insert(realm, (drapps.leagueoflegendshq.models.GlobalInfo) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
                io.realm.ChampionSimpleRealmProxy.insert(realm, (drapps.leagueoflegendshq.models.ChampionSimple) object, cache);
            } else if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
                io.realm.ChampionRankedStatsRealmProxy.insert(realm, (drapps.leagueoflegendshq.models.ChampionRankedStats) object, cache);
            } else if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
                io.realm.SummonerInfoRealmProxy.insert(realm, (drapps.leagueoflegendshq.models.SummonerInfo) object, cache);
            } else if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
                io.realm.FavoriteCoinRealmProxy.insert(realm, (drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin) object, cache);
            } else if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
                io.realm.CoinRealmProxy.insert(realm, (drapps.leagueoflegendshq.coinlist.Coin) object, cache);
            } else if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
                io.realm.GlobalInfoRealmProxy.insert(realm, (drapps.leagueoflegendshq.models.GlobalInfo) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
                    io.realm.ChampionSimpleRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
                    io.realm.ChampionRankedStatsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
                    io.realm.SummonerInfoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
                    io.realm.FavoriteCoinRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
                    io.realm.CoinRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
                    io.realm.GlobalInfoRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
            io.realm.ChampionSimpleRealmProxy.insertOrUpdate(realm, (drapps.leagueoflegendshq.models.ChampionSimple) obj, cache);
        } else if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
            io.realm.ChampionRankedStatsRealmProxy.insertOrUpdate(realm, (drapps.leagueoflegendshq.models.ChampionRankedStats) obj, cache);
        } else if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
            io.realm.SummonerInfoRealmProxy.insertOrUpdate(realm, (drapps.leagueoflegendshq.models.SummonerInfo) obj, cache);
        } else if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
            io.realm.FavoriteCoinRealmProxy.insertOrUpdate(realm, (drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin) obj, cache);
        } else if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
            io.realm.CoinRealmProxy.insertOrUpdate(realm, (drapps.leagueoflegendshq.coinlist.Coin) obj, cache);
        } else if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
            io.realm.GlobalInfoRealmProxy.insertOrUpdate(realm, (drapps.leagueoflegendshq.models.GlobalInfo) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
                io.realm.ChampionSimpleRealmProxy.insertOrUpdate(realm, (drapps.leagueoflegendshq.models.ChampionSimple) object, cache);
            } else if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
                io.realm.ChampionRankedStatsRealmProxy.insertOrUpdate(realm, (drapps.leagueoflegendshq.models.ChampionRankedStats) object, cache);
            } else if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
                io.realm.SummonerInfoRealmProxy.insertOrUpdate(realm, (drapps.leagueoflegendshq.models.SummonerInfo) object, cache);
            } else if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
                io.realm.FavoriteCoinRealmProxy.insertOrUpdate(realm, (drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin) object, cache);
            } else if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
                io.realm.CoinRealmProxy.insertOrUpdate(realm, (drapps.leagueoflegendshq.coinlist.Coin) object, cache);
            } else if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
                io.realm.GlobalInfoRealmProxy.insertOrUpdate(realm, (drapps.leagueoflegendshq.models.GlobalInfo) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
                    io.realm.ChampionSimpleRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
                    io.realm.ChampionRankedStatsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
                    io.realm.SummonerInfoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
                    io.realm.FavoriteCoinRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
                    io.realm.CoinRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
                    io.realm.GlobalInfoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
            return clazz.cast(io.realm.ChampionSimpleRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
            return clazz.cast(io.realm.ChampionRankedStatsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
            return clazz.cast(io.realm.SummonerInfoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
            return clazz.cast(io.realm.FavoriteCoinRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
            return clazz.cast(io.realm.CoinRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
            return clazz.cast(io.realm.GlobalInfoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
            return clazz.cast(io.realm.ChampionSimpleRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
            return clazz.cast(io.realm.ChampionRankedStatsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
            return clazz.cast(io.realm.SummonerInfoRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
            return clazz.cast(io.realm.FavoriteCoinRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
            return clazz.cast(io.realm.CoinRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
            return clazz.cast(io.realm.GlobalInfoRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionSimple.class)) {
            return clazz.cast(io.realm.ChampionSimpleRealmProxy.createDetachedCopy((drapps.leagueoflegendshq.models.ChampionSimple) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.ChampionRankedStats.class)) {
            return clazz.cast(io.realm.ChampionRankedStatsRealmProxy.createDetachedCopy((drapps.leagueoflegendshq.models.ChampionRankedStats) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.SummonerInfo.class)) {
            return clazz.cast(io.realm.SummonerInfoRealmProxy.createDetachedCopy((drapps.leagueoflegendshq.models.SummonerInfo) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin.class)) {
            return clazz.cast(io.realm.FavoriteCoinRealmProxy.createDetachedCopy((drapps.leagueoflegendshq.models.realmobjects.FavoriteCoin) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(drapps.leagueoflegendshq.coinlist.Coin.class)) {
            return clazz.cast(io.realm.CoinRealmProxy.createDetachedCopy((drapps.leagueoflegendshq.coinlist.Coin) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(drapps.leagueoflegendshq.models.GlobalInfo.class)) {
            return clazz.cast(io.realm.GlobalInfoRealmProxy.createDetachedCopy((drapps.leagueoflegendshq.models.GlobalInfo) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
