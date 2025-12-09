---
description: 'Generate a Spring Boot REST API endpoint with proper error handling'
agent: 'edit'
---

# Generate Spring Boot REST API Endpoint

Create a new REST API endpoint in the FlavorHub Spring Boot application.

Endpoint path: ${input:path:/api/recipes}
HTTP method: ${input:method:GET}
Purpose: ${input:purpose:Retrieve recipes}
Controller class: ${input:controller:RecipeController}

## Requirements:

### Spring Boot Annotations
- Use appropriate Spring annotations (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping)
- Return ResponseEntity<T> with proper HTTP status codes
- Use @RequestParam, @PathVariable, or @RequestBody as appropriate

### Request Validation
- Include Bean Validation annotations (@Valid, @NotNull, @NotBlank, etc.)
- Validate path and query parameters
- Return 400 Bad Request for validation failures

### Error Handling
- Add comprehensive try-catch blocks
- Return proper HTTP status codes (200, 201, 400, 404, 500)
- Include meaningful error messages
- Create error response DTOs if needed

### Documentation
- Include Javadoc with:
  - Method description
  - @param for all parameters
  - @return for return value
  - @throws for exceptions (if any)
- Add inline comments for complex logic

### RESTful Conventions
- Use plural nouns for collections (/recipes not /recipe)
- Use HTTP methods correctly (GET for read, POST for create, etc.)
- Return 201 Created for POST requests
- Return 204 No Content for successful DELETE
- Include Location header for created resources

### Code Quality
- Follow Spring Boot best practices
- Use constructor injection for dependencies
- Keep methods focused and concise
- Use meaningful variable names

## Example Structure:

```java
/**
 * ${purpose}
 * 
 * @param param Description of parameter
 * @return ResponseEntity containing the result
 */
@${method}Mapping("${path}")
public ResponseEntity<?> methodName(@RequestParam String param) {
    try {
        // Input validation
        if (param == null || param.isBlank()) {
            return ResponseEntity.badRequest()
                .body(new ErrorResponse("Parameter cannot be empty"));
        }
        
        // Business logic
        var result = service.performOperation(param);
        
        // Check if result exists
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        // Success response
        return ResponseEntity.ok(result.get());
        
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest()
            .body(new ErrorResponse(e.getMessage()));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ErrorResponse("An error occurred: " + e.getMessage()));
    }
}
```

Generate the complete endpoint method with all necessary imports, annotations, and error handling following Spring Boot best practices.
