# Test cases to highlight differences between @GenericGenerator and @IdGeneratorType

- The unit tests `OverrideGenericGeneratorTestCase` and `OverrideIdGeneratorTypeTestCase` execute different SQL statements when creating a new entity
- The database schema is created by Hibernate using `hibernate.hbm2ddl.auto=create`
- Both tests define the default entity mapping with annotations and override the strategy for generating a new id with an XML mapping file
- The default strategy is to use sequences following a naming convention for table names
- The XML metadata should override the strategy to `IDENTITY` in both test cases, but this only works for `@GenericGenerator`
- The logic for providing portability depending on the DBMS is omitted
- Further reading:
    - https://vladmihalcea.com/how-to-replace-the-table-identifier-generator-with-either-sequence-or-identity-in-a-portable-way/
    - https://discourse.hibernate.org/t/deprecation-of-genericgenerator-in-hibernate-6-5/9482

## `OverrideGenericGeneratorTestCase`

- Overrides the deprecated @GenericGenerator
- The executed SQL does not contain a database sequence

## `OverrideIdGeneratorTypeTestCase`

- The new @IdGeneratorType (Hibernate 6.0) cannot be overwritten
- The executed SQL contains the creation and use of a database sequence


