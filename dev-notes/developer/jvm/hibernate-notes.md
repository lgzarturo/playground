# Mejores practicas con Hibernate

- Aplicar el tipo FetchType para las anotaciones `@OneToMany, @ManyToOne, @ManyToMany` y `@OneToOne`:

```java
@Entity
public class Author{
    @ManyToMany(mappedBy="authors", fetch=FetchType.LAZY)
    private List<Book> books = new ArrayList<Book>();
}
```

O también se pueden indicar las columnas se cargarán por medio de `Lazy`:

`@Basic(fetch = FetchType.LAZY)`

- Aplicar `FetchType Lazy` en las referencias:

```java
@Entity
public class Review {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_book")
    private Book book;
}
```

- No inicializar las asociaciones requeridas:

```java
List<Author> authors = em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
for (Author a : authors) {
    log.info(a.getFirstName() + " " + a.getLastName() + " wrote " + a.getBooks().size() + " books.");
}

Author a = em.createQuery(
    "SELECT a FROM Author a JOIN FETCH a.books WHERE a.id = 1", Author.class
).getSingleResult();
```

- Seleccionar los registros necesarios:

```java
List<Author> authors = em.createQuery(
    "SELECT a FROM Author a ORDER BY a.id ASC", Author.class
).setMaxResults(5).setFirstResult(0).getResultList();
```

- Siempre usar el paso de parámetros:

```java
TypedQuery<Author> q = em.createQuery("SELECT a FROM Author a WHERE a.id = :id", Author.class);
q.setParameter("id", 1L);
Author a = q.getSingleResult();
```

- Usar funciones de manejador de la base de datos en las consultas:

```java
Query q = em.createQuery("SELECT a, size(a.books) FROM Author a GROUP BY a.id");
List<Object[]> results = q.getResultList();

TypedQuery<Book> q = em.createQuery(
    "SELECT b FROM Book b WHERE b.id = function('calculate', 1, 2)", Book.class
);
Book b = q.getSingleResult();
```

- No llame al método flush sin una razón:

  1. No use Hibernate para todo: [jooq](https://www.jooq.org/), [querydsl](http://www.querydsl.com/). 2. No actualice ni elimine enormes listas de entidades una por una: Use consultas nativas para realizar actualizaciones masivas.

```java
em.createNativeQuery("UPDATE person p SET firstname = firstname || '-changed'").executeUpdate();
PersonEntity p = em.find(PersonEntity.class, 1L);

em.createNativeQuery("UPDATE person p SET firstname = firstname || '-changed'").executeUpdate();
log.info("FirstName: "+p.getFirstName());

p = em.find(PersonEntity.class, 1L);
log.info("FirstName: "+p.getFirstName());
PersonEntity p = em.find(PersonEntity.class, 1L);

log.info("Detach PersonEntity");
em.flush();
em.detach(p);

em.createNativeQuery("UPDATE person p SET firstname = firstname || '-changed'").executeUpdate();

p = em.find(PersonEntity.class, 1L);
```

- No use entidades para operaciones de solo lectura:

  - [Entities DTS with projection](https://thoughts-on-java.org/entities-dtos-use-projection/)
  - [Hibernate lazy loading](https://medium.com/free-code-camp/hibernate-deep-dive-relations-lazy-loading-n-1-problem-common-mistakes-aff1fa390446)
  - [Hibernate multi level fetching](https://vladmihalcea.com/hibernate-facts-multi-level-fetching/)
  - [Hibernate tuning](https://www.infoq.com/articles/hibernate_tuning/)
  - [Boost the performance with jpa](https://blog.ippon.tech/boost-the-performance-of-your-spring-data-jpa-application/)
  - [Performance tuning of spring and hibernate](https://www.javacodegeeks.com/2014/06/performance-tuning-of-springhibernate-applications.html)
  - [5 tips to write efficient queries](https://thoughts-on-java.org/5-tips-write-efficient-queries-jpa-hibernate/)
  - [Performance and tips](http://www.laliluna.de/articles/java-persistence-hibernate/performance-tips-hibernate-java-persistence.html)
  - [Hibernate named query](https://www.baeldung.com/hibernate-named-query)
  - [Tips to boots hibernate performance](https://thoughts-on-java.org/tips-to-boost-your-hibernate-performance/)
  - [Hibernate performance tuning](https://dzone.com/articles/hibernate-performance-tuning)
  - [Common performance problems](https://www.baeldung.com/hibernate-common-performance-problems-in-logs)
  - https://mrhaki.blogspot.com/2012/06/groovy-goodness-revisited-getting-sum.html
  - https://reflectoring.io/spring-boot-web-controller-test/

- Evitar el uso de `BigInteger & BigDecimal`: Utilice tipos de datos primitivos (_int, float_)

## Enlaces

- [11 common mistakes](https://thoughts-on-java.org/common-hibernate-mistakes-cripple-performance/)
- [Mejores practicas con hibernate](https://dzone.com/articles/50-best-performance-practices-for-hibernate-5-amp)
- [Hibernate con Spring Boot](https://github.com/AnghelLeonard/Hibernate-SpringBoot)
- [Best performace](https://blog.ippon.tech/boost-the-performance-of-your-spring-data-jpa-application/)
- [@Query Annotation](https://thoughts-on-java.org/spring-data-jpa-query-annotation/)
