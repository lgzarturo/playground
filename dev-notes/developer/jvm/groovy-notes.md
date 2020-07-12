# Flatten a nested list

```groovy
def list = ['foo', 'bar', ['inner_foo', 'inner_bar']]
list.flatten()
```

Resultado:

```bash
['foo', 'bar', 'inner_foo', 'inner_bar']
```

## Microbenchmark

- [Iteration benchmark](https://e.printstacktrace.blog/what-is-the-most-efficient-way-to-iterate-collection-in-groovy-jmh/)
- [Trampoline closure](https://e.printstacktrace.blog/groovy-trampoline-closure-a-step-into-recursive-closures/)
