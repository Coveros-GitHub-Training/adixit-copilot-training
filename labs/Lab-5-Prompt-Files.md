# Exercise 5 - Prompt Files

#### Duration: 20 minutes

## 🎯 Learning Objectives

By the end of this exercise, you will:
- Create and use prompt files for consistent, reusable AI interactions
- Understand prompt file structure with YAML headers and variables
- Build efficient workflows using standardized prompts
- Share team knowledge through reusable prompt templates

## 🍳 Scenario: Standardizing AI Interactions at FlavorHub

Your team at FlavorHub has noticed that developers often repeat similar complex prompts for common operations. You've decided to create reusable prompt files that capture team knowledge and ensure consistency.

Today, you'll learn how to:
- Create reusable prompts that capture team knowledge
- Use variables to make prompts flexible and adaptable
- Streamline repetitive development tasks
- Standardize how the team interacts with Copilot

## 📝 Step 1: Understanding Prompt Files

Prompt files allow you to create reusable, standardized prompts that maintain consistency across your team and save time on repetitive tasks.

### Step 1.1: Why Prompt Files Matter

**Benefits:**
- **Consistency**: Same prompt structure every time
- **Efficiency**: No need to retype complex prompts
- **Standardization**: Team uses the same approaches
- **Knowledge sharing**: Capture expert prompting techniques

### Step 1.2: Prompt File Structure

Prompt files consist of two main parts:

**Header (YAML):**
```yaml
---
name: The name of the prompt, used after typing / in chat. If not specified, the file name is used.
description: 'What this prompt does'
agent: 'ask', 'edit', 'agent', or the name of a custom agent
model: The language model used when running the prompt. If not specified, the currently selected model in model picker is used.
tools: ['optional-specific-tools']
---
```

**Body (Markdown):**
```markdown
Your prompt template here with ${input:variableName:placeholder}
```

**Available Variables:**
- `${workspaceFolder}` - Current workspace path
- `${file}` - Current file path
- `${selection}` - Selected text
- `${input:name:placeholder}` - User input with placeholder

**Context References:**
- Specific file paths for precise context. Ensure to use markdown link formatting for optimal results.

## 📋 Step 2: Explore Existing Prompt Files

Let's examine the prompt files already in the repository to understand best practices.

### Step 2.1: Navigate to Prompt Files

1. **Open the `.github/prompts/` folder**

2. **Review the existing prompt files:**
   - `generate-test.prompt.md`
   - `code-review.prompt.md`

3. **Notice the structure:**
   - YAML header with metadata
   - Clear description
   - Appropriate agent mode
   - Template body with variables

### Step 2.2: Use an Existing Prompt File

Try using one of the existing prompts to see how they work.

**Generate Spring Boot Tests:**

In Copilot Chat, reference the test generation prompt:

```
/generate-test Generate tests for RecipeService
```

**Review Code:**

Use the code review prompt to check your code:

```
/code-review Review the RecipeController class
```

### Observe:
- How the prompt automatically fills in your input
- The consistent structure of the generated output
- How variables are replaced with your values

## 🛠️ Step 3: Create Your Own Prompt File

Let's create a custom prompt file for generating Thymeleaf HTML components in the FlavorHub project. You'll create a prompt file that generates recipe card components with proper Spring Boot integration.

### Step 3.1: Enable Prompt Files

1. Open VS Code Settings: `Cmd+,` (Mac) or `Ctrl+,` (Windows/Linux)
2. Search for "Prompt file"
3. Ensure "Chat: Prompt Files" is enabled

### Step 3.2: Create the Prompt File

**Method 1: Using Copilot Chat UI**
1. Open GitHub Copilot Chat
2. Click the cogwheel (⚙️) in the top-right corner
3. Select "Prompt Files"
4. Click "New prompt file..."
5. Choose `.github/prompts/` as the location
6. Name it `generate-recipe-card.prompt.md`

**Method 2: Create Manually**

Create a new file at `.github/prompts/generate-recipe-card.prompt.md`

### Step 3.3: Define Your Prompt Template

Try to come up with a prompt template that is capable of generating Thymeleaf HTML components that is in line with how other componenets in this repository are built. Remember to follow best practices by writting out clearly in markdown syntax what it is that you want Copilot to do for you.

If you need a little guidance, there is a provided prompt below.

