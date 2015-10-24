## Usage

    [f coll]
    [f val coll]

## Docs

Clojure's [fold right](https://en.wikipedia.org/wiki/Fold_%28higher-order_function%29) function.

`f` should be a function of 2 arguments. If val is not supplied,
`reduce` returns the result of applying `f` to the first 2 items in
`coll`, then applying `f` to that result and the 3rd item, etc.

If `coll` may be empty, `f` must accept no arguments as well because
when `coll` is empty and `val` is not supplied, `reduce` returns the
result of calling `f` with no arguments.

If `coll` has only 1 item, it is returned and `f` is not called.

If val is supplied, `reduce` returns the result of applying `f` to val
and the first item in coll, then applying `f` to that result and the
2nd item, etc. If `coll` contains no items, returns `val` and `f` is
not called.

## Notes

That `f` may be called with 0 arguments is an oft overlooked property
of `reduce`. Unless dealing with a function such as
clj::clojure.core/+ which behaves as an agebraic group and has a
meaningful 0-arity invocation an identity element `val` should always
be provided.

`(reduce concat ...)` should be avoided, see clj::clojure.core/concat
for more details.

`(reduce conj ...)` and `(reduce assoc ...)` should be avoided, see
clj::clojure.core/into for more details.
