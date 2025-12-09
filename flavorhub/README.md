# FlavorHub - GitHub Copilot Workshop Application

A Spring Boot application for managing recipes, ingredients, and pantry items. This application is designed as a learning tool for the GitHub Copilot Advanced Workshop.

## Overview

FlavorHub helps users:
- Manage ingredients in their virtual "pantry"
- Browse and search through available recipes
- Get recipe recommendations based on pantry ingredients
- Filter recipes by difficulty, cuisine type, and cooking time

## Technologies Used

- **Java 21** - Programming language
- **Spring Boot 3.2.0** - Application framework
- **Spring Data JPA** - Data persistence
- **H2 Database** - In-memory database (development)
- **Maven** - Build tool
- **Lombok** - Reduces boilerplate code
- **Thymeleaf** - Template engine

## Prerequisites

### Option 1: GitHub Codespaces (Recommended)
- GitHub account with Copilot access
- No local installation required!

### Option 2: Local Development
- **Java Development Kit (JDK) 21** or newer
  - Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
  - Verify installation: `java -version`
- **Maven 3.6+** (or use included Maven Wrapper)
  - Download from [Apache Maven](https://maven.apache.org/download.cgi)
  - Verify installation: `mvn -version`
- **VS Code** with recommended extensions:
  - Extension Pack for Java
  - Spring Boot Extension Pack
  - GitHub Copilot
  - GitHub Copilot Chat

## Getting Started

### Using GitHub Codespaces

1. Click the **"Code"** button on the repository page
2. Select **"Codespaces"** tab
3. Click **"Create codespace on main"**
4. Wait for the environment to build
5. Once ready, navigate to the `flavorhub` directory:
   ```bash
   cd flavorhub
   ```
6. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
7. Open the forwarded port (default: 8080) in your browser

### Local Development

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd copilot-advanced-workshop-java/flavorhub
   ```

2. Build the project:
   ```bash
   ./mvnw clean install
   ```
   
   Or on Windows:
   ```cmd
   mvnw.cmd clean install
   ```

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Access the application at [http://localhost:8080](http://localhost:8080)

## Application Structure

```
flavorhub/
├── src/
│   ├── main/
│   │   ├── java/com/coveros/training/flavorhub/
│   │   │   ├── config/          # Configuration classes
│   │   │   │   └── DataLoader.java  # Sample data initialization
│   │   │   ├── controller/      # REST API controllers
│   │   │   │   ├── IngredientController.java
│   │   │   │   ├── RecipeController.java
│   │   │   │   ├── UserPantryController.java
│   │   │   │   └── HomeController.java
│   │   │   ├── model/          # Entity classes
│   │   │   │   ├── Ingredient.java
│   │   │   │   ├── Recipe.java
│   │   │   │   ├── RecipeIngredient.java
│   │   │   │   └── UserPantry.java
│   │   │   ├── repository/     # Data access layer
│   │   │   │   ├── IngredientRepository.java
│   │   │   │   ├── RecipeRepository.java
│   │   │   │   └── UserPantryRepository.java
│   │   │   ├── service/        # Business logic layer
│   │   │   │   ├── IngredientService.java
│   │   │   │   ├── RecipeService.java
│   │   │   │   └── UserPantryService.java
│   │   │   └── FlavorHubApplication.java
│   │   └── resources/
│   │       ├── application.properties   # App configuration
│   │       ├── templates/              # HTML templates
│   │       │   └── index.html
│   │       └── static/                 # Static assets (CSS, JS)
│   └── test/                          # Test classes
├── pom.xml                            # Maven configuration
└── README.md                          # This file
```

## Data Models

### Ingredient
Represents an ingredient that can be used in recipes.
- `id` - Unique identifier
- `name` - Ingredient name (e.g., "Tomato")
- `category` - Category (e.g., "Vegetable", "Dairy")
- `unit` - Measurement unit (e.g., "cups", "grams")

### Recipe
Represents a recipe with instructions.
- `id` - Unique identifier
- `name` - Recipe name
- `description` - Brief description
- `prepTime` - Preparation time in minutes
- `cookTime` - Cooking time in minutes
- `servings` - Number of servings
- `difficultyLevel` - Easy, Medium, or Hard
- `cuisineType` - Italian, Mexican, Asian, etc.
- `ingredients` - List of RecipeIngredient
- `instructions` - Step-by-step instructions
- `imageUrl` - Optional image URL

### UserPantry
Represents ingredients a user has in their pantry.
- `id` - Unique identifier
- `userId` - User identifier (hardcoded to 1 for workshop)
- `ingredient` - Reference to Ingredient
- `quantity` - Amount available
- `unit` - Measurement unit
- `notes` - Optional notes (e.g., "expires soon")

## API Endpoints

### Recipes
- `GET /api/recipes` - Get all recipes
- `GET /api/recipes/{id}` - Get recipe by ID
- `GET /api/recipes/search?query={term}` - Search recipes by name
- `POST /api/recipes` - Create a new recipe
- `PUT /api/recipes/{id}` - Update a recipe
- `DELETE /api/recipes/{id}` - Delete a recipe

### Ingredients
- `GET /api/ingredients` - Get all ingredients
- `GET /api/ingredients/{id}` - Get ingredient by ID
- `GET /api/ingredients/search?query={term}` - Search ingredients
- `GET /api/ingredients/category/{category}` - Get by category
- `POST /api/ingredients` - Create a new ingredient
- `PUT /api/ingredients/{id}` - Update an ingredient
- `DELETE /api/ingredients/{id}` - Delete an ingredient

### User Pantry
- `GET /api/pantry` - Get all pantry items for current user
- `POST /api/pantry` - Add item to pantry
- `DELETE /api/pantry/{id}` - Remove pantry item

## Database Access

The application uses an in-memory H2 database. To view and query the database:

1. Navigate to [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
2. Use these connection settings:
   - **JDBC URL**: `jdbc:h2:mem:recipedb`
   - **User Name**: `sa`
   - **Password**: (leave empty)
3. Click "Connect"

## Sample Data

The application loads sample data on startup:
- **Ingredients**: Common cooking ingredients across multiple categories
- **Recipes**: 4 sample recipes including Spaghetti Carbonara, Grilled Chicken, Vegetable Stir-Fry, and Tomato Basil Soup
- **Pantry Items**: A few items pre-loaded for testing

## Development Commands

```bash
# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run

# Run tests
./mvnw test

# Package as JAR
./mvnw package

# Run the packaged JAR
java -jar target/flavorhub-1.0.0.jar

# Skip tests during build
./mvnw clean install -DskipTests
```

## Workshop Notes

⚠️ **This application is intentionally incomplete!**

Throughout the GitHub Copilot workshop, you'll:
- Implement missing API endpoints (marked with `// TODO`)
- Add missing business logic methods
- Write unit and integration tests
- Improve error handling and validation
- Add new features like recipe recommendations
- Refactor and optimize code
- Document your code with Copilot's help

Look for `// TODO` comments throughout the codebase to find areas where you'll practice using GitHub Copilot.

## Troubleshooting

### Port Already in Use
If port 8080 is already in use, change it in `application.properties`:
```properties
server.port=8081
```

### Maven Wrapper Not Executable
On Unix/Linux/Mac, make the Maven wrapper executable:
```bash
chmod +x mvnw
```

### Java Version Issues
Ensure you're using Java 21 or newer:
```bash
java -version
```

If needed, set JAVA_HOME environment variable to your JDK 21+ installation.

### IDE Not Recognizing Code
If your IDE shows errors:
1. Ensure Lombok is installed/enabled in your IDE
2. Trigger a Maven reimport/refresh
3. Rebuild the project

## Next Steps

1. Start with Lab 1 in the workshop materials
2. Explore the codebase using GitHub Copilot Chat
3. Complete the exercises to implement missing features
4. Experiment with Copilot's code generation capabilities

## License

This project is part of the GitHub Copilot Advanced Workshop training materials.