<details>
  <summary>💡 Example Prompt</summary>

  ```markdown
  ---
  description: 'Generate a Thymeleaf recipe card component with Spring Boot integration'
  agent: 'edit'
  ---
  
  Create a new Thymeleaf HTML fragment for displaying recipe cards in the FlavorHub application.
  
  Component name: ${input:componentName:recipe-card}
  Component purpose: ${input:purpose:Display a recipe with image, title, and metadata}
  Location: src/main/resources/templates/fragments/${input:componentName}.html
  
  Requirements:
  - Use Thymeleaf syntax (th:* attributes)
  - Include proper Spring Boot template structure
  - Make it responsive with modern CSS (flexbox/grid)
  - Add hover effects and transitions
  - Use semantic HTML5 elements
  - Include accessibility attributes (aria-labels, alt text)
  - Style with inline CSS or reference existing styles
  - Accept a recipe object as a Thymeleaf parameter
  - Follow the existing template patterns in src/main/resources/templates/
  
  The component should be reusable across different pages of the application.
  
  Example usage in a controller:
  ```java
  model.addAttribute("recipe", recipe);
  ```
  
  Example usage in a template:
  ```html
  <div th:replace="fragments/${componentName} :: ${componentName}(recipe=${recipe})"></div>
  ```

</details>

### Step 3.4: Test Your Prompt File

1. In Copilot Chat, type `/` to see available prompt files
2. Type `/generate-recipe-card`
3. Provide values for the input variables
   - Example: `/generate-recipe-card componentName=recipe-card`
4. Press Enter
5. Review the generated HTML/Thymeleaf code

### ✅ Success Criteria
- [ ] Your prompt file appears in the `/` command list
- [ ] Variables are correctly replaced with your input
- [ ] Generated code follows Thymeleaf conventions
- [ ] Component is created in the correct location

## 💡 Step 5: Advanced Prompt File Techniques

### Step 5.1: Using Multiple Variables

Create prompts with multiple input variables for flexibility:

```markdown
---
description: 'Create a Spring Boot feature with tests'
agent: 'edit'
---

Create a new ${input:featureType:service} called ${input:name:MyFeature}.

Add the following functionality:
${input:functionality:Describe the functionality here}

Also create JUnit 5 unit tests using Mockito.
Include tests for happy path and edge cases.
```

### Step 5.2: Using Workspace Variables

Reference current file and workspace context:

```markdown
---
description: 'Refactor current Java file'
agent: 'edit'
---

Refactor the file at ${file} to improve:
- Code readability
- Performance
- Type safety
- Spring Boot best practices

Current working directory: ${workspaceFolder}
```

### Step 5.3: Using File Context

Reference specific files for context:

```markdown
---
description: 'Create similar controller'
agent: 'edit'
---

Create a controller similar to @src/main/java/com/coveros/training/flavorhub/controller/RecipeController.java but for ${input:purpose:managing user preferences}.

Follow the same patterns and Spring Boot conventions.
```

## 🎯 Step 6: Best Practices for Prompt Files

### Naming Conventions
- Use descriptive names: `generate-recipe-card` not `gen-card`
- Use kebab-case: `create-api-endpoint` not `CreateAPIEndpoint`
- Group related prompts: `test-generate-unit`, `test-generate-integration`

### Structure Guidelines
1. **Clear Description**: Make it obvious what the prompt does
2. **Right Agent Mode**: 
   - Use `ask` for questions
   - Use `edit` for code generation/modification
   - Use `agent` for autonomous multi-file tasks
3. **Meaningful Defaults**: Provide helpful placeholder values
4. **Precise Instructions**: Be specific about requirements
5. **Context References**: Include relevant files with `@` notation

### Collaboration Tips
- Document your prompts with clear descriptions
- Share prompt files through version control
- Review and refine based on team feedback
- Create prompt files for frequently repeated tasks
- Maintain consistency across related prompts

### Community Examples
For examples of effective prompt file practices and they types of things you could use them for, visit the Awesome [GitHub Copilot Repository](https://github.com/github/awesome-copilot). This repository is curated and owned by GitHub and has tons of helpful examples from the community on all aspects of GitHub Copilot.
- [Awesome Copilot Prompts](https://github.com/github/awesome-copilot/tree/main/prompts)

## 🏆 Exercise Wrap-up

Excellent work! You've mastered prompt files:
- ✅ Understood the benefits of prompt files for team productivity
- ✅ Explored existing prompt files in the repository
- ✅ Created your own custom prompt file
- ✅ Learned to use variables and context references
- ✅ Applied best practices for prompt file creation

### Reflection Questions:
1. **What repetitive tasks in your workflow could benefit from prompt files?**
2. **How could prompt files help standardize your team's approach to common tasks?**
3. **What variables would make your prompts more flexible?**
4. **How will you share and maintain prompt files with your team?**

### Key Takeaways:
- Prompt files capture team knowledge and ensure consistency
- Variables make prompts flexible and reusable
- Clear descriptions and proper agent modes improve usability
- Version control enables team collaboration on prompts
- Prompt files multiply productivity across your entire team

## Coming up next...

In the next lab, you'll learn about Custom Agents:
- Create custom agents for specialized development workflows
- Build agents with expert knowledge for specific technologies
- Use agents for autonomous task execution
- Share agents across your organization for consistent practices
