# JPAIDGeneration

### persistence.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
  <persistence-unit name="JPAIDGeneration" transaction-type="JTA">
    <jta-data-source>jdbc/localoracle</jta-data-source>
    <mapping-file>META-INF/orm.xml</mapping-file>
    <class>com.ilkinabdullayev.jpaidgeneration.Employee</class>
    <class>com.ilkinabdullayev.jpaidgeneration.Person</class>
    <exclude-unlisted-classes>true</exclude-unlisted-classes>
    <properties>
      <property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
      <property name="eclipselink.logging.level" value="FINEST"/>
    </properties>
  </persistence-unit>
</persistence>
```

### orm.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<entity-mappings xmlns="http://java.sun.com/xml/ns/persistence/orm"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xsi:schemaLocation="http://java.sun.com/xml/ns/persistence/orm    
http://java.sun.com/xml/ns/persistence/orm_1_0.xsd"
    version="1.0">
    <description>My First JPA XML Application</description>
    <package>entity</package> 
    <entity class="com.ilkinabdullayev.jpaidgeneration.Employee" name="Employee">        
        <table name="Employee"/>
        <table-generator name="TABLE_GENERATOR" table="ID_TABLE" pk-column-name="ID_TABLE_NAME" pk-column-value="PERSON_ID" value-column-name="ID_TABLE_VALUE" />
        <attributes>
            <id name="empId">
                <generated-value strategy="TABLE" generator="TABLE_GENERATOR"/>
            </id>
            <basic name="empName">
                <column name="EMP_NAME" length="100"/>
            </basic>
            <basic name="empSalary">
            </basic>
        </attributes>
   </entity>
</entity-mappings>
```
