/**
 * DataStoreProvider should relay on some serialization / deserialization mechanism
 * when appending to / loading from eventlog
 *
 * SerializationProvider examples:
 *
 * JsonSerializationProvider
 * - JacksonJsonSerializer
 * - JacksonJsonDeserializer
 * - JsonbJsonSerializer
 * - JsonbJsonDeserializer
 * XmlSerializationProvider
 * - JacksonXmlSerializer
 * - JacksonXmlDeserializer
 * BinarySerialisationProvider
 * - ProtoBufSerializer
 * - ProtoBufDeserializer
 */
package com.github.daggerok.deventstore.api.provider.data.serialisation;
