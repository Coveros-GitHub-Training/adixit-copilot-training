---
description: 'Generate comprehensive OpenAPI/Swagger documentation for REST endpoints'
agent: 'edit'
---

# Generate API Documentation

Generate comprehensive OpenAPI 3.0 documentation for Spring Boot REST endpoints.

## Documentation Requirements:

### Endpoint Summary
- Clear, concise summary (one line)
- Detailed description (2-3 sentences explaining purpose and use case)
- Tags for grouping related endpoints

### Parameters
- Path parameters with types and descriptions
- Query parameters with defaults and examples
- Request body schema with field descriptions
- Mark required vs optional parameters clearly

### Response Documentation
- Success response (200, 201, etc.) with example JSON
- Error responses (400, 404, 500) with example error messages
- Schema definitions for complex objects

### Request/Response Examples
- Realistic example data using FlavorHub domain
- Show actual recipe names, ingredients, cuisines
- Include edge cases in examples (empty lists, null values)

### Security & Authentication
- Note if endpoint requires authentication
- Specify required permissions or roles

### Spring Boot API Standards
- Use camelCase for JSON properties
- Include pagination details for list endpoints
- Document rate limiting if applicable
- Mention any deprecation warnings

## Example Structure:
```yaml
paths:
  /api/recipes/{id}:
    get:
      summary: Get recipe by ID
      description: Retrieves detailed information about a specific recipe including ingredients, instructions, and metadata
      tags:
        - Recipes
      parameters:
        - name: id
          in: path
          required: true
          description: Unique identifier of the recipe
          schema:
            type: integer
            format: int64
      responses:
        200:
          description: Recipe found successfully
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Recipe'
              example:
                id: 1
                name: "Classic Margherita Pizza"
                description: "Traditional Italian pizza with tomato, mozzarella, and basil"
                prepTime: 20
                cookTime: 15
                servings: 4
                difficulty: "Medium"
                cuisine: "Italian"
        404:
          description: Recipe not found
          content:
            application/json:
              example:
                error: "Recipe with ID 999 not found"
```

Generate complete OpenAPI 3.0 YAML or JSON documentation for the selected Spring Boot controller method.
