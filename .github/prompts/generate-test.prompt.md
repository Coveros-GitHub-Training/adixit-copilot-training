---
description: 'Generate comprehensive JUnit 5 tests for Spring Boot classes'
agent: 'edit'
---

# Generate Spring Boot Test

Generate a comprehensive JUnit 5 test class for a Spring Boot service or controller.

## Instructions

When asked to generate tests, please:

1. **Use JUnit 5** with modern annotations (`@Test`, `@BeforeEach`, `@AfterEach`)
2. **Use Mockito** for mocking dependencies
3. **Follow AAA pattern**: Arrange, Act, Assert
4. **Use descriptive test names**: `testMethodName_WhenCondition_ThenExpectedResult`
5. **Include edge cases**: Test happy path, error cases, and boundary conditions
6. **Mock all dependencies**: Don't use real database or external services
7. **Use appropriate Spring Boot test annotations**:
   - `@SpringBootTest` for integration tests
   - `@WebMvcTest(ControllerClass.class)` for controller tests
   - `@DataJpaTest` for repository tests
   - `@ExtendWith(MockitoExtension.class)` for unit tests

## Example Output

```java
@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {
    
    @Mock
    private RecipeRepository recipeRepository;
    
    @InjectMocks
    private RecipeService recipeService;
    
    private Recipe testRecipe;
    
    @BeforeEach
    void setUp() {
        testRecipe = new Recipe("Pasta", "Italian pasta dish", 10, 15, 4, "Easy", "Italian");
        testRecipe.setId(1L);
    }
    
    @Test
    void testGetRecipeById_WhenRecipeExists_ThenReturnsRecipe() {
        // Arrange
        when(recipeRepository.findById(1L)).thenReturn(Optional.of(testRecipe));
        
        // Act
        Optional<Recipe> result = recipeService.getRecipeById(1L);
        
        // Assert
        assertTrue(result.isPresent());
        assertEquals("Pasta", result.get().getName());
        verify(recipeRepository).findById(1L);
    }
    
    @Test
    void testGetRecipeById_WhenRecipeDoesNotExist_ThenReturnsEmpty() {
        // Arrange
        when(recipeRepository.findById(999L)).thenReturn(Optional.empty());
        
        // Act
        Optional<Recipe> result = recipeService.getRecipeById(999L);
        
        // Assert
        assertFalse(result.isPresent());
        verify(recipeRepository).findById(999L);
    }
}
```

## Coverage Requirements

- Test all public methods
- Include positive and negative test cases
- Test boundary conditions
- Test exception handling
- Achieve at least 80% code coverage
