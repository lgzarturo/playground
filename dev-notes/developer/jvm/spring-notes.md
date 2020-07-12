# Consultas transaccionales

Para definir un método transaccional de tipo lectura, usar la anotación `@Transactional` como se muestra en el ejemplo:

```java
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByLastname(String lastname);
  @Modifying
  @Transactional
  @Query("delete from User u where u.active = false")
  void deleteInactiveUsers();
}
```

Typically, you want the readOnly flag to be set to true, as most of the query methods only read data. In contrast
to that, `deleteInactiveUsers()` makes use of the `@Modifying` annotation and overrides the transaction configuration.
Thus, the method runs with the `readOnly = false`.

You can use transactions for read-only queries and mark them as such by setting the readOnly flag. Doing so does not,
however, act as a check you do not trigger a manipulating query (_although some databases reject INSERT and
UPDATE statements inside a read-only transaction_). The readOnly flag instead propagated as a hint to the underlying
JDBC driver for performance optimizations. Furthermore, Spring performs some optimizations on the underlying JPA
provider. For example, when used with Hibernate, the flush mode set to NEVER when you configure a transaction as
readOnly, which causes Hibernate to skip dirty checks (_a noticeable improvement on large object trees_).

Optimize `SELECT DISTINCT` Via Hibernate `HINT_PASS_DISTINCT_THROUGH` Hint

### Description:

Starting with Hibernate 5.2.2, we can optimize JPQL (_HQL_) query entites of type
`SELECT DISTINCT` via `HINT_PASS_DISTINCT_THROUGH` hint. Keep in mind that this hint is useful only for JPQL (_HQL_)
query entites. Is not useful for scalar queries (_e.g., List<Integer>_) or DTO. In such cases, the `DISTINCT JPQL`
keyword passed to the underlying SQL query. This will instruct the database to remove duplicates
from the result set.

> Check HHH-13280.

#### Key points:

- use `@QueryHints(value = @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false"))`

## Query Method Syntax

Let's go over the basics of the syntax needed to make these query methods work. First, query methods are simply methods
defined in your JPA repository that Spring Data JPA will auto-implement on your behalf. They are one way that Spring
Data JPA can implement queries for you.

When you create a query method, the query parser will look for methods that start with find, query, read, count, or
get. These prefixes can be enhanced with other keywords until, eventually, you get to the B-Y, or By, a section of the
method name.

This signals that the criteria, or filter piece, of the query, is beginning and Spring Data JPA matches up the entity
attributes of the method criteria with the actual WHERE clause in your SQL Multiple criteria definitions can be added
to your method name with the `And` or `Or` keywords.

This may sound a little confusing, so let's look at the location query on the code below.

```java
public interface LocationJpaRepository extends JpaRepository<Location, Long> {
    findByAgeLike(Integer age);
}
```

- **find** - The method starts with find so that the query parser understands that it needs to implement this query contract.
- **By** - Following the previous keyword, we added this one signaling that the criteria information will be coming next in the method name.
- **Age** - Afterwards, we specified it further. Age matches the attribute name age in my location JPA entity, and age is of data type Integer.
- **Like** - The final keyword tells the implementation that we want to create a Like query, rather than an exact match.

I then pass in an Integer variable that the query implementation should use as the actual filter criteria. It's of type
Integer because our data type of age in the location entity is of type Integer.

By piecing the query DSL keywords together with the JPA repository generics typing, you can see how Spring Data JPA
can generate the JPQL for us.

This, in turn, gets mapped to the actual SQL that will get issued against the database thanks to the JPA ORM framework.

## Keywords

