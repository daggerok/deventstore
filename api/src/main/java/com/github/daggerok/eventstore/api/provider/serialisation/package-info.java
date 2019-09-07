/**
 * EventStore should relay on some serialization / deserialization mechanism
 *
 * SerializationProvider examples:
 *
 * JsonSerializationProvider
 * - JacksonJsonValueSerializer
 * - JacksonJsonValueDeserializer
 * - JsonbSerializer
 * - JsonbDeserializer
 * XmlSerializationProvider
 * - JacksonXmlSerializer
 * - JacksonXmlDeserializer
 * BinarySerialisationProvider
 * - ProtoBufSerializer
 * - ProtoBufDeserializer
 */
package com.github.daggerok.eventstore.api.provider.serialisation;
