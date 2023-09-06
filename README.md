# Build Labratory

Started with a Roman Numeral converter codebase to test build tools and I've expanded it to include Advent of Code solutions, where I take my time as write them as best I can.

## Contains

- Some code to convert Roman numerals to numbers and back
- Some Unit tests to test the Roman Numeral conversions
- Pitest dependencies to mutate the code and validate the unit tests
- Reports published to GitHub pages [here](https://rossdrew.github.io/build-lab/) using [peaceiris/actions-gh-pages](https://github.com/peaceiris/actions-gh-pages)
  - JaCoCo code coverage
  - Pitest mutation testing
  - Checkstyle reports
- Checkstyle reports attached to commits via [jwgmeligmeyling/checkstyle-github-action](https://github.com/jwgmeligmeyling/checkstyle-github-action).  Using a branch of this ([cmelchior/checkstyle-github-action](https://github.com/cmelchior/checkstyle-github-action)) to use a newer version (16) of node


## Next Up
- Pitest attached to commits, evaluating [Bonajo/pitest-report-action](https://github.com/Bonajo/pitest-report-action)