| Keyword              | Sample                                     | JPQL Snippet                                                                                                                                           |
| -------------------- | ------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------ |
| And                  | findByLastnameAndFirstname                 | ...where x.lastname = ?1 and x.firstname = ?2                                                                                                          |
| Or                   | findByLastnameOrFirstname                  | ...where x.lastname = ?1 or x.firstname = ?2                                                                                                           |
| Is, Equals           | findByFirstnameEquals                      | ...where x.firstname = ?1                                                                                                                              |
| Between              | findByStartDateBetween                     | ...where x.startDate between ?1 and ?                                                                                                                  |
| LessThan             | findByAgeLessThan                          | ...where x.age < ?1                                                                                                                                    |
| LessThanEqual        | findByAgeLessThanEqual                     | ...where x.age <= ?1                                                                                                                                   |
| GreaterThan          | findByAgeGreaterThan                       | ...where x.age > ?1                                                                                                                                    |
| GreaterThanEqual     | findByAgeGreaterThanEqual                  | ...where x.age >= ?1                                                                                                                                   |
| After                | findByStartDateAfter                       | ...where x.startDate > ?1                                                                                                                              |
| Before               | findByStartDateBefore                      | ...where x.startDate < ?1                                                                                                                              |
| IsNull               | findByAgeIsNull                            | ...where x.age is null                                                                                                                                 |
| IsNotNull, NotNull   | findByAge(Is)NotNull                       | ...where x.age not null                                                                                                                                |
| Like                 | findByFirstnameLike                        | ...where x.firstname like ?1                                                                                                                           |
| NotLike              | findByFirstnameNotLike                     | ...where x.firstname not like ?1                                                                                                                       |
| StartingWith         | findByFirstnameStartingWith                | ...where x.firstname like ?1 (parameter bound with appended %)                                                                                         |
| EndingWith           | findByFirstnameEndingWith                  | ...where x.firstname like ?1 (parameter bound with prepended %)                                                                                        |
| Containing           | findByFirstnameContaining                  | ...where x.firstname like ?1 (parameter bound wrapped in %)                                                                                            |
| OrderBy              | findByAgeOrderByLastnameDesc               | ...where x.age = ?1 order by x.lastname desc                                                                                                           |
| Not                  | findByLastnameNot                          | ...where x.lastname <> ?1                                                                                                                              |
| In                   | findByAgeIn(Collection ages)               | ...where x.age in ?1                                                                                                                                   |
| NotIn                | findByAgeNotIn(Collection ages)            | ...where x.age not in ?1                                                                                                                               |
| True                 | findByActiveTrue()                         | ...where x.active = true                                                                                                                               |
| False                | findByActiveFalse()                        | ...where x.active = false                                                                                                                              |
| IgnoreCase           | findByFirstnameIgnoreCase                  | ...where UPPER(x.firstname) = UPPER(?1)                                                                                                                |
| Find                 | findByFirstname                            | ...where x.firstname = ?1                                                                                                                              |
| Find associations    | findByBooksTitle                           | ...left outer join book*author books1* on author0*.id=books1*.fk*author left outer join book book2* on books1*.fk_book=book2*.id where book2\_.title=? |
| Comparisons          | findByFirstNameContainingIgnoreCase        | ...where upper(author0\_.first_name) like upper(?)                                                                                                     |
| Comparisons          | findByFirstnameContainsOrderByFirstnameAsc | ...where x.firstname like ?1 order by x.firstname asc                                                                                                  |
| Limiting the results | findFirst5ByFirstnameOrderByFirstnameAsc   | ...where x.firstname like ?1 order by x.firstname asc limit ?                                                                                          |

## Order the results

```java
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContains(String title, Sort sort);
}

Sort sort = new Sort(Sort.Direction.ASC, "title");
List<Book> b = bookRepository.findByTitleContains("Hibernate", sort);
```

## Paginate results

```java
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAll(Pageable pageable);
}

Pageable pageable = PageRequest.of(0, 10);
Page<Book> b = bookRepository.findAll(pageable);
```

## Query

Query refers to JPQL/HQL query with syntax similar to SQL generally used to execute DML statements(_CRUD operations_).

In JPA, you can create a query using `entityManager.createQuery()`. You can look into API for more detail.

In Hibernate, you use `session.createQuery()`

### NativeQuery

NativeQuery refers to actual sql queries (_referring to actual database objects_). These queries are the sql statements
which can be directly executed in a database using a database client.

- **JPA**: `entityManager.createNativeQuery()`
- **Hibernate** (_Non-JPA implementation_): `session.createSQLQuery()`

### NamedQuery

NamedQuery is the way you define your query by giving it a name. You could define this in mapping file in hibernate
or also using annotations at entity level.

### TypedQuery

TypedQuery gives you an option to mention the type of entity when you create a query and therefore any operation
thereafter does not need an explicit cast to the intended type. Whereas the normal Query API does not return the exact
type of Object you expect, and you need to cast.

# Swagger UI

Configuración de swagger con Spring Boot y aceptando parametros de autenticación y headers adicionales.

- https://stackoverflow.com/questions/50545286/spring-boot-swagger-ui-set-jwt-token
- https://github.com/springfox/springfox/issues/2194
- https://github.com/swagger-api/swagger-ui/issues/1566
- https://stackoverflow.com/questions/26742521/sending-dynamic-custom-headers-in-swagger-ui-try-outs

## Links

- [Spring Data JPA](https://stackabuse.com/guide-to-spring-data-jpa/)
- [Spring Data official](https://spring.io/projects/spring-data)
- [ObjectDB](https://www.objectdb.com/java/jpa/query/criteria)
- [Derived Queries](https://thoughts-on-java.org/ultimate-guide-derived-queries-with-spring-data-jpa/)
