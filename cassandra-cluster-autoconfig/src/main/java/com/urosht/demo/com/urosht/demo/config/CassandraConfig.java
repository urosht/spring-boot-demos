package com.idbmobile.mcore.mt.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DataCenterReplication;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.urosht.demo.repository")
public class CassandraConfig extends org.springframework.data.cassandra.config.AbstractCassandraConfiguration {

  @Autowired
  private Environment env;

  /**
   * Name of the DC where this Cassandra database is located.
   */
  @Value("${cassandra.datacenter}")
  private String dataCenter;

  /**
   * Replication factor for this Cassandra database.
   */
  @Value("${cassandra.replication-factor}")
  private Long replicationFactor;

  /*
   * Provide contact points for connecting
   */
  @Override
  public String getContactPoints() {
    return env.getProperty("cassandra.contact-points");
  }

  /*
   * Provide a keyspace name
   */
  @Override
  public String getKeyspaceName() {
    return env.getProperty("cassandra.keyspace");
  }

  /*
   * Automatically creates a Cassandra keyspace with 'Network topology
   * replication' strategy and durable writes
   *
   * @see org.springframework.data.cassandra.config.AbstractClusterConfiguration#
   * getKeyspaceCreations()
   */
  @Override
  protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
    final CreateKeyspaceSpecification specification = CreateKeyspaceSpecification
        .createKeyspace(env.getProperty("cassandra.keyspace")).ifNotExists()
        .with(KeyspaceOption.DURABLE_WRITES, true)
        .withNetworkReplication(DataCenterReplication.of(dataCenter, replicationFactor));
    return Arrays.asList(specification);
  }

  /*
   * Creates a Cassandra table in the keyspace (if not already created)
   *
   * @see
   * org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration
   * #getSchemaAction()
   */
  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.CREATE_IF_NOT_EXISTS;
  }

  @Override
  public String[] getEntityBasePackages() {
    return new String[] { "com.urosht.demo.entity" };
  }

}