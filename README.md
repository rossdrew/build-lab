# Build Laboratory

Started with a Roman Numeral converter codebase to test build tools and I've expanded it to include Advent of Code solutions, where I take my time as write them as best I can.

## Contains

- Some code to convert Roman numerals to numbers and back
- Some Unit tests to test the Roman Numeral conversions
- Pitest's dependencies to mutate the code and validate the unit tests
- Reports published to GitHub pages [here](https://rossdrew.github.io/build-lab/) using [peaceiris/actions-gh-pages](https://github.com/peaceiris/actions-gh-pages)
  - JaCoCo code coverage
  - Pitest mutation testing
  - Checkstyle reports
- Checkstyle reports attached to commits via [jwgmeligmeyling/checkstyle-github-action](https://github.com/jwgmeligmeyling/checkstyle-github-action).  Using a branch of this ([cmelchior/checkstyle-github-action](https://github.com/cmelchior/checkstyle-github-action)) to use a newer version (16) of node

## Workflow

1. Write the failing test
2. Write the code to pass the test
3. Run Checkstyle (checkstyle:check)
4. Fix style issues
5. Run Mutation Testing (pitest:mutationCoverage)
6. Fix mutation issues

## Next Up
- Pitest attached to commits, evaluating [Bonajo/pitest-report-action](https://github.com/Bonajo/pitest-report-action)
- Figure out why Pitest sees 100% coverage but Jacoco is much lower (6% at the time of writing)