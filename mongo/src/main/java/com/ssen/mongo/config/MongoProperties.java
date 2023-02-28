package com.ssen.mongo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mongodatasource")
public class MongoProperties {
    private String host;
    private String port;
    private String database;
    private String username;
    private String password;
    private String retryWrites;
    private String tls;
    private String minPoolSize;
    private String maxPoolSize;
    private String connectionString;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRetryWrites() {
        return retryWrites;
    }

    public String getTls() {
        return tls;
    }

    public String getMinPoolSize() {
        return minPoolSize;
    }

    public String getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRetryWrites(String retryWrites) {
        this.retryWrites = retryWrites;
    }

    public void setTls(String tls) {
        this.tls = tls;
    }

    public void setMinPoolSize(String minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public void setMaxPoolSize(String maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getConnectionUri(){
        return "mongodb://"+getHost()+":"+getPort()+"/"+getDatabase()+"?retryWrites="+getRetryWrites();
    }
}
