![Logo image](img/sbtscalasamlogo_small.png)

# sam-schema-repo-seed.g8
A template project for quickly creating a serverless avro schema repository. A schema repository is a central component of data intensive solutions for example data processing and analytics platforms need data definitions in order to reason about data, data transformations and data governance in order to provide high quality data products for its data stakeholders and in order to become compliant.

For more information see [sbt-sam](https://github.com/dnvriend/sbt-sam)

## Usage
Create a new template project by typing:

```
sbt new dnvriend/sam-schema-repo-seed.g8
```

## Deploy
To deploy the project type `samDeploy`

## Remove
To remove the project type `samRemove`

## Info
To get deployment information like available endpoints and stack information, type `samInfo`

## Available endpoints
The following endpoints are available:

- GET - /namespaces/{namespaceName}/schemas/{schemaName}/versions/{version} - get a specific version of a schema
- GET - /namespaces/{namespaceName}/schemas/{schemaName}/versions - get all versions of a schema
- GET - /fingerprint/{fingerprint} - get a schema by fingerprint
- PUT - /namespaces/{namespaceName}/schemas/{schemaName} - store a schema by PUT-ting an avro schema to the repository

## Concepts
An [apache avro](http://avro.apache.org/) schema can be stored in the schema repository by means of a vector that consists of a 'namespace-name':'schema-name':'version' combination. The vector is encoded in the resource path.

A schema is technically identified by means of a fingerprint. A fingerprint is a hex-string encoded, SHA-256 digest of the [avro schema's canonical form](http://avro.apache.org/docs/1.8.2/spec.html#Parsing+Canonical+Form+for+Schemas). This means that when a deserializer resolves a schema, a schema will be resolved that can be used to interpret the data.

## Implementation
This very simple schema repository uses three dynamodb tables:

- schema_by_vector: store a 'vector', 'version' and the schema 'json' in said attributes,
- schema_by_fingerprint: store a 'fingerprint' and the schema 'json' in said attributes,
- counters: store counter state in the 'counter_key' and 'counter_value' attributes.

