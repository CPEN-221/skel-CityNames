## Cities and TLAs

For various reasons, we use three-letter abbreviations and [three-letter acronyms](https://en.wikipedia.org/wiki/Three-letter_acronym). We will refer to three-letter acronyms or abbreviations as TLAs (itself a TLA). When it comes to names of cities or towns, three-letter abbreviations are useful for, say, [train station codes](https://en.wikipedia.org/wiki/List_of_IATA-indexed_railway_stations).

For the purposes of this activity, we define a valid TLA for the name of a city or town as follows: given a `String` `s` that represents that name of a town or city, a `String` `t` is a valid TLA of `s` if:

1. `t` contains three alphabets (no more, no less);
2. `t` contains only alphabets (for simplicity, we will assume all letters are upper-case);
3. the letters in `t` appear in `s` in the same order (although not necesssarily consecutive);
4. a letter in `s` can be used at most once in `t`.

**Examples**: If the city name is `VANCOUVER` then `VAN`, `VAC`, `VAR`, `ANC`, and `OUR` are all potential TLAs. On the other hand, `CAN` is not a valid TLA because `C` does not appear before an `A` and an `N` in `VANCOUVER`. Similarly, `YVR` is not a valid TLA for `VANCOUVER` because there is no `Y` in `VANCOUVER`. It is possible that a city name has a space (`" "`) in it (such as in `NEW DELHI`) but the corresponding TLA will not contain a space (TLAs only contain alphabets in upper-case form).

### Task 1 (1 point)

Let us define the type `CityTLA` as follows:

```java
public class CityTLA {
    public final String _cityName; // the name of the city or town
    public final String _cityCode; // a TLA for cityName
}
```

Implement a method `boolean checkRep()` for this type that verifies `_cityCode` is a valid TLA for `_cityName`. (In effect, we are checking the representation invariant. Normally this is a `private` method but for the purposes of this activity, we will make it a `public ` method.)

### Task 2 (1 point)

The challenge with TLAs as codes for city or town names is that we would like to avoid ambiguities. Given a list of cities, we would naturally like each city to have a **unique** code. But we go even further and will require that the code chosen for a city is such that that code **cannot be the code for any other city** given a list of city (or town) names.

For this task, we will define the type `CityNetwork` as follows:

```java
public class CityNetwork {
    public final List<CityTLA> _cities;
}
```

A valid `CityNetwork` contains at least one city, and if it contains more than one city then no two cities have the same TLA and the TLA chosen for one city cannot be TLA for another city in that `CityNetwork`. You will implement `checkRep` for `CityNetwork` that ensures that cities have valid codes and that the codes have no ambiguity. 

**Examples**

1. If the cities in a `CityNetwork` are `VANCOUVER`, `TORONTO` and `PARIS` then the codes `VAN`, `TOR` and `PAR`, respectively, are valid and the code for one city cannot be mistaken as the code for another city.
2. If the cities are `NEW YORK`, `NEW DELHI` and `NEW AMSTERDAM` then the codes `YOR`, `DEL` and `AMS`, respectively, are valid but the codes `NEW`, `DEL` and `AMS` (respectively) are not because `NEW` is not ambiguity-free.

### Task 3 (0.5 points)

In this task, given a `List` of `String`s where each `String` represents the name of a city or town, you should return a `CityNetwork` instance after computing valid codes for each city or town. The codes should satisfy the rules for a `CityNetwork` so they must be ambiguity-free. In the case that it is not possible to produce a valid `CityNetwork` instance for all provided city names, return a network with the maximum number of cities from the given the `List` for which ambiguity-free TLAs are possible.

## Submission Instructions

+ Submit your work to the Github classroom repository that was created for you.
+ **Do not alter the directory/folder structure. You should retain the structure as in this repository.**
+ Do not wait until the last minute to push your work to Github. It is a good idea to push your work at intermediate points as well. _We would recommend that you get your Git and Github workflow set up at the start._
+ You should submit your work to the `main` branch.

## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes.
+ You can use additional **standard** Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.

## Honour Code

By submitting your work to Github you agree to the following:

+ You did not consult with any other person for the purpose of completing this activity.
+ You did not aid any other person in the class in completing their activity.
+ You are submitting work from your own GitHub account.
+ If you consulted any external sources, such as resources available on the World Wide Web, in completing the examination then you have cited the source. (You do not need to cite class notes or Sun/Oracle Java documentation.)
+ You are not aware of any infractions of the honour code for this activity.