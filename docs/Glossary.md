# GitHub Copilot Glossary

A comprehensive reference for GitHub Copilot terms, features, and concepts used throughout the workshop.

---

## Core Concepts

### GitHub Copilot
An AI pair programmer that helps you write code faster and with less effort. Copilot suggests whole lines or entire functions right inside your editor.

### GitHub Copilot Chat
An interactive AI assistant that can answer questions, explain code, generate code, and help with various development tasks through a conversational interface.

### Context Window
The amount of code and information that Copilot can "see" and use when generating suggestions. Includes open files, cursor position, and recent edits.

---

## Chat Modes

### Ask Mode
Default chat mode for asking questions about code, getting explanations, or learning about concepts.
- **Use when**: You need information or explanations
- **Example**: "How does Spring Data JPA work?"

### Edit Mode
Inline editing mode that modifies code directly in your editor based on natural language instructions.
- **Use when**: You want to modify existing code
- **Example**: "Add pagination to this endpoint"
- **Shortcut**: Ctrl+I / Cmd+I

### Agent Mode
Autonomous mode where Copilot can make multi-file changes and perform complex refactoring tasks.
- **Use when**: Changes span multiple files or are complex
- **Example**: "@workspace Add a rating feature across all layers"

---

## Chat Participants

### @workspace
Provides context about your entire workspace/repository.
- **Use when**: Asking about project structure or multi-file questions
- **Example**: "@workspace Find all TODO comments"

### @vscode
Answers questions about VS Code itself.
- **Use when**: You need help with editor features
- **Example**: "@vscode How do I set up debugging?"

### @terminal
Helps with terminal commands and shell operations.
- **Use when**: You need command-line help
- **Example**: "@terminal How do I build this Maven project?"

---

## Slash Commands

### /explain
Explains selected code or a specific file.
- **Usage**: `/explain #file:RecipeController.java`
- **Output**: Detailed explanation of the code's purpose and functionality

### /fix
Suggests fixes for problems in your code.
- **Usage**: `/fix` (with code selected)
- **Output**: Proposed corrections for errors or issues

### /tests
Generates unit tests for selected code.
- **Usage**: `/tests` (with code selected)
- **Output**: Comprehensive test cases

### /doc
Generates documentation for your code.
- **Usage**: `/doc` (with code selected)
- **Output**: Javadoc or documentation comments

---

## Advanced Features

### Copilot Instructions
Configuration files that guide Copilot's behavior:
- **Personal Instructions**: Apply to all your projects
- **Repository Instructions**: Apply to a specific project (.github/copilot-instructions.md)

### Prompt Files
Reusable templates for common tasks stored in `.github/prompts/`
- **Use when**: You have repetitive tasks
- **Example**: generate-test.md, code-review.md

### Custom Agents
Specialized AI assistants with expert knowledge for autonomous development, stored in `.github/agents/` or organization-wide in `{org}/.github/agents/`

**Access**: 
- **Create in VS Code**: Open Copilot Chat panel → Click the settings gear icon (⚙️) at the top → Select "Custom Agents" → `New Custom Agent` → `.github/agents` → Enter the name you want for the custom agent file (**Note**: The name of the file is not the name of the agent in the drop down. That is controlled by the `name` field in the file) → This creates a file in `.github/agents/` with proper template in YAML format
- **Use in IDE**: In Agent mode, custom agents are available in the agent selector
- **Use with Coding Agent**: Reference agent in issue assignment or through GitHub.com interface
- **Alternative**: Manually create files in `.github/agents/` directory with `.agent.yml` extension

**Location**: `.github/agents/*.agent.yml`  
**Format**: YAML with markdown instructions  
**Use when**: You want specialized, autonomous development assistance  
**Example**: Java Expert, Test Engineer, Security Reviewer

---

## Copilot Spaces

### Copilot Space
A dedicated workspace in GitHub for focused AI-assisted development.
- **Features**: Persistent context, collaborative work, integrated with GitHub
- **Use when**: Working on complex features or with team members

---

## Coding Agent

### GitHub Copilot Coding Agent
An autonomous agent that can implement features from GitHub issues and create pull requests.
- **How to use**: Assign a GitHub issue to @copilot
- **What it does**: Analyzes requirements, writes code, creates tests, opens PR
- **Best for**: Well-defined features with clear acceptance criteria

---

## Model Context Protocol (MCP)

### MCP
A protocol that allows Copilot to connect to external tools and services.
- **Benefits**: Enhanced context, access to external data
- **Example**: GitHub MCP for repository data

---

## AI Models

### GPT-4o
OpenAI's latest model, optimized for code generation.
- **Strengths**: General-purpose, fast, good for most tasks
- **Use when**: Standard code generation and chat

### Claude 3.5 Sonnet
Anthropic's model known for detailed, thoughtful responses.
- **Strengths**: Complex reasoning, detailed explanations
- **Use when**: Need thorough analysis or complex refactoring

### o1-preview / o1-mini
Advanced reasoning models for complex problem-solving.
- **Strengths**: Deep analysis, complex algorithms
- **Use when**: Difficult architectural decisions or algorithms
- **Note**: Uses premium requests

---

## Key Shortcuts

| Action | Windows/Linux | Mac |
|--------|--------------|-----|
| Inline suggestion (accept) | Tab | Tab |
| Next suggestion | Alt+] | Option+] |
| Previous suggestion | Alt+[ | Option+[ |
| Open Copilot Chat | Ctrl+Shift+I | Cmd+Shift+I |
| Inline Edit mode | Ctrl+I | Cmd+I |
| Show completions panel | Ctrl+Enter | Cmd+Enter |

---

## Best Practices

### Effective Prompting
1. Be specific and clear
2. Provide context
3. Include examples when possible
4. Iterate and refine

### Code Review
1. Always review Copilot's suggestions
2. Verify logic and edge cases
3. Ensure code matches project standards
4. Test generated code thoroughly

### Security
1. Never commit secrets or API keys
2. Review security implications
3. Validate all input
4. Follow security best practices

---

## Spring Boot Specific Terms

### Entity
A JPA class that maps to a database table.
- **Example**: `@Entity public class Recipe { ... }`

### Repository
Interface for database operations using Spring Data JPA.
- **Example**: `interface RecipeRepository extends JpaRepository<Recipe, Long>`

### Service
Business logic layer between controller and repository.
- **Example**: `@Service public class RecipeService { ... }`

### Controller
Handles HTTP requests and returns responses.
- **Example**: `@RestController @RequestMapping("/api/recipes")`

### DTO (Data Transfer Object)
Object used to transfer data between layers.
- **Use when**: Request/response payloads differ from entities

---

## Workshop-Specific Terms

### FlavorHub
The Spring Boot application used in this workshop for hands-on learning.

### TODO Comments
Intentionally incomplete features marked for workshop exercises.
- **Example**: `// TODO: Implement recipe recommendation logic`

### DataLoader
Component that populates the database with sample data on startup.
- **Location**: `config/DataLoader.java`

---

## Additional Resources

- [GitHub Copilot Documentation](https://docs.github.com/en/copilot)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Workshop Labs](../labs/)
- [Best Practices](Copilot-Instruction-Best-Practices.md)

---

## Need More Help?

- Use Copilot Chat: Ask "@workspace what does [term] mean?"
- Review the labs for hands-on examples
- Check the copilot-instructions.md for project-specific guidance
