/**
 * EventStore should relay on messaging to receive, react and replay on different activities happening around it
 *
 * MessagingProvider examples:
 *
 * InMemoryMessagingProvider:
 * - BlockingQueueTransport
 * - EmbeddedActivemqTransport
 * BrokerMessagingProvider:
 * - ActivemqTransport
 * - RedisTransport
 * - RabbitmqTransport
 * - KafkaTransport
 */
package com.github.daggerok.deventstore.api.provider.messaging;
