# Notes

## Gotchas

- Given a list of maps means you need to find if there is an existing kvp and increment the count. Can't just do a simple `put`
- Multiple null cases, map entries could be null, or the visitor info can be null
  - The visitor info being null is handled by my try catch for parsing the character as a long
