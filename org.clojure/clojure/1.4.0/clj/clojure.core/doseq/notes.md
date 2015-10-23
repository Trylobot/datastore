## Usage

    [seq-exprs & body]

## Docstring

Repeatedly executes the body expressions with modifiers as provided by
clj::clojure.core/for, does not retain the head of the
sequence. Returns nil.

## Notes

Unlike `for` which is intended for generating a sequence of results
and cannot/should not be used to perform effects due to lazy sequence
chunking behavior, `doseq` is designed to eagerly perform effects with
no result. Effects with a result should be expressed in terms of an
imperative clj::clojure.core/mapv or with clj::clojure.core/loop

Supported modifiers are:

- `:let [binding-form expr ...]` which establishes normal non-iterated bindings
- `:while form` which allows for the termination of the sequence when form is truthy
- `:when form` which continues unless form is truthy
