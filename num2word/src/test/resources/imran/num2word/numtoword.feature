Feature: an equivalent number in british english words
  As a user
  I want to see a given number converted into british english words
  So that I can verify result

  Scenario: Take a number and give the equivalent number in british english words
    Given num to word is submitted by a user
    When this program is run with one of the following positive integer numbers given as an input:
        | 1         |
        | 11        |
        | 21        |
        | 105       |
        | 4567      |
        | 30245     |
        | 283471    |
        | 8235694   |
        | 56945781  |
        | 999999999 |
    Then the output is an equivalent number in british english words as:
        | one                                                                                                     |
        | eleven                                                                                                  |
        | twenty one                                                                                              |
        | one hundred and five                                                                                    |
        | four thousand five hundred and sixty seven                                                              |
        | thirty thousand two hundred and forty five                                                              |
        | two hundred and eighty three thousand four hundred and seventy one                                      |
        | eight million two hundred and thirty five thousand six hundred and ninety four                          |
        | fifty six million nine hundred and forty five thousand seven hundred and eighty one                     |
        | nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine |

  Scenario: Take an edge case number and give the equivalent number in british english words
      Given num to word is submitted by a user
      When this program is run with one of the following positive integer numbers given as an input:
        | 10        |
        | 100       |
        | 101       |
        | 1000      |
        | 1001      |
        | 10000     |
        | 10001     |
        | 100000    |
        | 100001    |
        | 1000000   |
        | 1000001   |
        | 10000000  |
        | 10000001  |
        | 100000000 |
        | 100000001 |
      Then the output is an equivalent number in british english words as:
        | ten                           |
        | one hundred                   |
        | one hundred and one           |
        | one thousand                  |
        | one thousand and one          |
        | ten thousand                  |
        | ten thousand and one          |
        | one hundred thousand          |
        | one hundred thousand and one  |
        | one million                   |
        | one million and one           |
        | ten million                   |
        | ten million and one           |
        | one hundred million           |
        | one hundred million and one   |

  Scenario: Take zero and try to give the equivalent number in british english words
    Given num to word is submitted by a user
    When this program is run with a zero integer number "0" given as an input
    Then the output is "zero"

  Scenario: Take an invalid number and try to give the equivalent number in british english words
    Given num to word is submitted by a user
    When this program is run with a negative integer number "-1" given as an input
    Then the output is an error message as "ERROR: Invalid argument -1"

  Scenario: Take an invalid string and try to give the equivalent number in british english words
    Given num to word is submitted by a user
    When this program is run with a non integer number "non-integer" given as an input
    Then the output is an error message as "ERROR: Invalid argument non-integer"
