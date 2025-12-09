# GitHub Copilot Repository Instructions

These instructions guide GitHub Copilot when working within the FlavorHub project.

## Project Context

This is a Spring Boot application for managing recipes and pantry ingredients, used as a training application for the GitHub Copilot Advanced Workshop. The application features a Java backend with REST APIs and a web frontend using Thymeleaf templates.

## Code Style and Standards

### Java Coding Standards
- Follow standard Java naming conventions (camelCase for methods/variables, PascalCase for classes)
- Use meaningful, descriptive names
- Keep methods focused and concise (single responsibility)
- Prefer composition over inheritance
- Use Java 21 features where appropriate

### Frontend Guidelines (HTML/CSS/JavaScript)
- Use Thymeleaf template engine for server-side rendering
- Keep HTML semantic and accessible
- Use CSS Grid and Flexbox for layouts
- Follow mobile-first responsive design principles
- Add TODO comments for incomplete JavaScript functionality
- Use vanilla JavaScript for simple interactions
- Keep inline styles minimal; prefer CSS classes

### Spring Boot Best Practices
- Use constructor injection (via Lombok's `@RequiredArgsConstructor`) instead of field injection
- Mark service classes with `@Service` and repositories with `@Repository`
- Use `@Transactional` on service methods that modify data
- RESTful endpoint naming: use nouns for resources, HTTP methods for actions
- Return `ResponseEntity<T>` from controller methods for proper HTTP status control

### Lombok Usage
- Use `@Data` for entity classes with simple getters/setters
- Use `@NoArgsConstructor` and `@AllArgsConstructor` for constructors
- Use `@RequiredArgsConstructor` for dependency injection
- Avoid `@Builder` unless complex object construction is needed

### Documentation
- Add Javadoc comments to all public classes and methods
- Include `@param`, `@return`, and `@throws` tags where applicable
- Explain WHY, not just WHAT, in comments
- Mark incomplete features with `// TODO:` followed by a clear description

## Testing Guidelines

### Test Structure
- Use JUnit 5 (`@Test`, `@BeforeEach`, `@AfterEach`)
- Use Mockito for mocking dependencies
- Follow AAA pattern: Arrange, Act, Assert
- Use descriptive test method names: `testMethodName_WhenCondition_ThenExpectedResult`

### Spring Boot Testing
- Use `@SpringBootTest` for integration tests
- Use `@WebMvcTest` for controller tests
- Use `@DataJpaTest` for repository tests
- Mock external dependencies in unit tests

## API Design

### REST Endpoints
- Use appropriate HTTP methods: GET (read), POST (create), PUT (update), DELETE (delete)
- Return appropriate status codes (200 OK, 201 Created, 404 Not Found, etc.)
- Use plural nouns for resource endpoints (`/api/recipes`, not `/api/recipe`)
- Use path variables for resource IDs: `/api/recipes/{id}`
- Use query parameters for filtering and search: `/api/recipes?difficulty=Easy`

### Request/Response
- Use DTOs (Data Transfer Objects) for complex request/response payloads
- Validate input with Bean Validation annotations (`@NotNull`, `@NotBlank`, etc.)
- Return meaningful error messages in responses
- Use consistent JSON naming (camelCase)

## Database

### JPA/Hibernate
- Use standard JPA annotations (`@Entity`, `@Table`, `@Column`, etc.)
- Define proper relationships (`@OneToMany`, `@ManyToOne`, `@ManyToMany`)
- Use `@GeneratedValue` for auto-incrementing primary keys
- Create custom query methods in repositories following Spring Data JPA naming conventions

### Data Management
- Use the H2 in-memory database for development and testing
- Populate sample data via `DataLoader` component
- Keep entities simple and focused
- Use `@Embeddable` for composite value objects

## Workshop-Specific Guidelines

### Intentional Incompleteness
- Some features are intentionally marked with `// TODO` for workshop exercises
- When implementing TODO items, follow existing code patterns
- Write tests for newly implemented features
- Update documentation when adding features

### Learning Focus
- Prioritize code clarity over clever solutions
- Add comments to explain Spring Boot concepts
- Keep code simple enough for beginners to understand
- Demonstrate best practices, not just working code

## When Generating Code

1. **Check existing patterns**: Look at similar code in the project first
2. **Follow Spring conventions**: Use standard Spring Boot patterns
3. **Match frontend style**: Follow existing HTML/CSS patterns in templates
4. **Include error handling**: Add appropriate exception handling
5. **Write tests**: Generate tests alongside implementation code
6. **Add documentation**: Include Javadoc for public methods and HTML comments for complex UI sections
7. **Validate input**: Use Bean Validation annotations for backend, client-side validation for forms
8. **Return proper responses**: Use `ResponseEntity` with appropriate status codes
9. **Full-stack coherence**: Ensure frontend and backend work together seamlessly

## Prohibited Practices

- ❌ Do not use field injection (`@Autowired` on fields)
- ❌ Do not return null from API endpoints (use Optional or throw exceptions)
- ❌ Do not put business logic in controllers
- ❌ Do not use raw SQL unless absolutely necessary
- ❌ Do not ignore exceptions or use empty catch blocks

## Examples

### Good Controller Method
```java
@GetMapping("/{id}")
public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
    return recipeService.getRecipeById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}
```

### Good Service Method
```java
@Transactional
public Recipe saveRecipe(Recipe recipe) {
    return recipeRepository.save(recipe);
}
```

### Good Test Method
```java
@Test
void testGetRecipeById_WhenRecipeExists_ThenReturnsRecipe() {
    // Arrange
    Recipe recipe = new Recipe("Pasta", "Italian pasta dish", 10, 15, 4, "Easy", "Italian");
    when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));
    
    // Act
    Optional<Recipe> result = recipeService.getRecipeById(1L);
    
    // Assert
    assertTrue(result.isPresent());
    assertEquals("Pasta", result.get().getName());
}
```

### Good HTML/CSS Pattern
```html
<!-- Use semantic HTML with clear class names -->
<div class="recipe-card">
    <div class="recipe-header">
        <h3 th:text="${recipe.name}">Recipe Name</h3>
        <span class="recipe-cuisine" th:text="${recipe.cuisine}">Cuisine</span>
    </div>
    <div class="recipe-body">
        <p th:text="${recipe.description}">Description</p>
        <span class="difficulty" th:classappend="${recipe.difficulty.toLowerCase()}"
              th:text="${recipe.difficulty}">Easy</span>
    </div>
</div>
```

### Good JavaScript Pattern
```javascript
// Use clear, descriptive function names and handle errors
async function fetchRecipes() {
    try {
        const response = await fetch('/api/recipes');
        if (!response.ok) {
            throw new Error('Failed to fetch recipes');
        }
        const recipes = await response.json();
        displayRecipes(recipes);
    } catch (error) {
        console.error('Error loading recipes:', error);
        showErrorMessage('Unable to load recipes. Please try again.');
    }
}
```

## Additional Resources

- [Spring Boot Best Practices](https://spring.io/guides)
- [Effective Java (Joshua Bloch)](https://www.oreilly.com/library/view/effective-java/9780134686097/)
- [REST API Design Best Practices](https://restfulapi.net/)
