# ADR 0001: Kotoba is the FBF catalog source authority

- Status: Accepted
- Date: 2026-07-21

`src/association_facts.kotoba` is the sole production source. It preserves both
French titles and official citations, both absent establishment/revision dates,
and the asymmetric topic sets without inferring dates from retrieval time.
Unknown values and indexes fail closed; no effects are declared. Conformance is
semantic across reference, restricted JavaScript, and instantiated typed
WebAssembly; compiler-output byte identity is not a gate. Clojure and the JVM
are compiler/test hosts only.
