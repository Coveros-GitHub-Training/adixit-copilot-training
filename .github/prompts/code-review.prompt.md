---
description: 'Perform thorough code review with Spring Boot best practices checklist'
agent: 'ask'
---

# Code Review Checklist

Perform a thorough code review focusing on Spring Boot best practices, code quality, security, and maintainability.

## Review Criteria

### Code Quality
- [ ] Code follows Java naming conventions
- [ ] Methods are focused and have single responsibility
- [ ] No code duplication (DRY principle)
- [ ] Proper use of Lombok annotations
- [ ] Meaningful variable and method names

### Spring Boot Best Practices
- [ ] Uses constructor injection (not field injection)
- [ ] Proper use of `@Service`, `@Repository`, `@Controller` annotations
- [ ] `@Transactional` used correctly on service methods
- [ ] RESTful endpoint design follows conventions
- [ ] Proper HTTP status codes returned

### Error Handling
- [ ] Exceptions are properly handled
- [ ] No empty catch blocks
- [ ] Meaningful error messages
- [ ] Proper use of `ResponseEntity` for error responses
- [ ] Input validation with Bean Validation annotations

### Security
- [ ] No SQL injection vulnerabilities
- [ ] Input validation on all endpoints
- [ ] No sensitive data in logs
- [ ] Proper authentication/authorization (if applicable)

### Testing
- [ ] Unit tests exist for new code
- [ ] Tests follow AAA pattern
- [ ] Mocks used appropriately
- [ ] Edge cases covered
- [ ] Tests are readable and maintainable

### Documentation
- [ ] Public methods have Javadoc
- [ ] Complex logic is explained with comments
- [ ] README updated if needed
- [ ] API documentation updated

### Performance
- [ ] No N+1 query problems
- [ ] Proper use of JPA relationships
- [ ] Efficient database queries
- [ ] No unnecessary object creation

## Example Review Comment

```
❌ Issue: Field injection used instead of constructor injection
📝 Location: UserPantryService.java, line 15
🔧 Suggestion: Replace @Autowired field injection with constructor injection using Lombok's @RequiredArgsConstructor
📚 Why: Constructor injection makes dependencies explicit, improves testability, and prevents null pointer exceptions

Before:
@Autowired
private UserPantryRepository userPantryRepository;

After:
@RequiredArgsConstructor
public class UserPantryService {
    private final UserPantryRepository userPantryRepository;
    ...
}
```
