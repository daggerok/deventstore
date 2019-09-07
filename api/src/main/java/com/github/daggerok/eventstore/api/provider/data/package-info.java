/**
 * EventStore can be in-memory or persistent, but in any case
 * it should use some abstraction around data its manipulating...
 *
 * DataProvider examples:
 *
 * InMemoryDataProvider:
 * - ConcurrentHashMapEventLog
 * FilesystemDataProvider:
 * - FileAppendOnlyEventLog
 * RdbmsDataProvider:
 * - H2EventLog
 * - MysqlEventLog
 * - PostgresqlEventLog
 * NoSqlDataProvider:
 * - MongodbEventLog
 * - RedisEventLog
 */
package com.github.daggerok.eventstore.api.provider.data;
