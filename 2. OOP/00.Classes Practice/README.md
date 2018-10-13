# OOP Workshop

Design and implement a superheroes universe hierarchy, following the requirements:

- Each superhero has:
    - A name
        - Between 3 and 60 characters long
    - A secret identity
        - Between 3 and 60 characters long
    - An alignment
        - Can be either Good, Evil or Neutral
    - A life points
        - An integer between 0 and 100
    - A list of immunities
        - Power types
    - A list of powers
- Each power has:
    - A name
        - Between 3 and 20 characters long
    - A type
        - Can be either Magic, Chemical, Intellect, Tech, Other

Implement behavior for:

- Adding power to a superhero
    - Example:

    ```java
    batman.addPower(intelligence);
    ```

- Attacking another superhero
    - If the attacked superhero is imune to the attacking supower power, no life points are taken
        - Otherwise, take 10 points
    - Example

    ```java
    batman.attack(superman, kryptonite); 
    ```
