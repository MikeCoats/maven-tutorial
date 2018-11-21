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

----

# Maven Plugins

## Provide Maven with flexibility & power
- Maven has `phase`s that it walks through
- Plugins have `goal`s that provide functionality
- `execution`s bind the two together

----

# Maven Plugins - Example

- The Cargo plugin `redeploy`s code to Payara
- We want Maven to execute this during the `pre-integration-test` phase
- We build an `execution` to do this

```xml
<plugin>
  <groupId>org.codehaus.cargo</groupId>
  <artifactId>cargo-maven2-plugin</artifactId>
  <executions>
    <execution>
      <phase>pre-integration-test</phase>
      <goals>
        <goal>redeploy</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```

----

# Tutorial Webapp


```
http://localhost:8080/maventutorial/calculate
```

## that takes in

```js
{
  "leftOperand": 3.0,
  "opertor": "+",
  "rightOperand": 5.0
}
```

## and returns

```js
{
  "result": 8.0
}
```

----

# Base Project
## Fork and Clone [https://github.com/MikeCoats/maven-tutorial](https://github.com/MikeCoats/maven-tutorial)
###### `$ git clone https://github.com/YourNameHere/maven-tutorial.git`
## Checkout master branch
###### `$ git checkout master`

----

# Step 1 - Minimum required `pom.xml`
## [`step/01-minimum-pom`](https://github.com/MikeCoats/maven-tutorial/commit/5aa6671b2d91d3322c397d3f789a2cfeaf14cee6)


----

# Step 2 - Write your first (hopefully) failing test
## [`step/02-first-failing-test`](https://github.com/MikeCoats/maven-tutorial/commit/6d29df38b6d6fa38aee3ded96d5af3f53a510d8d)

----

# Fix it
- ## Start Payara
  `$ /c/payara/payara5.183/bin/asadmin start-domain`

----

# Step 3 - Check for 200 status
## [`step/03-second-failing-test`](https://github.com/MikeCoats/maven-tutorial/commit/29b3e9bb03b37e807f2663c06c965674bdbfeea0)

----

# Step 4 - Add GET handler and deployment
## [`step/04-fix-returns-200-test`](https://github.com/MikeCoats/maven-tutorial/commit/ff952e6c5f9685fa9c0269622cf446d3dd64328d)
## [`step/04-fix-returns-200-test`](https://github.com/MikeCoats/maven-tutorial/commit/869a2fdea9445eee39610e44210409cfbcca3588)

----

# Step 5 - Test for JSON
## [`step/05-json-type-test`](https://github.com/MikeCoats/maven-tutorial/commit/66c378b7c963b0e37834fb56dd4427f4ae0f2922)

----

# Step 6 - Return some JSON
## [`step/06-fix-return-type`](https://github.com/MikeCoats/maven-tutorial/commit/4d2893aff0fa42819fe6662396945e0e3f57ccf7)

----

# Step 7 - Test returned object's 'shape'
## [`step/07-result-object-test`](https://github.com/MikeCoats/maven-tutorial/commit/17a8fd984656cc6cf27f3d495863cd60e0e1f6bf)

----

# Step 8 - Build and return a Result
## [`step/08-return-result-object`](https://github.com/MikeCoats/maven-tutorial/commit/e03a5b3852f3656ddd400f6f5062b442a1c5067a)

----

# Step 9 - Test what the result is
## [`step/09-check-result-test`](https://github.com/MikeCoats/maven-tutorial/commit/aafdb14a66952cbff962b7e9c6b8b0fa3053d846)

----

# Step 10 - Build Calculation to return Result
## [`step/10-respond-correct-result`](https://github.com/MikeCoats/maven-tutorial/commit/eca2c485dc80ccdbd14d7c4020d0ba232f69deda)

----

# Step 11 - Test a different sum
## [`step/11-test-different-sum`](https://github.com/MikeCoats/maven-tutorial/commit/61736ba7250787ce9ed090dc2898a72eb0c1d055)

----

# Step 12 - Handle different sums
## [`step/12-handle-different-sums`](https://github.com/MikeCoats/maven-tutorial/commit/e3882d7e646840876183d22d4266a03551adf975)

----

# Step 13 - Test subtraction
## [`step/13-test-subtraction`](https://github.com/MikeCoats/maven-tutorial/commit/5bcacb613a69bc189f0e83b464fa92d301a80117)

----

# Step 14 - Handle subtraction
## [`step/14-handle-subtraction`](https://github.com/MikeCoats/maven-tutorial/commit/2d5eb8df4de97d2e17abf41dc7e94a4b77346cd5)

----

# Step 15 - Test multiplication & division
## [`step/15-test-multiplication-division`](https://github.com/MikeCoats/maven-tutorial/commit/4cae82116393093a5c2cd87918adef5694058803)

----

# Step 16 - Handle multiplication & division
## [`step/16-handle-multiplication-division`](https://github.com/MikeCoats/maven-tutorial/commit/b9714c1244150d81422b6d6a5c88592d8df544fb)

----

# Step 17 - Test invalid functions
## [`step/17-test-only-four-functions`](https://github.com/MikeCoats/maven-tutorial/commit/6cb562ed0370703cf186e5662919b65d821ffa9d)

----

# Step 18 - Handle errors gracefully
## [`step/18-limit-four-error-otherwise`](https://github.com/MikeCoats/maven-tutorial/commit/9d9070f99964360b671cd4a09d3f92b26eb6792d)

----


# Step 19 - Enable checkstyle
## [`step/19-enable-checkstyle`](https://github.com/MikeCoats/maven-tutorial/commit/ef86159dc3b5ed5b6eff00ba07ff5d735b7d8d8e)

----


# Step 20 - Fix up the project
## [`step/20-checkstyle`](https://github.com/MikeCoats/maven-tutorial/commit/989624ee27b7f9108bf09f42b5c8b9836372ab4f)

