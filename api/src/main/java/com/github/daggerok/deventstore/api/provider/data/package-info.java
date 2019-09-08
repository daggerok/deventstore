/**
 * EventStore can be in-memory or persistent, but in any case
 * it should use some abstraction around data its manipulating...
 *
 * DataStoreProvider examples:
 *
 * InMemoryDataStoreProvider:
 * - ConcurrentHashMapEventLog
 * FilesystemDataProvider:
 * - FileAppendOnlyEventLog
 * RdbmsDataStoreProvider:
 * - H2EventLog
 * - MysqlEventLog
 * - PostgresqlEventLog
 * NoSqlDataStoreProvider:
 * - MongodbEventLog
 * - RedisEventLog
 */
package com.github.daggerok.deventstore.api.provider.data;
