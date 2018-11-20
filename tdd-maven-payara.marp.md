# Test Driven (or Assisted) Development with Maven and Payara

> "We have brakes on our cars not to slow us down, but to let us go fast."

_TDD Proverb_

----

# Maven Lifecycles

## `clean`, `build`, `site`
- `clean` removes any already built artefacts
- `build` compiles & tests the project
- `site` creates reports on the project
  - javadoc, checkstyle, dependencies, ...

----

# Maven Phases

## clean lifecycle
### `clean`

## build lifecycle
### `compile`, `test-compile`, `test`, `package`, `integration-test`, `verify`, `install`, `deploy`

## site lifecycle
### `site`, `site-deploy`

## plus many `pre-` and `post-` phases

----

# Maven Command `mvn`

## `$ mvn clean verify site`

- specify phases in 1, 2 or all 3 lifecycles
- maven will run up to and including the specified phase
  - `test` runs `compile`, `test-compile` & `test`
